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
public final class iffItem extends iffBase {
    
    // base should be equal to iffBase.getColNum()
    private static final int base = iffBase.base;
    public String Sprite2Name = ""; // 40 bytes - bytes 144-184
    public short Amount = 0; // 2 bytes - byte 110-111
    public short U33 = 0; // 2 bytes COM0? - bytes 185-186
    public short U34 = 0; // 2 bytes COM1? - bytes 187-188
    public short U35 = 0; // 2 bytes COM2? - bytes 189-190
    public short U36 = 0; // 2 bytes COM3? - bytes 191-192
    public short U37 = 0; // 2 bytes COM4? - bytes 193-194
    String[] colNames = new String[] {  "Icon2?",
                                        "Amount",
                                        "COM1?",
                                        "COM2?",
                                        "COM3?",
                                        "COM4?",
                                        "NA"};

    public iffItem(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffItem() {
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
    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
    
    @Override
    public void getItem(byte[] inData) throws IOException {
        try {
            super.getItem(inData);
            Sprite2Name = uData.getString(new ByteArrayInputStream(inData, 144, 40));
            Amount = uData.getShort(new byte[]{inData[184], inData[185]});
            U33 = uData.getShort(new byte[]{inData[186], inData[187]});
            U34 = uData.getShort(new byte[]{inData[188], inData[189]});
            U35 = uData.getShort(new byte[]{inData[190], inData[191]});
            U36 = uData.getShort(new byte[]{inData[192], inData[193]});
            U37 = uData.getShort(new byte[]{inData[194], inData[195]});
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }

    @Override
    public Object getValue(int colIndex) {
        if (colIndex < super.getColNum()) {
            return super.getValue(colIndex);
        }
        else {
            switch (colIndex) {
                case base:
                    return this.Sprite2Name;
                case (base+1):
                    return uData.getInt(this.Amount);
                case (base+2):
                    return uData.getInt(this.U33);
                case (base+3):
                    return uData.getInt(this.U34);
                case (base+4):
                    return uData.getInt(this.U35);
                case (base+5):
                    return uData.getInt(this.U36);
                case (base+6):
                    return uData.getInt(this.U37);
                default:
                    return "";
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
                    this.Sprite2Name = (String)value;
                    break;
                case (base+1):
                    this.Amount = uData.getShort((Integer)value);
                    break;
                case (base+2):
                    this.U33 = uData.getShort((Integer)value);
                    break;
                case (base+3):
                    this.U34 = uData.getShort((Integer)value);
                    break;
                case (base+4):
                    this.U35 = uData.getShort((Integer)value);
                    break;
                case (base+5):
                    this.U36 = uData.getShort((Integer)value);
                    break;
                case (base+6):
                    this.U37 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
