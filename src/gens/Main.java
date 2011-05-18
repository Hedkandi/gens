/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gens;

import iffClasses.iffHandler;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipException;

/**
 *
 * @author hedkandi
 */
public class Main {

    private static boolean bDoOverwrite = true;
    private static boolean bAppend = false;
    private static boolean bWriteTitles = true;
    private static String sInFilename = "";
    private static String sTextDelimiter = "\'";
    private static String sRowDelimiter = "\r\n";
    private static String sTargetDir = "";
    private static String sVersion = "0.1";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        try {
            if (args.length >= 3) {
                if (args[0].equals("-ii") || args[0].equals("--in-iff")) {
                    sInFilename = args[1];
                    sTargetDir = sInFilename.substring(0, sInFilename.indexOf("."));
                    if (args[2].equals("-oc") || args[2].equals("--out-csv")) {
                        doDirectIFFtoCSV();
                        System.out.println("Finished writing the csv-files to directory " + sTargetDir + ".");
                        System.exit(0);
                    }
                    else if (args[2].equals("-oi") || args[2].equals("--out-iff")) {
                        doExtract();
                        System.out.println("Finished writing the iff-files to " + sTargetDir + ".");
                        System.exit(0);
                    }
                }
                else if (args[1].equals("-ic") || args[1].equals("--in-csv")) {

                }

                // Fall through
                System.out.println("One or more arguments are wrong.");
                printUsage();
                /*
                File[] listDir = new File("pangya_th").listFiles();
                for (int i=0;i<listDir.length;i++) {
                    System.out.println("listZip: " + t[i]);
                    if (listDir[i].getName().endsWith("iff")) {
                        //System.out.println(listDir[i].getName());
                        CSV csv = new CSV(listDir[i].getName().substring(0, listDir[i].getName().indexOf(".")) + ".csv", bAppend);
                        csv.setOverwrite(bDoOverwrite);
                        csv.setTextDelimiter("\"");
                        csv.writeCSV(ih.readIff(listDir[i]));
                        csv.close();
                    }
                }*/
            }
            else {
                printUsage();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void printUsage() {
        StringBuilder sUsage = new StringBuilder();
        sUsage.append("**********************\n");
        sUsage.append("**     gens ").append(sVersion).append("     **\n");
        sUsage.append("**********************\n");
        sUsage.append("Usage example: gens.jar -iz input.iff -oc\n");
        sUsage.append("Input parameters:\n");
        sUsage.append("-ii or --in-iff FILENAME - The input iff-file (The zipped file containing all other iff-files)\n");
        sUsage.append("-ic or --in-csv FILENAME - The input csv-file\n");
        sUsage.append("\n");
        sUsage.append("One of the above is required for operation.\n");
        sUsage.append("\n");
        sUsage.append("Output parameters:\n");
        sUsage.append("DIRNAME is optional, without it directory will be the name of the input file without extension.\n");
        sUsage.append("-oc or --out-csv [DIRNAME] - The directory to put csv-files in.\n");
        sUsage.append("-oi or --out-iff [DIRNAME] - The directory to put iff-files in.\n");
        System.out.print(sUsage.toString());
    }

    public static void doExtract() {
        try {
            iffZipper iz = new iffZipper(sInFilename, sTargetDir, bDoOverwrite);
            iz.doExtract();
        } catch (ZipException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void doDirectIFFtoCSV() {
        try {
            iffZipper iz = new iffZipper(sInFilename);
            String[] t = iz.listZip();
            iffHandler ih = new iffHandler();
            ih.setWriteTitles(bWriteTitles);
            CSV csv = new CSV();
            for (int i = 0; i < t.length; i++) {
                csv.setFilename(t[i].substring(0, t[i].indexOf(".")) + ".csv");
                csv.setOverwrite(bDoOverwrite);
                csv.setAppend(bAppend);
                csv.setRowDelimiter(sRowDelimiter);
                csv.setTextDelimiter(sTextDelimiter);
                csv.setTargetDir(sTargetDir);
                System.out.println("File " + (i+1) + "/" + t.length + ": " + t[i] + " -> " + sTargetDir + File.separatorChar + t[i].substring(0, t[i].lastIndexOf(".")) + ".csv");
                csv.writeCSV(ih.readIff(iz.doExtract(t[i]), t[i]));
                csv.close();
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

}
