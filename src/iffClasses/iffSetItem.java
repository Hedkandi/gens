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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hedkandi
 */
public class iffSetItem extends iffBase {
    
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
        getItem(inData);
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

    public int getColNum() {
        return this.colNames.length;
    }

    @Override
    public void getItem(byte[] inData) {
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
            Logger.getLogger(iffSetItem.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Object getValue(int colIndex) {
        switch (colIndex) {
            case 0:
                return this.isValid;
            case 1:
                return uData.getLong(this.ItemID);
            case 2:
                return this.ItemName;
            case 3:
                return uData.getShort(this.lvlReq);
            case 4:
                return this.Icon;
            case 5:
                return uData.getShort(this.U2);
            case 6:
                return uData.getShort(this.U3);
            case 7:
                return uData.getShort(this.U4);
            case 8:
                return uData.getLong(this.ItemPrice);
            case 9:
                return uData.getLong(this.DiscountPrice);
            case 10:
                return uData.getLong(this.U7);
            case 11:
                return uData.getShort(this.shopFlag);
            case 12:
                return uData.getShort(this.moneyFlag);
            case 13:
                return uData.getInt(this.U9);
            case 14:
                return uData.getInt(this.U12);
            case 15:
                return uData.getInt(this.U13);
            case 16:
                return uData.getInt(this.fYear);
            case 17:
                return uData.getInt(this.fMonth);
            case 18:
                return uData.getInt(this.fZero);
            case 19:
                return uData.getInt(this.fDay);
            case 20:
                return uData.getInt(this.fHour);
            case 21:
                return uData.getInt(this.fMinute);
            case 22:
                return uData.getInt(this.fSecond);
            case 23:
                return uData.getInt(this.fMSecond);
            case 24:
                return uData.getInt(this.tYear);
            case 25:
                return uData.getInt(this.tMonth);
            case 26:
                return uData.getInt(this.tZero);
            case 27:
                return uData.getInt(this.tDay);
            case 28:
                return uData.getInt(this.tHour);
            case 29:
                return uData.getInt(this.tMinute);
            case 30:
                return uData.getInt(this.tSecond);
            case 31:
                return uData.getInt(this.tMSecond);
            case 32:
                return uData.getLong(this.numRef);
            case 33:
                return uData.getLong(this.refItem1);
            case 34:
                return uData.getLong(this.refItem2);
            case 35:
                return uData.getLong(this.refItem3);
            case 36:
                return uData.getLong(this.refItem4);
            case 37:
                return uData.getLong(this.refItem5);
            case 38:
                return uData.getLong(this.refItem6);
            case 39:
                return uData.getLong(this.refItem7);
            case 40:
                return uData.getLong(this.refItem8);
            case 41:
                return uData.getLong(this.refItem9);
            case 42:
                return uData.getLong(this.refItem10);
            case 43:
                return uData.getInt(this.Amount);
            case 44:
                return uData.getInt(this.U33);
            case 45:
                return uData.getInt(this.U34);
            case 46:
                return uData.getInt(this.U35);
            case 47:
                return uData.getInt(this.U36);
            case 48:
                return uData.getInt(this.U37);
            case 49:
                return uData.getInt(this.U38);
            case 50:
                return uData.getInt(this.U39);
            case 51:
                return uData.getInt(this.U40);
            case 52:
                return uData.getInt(this.U41);
            case 53:
                return uData.getInt(this.U42);
            case 54:
                return uData.getInt(this.U43);
            case 55:
                return uData.getInt(this.U44);
            case 56:
                return uData.getInt(this.U45);
            case 57:
                return uData.getInt(this.U46);
            case 58:
                return uData.getInt(this.U47);
            default:
                return 99;
        }
    }
    
    @Override
    public void setValue(int colIndex, Object value) {
        switch (colIndex) {
            case 0:
                this.isValid = (Boolean)value;
                break;
            case 1:
                this.ItemID = uData.getInt((Long)value);
                break;
            case 2:
                this.ItemName = (String)value;
                break;
            case 3:
                this.lvlReq = uData.getByte((Short)value);
                break;
            case 4:
                this.Icon = (String)value;
                break;
            case 5:
                this.U2 = uData.getByte((Short)value);
                break;
            case 6:
                this.U3 = uData.getByte((Short)value);
                break;
            case 7:
                this.U4 = uData.getByte((Short)value);
                break;
            case 8:
                this.ItemPrice = uData.getInt((Long)value);
                break;
            case 9:
                this.DiscountPrice = uData.getInt((Long)value);
                break;
            case 10:
                this.U7 = uData.getInt((Long)value);
                break;
            case 11:
                this.shopFlag = uData.getByte((Short)value);
                break;
            case 12:
                this.moneyFlag = uData.getByte((Short)value);
                break;
            case 13:
                this.U9 = uData.getShort((Integer)value);
                break;
            case 14:
                this.U12 = uData.getShort((Integer)value);
                break;
            case 15:
                this.U13 = uData.getShort((Integer)value);
                break;
            case 16:
                this.fYear = uData.getShort((Integer)value);
                break;
            case 17:
                this.fMonth = uData.getShort((Integer)value);
                break;
            case 18:
                this.fZero = uData.getShort((Integer)value);
                break;
            case 19:
                this.fDay = uData.getShort((Integer)value);
                break;
            case 20:
                this.fHour = uData.getShort((Integer)value);
                break;
            case 21:
                this.fMinute = uData.getShort((Integer)value);
                break;
            case 22:
                this.fSecond = uData.getShort((Integer)value);
                break;
            case 23:
                this.fMSecond = uData.getShort((Integer)value);
                break;
            case 24:
                this.tYear = uData.getShort((Integer)value);
                break;
            case 25:
                this.tMonth = uData.getShort((Integer)value);
                break;
            case 26:
                this.tZero = uData.getShort((Integer)value);
                break;
            case 27:
                this.tDay = uData.getShort((Integer)value);
                break;
            case 28:
                this.tHour = uData.getShort((Integer)value);
                break;
            case 29:
                this.tMinute = uData.getShort((Integer)value);
                break;
            case 30:
                this.tSecond = uData.getShort((Integer)value);
                break;
            case 31:
                this.tMSecond = uData.getShort((Integer)value);
                break;
            case 33:
                this.numRef = uData.getInt((Long)value);
                break;
            case 34:
                this.refItem1 = uData.getInt((Long)value);
                break;
            case 35:
                this.refItem2 = uData.getInt((Long)value);
                break;
            case 36:
                this.refItem3 = uData.getInt((Long)value);
                break;
            case 37:
                this.refItem4 = uData.getInt((Long)value);
                break;
            case 38:
                this.refItem5 = uData.getInt((Long)value);
                break;
            case 39:
                this.refItem6 = uData.getInt((Long)value);
                break;
            case 40:
                this.refItem7 = uData.getInt((Long)value);
                break;
            case 41:
                this.refItem8 = uData.getInt((Long)value);
                break;
            case 42:
                this.refItem9 = uData.getInt((Long)value);
                break;
            case 43:
                this.refItem10 = uData.getInt((Long)value);
                break;
            case 44:
                this.Amount = uData.getShort((Integer)value);
                break;
            case 45:
                this.U33 = uData.getShort((Integer)value);
                break;
            case 46:
                this.U34 = uData.getShort((Integer)value);
                break;
            case 47:
                this.U35 = uData.getShort((Integer)value);
                break;
            case 48:
                this.U36 = uData.getShort((Integer)value);
                break;
            case 49:
                this.U37 = uData.getShort((Integer)value);
                break;
            case 50:
                this.U38 = uData.getShort((Integer)value);
                break;
            case 51:
                this.U39 = uData.getShort((Integer)value);
                break;
            case 52:
                this.U40 = uData.getShort((Integer)value);
                break;
            case 53:
                this.U41 = uData.getShort((Integer)value);
                break;
            case 54:
                this.U42 = uData.getShort((Integer)value);
                break;
            case 55:
                this.U43 = uData.getShort((Integer)value);
                break;
            case 56:
                this.U44 = uData.getShort((Integer)value);
                break;
            case 57:
                this.U45 = uData.getShort((Integer)value);
                break;
            case 58:
                this.U46 = uData.getShort((Integer)value);
                break;
            case 59:
                this.U47 = uData.getShort((Integer)value);
                break;
        }
    }
}
