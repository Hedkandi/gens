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
public class iffOfflineShop extends iffBase {
    public int numRef = 0;
    public int ref1 = 0;
    public int ref2 = 0;
    public int ref3 = 0;
    public int ref4 = 0;
    public int ref5 = 0;
    public int ref6 = 0;
    public int ref7 = 0;
    public int ref8 = 0;
    public int ref9 = 0;
    public int ref10 = 0;
    public int ref11 = 0;
    public int ref12 = 0;
    public int ref13 = 0;
    String[] colNames = new String[] {  "Num Refs",
                                        "Ref 1",
                                        "Ref 2",
                                        "Ref 3",
                                        "Ref 4",
                                        "Ref 5",
                                        "Ref 6",
                                        "Ref 7",
                                        "Ref 8",
                                        "Ref 9",
                                        "Ref 10",
                                        "Ref 11",
                                        "Ref 12",
                                        "Ref 13"};

    public iffOfflineShop(byte[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffOfflineShop() {
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
            ref1 = uData.getInt(new byte[]{inData[148], inData[149], inData[150], inData[151]});
            ref2 = uData.getInt(new byte[]{inData[152], inData[153], inData[154], inData[155]});
            ref3 = uData.getInt(new byte[]{inData[156], inData[157], inData[158], inData[159]});
            ref4 = uData.getInt(new byte[]{inData[160], inData[161], inData[162], inData[163]});
            ref5 = uData.getInt(new byte[]{inData[164], inData[165], inData[166], inData[167]});
            ref6 = uData.getInt(new byte[]{inData[168], inData[169], inData[170], inData[171]});
            ref7 = uData.getInt(new byte[]{inData[172], inData[173], inData[174], inData[175]});
            ref8 = uData.getInt(new byte[]{inData[176], inData[177], inData[178], inData[179]});
            ref9 = uData.getInt(new byte[]{inData[180], inData[181], inData[182], inData[183]});
            ref10 = uData.getInt(new byte[]{inData[184], inData[185], inData[186], inData[187]});
            ref11 = uData.getInt(new byte[]{inData[188], inData[189], inData[190], inData[191]});
            ref12 = uData.getInt(new byte[]{inData[192], inData[193], inData[194], inData[195]});
            ref13 = uData.getInt(new byte[]{inData[194], inData[197], inData[198], inData[199]});
        } catch (IOException ex) {
            Logger.getLogger(iffOfflineShop.class.getName()).log(Level.SEVERE, null, ex);
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
                return uData.getLong(this.ref1);
            case 34:
                return uData.getLong(this.ref2);
            case 35:
                return uData.getLong(this.ref3);
            case 36:
                return uData.getLong(this.ref4);
            case 37:
                return uData.getLong(this.ref5);
            case 38:
                return uData.getLong(this.ref6);
            case 39:
                return uData.getLong(this.ref7);
            case 40:
                return uData.getLong(this.ref8);
            case 41:
                return uData.getLong(this.ref9);
            case 42:
                return uData.getLong(this.ref10);
            case 43:
                return uData.getLong(this.ref11);
            case 44:
                return uData.getLong(this.ref12);
            case 45:
                return uData.getLong(this.ref13);
            default:
                return "";
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
            case 32:
                this.numRef = uData.getInt((Long)value);
                break;
            case 33:
                this.ref1 = uData.getInt((Long)value);
                break;
            case 34:
                this.ref2 = uData.getInt((Long)value);
                break;
            case 35:
                this.ref3 = uData.getInt((Long)value);
                break;
            case 36:
                this.ref4 = uData.getInt((Long)value);
                break;
            case 37:
                this.ref6 = uData.getInt((Long)value);
                break;
            case 38:
                this.ref7 = uData.getInt((Long)value);
                break;
            case 39:
                this.ref8 = uData.getInt((Long)value);
                break;
            case 40:
                this.ref9 = uData.getInt((Long)value);
                break;
            case 41:
                this.ref10 = uData.getInt((Long)value);
                break;
            case 42:
                this.ref11 = uData.getInt((Long)value);
                break;
            case 43:
                this.ref12 = uData.getInt((Long)value);
                break;
            case 44:
                this.ref13 = uData.getInt((Long)value);
                break;
        }
    }
}
