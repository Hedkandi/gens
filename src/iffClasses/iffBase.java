/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iffClasses;

import gens.uData;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 *
 * @author hedkandi
 * 
 * This structure is a combination of my own "research" along with the thread
 * over at ragezone and some finishing touches by Tsukasa.
 * 
 */
public class iffBase {

    public boolean isValid = false;
    public int ItemID = 0;
    public String itemName = "";
    public byte lvlReq = 0;
    public boolean isMaxLVL = false;
    public String Icon = "";
    public byte U2 = 0;
    public byte U3 = 0;
    public byte U4 = 0;
    public int itemPrice = 0;
    public int DiscountPrice = 0;
    public int UsedPrice = 0;
    public byte moneyFlag = 0;
    public byte shopFlag = 0;
    public byte timeFlag = 0;
    public byte Time = 0;
    public int Point = 0;
    public short fYear = 0;
    public short fMonth = 0;
    public short fZero = 0;
    public short fDay = 0;
    public short fHour = 0;
    public short fMinute = 0;
    public short fSecond = 0;
    public short fMSecond = 0;
    public short tYear = 0;
    public short tMonth = 0;
    public short tZero = 0;
    public short tDay = 0;
    public short tHour = 0;
    public short tMinute = 0;
    public short tSecond = 0;
    public short tMSecond = 0;
    public String[] colNames = new String[] {  "Use",
                                        "ItemID",
                                        "ItemName",
                                        "lvlReq",
                                        "isMaxLVL",
                                        "Icon",
                                        "Not Used",
                                        "Not Used",
                                        "Not Used",
                                        "Price",
                                        "Discount Price",
                                        "Used Price",
                                        "Money Flags",
                                        "Shop Flags",
                                        "Time Flags",
                                        "Time",
                                        "Point",
                                        "From Year",
                                        "From Month",
                                        "From 0",
                                        "From Day",
                                        "From Hour",
                                        "From Minute",
                                        "From Second",
                                        "From Millisecond",
                                        "To Year",
                                        "To Month",
                                        "To 0",
                                        "To Day",
                                        "To Hour",
                                        "To Minute",
                                        "To Second",
                                        "To Millisecond"};

    public iffBase() {
        
    }

    public int getColNum() {
        return this.colNames.length;
    }
    
    public void getItem(String[] inData) {
        try {
            if (inData[0].equals("true")) {
                isValid = true;
            }
            ItemID = uData.getInt(Long.parseLong(inData[1]));
            itemName = inData[2];
            lvlReq = uData.getByte(Short.parseShort(inData[3]));
            if (inData[4].equals("true")) {
                isMaxLVL = true;
            }
            Icon = inData[5];
            U2 = uData.getByte(Short.parseShort(inData[6]));
            U3 = uData.getByte(Short.parseShort(inData[7]));
            U4 = uData.getByte(Short.parseShort(inData[8]));
            itemPrice = uData.getInt(Long.parseLong(inData[9]));
            DiscountPrice = uData.getInt(Long.parseLong(inData[10]));
            UsedPrice = uData.getInt(Long.parseLong(inData[11]));
            moneyFlag = uData.getByte(Short.parseShort(inData[12]));
            shopFlag = uData.getByte(Short.parseShort(inData[13]));
            timeFlag = uData.getByte(Short.parseShort(inData[14]));
            Time = uData.getByte(Short.parseShort(inData[15]));
            Point = uData.getInt(Long.parseLong(inData[16]));
            fYear = uData.getShort(Integer.parseInt(inData[17]));
            fMonth = uData.getShort(Integer.parseInt(inData[18]));
            fZero = uData.getShort(Integer.parseInt(inData[19]));
            fDay = uData.getShort(Integer.parseInt(inData[20]));
            fHour = uData.getShort(Integer.parseInt(inData[21]));
            fMinute = uData.getShort(Integer.parseInt(inData[22]));
            fSecond = uData.getShort(Integer.parseInt(inData[23]));
            fMSecond = uData.getShort(Integer.parseInt(inData[24]));
            tYear = uData.getShort(Integer.parseInt(inData[25]));
            tMonth = uData.getShort(Integer.parseInt(inData[26]));
            tZero = uData.getShort(Integer.parseInt(inData[27]));
            tDay = uData.getShort(Integer.parseInt(inData[28]));
            tHour = uData.getShort(Integer.parseInt(inData[29]));
            tMinute = uData.getShort(Integer.parseInt(inData[30]));
            tSecond = uData.getShort(Integer.parseInt(inData[31]));
            tMSecond = uData.getShort(Integer.parseInt(inData[32]));
        } catch (Exception ex) {
            //throw new IOException("Failed to read base data.");
        }
    }
    
