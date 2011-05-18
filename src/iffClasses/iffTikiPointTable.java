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
public class iffTikiPointTable {
    public int ID = 0;
    public int ItemID = 0;
    public byte lvlReq = 0;
    public byte U2 = 0;
    public byte U3 = 0;
    public byte U4 = 0;
    public byte U5 = 0;
    public byte U6 = 0;
    public byte U7 = 0;
    public byte U8 = 0;
    public byte U9 = 0;
    public byte U10 = 0;
    public byte U11 = 0;
    public byte U12 = 0;
    public byte U13 = 0;
    public byte U14 = 0;
    public byte U15 = 0;
    public byte U16 = 0;
    public byte U17 = 0;
    public byte U18 = 0;
    public byte U19 = 0;
    public byte U20 = 0;
    public byte U21 = 0;
    public byte U22 = 0;
    public byte U23 = 0;
    public byte U24 = 0;
    public byte U25 = 0;
    public byte U26 = 0;
    public byte U27 = 0;
    public byte U28 = 0;
    public byte U29 = 0;
    public byte U30 = 0;
    public byte U31 = 0;
    public byte U32 = 0;
    public byte U33 = 0;
    public byte U34 = 0;
    public byte U35 = 0;
    public byte U36 = 0;
    public byte U37 = 0;
    public byte U38 = 0;
    public byte U39 = 0;
    public byte U40 = 0;
    String[] colNames = new String[] {  "NA",
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
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA"};

    public iffTikiPointTable(byte[] inData) {
        getItem(inData);
    }

    public iffTikiPointTable() {
        
    }

    public int getColNum() {
        return this.colNames.length;
    }

    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
    
    private void getItem(byte[] inData) {
        ID = uData.getInt(new byte[] {inData[0], inData[1], inData[2], inData[3]});
        ItemID = uData.getInt(new byte[] {inData[4], inData[5], inData[6], inData[7]});
        lvlReq = inData[8];
        U2 = inData[9];
        U3 = inData[10];
        U4 = inData[11];
        U5 = inData[12];
        U6 = inData[13];
        U7 = inData[14];
        U8 = inData[15];
        U9 = inData[16];
        U10 = inData[17];
        U11 = inData[18];
        U12 = inData[19];
        U13 = inData[20];
        U14 = inData[21];
        U15 = inData[22];
        U16 = inData[23];
        U17 = inData[24];
        U18 = inData[25];
        U19 = inData[26];
        U20 = inData[27];
        U21 = inData[28];
        U22 = inData[29];
        U23 = inData[30];
        U24 = inData[31];
        U25 = inData[32];
        U26 = inData[33];
        U27 = inData[34];
        U28 = inData[35];
        U29 = inData[36];
        U30 = inData[37];
        U31 = inData[38];
        U32 = inData[39];
        U33 = inData[40];
        U34 = inData[41];
        U35 = inData[42];
        U36 = inData[43];
        U37 = inData[44];
        U38 = inData[45];
        U39 = inData[46];
        U40 = inData[47];
    }

    public Object getValue(int colIndex) {
        switch (colIndex) {
            case 0:
                return uData.getLong(this.ID);
            case 1:
                return uData.getLong(this.ItemID);
            case 2:
                return uData.getShort(this.lvlReq);
            case 3:
                return uData.getShort(this.U2);
            case 4:
                return uData.getShort(this.U3);
            case 5:
                return uData.getShort(this.U4);
            case 6:
                return uData.getShort(this.U5);
            case 7:
                return uData.getShort(this.U6);
            case 8:
                return uData.getShort(this.U7);
            case 9:
                return uData.getShort(this.U8);
            case 10:
                return uData.getShort(this.U9);
            case 11:
                return uData.getShort(this.U10);
            case 12:
                return uData.getShort(this.U11);
            case 13:
                return uData.getShort(this.U12);
            case 14:
                return uData.getShort(this.U13);
            case 15:
                return uData.getShort(this.U14);
            case 16:
                return uData.getShort(this.U15);
            case 17:
                return uData.getShort(this.U16);
            case 18:
                return uData.getShort(this.U17);
            case 19:
                return uData.getShort(this.U18);
            case 20:
                return uData.getShort(this.U19);
            case 21:
                return uData.getShort(this.U20);
            case 22:
                return uData.getShort(this.U21);
            case 23:
                return uData.getShort(this.U22);
            case 24:
                return uData.getShort(this.U23);
            case 25:
                return uData.getShort(this.U24);
            case 26:
                return uData.getShort(this.U25);
            case 27:
                return uData.getShort(this.U26);
            case 28:
                return uData.getShort(this.U27);
            case 29:
                return uData.getShort(this.U28);
            case 30:
                return uData.getShort(this.U29);
            case 31:
                return uData.getShort(this.U30);
            case 32:
                return uData.getShort(this.U31);
            case 33:
                return uData.getShort(this.U32);
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
            default:
                return "";
        }
    }

    public void setValue(int colIndex, Object value) {
        switch (colIndex) {
            case 0:
                this.ID = uData.getInt((Long)value);
                break;
            case 1:
                this.ItemID = uData.getInt((Long)value);
                break;
            case 2:
                this.lvlReq = uData.getByte((Short)value);
                break;
            case 3:
                this.U2 = uData.getByte((Short)value);
                break;
            case 4:
                this.U3 = uData.getByte((Short)value);
                break;
            case 5:
                this.U4 = uData.getByte((Short)value);
                break;
            case 6:
                this.U5 = uData.getByte((Short)value);
                break;
            case 7:
                this.U6 = uData.getByte((Short)value);
                break;
            case 8:
                this.U7 = uData.getByte((Short)value);
                break;
            case 9:
                this.U8 = uData.getByte((Short)value);
                break;
            case 10:
                this.U9 = uData.getByte((Short)value);
                break;
            case 11:
                this.U10 = uData.getByte((Short)value);
                break;
            case 12:
                this.U11 = uData.getByte((Short)value);
                break;
            case 13:
                this.U12 = uData.getByte((Short)value);
                break;
            case 14:
                this.U13 = uData.getByte((Short)value);
                break;
            case 15:
                this.U14 = uData.getByte((Short)value);
                break;
            case 16:
                this.U15 = uData.getByte((Short)value);
                break;
            case 17:
                this.U16 = uData.getByte((Short)value);
                break;
            case 18:
                this.U17 = uData.getByte((Short)value);
                break;
            case 19:
                this.U18 = uData.getByte((Short)value);
                break;
            case 20:
                this.U19 = uData.getByte((Short)value);
                break;
            case 21:
                this.U20 = uData.getByte((Short)value);
                break;
            case 22:
                this.U21 = uData.getByte((Short)value);
                break;
            case 23:
                this.U22 = uData.getByte((Short)value);
                break;
            case 24:
                this.U23 = uData.getByte((Short)value);
                break;
            case 25:
                this.U24 = uData.getByte((Short)value);
                break;
            case 26:
                this.U25 = uData.getByte((Short)value);
                break;
            case 27:
                this.U26 = uData.getByte((Short)value);
                break;
            case 28:
                this.U27 = uData.getByte((Short)value);
                break;
            case 29:
                this.U28 = uData.getByte((Short)value);
                break;
            case 30:
                this.U29 = uData.getByte((Short)value);
                break;
            case 31:
                this.U30 = uData.getByte((Short)value);
                break;
            case 32:
                this.U31 = uData.getByte((Short)value);
                break;
            case 33:
                this.U32 = uData.getByte((Short)value);
                break;
            case 34:
                this.U33 = uData.getByte((Short)value);
                break;
            case 35:
                this.U34 = uData.getByte((Short)value);
                break;
            case 36:
                this.U35 = uData.getByte((Short)value);
                break;
            case 37:
                this.U36 = uData.getByte((Short)value);
                break;
            case 38:
                this.U37 = uData.getByte((Short)value);
                break;
            case 39:
                this.U38 = uData.getByte((Short)value);
                break;
            case 40:
                this.U39 = uData.getByte((Short)value);
                break;
            case 41:
                this.U40 = uData.getByte((Short)value);
                break;
        }
    }
}
