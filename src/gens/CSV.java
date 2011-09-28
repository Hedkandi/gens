/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gens;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author hedkandi
 */
final class CSV {

    private String sFilename = "";
    private boolean bAppend = false;
    private boolean bFirstRowTitles = false;
    private String sTargetDir = "";
    private String sColDelimiter = ";";
    private String sTextDelimiter = "";
    private String sRowDelimiter = "\r\n";
    private FileWriter fwStream;
    private FileReader frStream;
    private BufferedWriter bwOut;
    private Scanner scanIn;
    private File fileCSV;
    private boolean bDoOverwrite = false;

    public CSV(String sFilename,boolean bAppend) throws IOException {
        this.sFilename = sFilename;
        this.bAppend = bAppend;
        initFile();
    }

    public CSV() {
        
    }

    public String[][] readCSV() throws IOException {
        try {
            String[][] retData;
            //System.out.println("init " + this.getFilename());
            if (!this.getTargetDir().equals("")) {
                File dir = new File(this.getTargetDir());
                if (!dir.exists()) {
                    boolean dirMade = dir.mkdirs();
                }
            }
            fileCSV = new File(this.getTargetDir() + File.separatorChar + this.getFilename());
            frStream = new FileReader(fileCSV);
            try {
                frStream.getEncoding();
            } catch (Exception ex) {
                throw new IOException("Failed to get file encoding.");
            }
            int i = 0;
            scanIn = new Scanner(frStream);
            int rowCount = 0;
            while (scanIn.hasNextLine()) { scanIn.nextLine(); rowCount++; }
            scanIn.close();
            frStream.close();
            frStream = new FileReader(fileCSV);
            scanIn = new Scanner(frStream);
            retData = new String[rowCount][];
            while (scanIn.hasNextLine()) {
                if (i <= rowCount-1) {
                    //System.out.println((isFirstRowTitles() && i > 0));
                    //System.out.println((!isFirstRowTitles()));
                    if (isFirstRowTitles() && i < 1) {
                        scanIn.nextLine();
                    }
                    String[] currColumns = scanIn.nextLine().split(";");
                    retData[i] = new String[currColumns.length];
                    for (int j=0;j<currColumns.length;j++) {
                        if (currColumns[j].length() > 2) {
                            //System.out.println(currColumns[j].substring(1, currColumns[j].length()-1));
                            retData[i][j] = currColumns[j].substring(1, currColumns[j].length()-1);
                            //System.out.println(currColumns[j].substring(1, currColumns[j].length()-1));
                        }
                        else {
                            retData[i][j] = "";
                        }
                        //System.out.println(retData[i][j]);
                    }
                    i++;
                }
                else {
                    break;
                }
            }
            return retData;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new IOException(ex);
        }
    }

    private void initFile() throws IOException {
        try {
            //System.out.println("init " + this.getFilename());
            if (!this.getTargetDir().equals("")) {
                File dir = new File(this.getTargetDir());
                if (!dir.exists()) {
                    boolean dirMade = dir.mkdirs();
                }
            }
            fileCSV = new File(this.getTargetDir() + File.separatorChar + this.getFilename());
            fwStream = new FileWriter(fileCSV, isAppend());
            fwStream.flush();
            bwOut = new BufferedWriter(fwStream);
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }

    public void writeCSV(String[][] inData) throws IOException, Exception {
        if (this.sFilename.equals("")) {
            throw new IOException("No file to write to.");
        }
        else if (this.fileCSV == null && !this.getFilename().equals("")) {
            initFile();
        }
        else if (!this.fileCSV.getName().equals(this.getFilename())) {
            initFile();
        }
        else if(fileCSV.exists()) {
            if (!isAppend() && !isOverwrite()) {
                throw new IOException("File \"" + this.getFilename() + "\" already exists and instruction is NOT to append NOR overwrite.");
            }
            else if (isAppend() && isOverwrite()) {
                throw new IOException("I cant both append AND overwrite, please choose.");
            }
        }
        else if(!fileCSV.canWrite()) {
            throw new IOException("Failed to obtain write-access to " + getFilename());
        }
        //System.out.println("writing " + this.getFilename());
        for (int i=0;i<inData.length;i++) {
            writeRow(inData[i]);
        }
    }

    private void writeRow(String[] inData) throws IOException {       
        for(int k=0;k<inData.length;k++) {
            bwOut.write(getTextDelimiter());
            bwOut.write(inData[k]);
            bwOut.write(getTextDelimiter());
            if (k!=inData.length-1) {
                bwOut.write(getColDelimiter());
            }
        }
        //bwOut.write(getRowDelimiter());
        //bwOut.write((byte)0xd);
        //bwOut.write((byte)0xa);
        bwOut.newLine();
        //bwOut.newLine();
    }

    public void close() throws IOException {
        if (bwOut != null) {
            bwOut.flush();
            bwOut.close();
            fwStream.close();   
        }
        if (scanIn != null) {
            scanIn.close();
            frStream.close();
        }
    }

    // Getters & Setters
    public void setOverwrite(boolean bool) {
        this.bDoOverwrite = bool;
    }

    public boolean isOverwrite() {
        return this.bDoOverwrite;
    }

    /**
     * @return the sFilename
     */
    public String getFilename() {
        return sFilename;
    }

    /**
     * @param sFilename the sFilename to set
     */
    public void setFilename(String sFilename) {
        this.sFilename = sFilename;
    }

    /**
     * @return the bAppend
     */
    public boolean isAppend() {
        return bAppend;
    }

    /**
     * @param bAppend the bAppend to set
     */
    public void setAppend(boolean bAppend) {
        this.bAppend = bAppend;
    }

    /**
     * @return the sDelimiter
     */
    public String getColDelimiter() {
        return sColDelimiter;
    }

    /**
     * @param sDelimiter the sDelimiter to set
     */
    public void setColDelimiter(String sColDelimiter) {
        this.sColDelimiter = sColDelimiter;
    }

    /**
     * @return the sTextDelimiter
     */
    public String getTextDelimiter() {
        return sTextDelimiter;
    }

    /**
     * @param sTextDelimiter the sTextDelimiter to set
     */
    public void setTextDelimiter(String sTextDelimiter) {
        this.sTextDelimiter = sTextDelimiter;
    }

    /**
     * @return the sRowDelimiter
     */
    public String getRowDelimiter() {
        return sRowDelimiter;
    }

    /**
     * @param sRowDelimiter the sRowDelimiter to set
     */
    public void setRowDelimiter(String sRowDelimiter) {
        this.sRowDelimiter = sRowDelimiter;
    }

    /**
     * @return the targetDir
     */
    public String getTargetDir() {
        return sTargetDir;
    }

    /**
     * @param targetDir the targetDir to set
     */
    public void setTargetDir(String targetDir) {
        this.sTargetDir = targetDir;
    }

    /**
     * @return the bFirstRowTitles
     */
    public boolean isFirstRowTitles() {
        return bFirstRowTitles;
    }

    /**
     * @param bFirstRowTitles the bFirstRowTitles to set
     */
    public void setFirstRowTitles(boolean bFirstRowTitles) {
        this.bFirstRowTitles = bFirstRowTitles;
    }
}