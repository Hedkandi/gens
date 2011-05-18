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
public final class iffMascot extends iffBase {
    public String Sprite2Name = ""; 
    public String Sprite3Name = ""; 
    public short price1Day = 0; 
    public short U33 = 0; 
    public short U34 = 0; 
    public short U35 = 0; 
    public short U36 = 0; 
    public short U37 = 0; 
    public short U38 = 0; 
    public short U39 = 0; 
    public short U40 = 0; 
    public short U41 = 0; 
    public short U42 = 0; 
    public byte U43 = 0; 
    public byte U44 = 0; 
    public byte U45 = 0; 
    public byte U46 = 0; 
    public byte U47 = 0; 
    public byte U48 = 0; 
    public byte U49 = 0; 
    public byte U50 = 0; 
    public byte U51 = 0; 
    public byte U52 = 0; 
    String[] colNames = new String[] {  "Icon2?",
                                        "JPG",
                                        "Cost 1 Day",
                                        "Cost 15 Days?",
                                        "May be a part of the 15 day cost",
                                        "Cost 30 Days?",
                                        "May be a part of the 30 day cost",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "Pang or Exp multiplier",
                                        "Pang or Exp multiplier",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA"};
    
    public iffMascot(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffMascot() {
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
            Sprite3Name = uData.getString(new ByteArrayInputStream(inData, 184, uData.stringLength));
            price1Day = uData.getShort(new byte[]{inData[224], inData[225]});
            U33 = uData.getShort(new byte[]{inData[226], inData[227]});
            U34 = uData.getShort(new byte[]{inData[228], inData[229]});
            U35 = uData.getShort(new byte[]{inData[230], inData[231]});
            U36 = uData.getShort(new byte[]{inData[232], inData[233]});
            U37 = uData.getShort(new byte[]{inData[234], inData[235]});
            U38 = uData.getShort(new byte[]{inData[236], inData[237]});
            U39 = uData.getShort(new byte[]{inData[238], inData[239]});
            U40 = uData.getShort(new byte[]{inData[240], inData[241]});
            U41 = uData.getShort(new byte[]{inData[242], inData[243]});
            U42 = uData.getShort(new byte[]{inData[244], inData[245]});
            U43 = inData[246];
            U44 = inData[247];
            U45 = inData[248];
            U46 = inData[249];
            U47 = inData[250];
            U48 = inData[251];
            U49 = inData[252];
            U50 = inData[253];
            U51 = inData[254];
            U52 = inData[255];
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
                    return this.Sprite3Name;
                case 34:
                    return uData.getInt(this.price1Day);
                case 35:
                    return uData.getInt(this.U33);
                case 36:
                    return uData.getInt(this.U34);
                case 37:
                    return uData.getInt(this.U35);
                case 38:
                    return uData.getInt(this.U36);
                case 39:
                    return uData.getInt(this.U37);
                case 40:
                    return uData.getInt(this.U38);
                case 41:
                    return uData.getInt(this.U39);
                case 42:
                    return uData.getInt(this.U40);
                case 43:
                    return uData.getInt(this.U41);
                case 44:
                    return uData.getInt(this.U42);
                case 45:
                    return uData.getShort(this.U43);
                case 46:
                    return uData.getShort(this.U44);
                case 47:
                    return uData.getShort(this.U45);
                case 48:
                    return uData.getShort(this.U46);
                case 49:
                    return uData.getShort(this.U47);
                case 50:
                    return uData.getShort(this.U48);
                case 51:
                    return uData.getShort(this.U49);
                case 52:
                    return uData.getShort(this.U50);
                case 53:
                    return uData.getShort(this.U51);
                case 54:
                    return uData.getShort(this.U52);
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
                    this.Sprite3Name = (String)value;
                    break;
                case 34:
                    this.price1Day = uData.getShort((Integer)value);
                    break;
                case 35:
                    this.U33 = uData.getShort((Integer)value);
                    break;
                case 36:
                    this.U34 = uData.getShort((Integer)value);
                    break;
                case 37:
                    this.U35 = uData.getShort((Integer)value);
                    break;
                case 38:
                    this.U36 = uData.getShort((Integer)value);
                    break;
                case 39:
                    this.U37 = uData.getShort((Integer)value);
                    break;
                case 40:
                    this.U38 = uData.getShort((Integer)value);
                    break;
                case 41:
                    this.U39 = uData.getShort((Integer)value);
                    break;
                case 42:
                    this.U40 = uData.getShort((Integer)value);
                    break;
                case 43:
                    this.U41 = uData.getShort((Integer)value);
                    break;
                case 44:
                    this.U42 = uData.getShort((Integer)value);
                    break;
                case 45:
                    this.U43 = uData.getByte((Short)value);
                    break;
                case 46:
                    this.U44 = uData.getByte((Short)value);
                    break;
                case 47:
                    this.U45 = uData.getByte((Short)value);
                    break;
                case 48:
                    this.U46 = uData.getByte((Short)value);
                    break;
                case 49:
                    this.U47 = uData.getByte((Short)value);
                    break;
                case 50:
                    this.U48 = uData.getByte((Short)value);
                    break;
                case 51:
                    this.U49 = uData.getByte((Short)value);
                    break;
                case 52:
                    this.U50 = uData.getByte((Short)value);
                    break;
                case 53:
                    this.U51 = uData.getByte((Short)value);
                    break;
                case 54:
                    this.U52 = uData.getByte((Short)value);
                    break;
            }
        }
    }
}
