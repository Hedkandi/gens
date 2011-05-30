/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iffClasses;

import gens.uData;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/**
 *
 * @author hedkandi
 */
public class iffHandler {
    private boolean bWriteTitles = false;
    public static int stringLength = 0;
    public static int longStringLength = 0;
    
    public iffHandler() {
        
    }
    
    public String getRegion(short Rev, short Magic) throws IOException {
        //System.out.println(Rev + " - " + Magic);
        if ((Rev == 0 || Rev == 32322) && Magic == 11) {
            stringLength = 40;
            longStringLength = 512;
            return "TH";
        }
        else if ((Rev == 30319 || Rev == 18 || Rev == 26998 || Rev == 0) && Magic == 12) {
            stringLength = 40;
            longStringLength = 512;
            return "JP";
        }
        else {
            throw new IOException("Unknown region.");
        }
    }

    public String[][] readIff(byte[] extractedData, String sFilename) throws Exception {
        String[][] retData;
        short numRecords = uData.getShort(new byte[]{extractedData[0], extractedData[1]});
        short revision = uData.getShort(new byte[]{extractedData[2], extractedData[3]});
        byte magicNum = extractedData[4];
        String Region = getRegion(revision,magicNum);
        String classPath = "iffClasses.iff" + sFilename.substring(0, sFilename.indexOf("."));

        if ((extractedData.length-8) > 0 && numRecords > 0) {
            int itemSize = (int) ((extractedData.length-8)/(int)numRecords);
            System.out.println("   >\tRegion: " + Region + ", File size: " + uData.getFilesize(extractedData.length) + ", Record size: " + uData.getFilesize(itemSize) + ", Number of records: " + numRecords);
            if (isWriteTitles()) {
                retData = new String[numRecords+1][];
            }
            else {
                retData = new String[numRecords][];
            }
            int i=0;
            for (int j=8;j<extractedData.length;j=j+itemSize) {
                try {
                    byte[] item = new byte[itemSize];
                    InputStream test = new ByteArrayInputStream(extractedData,j,itemSize);
                    if (test.read(item) > 0) {
                        Constructor iffConstructor;
                        Object newInstance = null;
                        try {
                            iffConstructor = Class.forName(classPath).getConstructor(Array.newInstance(byte.class, 0).getClass());
                            newInstance = iffConstructor.newInstance(item);
                        } catch (ClassNotFoundException ce) {
                            System.out.println("ERROR!\nClass: " + classPath + " wasnt found.\nRecordsize: " + uData.getFilesize(itemSize) + "\nNumber of records: " + numRecords + "\nRev: " + revision + "\nMagic: " + magicNum);
                            System.exit(1);
                        }
                        final Method mthdColNum = newInstance.getClass().getDeclaredMethod("getColNum");
                        Method mthdGetValue = newInstance.getClass().getMethod("getValue", Integer.TYPE);
                        Method mthdGetTitle = newInstance.getClass().getMethod("getTitle", Integer.TYPE);
                        int colLength = (Integer) mthdColNum.invoke(newInstance);
                        if (colLength > 0) {
                            if(isWriteTitles() && i == 0) {
                                retData[i]= new String[colLength];
                                for(int n=0;n<colLength;n++) {
                                    retData[i][n] = (String)mthdGetTitle.invoke(newInstance, n);
                                }
                                i++;
                            }
                            retData[i]= new String[colLength];
                            for(int n=0;n<colLength;n++) {
                                Object colValue = mthdGetValue.invoke(newInstance, n);
                                //retData[i][n] = mthdGetValue.invoke(newInstance, n).toString();
                                if (colValue instanceof Boolean) {
                                    retData[i][n] = Boolean.toString((Boolean) colValue);
                                }
                                else if (colValue instanceof Long) {
                                    //System.out.println(colValue);
                                    retData[i][n] = Long.toString((Long)colValue);
                                }
                                else if (colValue instanceof Integer) {
                                    //System.out.println(colValue);
                                    retData[i][n] = Integer.toString((Integer)colValue);
                                }
                                else if (colValue instanceof Short) {
                                    //System.out.println(colValue);
                                    retData[i][n] = Short.toString((Short)colValue);
                                }
                                else if (colValue instanceof Byte) {
                                    //System.out.println(colValue);
                                    retData[i][n] = Byte.toString((Byte)colValue);
                                }
                                else if (colValue instanceof String) {
                                    retData[i][n] = (String) colValue;
                                }
                            }
                        }
                        else {
                            throw new IOException("Not enough columns.");
                        }
                        newInstance = null;
                        iffConstructor = null;
                    }
                    else {
                        throw new IOException("Failed to read item.");
                    }
                } catch (Exception ex) {
                    throw new Exception(ex);
                }
                i++;
            }
            extractedData = null;
            return retData;
        }
        return new String[][] {new String[] {""},new String[] {""}};
    }

