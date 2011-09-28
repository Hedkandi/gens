/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gens;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hedkandi
 */
public class uData {

    public static int stringLength = 40;

    public static long getLong(Object buf) {
        if (buf instanceof byte[]) {
            ByteBuffer bb = ByteBuffer.allocateDirect(8);
            bb.order(ByteOrder.LITTLE_ENDIAN);
            bb.put((byte[])buf);
            return bb.getLong(0);
        }
        else if (buf instanceof Long) {
            return (Long)buf;
        }
        else if(buf instanceof Integer) {
            long l = (Long) ((Integer)buf & 0xFFFFFFFFL);
            return l;
        }
        return 0L;
    }

    public static int getInt(Object buf) {
        if (buf instanceof byte[]) {
            ByteBuffer bb = ByteBuffer.allocateDirect(4);
            bb.order(ByteOrder.LITTLE_ENDIAN);
            bb.put((byte[])buf);
            return bb.getInt(0);
        }
        else if(buf instanceof Long) {
            int i = (int) ((Long)buf & 0xFFFFFFFFL);
            return i;
        }
        else if (buf instanceof Integer) {
            return (Integer)buf;
        }
        else if (buf instanceof Short) {
            int i = (int) ((Short)buf & 0xFFFF);
            return i;
        }
        return 0;
    }

    public static short getShort(Object buf) {
        if (buf instanceof byte[]) {
            ByteBuffer bb = ByteBuffer.allocate(2);
            bb.order(ByteOrder.LITTLE_ENDIAN);
            bb.put((byte[])buf);
            return bb.getShort(0);
        }
        else if (buf instanceof Byte) {
            ByteBuffer bb = ByteBuffer.allocate(2);
            bb.order(ByteOrder.LITTLE_ENDIAN);
            bb.put((Byte)buf);
            return bb.getShort(0);
        }
        else if (buf instanceof Integer) {
            short s = (short) ((Integer)buf & 0xFFFF);
            return s;
        }
        else if (buf instanceof Short) {
            return (Short)buf;
        }
        // Return a number thats easy to identify, to see "fall thrus"
        return -54;
    }
    
    public static byte getByte(Object in) {
        if (in instanceof Long) {
            return (byte)((Long)in & 0xFF);
        }
        if (in instanceof Integer) {
            return (byte)((Integer)in & 0xFF);
        }
        else if(in instanceof Short) {
            return (byte)((Short)in & 0xFF);
        }
        else if (in instanceof Byte) {
            return (Byte)in;
        }
        return 0xF;
    }

    public static boolean getBool(Object bool) {
        if (bool instanceof Short) {
            switch ((Short)bool) {
                case 1:
                    return true;
                default:
                    return false;
            }
        }
        else if (bool instanceof Byte) {
            switch ((Byte)bool) {
                case 0x1:
                    return true;
                default:
                    return false;
            }
        }
        else {
            return false;
        }
    }

    public static byte[] getBytes(Object buf) {
        if (buf instanceof Long) {
            byte[] val = new byte[4];
            val[3] = (byte)((Long)buf & 0xff000000);
            val[2] = (byte)((Long)buf & 0x00ff0000);
            val[1] = (byte)((Long)buf & 0x0000ff00);
            val[0] = (byte)((Long)buf & 0x000000ff);
            return val;
        }
        else if (buf instanceof Integer) {
            byte[] val = new byte[2];
            val[1] = (byte)((Integer)buf & 0xff00);
            val[0] = (byte)((Integer)buf & 0xff);
            return val;
        }
        else if (buf instanceof Short) {
            byte[] val = new byte[1];
            val[0] = (byte)((Short)buf & 0xff);
            return val;
        }
        else if (buf instanceof String) {
            byte[] val = new byte[uData.stringLength];
            for (int i=0;i<uData.stringLength;i++) {
                if (i<((String)buf).length()) {
                    val[i] = (byte)((String)buf).charAt(i);
                }
                else {
                    val[i] = 0x0;
                }
            }
            //System.out.println("String");
            return val;
        }
        else if (buf instanceof Boolean) {
            byte[] val = new byte[4];
            if ((Boolean)buf) {
                val[0] = 0x1;
            }
            else {
                val[0] = 0x0;
            }
            return val;
        }
        else {
            return null;
        }
    }

    public static String getString(ByteArrayInputStream bytes) throws IOException {
        InputStream test = bytes;
        byte[] temp = new byte[bytes.available()];
        try {
            test.read(temp);
        } catch (IOException ex) {
            throw new IOException("Failed to read string.");
        }
        String retString = "";//String.format(Locale.TAIWAN, "%s", temp);

        //bytesout.toString("TH");
        //System.out.println(bytes);
        for (int m=0;m<temp.length-1;m++) {
            if (temp[m] != 0x0) {
                if (temp[m] == 0xd && temp[m+1] == 0xa) {
                    retString += "<br>";
                }
                else if (temp[m] == 0xa) {
                    retString += "<br>";
                }
                else {
                    retString += new String(new byte[] {temp[m]}, "cp874");
                }
            }
        }
        return new String(retString.getBytes(),"UTF-8");
    }
    
    public static byte[] addToEnd(byte[] in, byte[] out) {
        byte[] temp = new byte[] {};
        //System.out.println(in.length + " - " + out.length);
        if (in.length > 0) {
             temp = new byte[in.length + out.length];
        }
        else {
            temp = new byte[out.length];
        }
        for (int i=0;i<in.length;i++) {
            temp[i] = in[i];
            //System.out.println(i);
        }
        for (int i=in.length;i<temp.length;i++) {
            temp[i] = out[i-in.length];
            //System.out.println(i);
        }
        return temp;
    }
    
    public static byte[] addToEnd(byte[] in, byte out) {
        byte[] temp = new byte[in.length + 1];
        for (int i=0;i<in.length;i++) {
            temp[i] = in[i];
            //System.out.println(i);
        }
        temp[temp.length-1] = out;
        return temp;
    }
    
    static final byte[] HEX_CHAR_TABLE = {
        (byte)'0', (byte)'1', (byte)'2', (byte)'3',
        (byte)'4', (byte)'5', (byte)'6', (byte)'7',
        (byte)'8', (byte)'9', (byte)'a', (byte)'b',
        (byte)'c', (byte)'d', (byte)'e', (byte)'f'
        };

    public static String getFilesize(int size) {
        String[] nameSizes = new String[] {"B", "KiB", "MiB", "GiB", "TiB", "PiB", "EiB", "ZiB", "YiB"};
        double tmpSize = size;
        int pos = 0;
        while (tmpSize > 1) {
            if (Math.floor(tmpSize / 1000) > 1.0) {
                tmpSize = tmpSize / 1000;
                pos++;
            }
            else {
                break;
            }
        }
        return String.format("%s %s", ((new DecimalFormat("#######.00").format(tmpSize))),nameSizes[pos]);
    }
    
    public static String getHexString(byte[] raw)
        throws UnsupportedEncodingException
        {
        byte[] hex = new byte[2 * raw.length];
        int index = 0;

        for (byte b : raw) {
          int v = b & 0xFF;
          hex[index++] = HEX_CHAR_TABLE[v >>> 4];
          hex[index++] = HEX_CHAR_TABLE[v & 0xF];
        }
        return new String(hex, "ASCII");
    }

    static String getSeconds(long l) {
        return String.format("%f", (double)l/1000);
    }
}
