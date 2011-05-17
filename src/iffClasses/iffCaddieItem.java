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
public final class iffCaddieItem extends iffBase {
    
    public String GFX1 = ""; // 40 bytes - bytes 144-184
    public String GFX2 = ""; // 40 bytes - bytes 144-184
    public short price1Day = 0; // 2 bytes - byte 110-111
    public short U33 = 0; // 2 bytes COM0? - bytes 185-186
    public short price7Days = 0; // 2 bytes COM1? - bytes 187-188
    public short price30Days = 0; // 2 bytes COM2? - bytes 189-190
    public short Amount = 0; // 2 bytes COM3? - bytes 191-192
    public short U37 = 0; // 2 bytes COM4? - bytes 193-194
    String[] colNames = new String[] {  "GFX1",
                                        "GFX2",
                                        "Price 1 Day",
                                        "NA",
                                        "Price 7 Days",
                                        "Price 30 Days",
                                        "Amount",
                                        "NA"};
    
    public iffCaddieItem(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            Logger.getLogger(iffCaddieItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public iffCaddieItem(String[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffCaddieItem() {
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
        GFX1 = inData[32];
        GFX2 = inData[33];
        price1Day = uData.getShort(Integer.parseInt(inData[34]));
        U33 = uData.getShort(Integer.parseInt(inData[35]));
        price7Days = uData.getShort(Integer.parseInt(inData[36]));
        price30Days = uData.getShort(Integer.parseInt(inData[37]));
        Amount = uData.getShort(Integer.parseInt(inData[38]));
        U37 = uData.getShort(Integer.parseInt(inData[39]));
    }

    @Override
    public void getItem(byte[] inData) throws IOException {
        super.getItem(inData);
        GFX1 = uData.getString(new ByteArrayInputStream(inData,144,40));
        GFX2 = uData.getString(new ByteArrayInputStream(inData,184,40));
        price1Day = uData.getShort(new byte[] {inData[224], inData[225]});
        U33 = uData.getShort(new byte[] {inData[226], inData[227]});
        price7Days = uData.getShort(new byte[] {inData[228], inData[229]});
        price30Days = uData.getShort(new byte[] {inData[230], inData[231]});
        Amount = uData.getShort(new byte[] {inData[232], inData[233]});
        U37 = uData.getShort(new byte[] {inData[234], inData[235]});
    }

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
                return this.GFX1;
            case 33:
                return this.GFX2;
            case 34:
                return uData.getInt(this.price1Day);
            case 35:
                return uData.getInt(this.U33);
            case 36:
                return uData.getInt(this.price7Days);
            case 37:
                return uData.getInt(this.price30Days);
            case 38:
                return uData.getInt(this.Amount);
            case 39:
                return uData.getInt(this.U37);
            default:
                return "&";
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
                this.GFX1 = (String)value;
                break;
            case 33:
                this.GFX2 = (String)value;
                break;
            case 34:
                this.price1Day = uData.getShort((Integer)value);
                break;
            case 35:
                this.U33 = uData.getShort((Integer)value);
                break;
            case 36:
                this.price7Days = uData.getShort((Integer)value);
                break;
            case 37:
                this.price30Days = uData.getShort((Integer)value);
                break;
            case 38:
                this.Amount = uData.getShort((Integer)value);
                break;
            case 39:
                this.U37 = uData.getShort((Integer)value);
                break;
        }
    }
}
