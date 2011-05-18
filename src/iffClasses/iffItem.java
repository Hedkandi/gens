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
                case 32:
                    return this.Sprite2Name;
                case 33:
                    return uData.getInt(this.Amount);
                case 34:
                    return uData.getInt(this.U33);
                case 35:
                    return uData.getInt(this.U34);
                case 36:
                    return uData.getInt(this.U35);
                case 37:
                    return uData.getInt(this.U36);
                case 38:
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
                case 32:
                    this.Sprite2Name = (String)value;
                    break;
                case 33:
                    this.Amount = uData.getShort((Integer)value);
                    break;
                case 34:
                    this.U33 = uData.getShort((Integer)value);
                    break;
                case 35:
                    this.U34 = uData.getShort((Integer)value);
                    break;
                case 36:
                    this.U35 = uData.getShort((Integer)value);
                    break;
                case 37:
                    this.U36 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
