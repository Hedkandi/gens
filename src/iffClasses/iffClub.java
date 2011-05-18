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
public final class iffClub extends iffBase {
    public String Sprite2Name = "";
    public short clubNum = 0;
    public short U33 = 0;
    public short U34 = 0;
    public short U35 = 0;
    public short U36 = 0;
    String[] colNames = new String[] {  "Icon2?",
                                        "Club #",
                                        "COM1?",
                                        "COM2?",
                                        "COM3?",
                                        "COM4?"};
    public iffClub(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffClub(String[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffClub() {
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
    public void getItem(String[] inData) {
        super.getItem(inData);
        Sprite2Name = inData[32];
        clubNum = uData.getShort(Integer.parseInt(inData[33]));
        U33 = uData.getShort(Integer.parseInt(inData[34]));
        U34 = uData.getShort(Integer.parseInt(inData[35]));
        U35 = uData.getShort(Integer.parseInt(inData[36]));
        U36 = uData.getShort(Integer.parseInt(inData[37]));
    }

    @Override
    public void getItem(byte[] inData) throws IOException {
        try {
            super.getItem(inData);
            Sprite2Name = uData.getString(new ByteArrayInputStream(inData, 144, 40));
            clubNum = uData.getShort(new byte[]{inData[184], inData[185]});
            U33 = uData.getShort(new byte[]{inData[186], inData[187]});
            U33 = uData.getShort(new byte[]{inData[188], inData[189]});
            U34 = uData.getShort(new byte[]{inData[190], inData[191]});
            U35 = uData.getShort(new byte[]{inData[192], inData[193]});
            U36 = uData.getShort(new byte[]{inData[194], inData[195]});
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
                    return uData.getInt(this.clubNum);
                case 34:
                    return uData.getInt(this.U33);
                case 35:
                    return uData.getInt(this.U34);
                case 36:
                    return uData.getInt(this.U35);
                case 37:
                    return uData.getInt(this.U36);
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
                    this.clubNum = uData.getShort((Integer)value);
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
