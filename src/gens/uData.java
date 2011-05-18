/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gens;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Locale;

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
        if (buf instanceof Integer) {
            ByteBuffer bb = ByteBuffer.allocateDirect(4).order(ByteOrder.LITTLE_ENDIAN);
            bb.putInt((Integer)buf);
            return bb.array();
        }
        else if (buf instanceof Short) {
            ByteBuffer bb = ByteBuffer.allocateDirect(2).order(ByteOrder.LITTLE_ENDIAN);
            bb.putInt((Integer)buf);
            return bb.array();
        }
        else if (buf instanceof Boolean) {
            ByteBuffer bb = ByteBuffer.allocateDirect(4).order(ByteOrder.LITTLE_ENDIAN);
            bb.putInt((Integer)1);
            return bb.array();
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
        for (int m=0;m<temp.length;m++) {
            if (temp[m] != 0x0) {
                retString += (char)temp[m];
            }
        }
        return retString;
    }
    static final byte[] HEX_CHAR_TABLE = {
        (byte)'0', (byte)'1', (byte)'2', (byte)'3',
        (byte)'4', (byte)'5', (byte)'6', (byte)'7',
        (byte)'8', (byte)'9', (byte)'a', (byte)'b',
        (byte)'c', (byte)'d', (byte)'e', (byte)'f'
        };

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
}
