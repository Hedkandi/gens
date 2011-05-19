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
public final class iffSetItem extends iffBase {
    
    // base should be equal to iffBase.getColNum()
    private static final int base = iffBase.base;
    public int numRef = 0;
    public int refItem1 = 0;
    public int refItem2 = 0;
    public int refItem3 = 0;
    public int refItem4 = 0;
    public int refItem5 = 0;
    public int refItem6 = 0;
    public int refItem7 = 0;
    public int refItem8 = 0;
    public int refItem9 = 0;
    public int refItem10 = 0;
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
    public short U43 = 0; 
    public short U44 = 0; 
    public short U45 = 0; 
    public short U46 = 0; 
    public short U47 = 0; 
    String[] colNames = new String[] {  "numRef",
                                        "Ref1",
                                        "Ref2",
                                        "Ref3",
                                        "Ref4",
                                        "Ref5",
                                        "Ref6",
                                        "Ref7",
                                        "Ref8",
                                        "Ref9",
                                        "Ref10",
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
    
    public iffSetItem(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffSetItem() {
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
            numRef = uData.getInt(new byte[]{inData[144], inData[145], inData[146], inData[147]});
            refItem1 = uData.getInt(new byte[]{inData[148], inData[149], inData[150], inData[151]});
            refItem2 = uData.getInt(new byte[]{inData[152], inData[153], inData[154], inData[155]});
            refItem3 = uData.getInt(new byte[]{inData[156], inData[157], inData[158], inData[159]});
            refItem4 = uData.getInt(new byte[]{inData[160], inData[161], inData[162], inData[163]});
            refItem5 = uData.getInt(new byte[]{inData[164], inData[165], inData[166], inData[167]});
            refItem6 = uData.getInt(new byte[]{inData[168], inData[169], inData[170], inData[171]});
            refItem7 = uData.getInt(new byte[]{inData[172], inData[173], inData[174], inData[175]});
            refItem8 = uData.getInt(new byte[]{inData[176], inData[177], inData[178], inData[179]});
            refItem9 = uData.getInt(new byte[]{inData[180], inData[181], inData[182], inData[183]});
            refItem10 = uData.getInt(new byte[]{inData[184], inData[185], inData[186], inData[187]});
            Amount = uData.getShort(new byte[]{inData[188], inData[189]});
            U33 = uData.getShort(new byte[]{inData[190], inData[191]});
            U34 = uData.getShort(new byte[]{inData[192], inData[193]});
            U35 = uData.getShort(new byte[]{inData[194], inData[195]});
            U36 = uData.getShort(new byte[]{inData[196], inData[197]});
            U37 = uData.getShort(new byte[]{inData[198], inData[199]});
            U38 = uData.getShort(new byte[]{inData[200], inData[201]});
            U39 = uData.getShort(new byte[]{inData[202], inData[203]});
            U40 = uData.getShort(new byte[]{inData[204], inData[205]});
            U41 = uData.getShort(new byte[]{inData[206], inData[207]});
            U42 = uData.getShort(new byte[]{inData[208], inData[209]});
            U43 = uData.getShort(new byte[]{inData[210], inData[211]});
            U44 = uData.getShort(new byte[]{inData[212], inData[213]});
            U45 = uData.getShort(new byte[]{inData[214], inData[215]});
            U46 = uData.getShort(new byte[]{inData[216], inData[217]});
            U47 = uData.getShort(new byte[]{inData[218], inData[219]});
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
                    return uData.getLong(this.numRef);
                case (base+1):
                    return uData.getLong(this.refItem1);
                case (base+2):
                    return uData.getLong(this.refItem2);
                case (base+3):
                    return uData.getLong(this.refItem3);
                case (base+4):
                    return uData.getLong(this.refItem4);
                case (base+5):
                    return uData.getLong(this.refItem5);
                case (base+6):
                    return uData.getLong(this.refItem6);
                case (base+7):
                    return uData.getLong(this.refItem7);
                case (base+8):
                    return uData.getLong(this.refItem8);
                case (base+9):
                    return uData.getLong(this.refItem9);
                case (base+10):
                    return uData.getLong(this.refItem10);
                case (base+11):
                    return uData.getInt(this.Amount);
                case (base+12):
                    return uData.getInt(this.U33);
                case (base+13):
                    return uData.getInt(this.U34);
                case (base+14):
                    return uData.getInt(this.U35);
                case (base+15):
                    return uData.getInt(this.U36);
                case (base+16):
                    return uData.getInt(this.U37);
                case (base+17):
                    return uData.getInt(this.U38);
                case (base+18):
                    return uData.getInt(this.U39);
                case (base+19):
                    return uData.getInt(this.U40);
                case (base+20):
                    return uData.getInt(this.U41);
                case (base+21):
                    return uData.getInt(this.U42);
                case (base+22):
                    return uData.getInt(this.U43);
                case (base+23):
                    return uData.getInt(this.U44);
                case (base+24):
                    return uData.getInt(this.U45);
                case (base+25):
                    return uData.getInt(this.U46);
                case (base+26):
                    return uData.getInt(this.U47);
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
                    this.numRef = uData.getInt((Long)value);
                    break;
                case (base+1):
                    this.refItem1 = uData.getInt((Long)value);
                    break;
                case (base+2):
                    this.refItem2 = uData.getInt((Long)value);
                    break;
                case (base+3):
                    this.refItem3 = uData.getInt((Long)value);
                    break;
                case (base+4):
                    this.refItem4 = uData.getInt((Long)value);
                    break;
                case (base+5):
                    this.refItem5 = uData.getInt((Long)value);
                    break;
                case (base+6):
                    this.refItem6 = uData.getInt((Long)value);
                    break;
                case (base+7):
                    this.refItem7 = uData.getInt((Long)value);
                    break;
                case (base+8):
                    this.refItem8 = uData.getInt((Long)value);
                    break;
                case (base+9):
                    this.refItem9 = uData.getInt((Long)value);
                    break;
                case (base+10):
                    this.refItem10 = uData.getInt((Long)value);
                    break;
                case (base+11):
                    this.Amount = uData.getShort((Integer)value);
                    break;
                case (base+12):
                    this.U33 = uData.getShort((Integer)value);
                    break;
                case (base+13):
                    this.U34 = uData.getShort((Integer)value);
                    break;
                case (base+14):
                    this.U35 = uData.getShort((Integer)value);
                    break;
                case (base+15):
                    this.U36 = uData.getShort((Integer)value);
                    break;
                case (base+16):
                    this.U37 = uData.getShort((Integer)value);
                    break;
                case (base+17):
                    this.U38 = uData.getShort((Integer)value);
                    break;
                case (base+18):
                    this.U39 = uData.getShort((Integer)value);
                    break;
                case (base+19):
                    this.U40 = uData.getShort((Integer)value);
                    break;
                case (base+20):
                    this.U41 = uData.getShort((Integer)value);
                    break;
                case (base+21):
                    this.U42 = uData.getShort((Integer)value);
                    break;
                case (base+22):
                    this.U43 = uData.getShort((Integer)value);
                    break;
                case (base+23):
                    this.U44 = uData.getShort((Integer)value);
                    break;
                case (base+24):
                    this.U45 = uData.getShort((Integer)value);
                    break;
                case (base+25):
                    this.U46 = uData.getShort((Integer)value);
                    break;
                case (base+26):
                    this.U47 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
