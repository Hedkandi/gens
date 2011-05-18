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
                case 32:
                    return uData.getInt(this.U20);
                case 33:
                    return uData.getInt(this.U21);
                case 34:
                    return uData.getInt(this.U22);
                case 35:
                    return uData.getInt(this.U23);
                case 36:
                    return uData.getInt(this.U24);
                case 37:
                    return uData.getInt(this.U25);
                case 38:
                    return uData.getInt(this.U26);
                case 39:
                    return uData.getInt(this.U27);
                case 40:
                    return uData.getInt(this.U28);
                case 41:
                    return uData.getInt(this.U29);
                case 42:
                    return uData.getInt(this.U30);
                case 43:
                    return uData.getInt(this.U31);
                case 44:
                    return uData.getInt(this.U32);
                case 45:
                    return uData.getInt(this.U44);
                case 46:
                    return uData.getInt(this.U45);
                case 47:
                    return uData.getInt(this.U46);
                case 48:
                    return this.Sprite2Name;
                case 49:
                    return uData.getInt(this.Amount);
                case 50:
                    return uData.getInt(this.U33);
                case 51:
                    return uData.getInt(this.U34);
                case 52:
                    return uData.getInt(this.U35);
                case 53:
                    return uData.getInt(this.U36);
                case 54:
                    return uData.getInt(this.U37);
                case 55:
                    return uData.getInt(this.U38);
                case 56:
                    return uData.getInt(this.U39);
                case 57:
                    return uData.getInt(this.U40);
                case 58:
                    return uData.getInt(this.U41);
                case 59:
                    return uData.getInt(this.U42);
                case 60:
                    return uData.getShort(this.U43);
                case 61:
                    return uData.getShort(this.U47);
                case 62:
                    return uData.getInt(this.U48);
                case 63:
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
                case 32:
                    this.U20 = uData.getShort((Integer)value);
                    break;
                case 33:
                    this.U21 = uData.getShort((Integer)value);
                    break;
                case 34:
                    this.U22 = uData.getShort((Integer)value);
                    break;
                case 35:
                    this.U23 = uData.getShort((Integer)value);
                    break;
                case 36:
                    this.U24 = uData.getShort((Integer)value);
                    break;
                case 37:
                    this.U25 = uData.getShort((Integer)value);
                    break;
                case 38:
                    this.U26 = uData.getShort((Integer)value);
                    break;
                case 39:
                    this.U27 = uData.getShort((Integer)value);
                    break;
                case 40:
                    this.U28 = uData.getShort((Integer)value);
                    break;
                case 41:
                    this.U29 = uData.getShort((Integer)value);
                    break;
                case 42:
                    this.U30 = uData.getShort((Integer)value);
                    break;
                case 43:
                    this.U31 = uData.getShort((Integer)value);
                    break;
                case 44:
                    this.U32 = uData.getShort((Integer)value);
                    break;
                case 45:
                    this.U33 = uData.getShort((Integer)value);
                    break;
                case 46:
                    this.U44 = uData.getShort((Integer)value);
                    break;
                case 47:
                    this.U45 = uData.getShort((Integer)value);
                    break;
                case 48:
                    this.U46 = uData.getShort((Integer)value);
                    break;
                case 49:
                    this.Sprite2Name = (String)value;
                    break;
                case 50:
                    this.Amount = uData.getShort((Integer)value);
                    break;
                case 51:
                    this.U33 = uData.getShort((Integer)value);
                    break;
                case 52:
                    this.U34 = uData.getShort((Integer)value);
                    break;
                case 53:
                    this.U35 = uData.getShort((Integer)value);
                    break;
                case 54:
                    this.U36 = uData.getShort((Integer)value);
                    break;
                case 55:
                    this.U37 = uData.getShort((Integer)value);
                    break;
                case 56:
                    this.U38 = uData.getShort((Integer)value);
                    break;
                case 57:
                    this.U39 = uData.getShort((Integer)value);
                    break;
                case 58:
                    this.U40 = uData.getShort((Integer)value);
                    break;
                case 59:
                    this.U41 = uData.getShort((Integer)value);
                    break;
                case 60:
                    this.U42 = uData.getShort((Integer)value);
                    break;
                case 61:
                    this.U43 = uData.getByte((Short)value);
                    break;
                case 62:
                    this.U47 = uData.getByte((Short)value);
                    break;
                case 63:
                    this.U48 = uData.getShort((Integer)value);
                    break;
                case 64:
                    this.U49 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
