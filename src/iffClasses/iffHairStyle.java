/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iffClasses;

import gens.uData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hedkandi
 */
public final class iffHairStyle extends iffBase {
    
    // base should be equal to iffBase.getColNum()
    private static final int base = iffBase.base;
    public byte colorID = 0;
    public byte numChar = 0;
    public byte U35 = 0;
    public byte U36 = 0;
    String[] colNames = new String[] {  "Color ID?",
                                        "Character",
                                        "NA",
                                        "NA"};
    
    public iffHairStyle(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public iffHairStyle(String[] inData) throws IOException {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffHairStyle() {
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
    public void getItem(String[] inData) throws IOException {
        try {
            super.getItem(inData);
            colorID = uData.getByte(Short.parseShort(inData[28]));
            numChar = uData.getByte(Short.parseShort(inData[29]));
            U35 = uData.getByte(Short.parseShort(inData[30]));
            U36 = uData.getByte(Short.parseShort(inData[31]));
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }
    
    @Override
    public void getItem(byte[] inData) throws IOException {
        try {
            super.getItem(inData);
            colorID = inData[144];
            numChar = inData[145];
            U35 = inData[146];
            U36 = inData[147];
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
                    return uData.getShort(this.colorID);
                case (base+1):
                    return uData.getShort(this.numChar);
                case (base+2):
                    return uData.getShort(this.U35);
                case (base+3):
                    return uData.getShort(this.U36);
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
                    this.colorID = uData.getByte((Short)value);
                    break;
                case (base+1):
                    this.numChar = uData.getByte((Short)value);
                    break;
                case (base+2):
                    this.U35 = uData.getByte((Short)value);
                    break;
                case (base+3):
                    this.U36 = uData.getByte((Short)value);
                    break;
            }
        }
    }
}
