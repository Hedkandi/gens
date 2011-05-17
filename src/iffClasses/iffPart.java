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
public final class iffPart extends iffBase {
    public String Sprite2Name = ""; 
    public byte numStat1 = 0; 
    public byte numStat2 = 0; 
    public byte numStat3 = 0; 
    public byte numStat4 = 0; 
    public byte numStat5 = 0; 
    public byte numStat6 = 0; 
    public byte numStat7 = 0; 
    public byte numStat8 = 0; 
    public byte numStat9 = 0; 
    public byte numStat10 = 0; 
    public byte numStat11 = 0; 
    public byte numStat12 = 0; 
    public String Sprite3Name = ""; 
    public String Sprite4Name = ""; 
    public String Sprite5Name = ""; 
    public String Sprite6Name = ""; 
    public String Sprite7Name = ""; 
    public String Sprite8Name = ""; 
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
    public String UString1 = "";
    public int equipWith1 = 0;
    public int equipWith2 = 0;
    public short U67 = 0; 
    public short U68 = 0; 
    public short U69 = 0; 
    public short U70 = 0; 
    String[] colNames = new String[] {  "Model",
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
                                        "Texture #1",
                                        "Texture #2",
                                        "Texture #3",
                                        "Texture #4",
                                        "Texture #5",
                                        "Texture #6",
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
                                        "Equip With #1?",
                                        "Equip With #2?",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA"};
    
    public iffPart(byte[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffPart() {
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

    public void getItem(byte[] inData) {
        try {
            super.getItem(inData);
            Sprite2Name = uData.getString(new ByteArrayInputStream(inData, 144, uData.stringLength));
            numStat1 = inData[184];
            numStat2 = inData[185];
            numStat3 = inData[186];
            numStat4 = inData[187];
            numStat5 = inData[188];
            numStat6 = inData[189];
            numStat7 = inData[190];
            numStat8 = inData[191];
            numStat9 = inData[192];
            numStat10 = inData[193];
            numStat11 = inData[194];
            numStat12 = inData[195];
            Sprite3Name = uData.getString(new ByteArrayInputStream(inData, 196, uData.stringLength));
            Sprite4Name = uData.getString(new ByteArrayInputStream(inData, 236, uData.stringLength));
            Sprite5Name = uData.getString(new ByteArrayInputStream(inData, 276, uData.stringLength));
            Sprite6Name = uData.getString(new ByteArrayInputStream(inData, 316, uData.stringLength));
            Sprite7Name = uData.getString(new ByteArrayInputStream(inData, 356, uData.stringLength));
            Sprite8Name = uData.getString(new ByteArrayInputStream(inData, 396, uData.stringLength));
            U33 = uData.getShort(new byte[]{inData[436], inData[437]});
            U34 = uData.getShort(new byte[]{inData[438], inData[439]});
            U35 = uData.getShort(new byte[]{inData[440], inData[441]});
            U36 = uData.getShort(new byte[]{inData[442], inData[443]});
            U37 = uData.getShort(new byte[]{inData[444], inData[445]});
            U38 = uData.getShort(new byte[]{inData[446], inData[447]});
            U39 = uData.getShort(new byte[]{inData[448], inData[449]});
            U40 = uData.getShort(new byte[]{inData[450], inData[451]});
            U41 = uData.getShort(new byte[]{inData[452], inData[453]});
            U42 = uData.getShort(new byte[]{inData[454], inData[455]});
            UString1 = uData.getString(new ByteArrayInputStream(inData, 456, uData.stringLength));
            equipWith1 = uData.getInt(new byte[]{inData[496], inData[497], inData[498], inData[499]});
            equipWith2 = uData.getInt(new byte[]{inData[500], inData[501], inData[502], inData[503]});
            U67 = uData.getShort(new byte[]{inData[504], inData[505]});
            U68 = uData.getShort(new byte[]{inData[506], inData[507]});
            U69 = uData.getShort(new byte[]{inData[508], inData[509]});
            U70 = uData.getShort(new byte[]{inData[510], inData[511]});
        } catch (IOException ex) {
            Logger.getLogger(iffPart.class.getName()).log(Level.SEVERE, null, ex);
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
                return uData.getShort(this.numStat1);
            case 34:
                return uData.getShort(this.numStat2);
            case 35:
                return uData.getShort(this.numStat3);
            case 36:
                return uData.getShort(this.numStat4);
            case 37:
                return uData.getShort(this.numStat5);
            case 38:
                return uData.getShort(this.numStat6);
            case 39:
                return uData.getShort(this.numStat7);
            case 40:
                return uData.getShort(this.numStat8);
            case 41:
                return uData.getShort(this.numStat9);
            case 42:
                return uData.getShort(this.numStat10);
            case 43:
                return uData.getShort(this.numStat11);
            case 44:
                return uData.getShort(this.numStat12);
            case 45:
                return this.Sprite3Name;
            case 46:
                return this.Sprite4Name;
            case 47:
                return this.Sprite5Name;
            case 48:
                return this.Sprite6Name;
            case 49:
                return this.Sprite7Name;
            case 50:
                return this.Sprite8Name;
            case 51:
                return uData.getInt(this.U33);
            case 52:
                return uData.getInt(this.U34);
            case 53:
                return uData.getInt(this.U35);
            case 54:
                return uData.getInt(this.U36);
            case 55:
                return uData.getInt(this.U37);
            case 56:
                return uData.getInt(this.U38);
            case 57:
                return uData.getInt(this.U39);
            case 58:
                return uData.getInt(this.U40);
            case 59:
                return uData.getInt(this.U41);
            case 60:
                return uData.getInt(this.U42);
            case 61:
                return this.UString1;
            case 62:
                return uData.getLong(this.equipWith1);
            case 63:
                return uData.getLong(this.equipWith2);
            case 64:
                return uData.getInt(this.U67);
            case 65:
                return uData.getInt(this.U68);
            case 66:
                return uData.getInt(this.U69);
            case 67:
                return uData.getInt(this.U70);
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
                this.numStat1 = uData.getByte((Short)value);
                break;
            case 34:
                this.numStat2 = uData.getByte((Short)value);
                break;
            case 35:
                this.numStat3 = uData.getByte((Short)value);
                break;
            case 36:
                this.numStat4 = uData.getByte((Short)value);
                break;
            case 37:
                this.numStat5 = uData.getByte((Short)value);
                break;
            case 38:
                this.numStat6 = uData.getByte((Short)value);
                break;
            case 39:
                this.numStat7 = uData.getByte((Short)value);
                break;
            case 40:
                this.numStat8 = uData.getByte((Short)value);
                break;
            case 41:
                this.numStat9 = uData.getByte((Short)value);
                break;
            case 42:
                this.numStat10 = uData.getByte((Short)value);
                break;
            case 43:
                this.numStat11 = uData.getByte((Short)value);
                break;
            case 44:
                this.numStat12 = uData.getByte((Short)value);
                break;
            case 45:
                this.Sprite3Name = (String)value;
                break;
            case 46:
                this.Sprite4Name = (String)value;
                break;
            case 47:
                this.Sprite5Name = (String)value;
                break;
            case 48:
                this.Sprite6Name = (String)value;
                break;
            case 49:
                this.Sprite7Name = (String)value;
                break;
            case 50:
                this.Sprite8Name = (String)value;
                break;
            case 51:
                this.U33 = uData.getShort((Integer)value);
                break;
            case 52:
                this.U34 = uData.getShort((Integer)value);
                break;
            case 53:
                this.U35 = uData.getShort((Integer)value);
                break;
            case 54:
                this.U36 = uData.getShort((Integer)value);
                break;
            case 55:
                this.U37 = uData.getShort((Integer)value);
                break;
            case 56:
                this.U38 = uData.getShort((Integer)value);
                break;
            case 57:
                this.U39 = uData.getShort((Integer)value);
                break;
            case 58:
                this.U40 = uData.getShort((Integer)value);
                break;
            case 59:
                this.U41 = uData.getShort((Integer)value);
                break;
            case 60:
                this.U42 = uData.getShort((Integer)value);
                break;
            case 61:
                this.UString1 = (String)value;
                break;
            case 62:
                this.equipWith1 = uData.getInt((Long)value);
                break;
            case 63:
                this.equipWith2 = uData.getInt((Long)value);
                break;
            case 64:
                this.U67 = uData.getShort((Integer)value);
                break;
            case 65:
                this.U68 = uData.getShort((Integer)value);
                break;
            case 66:
                this.U69 = uData.getShort((Integer)value);
                break;
            case 67:
                this.U70 = uData.getShort((Integer)value);
                break;
        }
    }
}
