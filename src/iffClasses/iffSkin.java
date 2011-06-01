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
public final class iffSkin extends iffBase {

    // base should be equal to iffBase.getColNum()
    private static final int base = iffBase.base;
    public String Sprite2Name = ""; 
    public int Amount = 0; 
    public byte U33 = 0;
    public byte U34 = 0;
    public int U35 = 0;
    public byte U36 = 0;
    public byte U37 = 0;
    public byte U38 = 0;
    public int U39 = 0;
    public byte U40 = 0;
    public byte U41 = 0;
    public byte U42 = 0; 
    public int U43 = 0;
    public int U47 = 0;
    public int U49 = 0;
    String[] colNames = new String[] {  "Icon2?",
                                        "Amount",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA"};

    public iffSkin(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffSkin() {
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
        colNames[3] = "Decoration Type";
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
            Sprite2Name = uData.getString(new ByteArrayInputStream(inData, 144, uData.stringLength));
            Amount = uData.getInt(new byte[]{inData[184], inData[185], inData[186], inData[187]});
            U35 = uData.getInt(new byte[]{inData[188], inData[189], inData[190], inData[191]});
            U39 = uData.getInt(new byte[]{inData[192], inData[193], inData[194], inData[195]});
            U43 = uData.getInt(new byte[]{inData[196], inData[197], inData[198], inData[199]});
            U47 = uData.getInt(new byte[]{inData[200], inData[201], inData[202], inData[203]});
            U49 = uData.getInt(new byte[]{inData[204], inData[205], inData[206], inData[207]});
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
                    return uData.getLong(this.Amount);
                case (base+2):
                    return uData.getLong(this.U35);
                case (base+3):
                    return uData.getLong(this.U39);
                case (base+4):
                    return uData.getLong(this.U43);
                case (base+5):
                    return uData.getLong(this.U47);
                case (base+6):
                    return uData.getLong(this.U49);
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
                    this.Sprite2Name = (String)value;
                    break;
                case (base+1):
                    this.Amount = uData.getShort((Integer)value);
                    break;
                case (base+2):
                    this.U35 = uData.getShort((Integer)value);
                    break;
                case (base+3):
                    this.U39 = uData.getShort((Integer)value);
                    break;
                case (base+4):
                    this.U43 = uData.getShort((Integer)value);
                    break;
                case (base+5):
                    this.U47 = uData.getShort((Integer)value);
                    break;
                case (base+6):
                    this.U49 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
