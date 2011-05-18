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
                case 32:
                    return this.Sprite2Name;
                case 33:
                    return uData.getInt(this.Amount);
                case 34:
                    return uData.getShort(this.U33);
                case 35:
                    return uData.getShort(this.U34);
                case 36:
                    return uData.getShort(this.U35);
                case 37:
                    return uData.getShort(this.U36);
                case 38:
                    return uData.getShort(this.U37);
                case 39:
                    return uData.getShort(this.U38);
                case 40:
                    return uData.getShort(this.U39);
                case 41:
                    return uData.getShort(this.U40);
                case 42:
                    return uData.getShort(this.U41);
                case 43:
                    return uData.getShort(this.U42);
                case 44:
                    return uData.getShort(this.U43);
                case 45:
                    return uData.getShort(this.U44);
                case 46:
                    return uData.getShort(this.U45);
                case 47:
                    return uData.getShort(this.U46);
                case 48:
                    return uData.getInt(this.U47);
                case 49:
                    return uData.getInt(this.U48);
                case 50:
                    return uData.getInt(this.U49);
                case 51:
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
                case 32:
                    this.Sprite2Name = (String)value;
                    break;
                case 33:
                    this.Amount = uData.getShort((Integer)value);
                    break;
                case 34:
                    this.U33 = uData.getByte((Short) value);
                    break;
                case 35:
                    this.U34 = uData.getByte((Short) value);
                    break;
                case 36:
                    this.U35 = uData.getByte((Short) value);
                    break;
                case 37:
                    this.U36 = uData.getByte((Short) value);
                    break;
                case 38:
                    this.U37 = uData.getByte((Short) value);
                    break;
                case 39:
                    this.U38 = uData.getByte((Short) value);
                    break;
                case 40:
                    this.U39 = uData.getByte((Short) value);
                    break;
                case 41:
                    this.U40 = uData.getByte((Short) value);
                    break;
                case 42:
                    this.U41 = uData.getByte((Short) value);
                    break;
                case 43:
                    this.U42 = uData.getByte((Short) value);
                    break;
                case 44:
                    this.U43 = uData.getByte((Short) value);
                    break;
                case 45:
                    this.U44 = uData.getByte((Short) value);
                    break;
                case 46:
                    this.U45 = uData.getByte((Short) value);
                    break;
                case 47:
                    this.U46 = uData.getByte((Short) value);
                    break;
                case 48:
                    this.U47 = uData.getShort((Integer)value);
                    break;
                case 49:
                    this.U48 = uData.getShort((Integer)value);
                    break;
                case 50:
                    this.U49 = uData.getShort((Integer)value);
                    break;
                case 51:
                    this.U50 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
