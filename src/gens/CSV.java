/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gens;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hedkandi
 */
final class CSV {

    private String sFilename = "";
    private boolean bAppend = false;
    private String sTargetDir = "";
    private String sColDelimiter = ";";
    private String sTextDelimiter = "\"";
    private String sRowDelimiter = "\r\n";
    private FileWriter fwStream;
    private BufferedWriter bwOut;
    private File fileCSV;
    private boolean bDoOverwrite = false;

    public CSV(String sFilename,boolean bAppend) throws IOException {
        this.sFilename = sFilename;
        this.bAppend = bAppend;
        initFile();
    }

    public CSV() {
        
    }

    public void readCSV() {

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
            this.fwStream = new FileWriter(fileCSV, isAppend());
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
        Pattern integerPattern = Pattern.compile("^[0-9].*$");        
        for(int k=0;k<inData.length;k++) {
            if (!this.sTextDelimiter.equals("") || this.sTextDelimiter != null) {
                Matcher matchesInteger = integerPattern.matcher(inData[k]);
                if (!matchesInteger.matches()) {
                    inData[k] = sTextDelimiter + inData[k].toString() + sTextDelimiter;
                }
            }
            if (k==inData.length-1) {
                bwOut.write(inData[k]);
            }
            else {
                bwOut.write(inData[k] + getDelimiter());
            }
        }
        bwOut.write(getsRowDelimiter());
    }

    public void close() throws IOException {
        bwOut.flush();
        bwOut.close();
        fwStream.close();
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
    public String getDelimiter() {
        return sColDelimiter;
    }

    /**
     * @param sDelimiter the sDelimiter to set
     */
    public void setDelimiter(String sDelimiter) {
        this.sColDelimiter = sDelimiter;
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
    public String getsRowDelimiter() {
        return sRowDelimiter;
    }

    /**
     * @param sRowDelimiter the sRowDelimiter to set
     */
    public void setsRowDelimiter(String sRowDelimiter) {
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
}