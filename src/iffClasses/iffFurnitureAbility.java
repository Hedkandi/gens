/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iffClasses;

import gens.uData;

/**
 *
 * @author hedkandi
 */
public class iffFurnitureAbility {
    
    
    public int isValid = 0; 
    public int itemID = 0; 
    public int num1 = 0; 
    public int num2 = 0; 
    public int num3 = 0; 
    public int num4 = 0; 
    public int num5 = 0; 
    public short numYear = 0; 
    public short numMonth = 0; 
    public short numZero = 0; 
    public short numDay = 0; 
    public short numHour = 0; 
    public short numMinute = 0; 
    public short numSecond = 0; 
    public short numMilliSecond = 0; 
    public byte num6 = 0; 
    public byte num7 = 0; 
    public byte num8 = 0; 
    public byte num9 = 0; 
    public byte num10 = 0; 
    public byte num11 = 0; 
    public byte num12 = 0; 
    public byte num13 = 0; 
    public byte num14 = 0; 
    public byte num15 = 0; 
    public byte num16 = 0; 
    public byte num17 = 0; 
    public byte num18 = 0; 
    public byte num19 = 0; 
    public byte num20 = 0; 
    public byte num21 = 0; 
    String[] colNames = new String[] {  "Valid?",
                                        "Item?",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "Year",
                                        "Month",
                                        "0",
                                        "Day",
                                        "Hour",
                                        "Minute",
                                        "Second",
                                        "Millisecond",
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

    
    public iffFurnitureAbility(byte[] inData) {
        getItem(inData);
    }

    public iffFurnitureAbility(String[] inData) throws Exception {
        getItem(inData);
    }
        
    public iffFurnitureAbility() {
        
    }

    public int getColNum() {
        return this.colNames.length;
    }

    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
    
    public void getItem(String[] inData) throws Exception {
        try {
            isValid = uData.getInt(Long.parseLong(inData[0]));
            itemID = uData.getInt(Long.parseLong(inData[1]));
            num1 = uData.getInt(Long.parseLong(inData[2]));
            num2 = uData.getInt(Long.parseLong(inData[3]));
            num3 = uData.getInt(Long.parseLong(inData[4]));
            num4 = uData.getInt(Long.parseLong(inData[5]));
            num5 = uData.getInt(Long.parseLong(inData[6]));
            numYear = uData.getShort(Integer.parseInt(inData[7]));
            numMonth = uData.getShort(Integer.parseInt(inData[8]));
            numZero = uData.getShort(Integer.parseInt(inData[9]));
            numDay = uData.getShort(Integer.parseInt(inData[10]));
            numHour = uData.getShort(Integer.parseInt(inData[11]));
            numMinute = uData.getShort(Integer.parseInt(inData[12]));
            numSecond = uData.getShort(Integer.parseInt(inData[13]));
            numMilliSecond = uData.getShort(Integer.parseInt(inData[14]));
            num6 = uData.getByte(Short.parseShort(inData[15]));
            num7 = uData.getByte(Short.parseShort(inData[16]));
            num8 = uData.getByte(Short.parseShort(inData[17]));
            num9 = uData.getByte(Short.parseShort(inData[18]));
            num10 = uData.getByte(Short.parseShort(inData[19]));
            num11 = uData.getByte(Short.parseShort(inData[20]));
            num12 = uData.getByte(Short.parseShort(inData[21]));
            num13 = uData.getByte(Short.parseShort(inData[22]));
            num14 = uData.getByte(Short.parseShort(inData[23]));
            num15 = uData.getByte(Short.parseShort(inData[24]));
            num16 = uData.getByte(Short.parseShort(inData[25]));
            num17 = uData.getByte(Short.parseShort(inData[26]));
            num18 = uData.getByte(Short.parseShort(inData[27]));
            num19 = uData.getByte(Short.parseShort(inData[28]));
            num20 = uData.getByte(Short.parseShort(inData[29]));
            num21 = uData.getByte(Short.parseShort(inData[30]));
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private void getItem(byte[] inData) {
        isValid = uData.getInt(new byte[] {inData[0], inData[1], inData[2], inData[3]});
        itemID = uData.getInt(new byte[] {inData[4], inData[5], inData[6], inData[7]});
        num1 = uData.getInt(new byte[] {inData[8], inData[9], inData[10], inData[11]});
        num2 = uData.getInt(new byte[] {inData[12], inData[13], inData[14], inData[15]});
        num3 = uData.getInt(new byte[] {inData[16], inData[17], inData[18], inData[19]});
        num4 = uData.getInt(new byte[] {inData[20], inData[21], inData[22], inData[23]});
        num5 = uData.getInt(new byte[] {inData[24], inData[25], inData[26], inData[27]});
        numYear = uData.getShort(new byte[] {inData[28], inData[29]});
        numMonth = uData.getShort(new byte[] {inData[30], inData[31]});
        numZero = uData.getShort(new byte[] {inData[32], inData[33]});
        numDay = uData.getShort(new byte[] {inData[34], inData[35]});
        numHour = uData.getShort(new byte[] {inData[36], inData[37]});
        numMinute = uData.getShort(new byte[] {inData[38], inData[39]});
        numSecond = uData.getShort(new byte[] {inData[40], inData[41]});
        numMilliSecond = uData.getShort(new byte[] {inData[42], inData[43]});
        num6 = inData[44];
        num7 = inData[45];
        num8 = inData[46];
        num9 = inData[47];
        num10 = inData[48];
        num11 = inData[49];
        num12 = inData[50];
        num13 = inData[51];
        num14 = inData[52];
        num15 = inData[53];
        num16 = inData[54];
        num17 = inData[55];
        num18 = inData[56];
        num19 = inData[57];
        num20 = inData[58];
        num21 = inData[59];
    }

    public Object getValue(int colIndex) {
        switch (colIndex) {
            case 0:
                return uData.getLong(this.isValid);
            case 1:
                return uData.getLong(this.itemID);
            case 2:
                return uData.getLong(this.num1);
            case 3:
                return uData.getLong(this.num2);
            case 4:
                return uData.getLong(this.num3);
            case 5:
                return uData.getLong(this.num4);
            case 6:
                return uData.getLong(this.num5);
            case 7:
                return uData.getInt(this.numYear);
            case 8:
                return uData.getInt(this.numMonth);
            case 9:
                return uData.getInt(this.numZero);
            case 10:
                return uData.getInt(this.numDay);
            case 11:
                return uData.getInt(this.numHour);
            case 12:
                return uData.getInt(this.numMinute);
            case 13:
                return uData.getInt(this.numSecond);
            case 14:
                return uData.getInt(this.numMilliSecond);
            case 15:
                return uData.getShort(this.num6);
            case 16:
                return uData.getShort(this.num7);
            case 17:
                return uData.getShort(this.num8);
            case 18:
                return uData.getShort(this.num9);
            case 19:
                return uData.getShort(this.num10);
            case 20:
                return uData.getShort(this.num11);
            case 21:
                return uData.getShort(this.num12);
            case 22:
                return uData.getShort(this.num13);
            case 23:
                return uData.getShort(this.num14);
            case 24:
                return uData.getShort(this.num15);
            case 25:
                return uData.getShort(this.num16);
            case 26:
                return uData.getShort(this.num17);
            case 27:
                return uData.getShort(this.num18);
            case 28:
                return uData.getShort(this.num19);
            case 29:
                return uData.getShort(this.num20);
            case 30:
                return uData.getShort(this.num21);
            default:
                return "";
        }
    }

        public void setValue(int colIndex, Object value) {
        switch (colIndex) {
            case 0:
                this.isValid = uData.getInt((Long)value);
                break;
            case 1:
                this.itemID = uData.getInt((Long)value);
                break;
            case 2:
                this.num1 = uData.getInt((Long)value);
                break;
            case 3:
                this.num2 = uData.getInt((Long)value);
                break;
            case 4:
                this.num3 = uData.getInt((Long)value);
                break;
            case 5:
                this.num4 = uData.getInt((Long)value);
                break;
            case 6:
                this.num5 = uData.getInt((Long)value);
                break;
            case 7:
                this.numYear = uData.getShort((Integer)value);
                break;
            case 8:
                this.numMonth = uData.getShort((Integer)value);
                break;
            case 9:
                this.numZero = uData.getShort((Integer)value);
                break;
            case 10:
                this.numDay = uData.getShort((Integer)value);
                break;
            case 11:
                this.numHour = uData.getShort((Integer)value);
                break;
            case 12:
                this.numMinute = uData.getShort((Integer)value);
                break;
            case 13:
                this.numSecond = uData.getShort((Integer)value);
                break;
            case 14:
                this.numMilliSecond = uData.getShort((Integer)value);
                break;
            case 15:
                this.num6 = uData.getByte((Short)value);
                break;
            case 16:
                this.num7 = uData.getByte((Short)value);
                break;
            case 17:
                this.num8 = uData.getByte((Short)value);
                break;
            case 18:
                this.num9 = uData.getByte((Short)value);
                break;
            case 19:
                this.num10 = uData.getByte((Short)value);
                break;
            case 20:
                this.num11 = uData.getByte((Short)value);
                break;
            case 21:
                this.num12 = uData.getByte((Short)value);
                break;
            case 22:
                this.num13 = uData.getByte((Short)value);
                break;
            case 23:
                this.num14 = uData.getByte((Short)value);
                break;
            case 24:
                this.num15 = uData.getByte((Short)value);
                break;
            case 25:
                this.num16 = uData.getByte((Short)value);
                break;
            case 26:
                this.num17 = uData.getByte((Short)value);
                break;
            case 27:
                this.num18 = uData.getByte((Short)value);
                break;
            case 28:
                this.num19 = uData.getByte((Short)value);
                break;
            case 29:
                this.num20 = uData.getByte((Short)value);
                break;
            case 30:
                this.num21 = uData.getByte((Short)value);
                break;
        }
    }
}
