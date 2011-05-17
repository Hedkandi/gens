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
public final class iffAuxPart extends iffClasses.iffBase {


    public short U14 = 0; 
    public short U33 = 0; 
    public short U34 = 0; 
    public short U35 = 0; 
    public short U36 = 0; 
    public short U37 = 0; 
    public short U38 = 0; 
    public short U39 = 0; 
    public short U40 = 0; 
    public short U41 = 0; 
    public short U42 = 0; 
    public short U43 = 0; 
    public short U44 = 0; 
    public short U45 = 0; 
    public short U46 = 0; 
    public short U47 = 0;
    
    public String[] colNames = new String[] {  "NA",
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
    

    public iffAuxPart(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffAuxPart(String[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffAuxPart() {
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

    @Override
    public void getItem(String[] inData) {
        super.getItem(inData);
        this.U14 = uData.getShort(Integer.parseInt(inData[32]));
        this.U33 = uData.getShort(Integer.parseInt(inData[33]));
        this.U34 = uData.getShort(Integer.parseInt(inData[34]));
        this.U35 = uData.getShort(Integer.parseInt(inData[35]));
        this.U36 = uData.getShort(Integer.parseInt(inData[36]));
        this.U37 = uData.getShort(Integer.parseInt(inData[37]));
        this.U38 = uData.getShort(Integer.parseInt(inData[38]));
        this.U39 = uData.getShort(Integer.parseInt(inData[39]));
        this.U40 = uData.getShort(Integer.parseInt(inData[40]));
        this.U41 = uData.getShort(Integer.parseInt(inData[41]));
        this.U42 = uData.getShort(Integer.parseInt(inData[42]));
        this.U43 = uData.getShort(Integer.parseInt(inData[43]));
        this.U44 = uData.getShort(Integer.parseInt(inData[44]));
        this.U45 = uData.getShort(Integer.parseInt(inData[45]));
        this.U46 = uData.getShort(Integer.parseInt(inData[46]));
        this.U47 = uData.getShort(Integer.parseInt(inData[47]));
    }

    @Override
    public final void getItem(byte[] inData) throws IOException {
        try {
            super.getItem(inData);
            this.U14 = uData.getShort(new byte[]{inData[144], inData[145]});
            this.U33 = uData.getShort(new byte[]{inData[146], inData[147]});
            this.U34 = uData.getShort(new byte[]{inData[148], inData[149]});
            this.U35 = uData.getShort(new byte[]{inData[150], inData[151]});
            this.U36 = uData.getShort(new byte[]{inData[152], inData[153]});
            this.U37 = uData.getShort(new byte[]{inData[154], inData[155]});
            this.U38 = uData.getShort(new byte[]{inData[156], inData[157]});
            this.U39 = uData.getShort(new byte[]{inData[158], inData[159]});
            this.U40 = uData.getShort(new byte[]{inData[160], inData[161]});
            this.U41 = uData.getShort(new byte[]{inData[162], inData[163]});
            this.U42 = uData.getShort(new byte[]{inData[164], inData[165]});
            this.U43 = uData.getShort(new byte[]{inData[166], inData[167]});
            this.U44 = uData.getShort(new byte[]{inData[168], inData[169]});
            this.U45 = uData.getShort(new byte[]{inData[170], inData[171]});
            this.U46 = uData.getShort(new byte[]{inData[172], inData[173]});
            this.U47 = uData.getShort(new byte[]{inData[174], inData[175]});
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }

    public int getColNum() {
        return this.colNames.length;
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
                return uData.getInt(this.U14);
            case 33:
                return uData.getInt(this.U33);
            case 34:
                return uData.getInt(this.U34);
            case 35:
                return uData.getInt(this.U35);
            case 36:
                return uData.getInt(this.U36);
            case 37:
                return uData.getInt(this.U37);
            case 38:
                return uData.getInt(this.U38);
            case 39:
                return uData.getInt(this.U39);
            case 40:
                return uData.getInt(this.U40);
            case 41:
                return uData.getInt(this.U41);
            case 42:
                return uData.getInt(this.U42);
            case 43:
                return uData.getInt(this.U43);
            case 44:
                return uData.getInt(this.U44);
            case 45:
                return uData.getInt(this.U45);
            case 46:
                return uData.getInt(this.U46);
            case 47:
                return uData.getInt(this.U47);
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
                this.U14 = uData.getShort((Integer)value);
                break;
            case 33:
                this.U33 = uData.getShort((Integer)value);
                break;
            case 34:
                this.U34 = uData.getShort((Integer)value);
                break;
            case 35:
                this.U35 = uData.getShort((Integer)value);
                break;
            case 36:
                this.U36 = uData.getShort((Integer)value);
                break;
            case 37:
                this.U37 = uData.getShort((Integer)value);
                break;
            case 38:
                this.U38 = uData.getShort((Integer)value);
                break;
            case 39:
                this.U39 = uData.getShort((Integer)value);
                break;
            case 40:
                this.U40 = uData.getShort((Integer)value);
                break;
            case 41:
                this.U41 = uData.getShort((Integer)value);
                break;
            case 42:
                this.U42 = uData.getShort((Integer)value);
                break;
            case 43:
                this.U43 = uData.getShort((Integer)value);
                break;
            case 44:
                this.U44 = uData.getShort((Integer)value);
                break;
            case 45:
                this.U45 = uData.getShort((Integer)value);
                break;
            case 46:
                this.U46 = uData.getShort((Integer)value);
                break;
            case 47:
                this.U47 = uData.getShort((Integer)value);
                break;
        }
    }
}
