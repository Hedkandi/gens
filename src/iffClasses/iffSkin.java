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
public class iffSkin extends iffBase {
    public String Sprite2Name = ""; 
    public short Amount = 0; 
    public byte U33 = 0;
    public byte U34 = 0;
    public byte U35 = 0;
    public byte U36 = 0;
    public byte U37 = 0;
    public byte U38 = 0;
    public byte U39 = 0;
    public byte U40 = 0;
    public byte U41 = 0;
    public byte U42 = 0; 
    public byte U43 = 0;
    public byte U44 = 0;
    public byte U45 = 0;
    public byte U46 = 0;
    public short U47 = 0;
    public short U48 = 0; 
    public short U49 = 0;
    public short U50 = 0; 
    String[] colNames = new String[] {  "Icon2?",
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
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA"};

    public iffSkin(byte[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffSkin() {
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
            Sprite2Name = uData.getString(new ByteArrayInputStream(inData, 144, uData.stringLength));
            Amount = uData.getShort(new byte[]{inData[184], inData[185]});
            U33 = inData[186];
            U34 = inData[187];
            U35 = inData[188];
            U36 = inData[189];
            U37 = inData[190];
            U38 = inData[191];
            U39 = inData[192];
            U40 = inData[193];
            U41 = inData[194];
            U42 = inData[195];
            U43 = inData[196];
            U44 = inData[197];
            U45 = inData[198];
            U46 = inData[199];
            U47 = uData.getShort(new byte[]{inData[200], inData[201]});
            U48 = uData.getShort(new byte[]{inData[202], inData[203]});
            U49 = uData.getShort(new byte[]{inData[204], inData[205]});
            U50 = uData.getShort(new byte[]{inData[206], inData[207]});
        } catch (IOException ex) {
            Logger.getLogger(iffSkin.class.getName()).log(Level.SEVERE, null, ex);
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
                return uData.getInt(this.Amount);
            case 34:
                return uData.getShort(this.U33);
            case 35:
                return uData.getShort(this.U34);
            case 36:
                return uData.getShort(this.U35);
            case 37:
                return uData.getShort(this.U36);
            case 38:
                return uData.getShort(this.U37);
            case 39:
                return uData.getShort(this.U38);
            case 40:
                return uData.getShort(this.U39);
            case 41:
                return uData.getShort(this.U40);
            case 42:
                return uData.getShort(this.U41);
            case 43:
                return uData.getShort(this.U42);
            case 44:
                return uData.getShort(this.U43);
            case 45:
                return uData.getShort(this.U44);
            case 46:
                return uData.getShort(this.U45);
            case 47:
                return uData.getShort(this.U46);
            case 48:
                return uData.getInt(this.U47);
            case 49:
                return uData.getInt(this.U48);
            case 50:
                return uData.getInt(this.U49);
            case 51:
                return uData.getInt(this.U50);
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
                this.Amount = uData.getShort((Integer)value);
                break;
            case 34:
                this.U33 = uData.getByte((Short) value);
                break;
            case 35:
                this.U34 = uData.getByte((Short) value);
                break;
            case 36:
                this.U35 = uData.getByte((Short) value);
                break;
            case 37:
                this.U36 = uData.getByte((Short) value);
                break;
            case 38:
                this.U37 = uData.getByte((Short) value);
                break;
            case 39:
                this.U38 = uData.getByte((Short) value);
                break;
            case 40:
                this.U39 = uData.getByte((Short) value);
                break;
            case 41:
                this.U40 = uData.getByte((Short) value);
                break;
            case 42:
                this.U41 = uData.getByte((Short) value);
                break;
            case 43:
                this.U42 = uData.getByte((Short) value);
                break;
            case 44:
                this.U43 = uData.getByte((Short) value);
                break;
            case 45:
                this.U44 = uData.getByte((Short) value);
                break;
            case 46:
                this.U45 = uData.getByte((Short) value);
                break;
            case 47:
                this.U46 = uData.getByte((Short) value);
                break;
            case 48:
                this.U47 = uData.getShort((Integer)value);
                break;
            case 49:
                this.U48 = uData.getShort((Integer)value);
                break;
            case 50:
                this.U49 = uData.getShort((Integer)value);
                break;
            case 51:
                this.U50 = uData.getShort((Integer)value);
                break;
        }
    }
}
