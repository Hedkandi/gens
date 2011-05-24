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

    public static final int base = 31;
    public boolean isValid = false;
    public int ItemID = 0;
    /*
     * Structure of ItemID
     * ((((
        ((IFFTYPE) * power((2),(26))
        + CHAR_SERIAL * power((2),(18)))
        + POS * power((2),(13)))
        + GROUP * power((2),(11)))
        + TYPE * power((2),(9)))
        + SERIAL)
     */
    public byte iffType = 0;
    public short charSerial = 0;
    public byte itemPos = 0;
    public byte itemGroup = 0;
    public byte itemType = 0;
    public short itemSerial = 0;
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
    /*
     * public byte moneyFlag = 0;
     * Cookies, Pang, Free makes moneyFlag
     */
    public boolean Cookies = false;
    public boolean Pang = false;
    public boolean Free = false;
    /*
     * public byte shopFlag = 0;
     * inStock, disableGift, showSpecial, showNew, showHot makes shopFlag
     */
    public boolean inStock = false;
    public boolean disableGift = false;
    public boolean showSpecial = false;
    public boolean showNew = false;
    public boolean showHot = false;
    public byte timeFlag = 0;
    public byte Time = 0;
    public int Point = 0;
    public iffDateTime startDateTime = new iffDateTime();
    public short fYear = 0;
    public short fMonth = 0;
    public short fZero = 0;
    public short fDay = 0;
    public short fHour = 0;
    public short fMinute = 0;
    public short fSecond = 0;
    public short fMSecond = 0;
    public iffDateTime endDateTime = new iffDateTime();
    public short tYear = 0;
    public short tMonth = 0;
    public short tZero = 0;
    public short tDay = 0;
    public short tHour = 0;
    public short tMinute = 0;
    public short tSecond = 0;
    public short tMSecond = 0;
    public String[] colNames = new String[] {  "Use",
                                        /* TODO 
                                         * Break out the different parts of ItemID to separate fields
                                         */
                                        "ItemID",
                                        "iffType",
                                        "charSerial",
                                        "itemPos",
                                        "itemGroup",
                                        "itemType",
                                        "itemSerial",
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
                                        "Cookies",
                                        "Pang",
                                        "Free",
                                        "In Stock",
                                        "Disable Gift",
                                        "Show Special",
                                        "Show New",
                                        "Show Hot",
                                        "Time Flags",
                                        "Time",
                                        "Point",
                                        "Start Date",
                                        "End Date"};

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
            // TODO Read the booleans instead of byte
            //moneyFlag = uData.getByte(Short.parseShort(inData[12]));
            //shopFlag = uData.getByte(Short.parseShort(inData[13]));
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
            iffType = (byte)((ItemID & 0xFC000000) >> 26);
            charSerial = (short)((ItemID & 0x3CF0000) >> 18);
            itemPos = (byte)((ItemID & 0x7E000) >> 13);
            itemGroup = (byte)((ItemID & 0x1800) >> 11);
            itemType = (byte)((ItemID & 0x600) >> 9);
            itemSerial = (short)(ItemID & 0x1FF);
            itemName = uData.getString(new ByteArrayInputStream(inData, 8, uData.stringLength));
            lvlReq = (byte)(inData[48] & 0x7F);
            isMaxLVL = ((inData[48] & 0x80) == 0x80);
            Icon = uData.getString(new ByteArrayInputStream(inData, 49, uData.stringLength));
            // Bytes 89-91 isnt used
            U2 = inData[89];
            U3 = inData[90];
            U4 = inData[91];
            itemPrice = uData.getInt(new byte[]{inData[92], inData[93], inData[94], inData[95]});
            DiscountPrice = uData.getInt(new byte[]{inData[96], inData[97], inData[98], inData[99]});
            UsedPrice = uData.getInt(new byte[]{inData[100], inData[101], inData[102], inData[103]});
            //moneyFlag = inData[104];
            Cookies = ((inData[104] & 0x1) == 0x1);
            Pang = ((inData[104] & 0x2) == 0x2);
            Free = ((inData[104]) == 0x0);
            //shopFlag = inData[105];
            inStock = ((inData[105] & 0x1) == 0x1);
            disableGift = ((inData[105] & 0x2) == 0x2);
            showSpecial = ((inData[105] & 0x4) == 0x4);
            showNew = ((inData[105] & 0x8) == 0x8);
            showHot = ((inData[105] & 0x10) == 0x10);
            timeFlag = inData[106];
            Time = inData[107];
            Point = uData.getInt(new byte[]{inData[108], inData[109], inData[110], inData[111]});
            startDateTime.setValue(0, uData.getShort(new byte[]{inData[112], inData[113]}));
            startDateTime.setValue(1, uData.getShort(new byte[]{inData[114], inData[115]}));
            startDateTime.setValue(2, uData.getShort(new byte[]{inData[116], inData[117]}));
            startDateTime.setValue(3, uData.getShort(new byte[]{inData[118], inData[119]}));
            startDateTime.setValue(4, uData.getShort(new byte[]{inData[120], inData[121]}));
            startDateTime.setValue(5, uData.getShort(new byte[]{inData[122], inData[123]}));
            startDateTime.setValue(6, uData.getShort(new byte[]{inData[124], inData[125]}));
            startDateTime.setValue(7, uData.getShort(new byte[]{inData[126], inData[127]}));
            endDateTime.setValue(0, uData.getShort(new byte[]{inData[128], inData[129]}));
            endDateTime.setValue(1, uData.getShort(new byte[]{inData[130], inData[131]}));
            endDateTime.setValue(2, uData.getShort(new byte[]{inData[132], inData[133]}));
            endDateTime.setValue(3, uData.getShort(new byte[]{inData[134], inData[135]}));
            endDateTime.setValue(4, uData.getShort(new byte[]{inData[136], inData[137]}));
            endDateTime.setValue(5, uData.getShort(new byte[]{inData[138], inData[139]}));
            endDateTime.setValue(6, uData.getShort(new byte[]{inData[140], inData[141]}));
            endDateTime.setValue(7, uData.getShort(new byte[]{inData[142], inData[143]}));
        } catch (IOException ex) {
            throw new IOException("Failed to read base data.");
        }
    }
    
    public byte[] getItem() {
        byte[] retData = new byte[144];
        for (int i=0;i<getColNum();i++) {
            retData = uData.getBytes(getValue(i));
        }
        return retData;
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
                return uData.getShort(this.iffType);
            case 3:
                return uData.getInt(this.charSerial);
            case 4:
                return uData.getShort(this.itemPos);
            case 5:
                return uData.getShort(this.itemGroup);
            case 6:
                return uData.getShort(this.itemType);
            case 7:
                return uData.getInt(this.itemSerial);
            case 8:
                return this.itemName;
            case 9:
                return uData.getShort(this.lvlReq);
            case 10:
                return this.isMaxLVL;
            case 11:
                return this.Icon;
            case 12:
                return uData.getShort(this.U2);
            case 13:
                return uData.getShort(this.U3);
            case 14:
                return uData.getShort(this.U4);
            case 15:
                return uData.getLong(this.itemPrice);
            case 16:
                return uData.getLong(this.DiscountPrice);
            case 17:
                return uData.getLong(this.UsedPrice);
            case 18:
                return this.Cookies;
            case 19:
                return this.Pang;
            case 20:
                return this.Free;
            case 21:
                return this.inStock;
            case 22:
                return this.disableGift;
            case 23:
                return this.showSpecial;
            case 24:
                return this.showNew;
            case 25:
                return this.showHot;
            case 26:
                return uData.getInt(this.timeFlag);
            case 27:
                return uData.getInt(this.Time);
            case 28:
                return uData.getInt(this.Point);
            case 29:
                return this.startDateTime.getTime();
            case 30:
                return this.endDateTime.getTime();
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
                this.Cookies = (Boolean)value;
                break;
            case 13:
                this.Pang = (Boolean)value;
                break;
            case 14:
                this.Free = (Boolean)value;
                break;
            case 15:
                this.inStock = (Boolean)value;
                break;
            case 16:
                this.disableGift = (Boolean)value;
                break;
            case 17:
                this.showSpecial = (Boolean)value;
                break;
            case 18:
                this.showNew = (Boolean)value;
                break;
            case 19:
                this.showHot = (Boolean)value;
                break;
            case 20:
                this.timeFlag = uData.getByte((Short)value);
                break;
            case 21:
                this.Time = uData.getByte((Short)value);
                break;
            case 22:
                this.Point = uData.getShort((Integer)value);
                break;
            case 23:
                this.startDateTime.setTime((String)value);
                break;
            case 24:
                this.endDateTime.setTime((String)value);
                break;
        }
    }
}
