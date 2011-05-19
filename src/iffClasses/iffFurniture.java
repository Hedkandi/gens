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
public final class iffFurniture extends iffBase {
    
    // base should be equal to iffBase.getColNum()
    private static final int base = iffBase.base;
    public String Sprite2Name = ""; 
    public short Amount = 0; 
    public byte U33 = 0;
    public byte U60 = 0;
    public short U34 = 0; 
    public short U35 = 0; 
    public short U36 = 0; 
    public short U37 = 0; 
    public byte U38 = 0; 
    public byte U39 = 0; 
    public byte U40 = 0; 
    public byte U41 = 0; 
    public byte U42 = 0; 
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
    public byte U53 = 0; 
    public String Sprite3Name = ""; 
    public String Sprite4Name = ""; 
    public String Sprite5Name = ""; 
    public String Sprite6Name = ""; 
    public String Sprite7Name = ""; 
    public String Sprite8Name = ""; 
    public short U54 = 0; 
    public short U55 = 0; 
    public short U56 = 0; 
    public short U57 = 0; 
    public short U58 = 0; 
    public short U59 = 0; 
    String[] colNames = new String[] {  "Icon2?",
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

    public iffFurniture(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffFurniture() {
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
            U60 = inData[187];
            U34 = uData.getShort(new byte[]{inData[188], inData[189]});
            U35 = uData.getShort(new byte[]{inData[190], inData[191]});
            U36 = uData.getShort(new byte[]{inData[192], inData[193]});
            U37 = uData.getShort(new byte[]{inData[194], inData[195]});
            U38 = inData[196];
            U39 = inData[197];
            U40 = inData[198];
            U41 = inData[199];
            U42 = inData[200];
            U43 = inData[201];
            U44 = inData[202];
            U45 = inData[203];
            U46 = inData[204];
            U47 = inData[205];
            U48 = inData[206];
            U49 = inData[207];
            U50 = inData[208];
            U51 = inData[209];
            U52 = inData[210];
            U53 = inData[211];
            Sprite3Name = uData.getString(new ByteArrayInputStream(inData, 212, uData.stringLength));
            Sprite4Name = uData.getString(new ByteArrayInputStream(inData, 252, uData.stringLength));
            Sprite5Name = uData.getString(new ByteArrayInputStream(inData, 292, uData.stringLength));
            Sprite6Name = uData.getString(new ByteArrayInputStream(inData, 332, uData.stringLength));
            Sprite7Name = uData.getString(new ByteArrayInputStream(inData, 372, uData.stringLength));
            Sprite8Name = uData.getString(new ByteArrayInputStream(inData, 412, uData.stringLength));
            U54 = uData.getShort(new byte[]{inData[452], inData[453]});
            U55 = uData.getShort(new byte[]{inData[454], inData[455]});
            U56 = uData.getShort(new byte[]{inData[456], inData[457]});
            U57 = uData.getShort(new byte[]{inData[458], inData[459]});
            U58 = uData.getShort(new byte[]{inData[460], inData[461]});
            U59 = uData.getShort(new byte[]{inData[462], inData[463]});
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
                    return uData.getShort(this.U60);
                case (base+4):
                    return uData.getInt(this.U34);
                case (base+5):
                    return uData.getInt(this.U35);
                case (base+6):
                    return uData.getInt(this.U36);
                case (base+7):
                    return uData.getInt(this.U37);
                case (base+8):
                    return uData.getShort(this.U38);
                case (base+9):
                    return uData.getShort(this.U39);
                case (base+10):
                    return uData.getShort(this.U40);
                case (base+11):
                    return uData.getShort(this.U41);
                case (base+12):
                    return uData.getShort(this.U42);
                case (base+13):
                    return uData.getShort(this.U43);
                case (base+14):
                    return uData.getShort(this.U44);
                case (base+15):
                    return uData.getShort(this.U45);
                case (base+16):
                    return uData.getShort(this.U46);
                case (base+17):
                    return uData.getShort(this.U47);
                case (base+18):
                    return uData.getShort(this.U48);
                case (base+19):
                    return uData.getShort(this.U49);
                case (base+20):
                    return uData.getShort(this.U50);
                case (base+21):
                    return uData.getShort(this.U51);
                case (base+22):
                    return uData.getShort(this.U52);
                case (base+23):
                    return uData.getShort(this.U53);
                case (base+24):
                    return this.Sprite3Name;
                case (base+25):
                    return this.Sprite4Name;
                case (base+26):
                    return this.Sprite5Name;
                case (base+27):
                    return this.Sprite6Name;
                case (base+28):
                    return this.Sprite7Name;
                case (base+29):
                    return this.Sprite8Name;
                case (base+30):
                    return uData.getInt(this.U54);
                case (base+31):
                    return uData.getInt(this.U55);
                case (base+32):
                    return uData.getInt(this.U56);
                case (base+33):
                    return uData.getInt(this.U57);
                case (base+34):
                    return uData.getInt(this.U58);
                case (base+35):
                    return uData.getInt(this.U59);
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
                    this.U33 = uData.getByte((Short)value);
                    break;
                case (base+3):
                    this.U60 = uData.getByte((Short)value);
                    break;
                case (base+4):
                    this.U34 = uData.getShort((Integer)value);
                    break;
                case (base+5):
                    this.U35 = uData.getShort((Integer)value);
                    break;
                case (base+6):
                    this.U36 = uData.getShort((Integer)value);
                    break;
                case (base+7):
                    this.U37 = uData.getShort((Integer)value);
                    break;
                case (base+8):
                    this.U38 = uData.getByte((Short)value);
                    break;
                case (base+9):
                    this.U39 = uData.getByte((Short)value);
                    break;
                case (base+10):
                    this.U40 = uData.getByte((Short)value);
                    break;
                case (base+11):
                    this.U41 = uData.getByte((Short)value);
                    break;
                case (base+12):
                    this.U42 = uData.getByte((Short)value);
                    break;
                case (base+13):
                    this.U43 = uData.getByte((Short)value);
                    break;
                case (base+14):
                    this.U44 = uData.getByte((Short)value);
                    break;
                case (base+15):
                    this.U45 = uData.getByte((Short)value);
                    break;
                case (base+16):
                    this.U46 = uData.getByte((Short)value);
                    break;
                case (base+17):
                    this.U47 = uData.getByte((Short)value);
                    break;
                case (base+18):
                    this.U48 = uData.getByte((Short)value);
                    break;
                case (base+19):
                    this.U49 = uData.getByte((Short)value);
                    break;
                case (base+20):
                    this.U50 = uData.getByte((Short)value);
                    break;
                case (base+21):
                    this.U51 = uData.getByte((Short)value);
                    break;
                case (base+22):
                    this.U52 = uData.getByte((Short)value);
                    break;
                case (base+23):
                    this.U53 = uData.getByte((Short)value);
                    break;
                case (base+24):
                    this.Sprite3Name = (String)value;
                    break;
                case (base+25):
                    this.Sprite4Name = (String)value;
                    break;
                case (base+26):
                    this.Sprite5Name = (String)value;
                    break;
                case (base+27):
                    this.Sprite6Name = (String)value;
                    break;
                case (base+28):
                    this.Sprite7Name = (String)value;
                    break;
                case (base+29):
                    this.Sprite8Name = (String)value;
                    break;
                case (base+30):
                    this.U54 = uData.getShort((Integer)value);
                    break;
                case (base+31):
                    this.U55 = uData.getShort((Integer)value);
                    break;
                case (base+32):
                    this.U56 = uData.getShort((Integer)value);
                    break;
                case (base+33):
                    this.U57 = uData.getShort((Integer)value);
                    break;
                case (base+34):
                    this.U58 = uData.getShort((Integer)value);
                    break;
                case (base+35):
                    this.U59 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
