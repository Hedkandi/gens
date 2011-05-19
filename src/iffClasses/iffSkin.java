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
    public short Amount = 0; 
    public byte U33 = 0;
    public byte U34 = 0;
    public byte U35 = 0;
    public byte U36 = 0;
    public byte U37 = 0;
    public byte U38 = 0;
    public byte U39 = 0;
    public byte U40 = 0;
    public byte U41 = 0;
    public byte U42 = 0; 
    public byte U43 = 0;
    public byte U44 = 0;
    public byte U45 = 0;
    public byte U46 = 0;
    public short U47 = 0;
    public short U48 = 0; 
    public short U49 = 0;
    public short U50 = 0; 
    String[] colNames = new String[] {  "Icon2?",
                                        "Amount",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
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
            Amount = uData.getShort(new byte[]{inData[184], inData[185]});
            U33 = inData[186];
            U34 = inData[187];
            U35 = inData[188];
            U36 = inData[189];
            U37 = inData[190];
            U38 = inData[191];
            U39 = inData[192];
            U40 = inData[193];
            U41 = inData[194];
            U42 = inData[195];
            U43 = inData[196];
            U44 = inData[197];
            U45 = inData[198];
            U46 = inData[199];
            U47 = uData.getShort(new byte[]{inData[200], inData[201]});
            U48 = uData.getShort(new byte[]{inData[202], inData[203]});
            U49 = uData.getShort(new byte[]{inData[204], inData[205]});
            U50 = uData.getShort(new byte[]{inData[206], inData[207]});
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
                    return uData.getShort(this.U33);
                case (base+3):
                    return uData.getShort(this.U34);
                case (base+4):
                    return uData.getShort(this.U35);
                case (base+5):
                    return uData.getShort(this.U36);
                case (base+6):
                    return uData.getShort(this.U37);
                case (base+7):
                    return uData.getShort(this.U38);
                case (base+8):
                    return uData.getShort(this.U39);
                case (base+9):
                    return uData.getShort(this.U40);
                case (base+10):
                    return uData.getShort(this.U41);
                case (base+11):
                    return uData.getShort(this.U42);
                case (base+12):
                    return uData.getShort(this.U43);
                case (base+13):
                    return uData.getShort(this.U44);
                case (base+14):
                    return uData.getShort(this.U45);
                case (base+15):
                    return uData.getShort(this.U46);
                case (base+16):
                    return uData.getInt(this.U47);
                case (base+17):
                    return uData.getInt(this.U48);
                case (base+18):
                    return uData.getInt(this.U49);
                case (base+19):
                    return uData.getInt(this.U50);
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
                    this.U33 = uData.getByte((Short) value);
                    break;
                case (base+3):
                    this.U34 = uData.getByte((Short) value);
                    break;
                case (base+4):
                    this.U35 = uData.getByte((Short) value);
                    break;
                case (base+5):
                    this.U36 = uData.getByte((Short) value);
                    break;
                case (base+6):
                    this.U37 = uData.getByte((Short) value);
                    break;
                case (base+7):
                    this.U38 = uData.getByte((Short) value);
                    break;
                case (base+8):
                    this.U39 = uData.getByte((Short) value);
                    break;
                case (base+9):
                    this.U40 = uData.getByte((Short) value);
                    break;
                case (base+10):
                    this.U41 = uData.getByte((Short) value);
                    break;
                case (base+11):
                    this.U42 = uData.getByte((Short) value);
                    break;
                case (base+12):
                    this.U43 = uData.getByte((Short) value);
                    break;
                case (base+13):
                    this.U44 = uData.getByte((Short) value);
                    break;
                case (base+14):
                    this.U45 = uData.getByte((Short) value);
                    break;
                case (base+15):
                    this.U46 = uData.getByte((Short) value);
                    break;
                case (base+16):
                    this.U47 = uData.getShort((Integer)value);
                    break;
                case (base+17):
                    this.U48 = uData.getShort((Integer)value);
                    break;
                case (base+18):
                    this.U49 = uData.getShort((Integer)value);
                    break;
                case (base+19):
                    this.U50 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