    public String[][] readIff(File iffFile) throws FileNotFoundException, IOException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, Exception {
        int numRecords = Integer.MIN_VALUE;
        int itemSize = Integer.MIN_VALUE;
        String[][] retData;
        InputStream is = new FileInputStream(iffFile);

        long length = iffFile.length();
        if (length > Long.MAX_VALUE) {
            throw new IOException("Input file is too large.");
        }

        byte[] bytes = new byte[(int)length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length)) >= 0) {
            offset += numRead;
        }
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+iffFile.getName());
        }
        else if (offset > bytes.length) {
            throw new IOException("It seems like something got written to the file during the read operation.");
        }
        else {
            numRecords = uData.getShort(new byte[] {bytes[0], bytes[1]});
            if ((iffFile.length()-8) > 0 && numRecords > 0) {
                itemSize = (int) ((iffFile.length()-8)/(int)numRecords);
                //System.out.println(itemSize);
                int i = 0;
                if (isWriteTitles()) {
                    retData = new String[numRecords+1][];
                }
                else {
                    retData = new String[numRecords][];
                }
                
                for (int j=8;j<bytes.length;j=j+itemSize) {
                    try {
                        byte[] item = new byte[itemSize];
                        InputStream test = new ByteArrayInputStream(bytes,j,itemSize);
                        test.read(item);
    //                    System.out.println(uData.getHexString(item));
                        Constructor iffConstructor = Class.forName("iffClasses.iff" + iffFile.getName().substring(0, iffFile.getName().indexOf(".")),true,new ClassLoader() {}).getConstructor(Array.newInstance(byte.class, 0).getClass());
                        Object newInstance = iffConstructor.newInstance(item);
                        final Method mthdColNum = newInstance.getClass().getDeclaredMethod("getColNum");
                        int colLength = (Integer) mthdColNum.invoke(newInstance);
                        Method mthdGetValue = newInstance.getClass().getMethod("getValue", Integer.TYPE);
                        if(isWriteTitles() && i == 0) {
                            retData[i]= new String[colLength];
                            for(int n=0;n<colLength;n++) {
                                retData[i][n] = "Title";
                            }
                            System.out.println("titles!");
                            i++;
                        }
                        retData[i]= new String[colLength];
                        for(int n=0;n<colLength;n++) {
                            /*
                            if(n>15&&n<32&&(Integer)mthdGetValue.invoke(newInstance, n)>0){
                                System.out.println("n: " + uData.getInt((Integer)mthdGetValue.invoke(newInstance, n)));
                            }*/
                            Object colValue =mthdGetValue.invoke(newInstance, n);
                            //retData[i][n] = mthdGetValue.invoke(newInstance, n).toString();
                            
                            if (colValue instanceof Boolean) {
                                if (!(Boolean) colValue) {
                                    retData[i][n] = "0";
                                }
                                else {
                                    retData[i][n] = "1";
                                }
                            }
                            else if (colValue instanceof Long) {
                                //System.out.println(colValue);
                                retData[i][n] = Long.toString((Long)colValue);
                            }
                            else if (colValue instanceof Integer) {
                                //System.out.println(colValue);
                                retData[i][n] = Integer.toString((Integer)colValue);
                            }
                            else if (colValue instanceof Short) {
                                //System.out.println(colValue);
                                retData[i][n] = Short.toString((Short)colValue);
                            }
                            else if (colValue instanceof Byte) {
                                //System.out.println(colValue);
                                retData[i][n] = Byte.toString((Byte)colValue);
                            }
                            else if (colValue instanceof String) {
                                retData[i][n] = (String) colValue;
                            }
                            else {
                                System.out.println("row: " + i + " column: " + n);
                                System.out.println("Class not handled.");
                            }

                        }
                        /*
                        newInstance = null;
                        iffConstructor = null;
                         * 
                         */
                    } catch (Exception ex) {
                        throw new Exception(ex);
                    }
                    i++;
                }
                return retData;
            }
        }
        return new String[][] {new String[] {""},new String[] {""}};
    }

    /**
     * @return the bWriteTitles
     */
    public boolean isWriteTitles() {
        return bWriteTitles;
    }

    /**
     * @param bWriteTitles the bWriteTitles to set
     */
    public void setWriteTitles(boolean bWriteTitles) {
        this.bWriteTitles = bWriteTitles;
    }
}
