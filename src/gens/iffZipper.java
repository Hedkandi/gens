/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gens;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 *
 * @author hedkandi
 */
public class iffZipper {

    private File fFile = null;
    private String sTargetDir = "";
    private boolean bDoOverwrite = false;
    private ZipFile zf = null;


    public iffZipper(String sFilename) {
        this.fFile = new File(sFilename);

    }

    iffZipper(String sInFilename, String sTargetDir, boolean bDoOverwrite) {
        this.fFile = new File(sInFilename);
        this.sTargetDir = sTargetDir;
        this.bDoOverwrite = bDoOverwrite;
    }

    public String[] listZip() throws ZipException, IOException {
        zf = new ZipFile(fFile);
        Enumeration e = zf.entries();
        byte[] uzFile = null;
        int i=0;
        String[] retData = new String[zf.size()];
        while (e.hasMoreElements()) {
            ZipEntry ze = (ZipEntry)e.nextElement();
            retData[i++] = ze.getName();
        }
        return retData;
    }

    public byte[] doExtract(String sZipEntry) throws IOException {
        ZipEntry currEntry = zf.getEntry(sZipEntry);
        BufferedInputStream is = new BufferedInputStream(zf.getInputStream(currEntry));
        byte[] uzFile = new byte[is.available()];
        is.read(uzFile, 0, is.available());
        return uzFile;
    }

    public void doExtract() throws ZipException, IOException {
        BufferedOutputStream dest = null;
        zf = new ZipFile(fFile);
        Enumeration e = zf.entries();
        byte[] uzFile = null;
        while (e.hasMoreElements()) {
            ZipEntry ze = (ZipEntry)e.nextElement();
            File dir = new File(sTargetDir);
            if (!dir.exists()) {
                boolean dirMade = dir.mkdirs();
            }
                
            if (dir.exists()) {
                File targetFile = new File(dir.getPath() + File.separatorChar + ze.getName());
                if (targetFile.exists() && !bDoOverwrite) {
                    System.out.println("File " + targetFile.getPath() + " already exists and overwrite is set to false.\nTry running with --force to overwrite");
                }
                FileOutputStream fos = new FileOutputStream(targetFile);
                BufferedInputStream is = new BufferedInputStream(zf.getInputStream(ze));
                uzFile = new byte[is.available()];
                is.read(uzFile, 0, is.available());
                dest = new BufferedOutputStream(fos);
                dest.write(uzFile);
                dest.flush();
                dest.close();
            }
            else {
                throw new IOException("Target directory: " + dir.getPath() + " doesnt exist.");
            }
        }
    }

    public void doCompress() {

    }
}
