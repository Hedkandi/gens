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
public final class iffCard extends iffBase {

    public byte cardType = 0;
    public String Sprite2Name = ""; // 40 bytes - bytes 144-184
    public byte U14 = 0; // 2 bytes - byte 110-111
    public byte U15 = 0;
    public byte U16 = 0; // 2 bytes COM0? - bytes 185-186
    public byte U18 = 0; // 2 bytes COM1? - bytes 187-188
    public byte U20 = 0; // 2 bytes COM2? - bytes 189-190
    public byte U22 = 0;
    public byte U23 = 0;
    public byte U24 = 0;
    public byte U25 = 0;
    public byte U26 = 0; // 2 bytes COM4? - bytes 193-194
    public byte U27 = 0;
    public byte U28 = 0; // 2 bytes COM4? - bytes 193-194
    public String UString1 = ""; // 2 bytes COM4? - bytes 193-194
    public String UString2 = ""; // 2 bytes COM4? - bytes 193-194
    public String UString3 = ""; // 2 bytes COM4? - bytes 193-194
    public short U40 = 0; // 2 bytes COM4? - bytes 193-194
    public short U41 = 0; // 2 bytes COM4? - bytes 193-194
    public short U42 = 0; // 2 bytes COM4? - bytes 193-194
    public short U43 = 0; // 2 bytes COM4? - bytes 193-194
    private byte U17;
    private byte U19;
    private byte U21;
    String[] colNames = new String[] {  "Type",
                                            "Card GFX",
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
                                            "GFX1",
                                            "GFX2",
                                            "GFX3",
                                            "NA",
                                            "NA",
                                            "NA",
                                            "NA"};

    public iffCard(byte[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffCard(String[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffCard() {
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

    public void getItem(String[] inData) {
        super.getItem(inData);
        cardType = uData.getByte(Short.parseShort(inData[32]));
        Sprite2Name = inData[33];
        U14 = uData.getByte(Short.parseShort(inData[34]));
        U15 = uData.getByte(Short.parseShort(inData[35]));
        U16 = uData.getByte(Short.parseShort(inData[36]));
        U17 = uData.getByte(Short.parseShort(inData[37]));
        U18 = uData.getByte(Short.parseShort(inData[38]));
        U19 = uData.getByte(Short.parseShort(inData[39]));
        U20 = uData.getByte(Short.parseShort(inData[40]));
        U21 = uData.getByte(Short.parseShort(inData[41]));
        U22 = uData.getByte(Short.parseShort(inData[42]));
        U23 = uData.getByte(Short.parseShort(inData[43]));
        U24 = uData.getByte(Short.parseShort(inData[44]));
        U25 = uData.getByte(Short.parseShort(inData[45]));
        U26 = uData.getByte(Short.parseShort(inData[46]));
        U27 = uData.getByte(Short.parseShort(inData[47]));
        U28 = uData.getByte(Short.parseShort(inData[48]));
        UString1 = inData[49];
        UString2 = inData[50];
        UString3 = inData[51];
        U40 = uData.getShort(Integer.parseInt(inData[52]));
        U41 = uData.getShort(Integer.parseInt(inData[53]));
        U42 = uData.getShort(Integer.parseInt(inData[54]));
        U43 = uData.getShort(Integer.parseInt(inData[55]));
    }
    
    public void getItem(byte[] inData) {
        try {
            super.getItem(inData);
            cardType = inData[144];
            Sprite2Name = uData.getString(new ByteArrayInputStream(inData, 145, uData.stringLength));
            U14 = inData[185];
            U15 = inData[186];
            U16 = inData[187];
            U17 = inData[188];
            U18 = inData[189];
            U19 = inData[190];
            U20 = inData[191];
            U21 = inData[192];
            U22 = inData[193];
            U23 = inData[194];
            U24 = inData[195];
            U25 = inData[196];
            U26 = inData[197];
            U27 = inData[198];
            U28 = inData[199];
            UString1 = uData.getString(new ByteArrayInputStream(inData, 200, uData.stringLength));
            UString2 = uData.getString(new ByteArrayInputStream(inData, 240, uData.stringLength));
            UString3 = uData.getString(new ByteArrayInputStream(inData, 280, uData.stringLength));
            U40 = uData.getShort(new byte[]{inData[320], inData[321]});
            U41 = uData.getShort(new byte[]{inData[322], inData[323]});
            U42 = uData.getShort(new byte[]{inData[324], inData[325]});
            U43 = uData.getShort(new byte[]{inData[326], inData[327]});
        } catch (IOException ex) {
            Logger.getLogger(iffCard.class.getName()).log(Level.SEVERE, null, ex);
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
                return uData.getShort(this.cardType);
            case 33:
                return this.Sprite2Name;
            case 34:
                return uData.getShort(this.U14);
            case 35:
                return uData.getShort(this.U15);
            case 36:
                return uData.getShort(this.U16);
            case 37:
                return uData.getShort(this.U17);
            case 38:
                return uData.getShort(this.U18);
            case 39:
                return uData.getShort(this.U19);
            case 40:
                return uData.getShort(this.U20);
            case 41:
                return uData.getShort(this.U21);
            case 42:
                return uData.getShort(this.U22);
            case 43:
                return uData.getShort(this.U23);
            case 44:
                return uData.getShort(this.U24);
            case 45:
                return uData.getShort(this.U25);
            case 46:
                return uData.getShort(this.U26);
            case 47:
                return uData.getShort(this.U27);
            case 48:
                return uData.getShort(this.U28);
            case 49:
                return this.UString1;
            case 50:
                return this.UString2;
            case 51:
                return this.UString3;
            case 52:
                return uData.getInt(this.U40);
            case 53:
                return uData.getInt(this.U41);
            case 54:
                return uData.getInt(this.U42);
            case 55:
                return uData.getInt(this.U43);
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
                this.cardType = uData.getByte((Short)value);
                break;
            case 33:
                this.Sprite2Name = (String)value;
                break;
            case 34:
                this.U14 = uData.getByte((Short)value);
                break;
            case 35:
                this.U16 = uData.getByte((Short)value);
                break;
            case 36:
                this.U18 = uData.getByte((Short)value);
                break;
            case 37:
                this.U19 = uData.getByte((Short)value);
                break;
            case 38:
                this.U20 = uData.getByte((Short)value);
                break;
            case 39:
                this.U21 = uData.getByte((Short)value);
                break;
            case 40:
                this.U22 = uData.getByte((Short)value);
                break;
            case 41:
                this.U23 = uData.getByte((Short)value);
                break;
            case 42:
                this.U24 = uData.getByte((Short)value);
                break;
            case 43:
                this.U25 = uData.getByte((Short)value);
                break;
            case 44:
                this.U26 = uData.getByte((Short)value);
                break;
            case 45:
                this.U27 = uData.getByte((Short)value);
                break;
            case 46:
                this.U28 = uData.getByte((Short)value);
                break;
            case 47:
                this.UString1 = (String)value;
                break;
            case 48:
                this.UString2 = (String)value;
                break;
            case 49:
                this.UString3 = (String)value;
                break;
            case 50:
                this.U40 = uData.getShort((Integer)value);
                break;
            case 51:
                this.U41 = uData.getShort((Integer)value);
                break;
            case 52:
                this.U42 = uData.getShort((Integer)value);
                break;
            case 53:
                this.U43 = uData.getShort((Integer)value);
                break;
        }
    }
}
