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
    
    public iffHandler() {

    }

    public String[][] readIff(byte[] extractedData, String sFilename) throws Exception {
        String[][] retData;
        short numRecords = uData.getShort(new byte[]{extractedData[0], extractedData[1]});
        if ((extractedData.length-8) > 0 && numRecords > 0) {
            int itemSize = (int) ((extractedData.length-8)/(int)numRecords);
            //System.out.println(itemSize);
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
                    test.read(item);
//                    System.out.println(uData.getHexString(item));
                    Constructor iffConstructor = Class.forName("iffClasses.iff" + sFilename.substring(0, sFilename.indexOf(".")),true,new ClassLoader() {}).getConstructor(Array.newInstance(byte.class, 0).getClass());
                    Object newInstance = iffConstructor.newInstance(item);
                    final Method mthdColNum = newInstance.getClass().getDeclaredMethod("getColNum");
                    int colLength = (Integer) mthdColNum.invoke(newInstance);
                    Method mthdGetValue = newInstance.getClass().getMethod("getValue", Integer.TYPE);
                    Method mthdGetTitle = newInstance.getClass().getMethod("getTitle", Integer.TYPE);
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
                    newInstance = null;
                    iffConstructor = null;
                } catch (Exception ex) {
                    throw new Exception(ex);
                }
                i++;
            }
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
