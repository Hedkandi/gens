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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hedkandi
 */
public final class iffClub extends iffBase {
    public String Sprite2Name = "";
    public short clubNum = 0;
    public short U33 = 0;
    public short U34 = 0;
    public short U35 = 0;
    public short U36 = 0;
    String[] colNames = new String[] {  "Icon2?",
                                        "Club #",
                                        "COM1?",
                                        "COM2?",
                                        "COM3?",
                                        "COM4?"};
    public iffClub(byte[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffClub(String[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffClub() {
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
    public void getItem(String[] inData) {
        super.getItem(inData);
        Sprite2Name = inData[32];
        clubNum = uData.getShort(Integer.parseInt(inData[33]));
        U33 = uData.getShort(Integer.parseInt(inData[34]));
        U34 = uData.getShort(Integer.parseInt(inData[35]));
        U35 = uData.getShort(Integer.parseInt(inData[36]));
        U36 = uData.getShort(Integer.parseInt(inData[37]));
    }

    @Override
    public void getItem(byte[] inData) {
        try {
            super.getItem(inData);
            Sprite2Name = uData.getString(new ByteArrayInputStream(inData, 144, 40));
            clubNum = uData.getShort(new byte[]{inData[184], inData[185]});
            U33 = uData.getShort(new byte[]{inData[186], inData[187]});
            U33 = uData.getShort(new byte[]{inData[188], inData[189]});
            U34 = uData.getShort(new byte[]{inData[190], inData[191]});
            U35 = uData.getShort(new byte[]{inData[192], inData[193]});
            U36 = uData.getShort(new byte[]{inData[194], inData[195]});
        } catch (IOException ex) {
            Logger.getLogger(iffClub.class.getName()).log(Level.SEVERE, null, ex);
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
                return this.Sprite2Name;
            case 33:
                return uData.getInt(this.clubNum);
            case 34:
                return uData.getInt(this.U33);
            case 35:
                return uData.getInt(this.U34);
            case 36:
                return uData.getInt(this.U35);
            case 37:
                return uData.getInt(this.U36);
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
                this.Sprite2Name = (String)value;
                break;
            case 33:
                this.clubNum = uData.getShort((Integer)value);
                break;
            case 34:
                this.U33 = uData.getShort((Integer)value);
                break;
            case 35:
                this.U34 = uData.getShort((Integer)value);
                break;
            case 36:
                this.U35 = uData.getShort((Integer)value);
                break;
            case 37:
                this.U36 = uData.getShort((Integer)value);
                break;
        }
    }
}
