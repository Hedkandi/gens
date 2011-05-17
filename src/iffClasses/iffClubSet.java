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
public final class iffClubSet extends iffBase {
    
    public int clubWood = 0; // 40 bytes - bytes 144-184
    public int clubIron = 0; // 40 bytes - bytes 144-184
    public int clubWedge = 0; // 40 bytes - bytes 144-184
    public int clubPutter = 0; // 40 bytes - bytes 144-184
    public short initPower = 0; // 2 bytes COM0? - bytes 185-186
    public short initControl = 0; // 2 bytes COM1? - bytes 187-188
    public short initAccuracy = 0; // 2 bytes COM2? - bytes 189-190
    public short initSpin = 0; // 2 bytes COM3? - bytes 191-192
    public short initCurve = 0; // 2 bytes COM4? - bytes 193-194
    public short maxPower = 0; // 2 bytes COM4? - bytes 193-194
    public short maxControl = 0; // 2 bytes COM4? - bytes 193-194
    public short maxAccuracy = 0; // 2 bytes COM4? - bytes 193-194
    public short maxSpin = 0; // 2 bytes COM4? - bytes 193-194
    public short maxCurve = 0; // 2 bytes COM4? - bytes 193-194
    String[] colNames = new String[] {  "Wood Club",
                                        "Iron Club",
                                        "Wedge Club",
                                        "Putter Club",
                                        "Init Power",
                                        "Init Control",
                                        "Init Accuracy",
                                        "Init Spin",
                                        "Init Curve",
                                        "Max Power",
                                        "Max Control",
                                        "Max Accuracy",
                                        "Max Spin",
                                        "Max Curve"};


    //public short U38 = -1; // 2 bytes - bytes 195-196

    public iffClubSet(byte[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffClubSet() {
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
            clubWood = uData.getInt(new byte[]{inData[144], inData[145], inData[146], inData[147]});
            clubIron = uData.getInt(new byte[]{inData[148], inData[149], inData[150], inData[151]});
            clubWedge = uData.getInt(new byte[]{inData[152], inData[153], inData[154], inData[155]});
            clubPutter = uData.getInt(new byte[]{inData[156], inData[157], inData[158], inData[159]});
            initPower = uData.getShort(new byte[]{inData[160], 0x0});
            initControl = uData.getShort(new byte[]{inData[162], 0x0});
            initAccuracy = uData.getShort(new byte[]{inData[164], 0x0});
            initSpin = uData.getShort(new byte[]{inData[166], 0x0});
            initCurve = uData.getShort(new byte[]{inData[168], 0x0});
            maxPower = uData.getShort(new byte[]{inData[170], 0x0});
            maxControl = uData.getShort(new byte[]{inData[172], 0x0});
            maxAccuracy = uData.getShort(new byte[]{inData[174], 0x0});
            maxSpin = uData.getShort(new byte[]{inData[176], 0x0});
            maxCurve = uData.getShort(new byte[]{inData[178], 0x0});
        } catch (IOException ex) {
            Logger.getLogger(iffClubSet.class.getName()).log(Level.SEVERE, null, ex);
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
                return uData.getLong(this.clubWood);
            case 33:
                return uData.getLong(this.clubIron);
            case 34:
                return uData.getLong(this.clubWedge);
            case 35:
                return uData.getLong(this.clubPutter);
            case 36:
                return uData.getInt(this.initPower);
            case 37:
                return uData.getInt(this.initControl);
            case 38:
                return uData.getInt(this.initAccuracy);
            case 39:
                return uData.getInt(this.initSpin);
            case 40:
                return uData.getInt(this.initCurve);
            case 41:
                return uData.getInt(this.maxPower);
            case 42:
                return uData.getInt(this.maxControl);
            case 43:
                return uData.getInt(this.maxAccuracy);
            case 44:
                return uData.getInt(this.maxSpin);
            case 45:
                return uData.getInt(this.maxCurve);
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
                this.clubWood = uData.getInt((Long)value);
                break;
            case 33:
                this.clubIron = uData.getInt((Long)value);
                break;
            case 34:
                this.clubWedge = uData.getInt((Long)value);
                break;
            case 35:
                this.clubPutter = uData.getInt((Long)value);
                break;
            case 36:
                this.initPower = uData.getShort((Integer)value);
                break;
            case 37:
                this.initControl = uData.getShort((Integer)value);
                break;
            case 38:
                this.initAccuracy = uData.getShort((Integer)value);
                break;
            case 39:
                this.initSpin = uData.getShort((Integer)value);
                break;
            case 40:
                this.initCurve = uData.getShort((Integer)value);
                break;
            case 41:
                this.maxPower = uData.getShort((Integer)value);
                break;
            case 42:
                this.maxControl = uData.getShort((Integer)value);
                break;
            case 43:
                this.maxAccuracy = uData.getShort((Integer)value);
                break;
            case 44:
                this.maxSpin = uData.getShort((Integer)value);
                break;
            case 45:
                this.maxCurve = uData.getShort((Integer)value);
                break;
        }
    }
}
