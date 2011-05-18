/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iffClasses;

import gens.uData;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hedkandi
 */
public final class iffCourse extends iffBase {
    
    public String enName = ""; // 40 bytes - bytes 144-184
    public String thName = ""; // 40 bytes - bytes 144-184
    public byte bitFlag = 0;
    public short Amount = 0; // 2 bytes - byte 110-111
    public String xmlFile = ""; // 2 bytes COM0? - bytes 185-186
    public short U34 = 0; // 2 bytes COM1? - bytes 187-188
    public byte U35 = 0; // 2 bytes COM2? - bytes 189-190
    public int U36 = 0; // 2 bytes COM3? - bytes 191-192
    public String seqFile = "";
    String[] colNames = new String[] {  "English Short Name",
                                    "Thai Short Name?",
                                    "Flag",
                                    "XML-File",
                                    "COM3?",
                                    "COM4?",
                                    "COM4?",
                                    "Animation"};

    public iffCourse(byte[] inData) throws IOException {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffCourse() {
        super();
        buildColNames();
    }

    private void buildColNames() {
        List<String> temp = new ArrayList<String>(super.colNames.length + this.colNames.length);
        temp.addAll(Arrays.asList(super.colNames));
        temp.addAll(Arrays.asList(this.colNames));
        this.colNames = (String[]) temp.toArray(new String[temp.size()]);
        temp.clear();
        temp = null;
    }

    @Override
    public int getColNum() {
        return this.colNames.length;
    }
    
    @Override
    public void getItem(byte[] inData) throws IOException {
        try {
            super.getItem(inData);
            enName = uData.getString(new ByteArrayInputStream(inData, 144, 40));
            thName = uData.getString(new ByteArrayInputStream(inData, 184, 40));
            bitFlag = inData[224];
            xmlFile = uData.getString(new ByteArrayInputStream(inData, 225, 40));
            U34 = uData.getShort(new byte[]{inData[265], inData[266]});
            U35 = inData[267];
            U36 = uData.getInt(new byte[]{inData[268], inData[269], inData[270], inData[271]});
            seqFile = uData.getString(new ByteArrayInputStream(inData, 272, 40));
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }

    @Override
    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
    
    @Override
    public Object getValue(int colIndex) {
        if (colIndex < super.getColNum()) {
            return super.getValue(colIndex);
        }
        else {
            switch (colIndex) {
                case 32:
                    return this.enName;
                case 33:
                    return this.thName;
                case 34:
                    return this.bitFlag;
                case 35:
                    return this.xmlFile;
                case 36:
                    return uData.getInt(this.U34);
                case 37:
                    return uData.getShort(this.U35);
                case 38:
                    return uData.getLong(this.U36);
                case 39:
                    return this.seqFile;
                default:
                    return "&";
            }
        }
    }

    @Override
    public void setValue(int colIndex, Object value) {
        if (colIndex < super.getColNum()) {
            super.setValue(colIndex,value);
        }
        else {
            switch (colIndex) {
                case 32:
                    this.enName = (String)value;
                    break;
                case 33:
                    this.thName = (String)value;
                    break;
                case 34:
                    this.bitFlag = (Byte)value;
                    break;
                case 35:
                    this.Amount = (Short)value;
                    break;
                case 36:
                    this.xmlFile = (String)value;
                    break;
                case 37:
                    this.U34 = uData.getShort((Integer)value);
                    break;
                case 38:
                    this.U35 = uData.getByte((Short)value);
                    break;
                case 39:
                    this.U36 = uData.getInt((Long)value);
                    break;
                case 40:
                    this.seqFile = (String)value;
                    break;
            }
        }
    }
}
