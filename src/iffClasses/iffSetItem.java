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
    public int numItems = 0;
    public int Item1 = 0;
    public int Item2 = 0;
    public int Item3 = 0;
    public int Item4 = 0;
    public int Item5 = 0;
    public int Item6 = 0;
    public int Item7 = 0;
    public int Item8 = 0;
    public int Item9 = 0;
    public int Item10 = 0;
    public short numItem1 = 0; 
    public short numItem2 = 0; 
    public short numItem3 = 0; 
    public short numItem4 = 0; 
    public short numItem5 = 0; 
    public short numItem6 = 0; 
    public short numItem7 = 0; 
    public short numItem8 = 0; 
    public short numItem9 = 0; 
    public short numItem10 = 0; 
    public short U42 = 0; 
    public short U43 = 0; 
    public short U44 = 0; 
    public short U45 = 0; 
    public short U46 = 0; 
    public short U47 = 0; 
    String[] colNames = new String[] {  "Number of Items",
                                        "Item 1",
                                        "Item 2",
                                        "Item 3",
                                        "Item 4",
                                        "Item 5",
                                        "Item 6",
                                        "Item 7",
                                        "Item 8",
                                        "Item 9",
                                        "Item 10",
                                        "Item 1 Amount",
                                        "Item 2 Amount",
                                        "Item 3 Amount",
                                        "Item 4 Amount",
                                        "Item 5 Amount",
                                        "Item 6 Amount",
                                        "Item 7 Amount",
                                        "Item 8 Amount",
                                        "Item 9 Amount",
                                        "Item 10 Amount",
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
        colNames[3] = "NA";
        colNames[4] = "charSerial";
    }

    @Override
    public int getColNum() {
        return this.colNames.length;
    }

    @Override
    public void getItem(String[] inData) throws IOException {
        super.getItem(inData);
        numItems = uData.getInt(inData[28]);
        Item1 = uData.getInt(inData[29]);
        Item2 = uData.getInt(inData[30]);
        Item3 = uData.getInt(inData[31]);
        Item4 = uData.getInt(inData[32]);
        Item5 = uData.getInt(inData[33]);
        Item6 = uData.getInt(inData[34]);
        Item7 = uData.getInt(inData[35]);
        Item8 = uData.getInt(inData[36]);
        Item9 = uData.getInt(inData[37]);
        Item10 = uData.getInt(inData[38]);
        numItem1 = uData.getShort(inData[39]);
        numItem2 = uData.getShort(inData[40]);
        numItem3 = uData.getShort(inData[41]);
        numItem4 = uData.getShort(inData[42]);
        numItem5 = uData.getShort(inData[43]);
        numItem6 = uData.getShort(inData[44]);
        numItem7 = uData.getShort(inData[45]);
        numItem8 = uData.getShort(inData[46]);
        numItem9 = uData.getShort(inData[47]);
        numItem10 = uData.getShort(inData[48]);
        U42 = uData.getShort(inData[49]);
        U43 = uData.getShort(inData[50]);
        U44 = uData.getShort(inData[51]);
        U45 = uData.getShort(inData[52]);
        U46 = uData.getShort(inData[53]);
        U47 = uData.getShort(inData[54]);
        //throw new IOException("not done");
    }
    
    @Override
    public void getItem(byte[] inData) throws IOException {
        try {
            super.getItem(inData);
            numItems = uData.getInt(new byte[]{inData[144], inData[145], inData[146], inData[147]});
            Item1 = uData.getInt(new byte[]{inData[148], inData[149], inData[150], inData[151]});
            Item2 = uData.getInt(new byte[]{inData[152], inData[153], inData[154], inData[155]});
            Item3 = uData.getInt(new byte[]{inData[156], inData[157], inData[158], inData[159]});
            Item4 = uData.getInt(new byte[]{inData[160], inData[161], inData[162], inData[163]});
            Item5 = uData.getInt(new byte[]{inData[164], inData[165], inData[166], inData[167]});
            Item6 = uData.getInt(new byte[]{inData[168], inData[169], inData[170], inData[171]});
            Item7 = uData.getInt(new byte[]{inData[172], inData[173], inData[174], inData[175]});
            Item8 = uData.getInt(new byte[]{inData[176], inData[177], inData[178], inData[179]});
            Item9 = uData.getInt(new byte[]{inData[180], inData[181], inData[182], inData[183]});
            Item10 = uData.getInt(new byte[]{inData[184], inData[185], inData[186], inData[187]});
            numItem1 = uData.getShort(new byte[]{inData[188], inData[189]});
            numItem2 = uData.getShort(new byte[]{inData[190], inData[191]});
            numItem3 = uData.getShort(new byte[]{inData[192], inData[193]});
            numItem4 = uData.getShort(new byte[]{inData[194], inData[195]});
            numItem5 = uData.getShort(new byte[]{inData[196], inData[197]});
            numItem6 = uData.getShort(new byte[]{inData[198], inData[199]});
            numItem7 = uData.getShort(new byte[]{inData[200], inData[201]});
            numItem8 = uData.getShort(new byte[]{inData[202], inData[203]});
            numItem9 = uData.getShort(new byte[]{inData[204], inData[205]});
            numItem10 = uData.getShort(new byte[]{inData[206], inData[207]});
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
                    return uData.getLong(this.numItems);
                case (base+1):
                    return uData.getLong(this.Item1);
                case (base+2):
                    return uData.getLong(this.Item2);
                case (base+3):
                    return uData.getLong(this.Item3);
                case (base+4):
                    return uData.getLong(this.Item4);
                case (base+5):
                    return uData.getLong(this.Item5);
                case (base+6):
                    return uData.getLong(this.Item6);
                case (base+7):
                    return uData.getLong(this.Item7);
                case (base+8):
                    return uData.getLong(this.Item8);
                case (base+9):
                    return uData.getLong(this.Item9);
                case (base+10):
                    return uData.getLong(this.Item10);
                case (base+11):
                    return uData.getInt(this.numItem1);
                case (base+12):
                    return uData.getInt(this.numItem2);
                case (base+13):
                    return uData.getInt(this.numItem3);
                case (base+14):
                    return uData.getInt(this.numItem4);
                case (base+15):
                    return uData.getInt(this.numItem5);
                case (base+16):
                    return uData.getInt(this.numItem6);
                case (base+17):
                    return uData.getInt(this.numItem7);
                case (base+18):
                    return uData.getInt(this.numItem8);
                case (base+19):
                    return uData.getInt(this.numItem9);
                case (base+20):
                    return uData.getInt(this.numItem10);
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
                    this.numItems = uData.getInt((Long)value);
                    break;
                case (base+1):
                    this.Item1 = uData.getInt((Long)value);
                    break;
                case (base+2):
                    this.Item2 = uData.getInt((Long)value);
                    break;
                case (base+3):
                    this.Item3 = uData.getInt((Long)value);
                    break;
                case (base+4):
                    this.Item4 = uData.getInt((Long)value);
                    break;
                case (base+5):
                    this.Item5 = uData.getInt((Long)value);
                    break;
                case (base+6):
                    this.Item6 = uData.getInt((Long)value);
                    break;
                case (base+7):
                    this.Item7 = uData.getInt((Long)value);
                    break;
                case (base+8):
                    this.Item8 = uData.getInt((Long)value);
                    break;
                case (base+9):
                    this.Item9 = uData.getInt((Long)value);
                    break;
                case (base+10):
                    this.Item10 = uData.getInt((Long)value);
                    break;
                case (base+11):
                    this.numItem1 = uData.getShort((Integer)value);
                    break;
                case (base+12):
                    this.numItem2 = uData.getShort((Integer)value);
                    break;
                case (base+13):
                    this.numItem3 = uData.getShort((Integer)value);
                    break;
                case (base+14):
                    this.numItem4 = uData.getShort((Integer)value);
                    break;
                case (base+15):
                    this.numItem5 = uData.getShort((Integer)value);
                    break;
                case (base+16):
                    this.numItem6 = uData.getShort((Integer)value);
                    break;
                case (base+17):
                    this.numItem7 = uData.getShort((Integer)value);
                    break;
                case (base+18):
                    this.numItem8 = uData.getShort((Integer)value);
                    break;
                case (base+19):
                    this.numItem9 = uData.getShort((Integer)value);
                    break;
                case (base+20):
                    this.numItem10 = uData.getShort((Integer)value);
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