    public void getItem(byte[] inData) throws IOException {
        try {
            isValid = uData.getBool(inData[0]);
            ItemID = uData.getInt(new byte[]{inData[4], inData[5], inData[6], inData[7]});
            itemName = uData.getString(new ByteArrayInputStream(inData, 8, uData.stringLength));
            lvlReq = inData[48];
            isMaxLVL = ((inData[48] & 0x80) == 128);
            Icon = uData.getString(new ByteArrayInputStream(inData, 49, uData.stringLength));
            // Bytes 89-91 isnt used
            U2 = inData[89];
            U3 = inData[90];
            U4 = inData[91];
            itemPrice = uData.getInt(new byte[]{inData[92], inData[93], inData[94], inData[95]});
            DiscountPrice = uData.getInt(new byte[]{inData[96], inData[97], inData[98], inData[99]});
            UsedPrice = uData.getInt(new byte[]{inData[100], inData[101], inData[102], inData[103]});
            moneyFlag = inData[104];
            shopFlag = inData[105];
            timeFlag = inData[106];
            Time = inData[107];
            Point = uData.getInt(new byte[]{inData[108], inData[109], inData[110], inData[111]});
            fYear = uData.getShort(new byte[]{inData[112], inData[113]});
            fMonth = uData.getShort(new byte[]{inData[114], inData[115]});
            fZero = uData.getShort(new byte[]{inData[116], inData[117]});
            fDay = uData.getShort(new byte[]{inData[118], inData[119]});
            fHour = uData.getShort(new byte[]{inData[120], inData[121]});
            fMinute = uData.getShort(new byte[]{inData[122], inData[123]});
            fSecond = uData.getShort(new byte[]{inData[124], inData[125]});
            fMSecond = uData.getShort(new byte[]{inData[126], inData[127]});
            tYear = uData.getShort(new byte[]{inData[128], inData[129]});
            tMonth = uData.getShort(new byte[]{inData[130], inData[131]});
            tZero = uData.getShort(new byte[]{inData[132], inData[133]});
            tDay = uData.getShort(new byte[]{inData[134], inData[135]});
            tHour = uData.getShort(new byte[]{inData[136], inData[137]});
            tMinute = uData.getShort(new byte[]{inData[138], inData[139]});
            tSecond = uData.getShort(new byte[]{inData[140], inData[141]});
            tMSecond = uData.getShort(new byte[]{inData[142], inData[143]});
        }
         catch (IOException ex) {
            throw new IOException("Failed to read base data.");
        }
    }

    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
    
