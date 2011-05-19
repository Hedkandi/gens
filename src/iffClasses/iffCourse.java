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
    
    // base should be equal to iffBase.getColNum()
    private static final int base = iffBase.base;
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
                case base:
                    return this.enName;
                case (base+1):
                    return this.thName;
                case (base+2):
                    return this.bitFlag;
                case (base+3):
                    return this.xmlFile;
                case (base+4):
                    return uData.getInt(this.U34);
                case (base+5):
                    return uData.getShort(this.U35);
                case (base+6):
                    return uData.getLong(this.U36);
                case (base+7):
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
                case base:
                    this.enName = (String)value;
                    break;
                case (base+1):
                    this.thName = (String)value;
                    break;
                case (base+2):
                    this.bitFlag = (Byte)value;
                    break;
                case (base+3):
                    this.Amount = (Short)value;
                    break;
                case (base+4):
                    this.xmlFile = (String)value;
                    break;
                case (base+5):
                    this.U34 = uData.getShort((Integer)value);
                    break;
                case (base+6):
                    this.U35 = uData.getByte((Short)value);
                    break;
                case (base+7):
                    this.U36 = uData.getInt((Long)value);
                    break;
                case (base+8):
                    this.seqFile = (String)value;
                    break;
            }
        }
    }
}
