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
    
    // base should be equal to iffBase.getColNum()
    private static final int base = iffBase.base;
    public String Sprite2Name = ""; 
    public String Sprite3Name = ""; 
    public short price1Day = 0; 
    public int price15Days = 0; 
    public int price30Days = 0; 
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
                                        "Cost 30 Days?",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "PangUp",
                                        "ExpUp",
                                        "NA",
                                        "Item Slots",
                                        "Message board",
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

    public iffMascot(String[] inData) throws IOException {
        super();
        buildColNames();
        getItem(inData);
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
    public void getItem(String[] inData) throws IOException {
        try {
            super.getItem(inData);
            Sprite2Name = inData[28];
            Sprite3Name = inData[29];
            price1Day = uData.getShort(Integer.parseInt(inData[30]));
            price15Days = uData.getInt(Long.parseLong(inData[31]));
            price30Days = uData.getInt(Long.parseLong(inData[32]));
            U37 = uData.getShort(Integer.parseInt(inData[33]));
            U38 = uData.getShort(Integer.parseInt(inData[34]));
            U39 = uData.getShort(Integer.parseInt(inData[35]));
            U40 = uData.getShort(Integer.parseInt(inData[36]));
            U41 = uData.getShort(Integer.parseInt(inData[37]));
            U42 = uData.getShort(Integer.parseInt(inData[38]));
            U43 = uData.getByte(Short.parseShort(inData[39]));
            U44 = uData.getByte(Short.parseShort(inData[40]));
            U45 = uData.getByte(Short.parseShort(inData[41]));
            U46 = uData.getByte(Short.parseShort(inData[42]));
            U47 = uData.getByte(Short.parseShort(inData[43]));
            U48 = uData.getByte(Short.parseShort(inData[44]));
            U49 = uData.getByte(Short.parseShort(inData[45]));
            U50 = uData.getByte(Short.parseShort(inData[46]));
            U51 = uData.getByte(Short.parseShort(inData[47]));
            U52 = uData.getByte(Short.parseShort(inData[48]));
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }
    
    @Override
    public void getItem(byte[] inData) throws IOException {
        try {
            super.getItem(inData);
            Sprite2Name = uData.getString(new ByteArrayInputStream(inData, 144, uData.stringLength));
            Sprite3Name = uData.getString(new ByteArrayInputStream(inData, 184, uData.stringLength));
            price1Day = uData.getShort(new byte[]{inData[224], inData[225]});
            price15Days = uData.getInt(new byte[]{inData[226], inData[227], inData[228], inData[229]});
            price30Days = uData.getInt(new byte[]{inData[230], inData[231], inData[232], inData[233]});
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
                case base:
                    return this.Sprite2Name;
                case (base+1):
                    return this.Sprite3Name;
                case (base+2):
                    return uData.getInt(this.price1Day);
                case (base+3):
                    return uData.getInt(this.price15Days);
                case (base+4):
                    return uData.getInt(this.price30Days);
                case (base+5):
                    return uData.getInt(this.U37);
                case (base+6):
                    return uData.getInt(this.U38);
                case (base+7):
                    return uData.getInt(this.U39);
                case (base+8):
                    return uData.getInt(this.U40);
                case (base+9):
                    return uData.getInt(this.U41);
                case (base+10):
                    return uData.getInt(this.U42);
                case (base+11):
                    return uData.getShort(this.U43);
                case (base+12):
                    return uData.getShort(this.U44);
                case (base+13):
                    return uData.getShort(this.U45);
                case (base+14):
                    return uData.getShort(this.U46);
                case (base+15):
                    return uData.getShort(this.U47);
                case (base+16):
                    return uData.getShort(this.U48);
                case (base+17):
                    return uData.getShort(this.U49);
                case (base+18):
                    return uData.getShort(this.U50);
                case (base+19):
                    return uData.getShort(this.U51);
                case (base+20):
                    return uData.getShort(this.U52);
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
                    this.Sprite3Name = (String)value;
                    break;
                case (base+2):
                    this.price1Day = uData.getShort((Integer)value);
                    break;
                case (base+3):
                    this.price15Days = uData.getShort((Integer)value);
                    break;
                case (base+4):
                    this.price30Days = uData.getShort((Integer)value);
                    break;
                case (base+5):
                    this.U37 = uData.getShort((Integer)value);
                    break;
                case (base+6):
                    this.U38 = uData.getShort((Integer)value);
                    break;
                case (base+7):
                    this.U39 = uData.getShort((Integer)value);
                    break;
                case (base+8):
                    this.U40 = uData.getShort((Integer)value);
                    break;
                case (base+9):
                    this.U41 = uData.getShort((Integer)value);
                    break;
                case (base+10):
                    this.U42 = uData.getShort((Integer)value);
                    break;
                case (base+11):
                    this.U43 = uData.getByte((Short)value);
                    break;
                case (base+12):
                    this.U44 = uData.getByte((Short)value);
                    break;
                case (base+13):
                    this.U45 = uData.getByte((Short)value);
                    break;
                case (base+14):
                    this.U46 = uData.getByte((Short)value);
                    break;
                case (base+15):
                    this.U47 = uData.getByte((Short)value);
                    break;
                case (base+16):
                    this.U48 = uData.getByte((Short)value);
                    break;
                case (base+17):
                    this.U49 = uData.getByte((Short)value);
                    break;
                case (base+18):
                    this.U50 = uData.getByte((Short)value);
                    break;
                case (base+19):
                    this.U51 = uData.getByte((Short)value);
                    break;
                case (base+20):
                    this.U52 = uData.getByte((Short)value);
                    break;
            }
        }
    }
}