    public Object getValue(int colIndex) {
        switch (colIndex) {
            case 0:
                return this.isValid;
            case 1:
                return uData.getLong(this.ItemID);
            case 2:
                return this.itemName;
            case 3:
                return uData.getShort(this.lvlReq);
            case 4:
                return this.isMaxLVL;
            case 5:
                return this.Icon;
            case 6:
                return uData.getShort(this.U2);
            case 7:
                return uData.getShort(this.U3);
            case 8:
                return uData.getShort(this.U4);
            case 9:
                return uData.getLong(this.itemPrice);
            case 10:
                return uData.getLong(this.DiscountPrice);
            case 11:
                return uData.getLong(this.UsedPrice);
            case 12:
                return uData.getShort(this.moneyFlag);
            case 13:
                return uData.getShort(this.shopFlag);
            case 14:
                return uData.getInt(this.timeFlag);
            case 15:
                return uData.getInt(this.Time);
            case 16:
                return uData.getInt(this.Point);
            case 17:
                return uData.getInt(this.fYear);
            case 18:
                return uData.getInt(this.fMonth);
            case 19:
                return uData.getInt(this.fZero);
            case 20:
                return uData.getInt(this.fDay);
            case 21:
                return uData.getInt(this.fHour);
            case 22:
                return uData.getInt(this.fMinute);
            case 23:
                return uData.getInt(this.fSecond);
            case 24:
                return uData.getInt(this.fMSecond);
            case 25:
                return uData.getInt(this.tYear);
            case 26:
                return uData.getInt(this.tMonth);
            case 27:
                return uData.getInt(this.tZero);
            case 28:
                return uData.getInt(this.tDay);
            case 29:
                return uData.getInt(this.tHour);
            case 30:
                return uData.getInt(this.tMinute);
            case 31:
                return uData.getInt(this.tSecond);
            case 32:
                return uData.getInt(this.tMSecond);
            default:
                return "!";
        }
    }

    public void setValue(int colIndex, Object value) {
        switch (colIndex) {
            case 0:
                this.isValid = (Boolean)value;
                break;
            case 1:
                this.ItemID = uData.getInt((Long)value);
                break;
            case 2:
                this.itemName = (String)value;
                break;
            case 3:
                this.lvlReq = uData.getByte((Short)value);
                break;
            case 4:
                this.isMaxLVL = (Boolean)value;
                break;
            case 5:
                this.Icon = (String)value;
                break;
            case 6:
                this.U2 = uData.getByte((Short)value);
                break;
            case 7:
                this.U3 = uData.getByte((Short)value);
                break;
            case 8:
                this.U4 = uData.getByte((Short)value);
                break;
            case 9:
                this.itemPrice = uData.getInt((Long)value);
                break;
            case 10:
                this.DiscountPrice = uData.getInt((Long)value);
                break;
            case 11:
                this.UsedPrice = uData.getInt((Long)value);
                break;
            case 12:
                this.moneyFlag = uData.getByte((Short)value);
                break;
            case 13:
                this.shopFlag = uData.getByte((Short)value);
                break;
            case 14:
                this.timeFlag = uData.getByte((Short)value);
                break;
            case 15:
                this.Time = uData.getByte((Short)value);
                break;
            case 16:
                this.Point = uData.getShort((Integer)value);
                break;
            case 17:
                this.fYear = uData.getShort((Integer)value);
                break;
            case 18:
                this.fMonth = uData.getShort((Integer)value);
                break;
            case 19:
                this.fZero = uData.getShort((Integer)value);
                break;
            case 20:
                this.fDay = uData.getShort((Integer)value);
                break;
            case 21:
                this.fHour = uData.getShort((Integer)value);
                break;
            case 22:
                this.fMinute = uData.getShort((Integer)value);
                break;
            case 23:
                this.fSecond = uData.getShort((Integer)value);
                break;
            case 24:
                this.fMSecond = uData.getShort((Integer)value);
                break;
            case 25:
                this.tYear = uData.getShort((Integer)value);
                break;
            case 26:
                this.tMonth = uData.getShort((Integer)value);
                break;
            case 27:
                this.tZero = uData.getShort((Integer)value);
                break;
            case 28:
                this.tDay = uData.getShort((Integer)value);
                break;
            case 29:
                this.tHour = uData.getShort((Integer)value);
                break;
            case 30:
                this.tMinute = uData.getShort((Integer)value);
                break;
            case 31:
                this.tSecond = uData.getShort((Integer)value);
                break;
            case 32:
                this.tMSecond = uData.getShort((Integer)value);
                break;
        }
    }
}
