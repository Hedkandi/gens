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
                case 32:
                    return uData.getShort(this.colorID);
                case 33:
                    return uData.getShort(this.numChar);
                case 34:
                    return uData.getShort(this.U35);
                case 35:
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
                case 32:
                    this.colorID = uData.getByte((Short)value);
                    break;
                case 33:
                    this.numChar = uData.getByte((Short)value);
                    break;
                case 34:
                    this.U35 = uData.getByte((Short)value);
                    break;
                case 35:
                    this.U36 = uData.getByte((Short)value);
                    break;
            }
        }
    }
}
