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
public final class iffQuestDrop extends iffBase {
    
    // base should be equal to iffBase.getColNum()
    private static final int base = iffBase.base;
    public short U20 = 0;
    public short U21 = 0;
    public short U22 = 0;
    public short U23 = 0;
    public short U24 = 0;
    public short U25 = 0;
    public short U26 = 0;
    public short U27 = 0;
    public short U28 = 0;
    public short U29 = 0;
    public short U30 = 0;
    public short U31 = 0;
    public short U32 = 0;
    public short U44 = 0;
    public short U45 = 0;
    public short U46 = 0;
    public String Sprite2Name = ""; 
    public short Amount = 0; 
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
    public byte U47 = 0;
    public short U48 = 0;
    public short U49 = 0;
    String[] colNames = new String[] {  "NA",
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
                                        "Icon2?",
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
                                        "NA"};
    
    public iffQuestDrop(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffQuestDrop() {
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
            U20 = uData.getShort(new byte[]{inData[144], inData[145]});
            U21 = uData.getShort(new byte[]{inData[146], inData[147]});
            U22 = uData.getShort(new byte[]{inData[148], inData[149]});
            U23 = uData.getShort(new byte[]{inData[150], inData[151]});
            U24 = uData.getShort(new byte[]{inData[152], inData[153]});
            U25 = uData.getShort(new byte[]{inData[154], inData[155]});
            U26 = uData.getShort(new byte[]{inData[156], inData[157]});
            U27 = uData.getShort(new byte[]{inData[158], inData[159]});
            U28 = uData.getShort(new byte[]{inData[160], inData[161]});
            U29 = uData.getShort(new byte[]{inData[162], inData[163]});
            U30 = uData.getShort(new byte[]{inData[164], inData[165]});
            U31 = uData.getShort(new byte[]{inData[166], inData[167]});
            U32 = uData.getShort(new byte[]{inData[168], inData[169]});
            U44 = uData.getShort(new byte[]{inData[170], inData[171]});
            U45 = uData.getShort(new byte[]{inData[172], inData[173]});
            U46 = uData.getShort(new byte[]{inData[174], inData[175]});
            Sprite2Name = uData.getString(new ByteArrayInputStream(inData, 176, 40));
            Amount = uData.getShort(new byte[]{inData[216], inData[217]});
            U33 = uData.getShort(new byte[]{inData[218], inData[219]});
            U34 = uData.getShort(new byte[]{inData[220], inData[221]});
            U35 = uData.getShort(new byte[]{inData[222], inData[223]});
            U36 = uData.getShort(new byte[]{inData[224], inData[225]});
            U37 = uData.getShort(new byte[]{inData[226], inData[227]});
            U38 = uData.getShort(new byte[]{inData[228], inData[229]});
            U39 = uData.getShort(new byte[]{inData[230], inData[231]});
            U40 = uData.getShort(new byte[]{inData[232], inData[233]});
            U41 = uData.getShort(new byte[]{inData[234], inData[235]});
            U42 = uData.getShort(new byte[]{inData[236], inData[237]});
            U43 = inData[238];
            U47 = inData[239];
            U48 = uData.getShort(new byte[]{inData[240], inData[241]});
            U49 = uData.getShort(new byte[]{inData[242], inData[243]});
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
                    return uData.getInt(this.U20);
                case (base+1):
                    return uData.getInt(this.U21);
                case (base+2):
                    return uData.getInt(this.U22);
                case (base+3):
                    return uData.getInt(this.U23);
                case (base+4):
                    return uData.getInt(this.U24);
                case (base+5):
                    return uData.getInt(this.U25);
                case (base+6):
                    return uData.getInt(this.U26);
                case (base+7):
                    return uData.getInt(this.U27);
                case (base+8):
                    return uData.getInt(this.U28);
                case (base+9):
                    return uData.getInt(this.U29);
                case (base+10):
                    return uData.getInt(this.U30);
                case (base+11):
                    return uData.getInt(this.U31);
                case (base+12):
                    return uData.getInt(this.U32);
                case (base+13):
                    return uData.getInt(this.U44);
                case (base+14):
                    return uData.getInt(this.U45);
                case (base+15):
                    return uData.getInt(this.U46);
                case (base+16):
                    return this.Sprite2Name;
                case (base+17):
                    return uData.getInt(this.Amount);
                case (base+18):
                    return uData.getInt(this.U33);
                case (base+19):
                    return uData.getInt(this.U34);
                case (base+20):
                    return uData.getInt(this.U35);
                case (base+21):
                    return uData.getInt(this.U36);
                case (base+22):
                    return uData.getInt(this.U37);
                case (base+23):
                    return uData.getInt(this.U38);
                case (base+24):
                    return uData.getInt(this.U39);
                case (base+25):
                    return uData.getInt(this.U40);
                case (base+26):
                    return uData.getInt(this.U41);
                case (base+27):
                    return uData.getInt(this.U42);
                case (base+28):
                    return uData.getShort(this.U43);
                case (base+29):
                    return uData.getShort(this.U47);
                case (base+30):
                    return uData.getInt(this.U48);
                case (base+31):
                    return uData.getInt(this.U49);
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
                    this.U20 = uData.getShort((Integer)value);
                    break;
                case (base+1):
                    this.U21 = uData.getShort((Integer)value);
                    break;
                case (base+2):
                    this.U22 = uData.getShort((Integer)value);
                    break;
                case (base+3):
                    this.U23 = uData.getShort((Integer)value);
                    break;
                case (base+4):
                    this.U24 = uData.getShort((Integer)value);
                    break;
                case (base+5):
                    this.U25 = uData.getShort((Integer)value);
                    break;
                case (base+6):
                    this.U26 = uData.getShort((Integer)value);
                    break;
                case (base+7):
                    this.U27 = uData.getShort((Integer)value);
                    break;
                case (base+8):
                    this.U28 = uData.getShort((Integer)value);
                    break;
                case (base+9):
                    this.U29 = uData.getShort((Integer)value);
                    break;
                case (base+10):
                    this.U30 = uData.getShort((Integer)value);
                    break;
                case (base+11):
                    this.U31 = uData.getShort((Integer)value);
                    break;
                case (base+12):
                    this.U32 = uData.getShort((Integer)value);
                    break;
                case (base+13):
                    this.U33 = uData.getShort((Integer)value);
                    break;
                case (base+14):
                    this.U44 = uData.getShort((Integer)value);
                    break;
                case (base+15):
                    this.U45 = uData.getShort((Integer)value);
                    break;
                case (base+16):
                    this.U46 = uData.getShort((Integer)value);
                    break;
                case (base+17):
                    this.Sprite2Name = (String)value;
                    break;
                case (base+18):
                    this.Amount = uData.getShort((Integer)value);
                    break;
                case (base+19):
                    this.U33 = uData.getShort((Integer)value);
                    break;
                case (base+20):
                    this.U34 = uData.getShort((Integer)value);
                    break;
                case (base+21):
                    this.U35 = uData.getShort((Integer)value);
                    break;
                case (base+22):
                    this.U36 = uData.getShort((Integer)value);
                    break;
                case (base+23):
                    this.U37 = uData.getShort((Integer)value);
                    break;
                case (base+24):
                    this.U38 = uData.getShort((Integer)value);
                    break;
                case (base+25):
                    this.U39 = uData.getShort((Integer)value);
                    break;
                case (base+26):
                    this.U40 = uData.getShort((Integer)value);
                    break;
                case (base+27):
                    this.U41 = uData.getShort((Integer)value);
                    break;
                case (base+28):
                    this.U42 = uData.getShort((Integer)value);
                    break;
                case (base+29):
                    this.U43 = uData.getByte((Short)value);
                    break;
                case (base+30):
                    this.U47 = uData.getByte((Short)value);
                    break;
                case (base+31):
                    this.U48 = uData.getShort((Integer)value);
                    break;
                case (base+32):
                    this.U49 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
