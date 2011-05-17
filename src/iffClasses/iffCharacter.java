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
public final class iffCharacter extends iffBase {
    
    public String Sprite2Name = ""; 
    public String GFX1 = ""; 
    public String GFX2 = ""; 
    public String GFX3 = ""; 
    public short firstPower = 0; 
    public short firstControl = 0; 
    public short firstAccuracy = 0; 
    public short firstSpin = 0; 
    public short firstCurve = 0;
    public byte U37 = 0; 
    public byte U38 = 0; 
    public byte U39 = 0; 
    public byte U43 = 0; 
    public byte U44 = 0; 
    public byte U45 = 0; 
    public int U46 = 0; 
    public byte initPower = 0; 
    public byte initControl = 0; 
    public byte initAccuracy = 0; 
    public byte initSpin = 0; 
    public byte initCurve = 0; 
    public int U52 = 0; 
    public byte U53 = 0; 
    public short U55 = 0; 
    public short U56 = 0; 
    public short U57 = 0; 
    public short U58 = 0; 
    public short U59 = 0; 
    public short U60 = 0; 
    public short U61 = 0; 
    public short U62 = 0; 
    public short U63 = 0; 
    public short U64 = 0; 
    public short U65 = 0; 
    public short U66 = 0; 
    public short U67 = 0; 
    public short U68 = 0; 
    public short U69 = 0; 
    public short U70 = 0; 
    public short U71 = 0; 
    public short U72 = 0; 
    public short U73 = 0; 
    public short U74 = 0; 

    public iffCharacter(byte[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffCharacter(String[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffCharacter() {
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
        Sprite2Name = inData[32];
        GFX1 = inData[33];
        GFX2 = inData[34];
        GFX3 = inData[35];
        firstPower = uData.getShort(Integer.parseInt(inData[36]));
        firstControl = uData.getShort(Integer.parseInt(inData[37]));
        firstAccuracy = uData.getShort(Integer.parseInt(inData[38]));
        firstSpin = uData.getShort(Integer.parseInt(inData[39]));
        firstCurve = uData.getShort(Integer.parseInt(inData[40]));
        U37 = uData.getByte(Short.parseShort(inData[41]));
        U38 = uData.getByte(Short.parseShort(inData[42]));
        U39 = uData.getByte(Short.parseShort(inData[43]));
        U43 = uData.getByte(Short.parseShort(inData[44]));
        U44 = uData.getByte(Short.parseShort(inData[45]));
        U45 = uData.getByte(Short.parseShort(inData[46]));
        U46 = uData.getInt(Long.parseLong(inData[47]));
        initPower = uData.getByte(Short.parseShort(inData[48]));
        initControl = uData.getByte(Short.parseShort(inData[49]));
        initAccuracy = uData.getByte(Short.parseShort(inData[50]));
        initSpin = uData.getByte(Short.parseShort(inData[51]));
        initCurve = uData.getByte(Short.parseShort(inData[52]));
        U52 = uData.getInt(Integer.parseInt(inData[53]));
        U53 = uData.getByte(Short.parseShort(inData[54]));
        U55 = uData.getShort(Integer.parseInt(inData[55]));
        U56 = uData.getShort(Integer.parseInt(inData[56]));
        U57 = uData.getShort(Integer.parseInt(inData[57]));
        U58 = uData.getShort(Integer.parseInt(inData[58]));
        U59 = uData.getShort(Integer.parseInt(inData[59]));
        U60 = uData.getShort(Integer.parseInt(inData[60]));
        U61 = uData.getShort(Integer.parseInt(inData[61]));
        U62 = uData.getShort(Integer.parseInt(inData[62]));
        U63 = uData.getShort(Integer.parseInt(inData[63]));
        U64 = uData.getShort(Integer.parseInt(inData[64]));
        U65 = uData.getShort(Integer.parseInt(inData[65]));
        U66 = uData.getShort(Integer.parseInt(inData[66]));
        U67 = uData.getShort(Integer.parseInt(inData[67]));
        U68 = uData.getShort(Integer.parseInt(inData[68]));
        U69 = uData.getShort(Integer.parseInt(inData[69]));
        U70 = uData.getShort(Integer.parseInt(inData[70]));
        U71 = uData.getShort(Integer.parseInt(inData[71]));
        U72 = uData.getShort(Integer.parseInt(inData[72]));
        U73 = uData.getShort(Integer.parseInt(inData[73]));
    }

    @Override
    public void getItem(byte[] inData) {
        try {
            super.getItem(inData);
            Sprite2Name = uData.getString(new ByteArrayInputStream(inData, 144, uData.stringLength));
            GFX1 = uData.getString(new ByteArrayInputStream(inData, 184, uData.stringLength));
            GFX2 = uData.getString(new ByteArrayInputStream(inData, 224, uData.stringLength));
            GFX3 = uData.getString(new ByteArrayInputStream(inData, 264, uData.stringLength));
            firstPower = uData.getShort(new byte[]{inData[304], inData[305]});
            firstControl = uData.getShort(new byte[]{inData[306], inData[307]});
            firstAccuracy = uData.getShort(new byte[]{inData[308], inData[309]});
            firstSpin = uData.getShort(new byte[]{inData[310], inData[311]});
            firstCurve = uData.getShort(new byte[]{inData[312], inData[313]});
            U37 = inData[314];
            U38 = inData[315];
            U39 = inData[316];
            U43 = inData[317];
            U44 = inData[318];
            U45 = inData[319];
            U46 = uData.getInt(new byte[]{inData[320], inData[321], inData[322], inData[323]});
            initPower = inData[324];
            initControl = inData[325];
            initAccuracy = inData[326];
            initSpin = inData[327];
            initCurve = inData[328];
            U52 = uData.getInt(new byte[]{inData[329], inData[330], inData[331], inData[332]});
            U53 = inData[333];
            U55 = uData.getShort(new byte[]{inData[334], inData[335]});
            U56 = uData.getShort(new byte[]{inData[336], inData[337]});
            U57 = uData.getShort(new byte[]{inData[338], inData[339]});
            U58 = uData.getShort(new byte[]{inData[340], inData[341]});
            U59 = uData.getShort(new byte[]{inData[342], inData[343]});
            U60 = uData.getShort(new byte[]{inData[344], inData[345]});
            U61 = uData.getShort(new byte[]{inData[346], inData[347]});
            U62 = uData.getShort(new byte[]{inData[348], inData[349]});
            U63 = uData.getShort(new byte[]{inData[350], inData[351]});
            U64 = uData.getShort(new byte[]{inData[352], inData[353]});
            U65 = uData.getShort(new byte[]{inData[354], inData[355]});
            U66 = uData.getShort(new byte[]{inData[356], inData[357]});
            U67 = uData.getShort(new byte[]{inData[358], inData[359]});
            U68 = uData.getShort(new byte[]{inData[360], inData[361]});
            U69 = uData.getShort(new byte[]{inData[362], inData[363]});
            U70 = uData.getShort(new byte[]{inData[364], inData[365]});
            U71 = uData.getShort(new byte[]{inData[366], inData[367]});
            U72 = uData.getShort(new byte[]{inData[368], inData[369]});
            U73 = uData.getShort(new byte[]{inData[370], inData[371]});
        } catch (IOException ex) {
            Logger.getLogger(iffCharacter.class.getName()).log(Level.SEVERE, null, ex);
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
                return this.GFX1;
            case 34:
                return this.GFX2;
            case 35:
                return this.GFX3;
            case 36:
                return uData.getInt(this.firstPower);
            case 37:
                return uData.getInt(this.firstControl);
            case 38:
                return uData.getInt(this.firstAccuracy);
            case 39:
                return uData.getInt(this.firstSpin);
            case 40:
                return uData.getInt(this.firstCurve);
            case 41:
                return uData.getShort(this.U37);
            case 42:
                return uData.getShort(this.U38);
            case 43:
                return uData.getShort(this.U39);
            case 44:
                return uData.getShort(this.U43);
            case 45:
                return uData.getShort(this.U44);
            case 46:
                return uData.getShort(this.U45);
            case 47:
                return uData.getLong(this.U46);
            case 48:
                return uData.getShort(this.initPower);
            case 49:
                return uData.getShort(this.initControl);
            case 50:
                return uData.getShort(this.initAccuracy);
            case 51:
                return uData.getShort(this.initSpin);
            case 52:
                return uData.getShort(this.initCurve);
            case 53:
                return uData.getLong(this.U52);
            case 54:
                return uData.getShort(this.U53);
            case 55:
                return uData.getInt(this.U55);
            case 56:
                return uData.getInt(this.U56);
            case 57:
                return uData.getInt(this.U57);
            case 58:
                return uData.getInt(this.U58);
            case 59:
                return uData.getInt(this.U59);
            case 60:
                return uData.getInt(this.U60);
            case 61:
                return uData.getInt(this.U61);
            case 62:
                return uData.getInt(this.U62);
            case 63:
                return uData.getInt(this.U63);
            case 64:
                return uData.getInt(this.U64);
            case 65:
                return uData.getInt(this.U65);
            case 66:
                return uData.getInt(this.U66);
            case 67:
                return uData.getInt(this.U67);
            case 68:
                return uData.getInt(this.U68);
            case 69:
                return uData.getInt(this.U69);
            case 70:
                return uData.getInt(this.U70);
            case 71:
                return uData.getInt(this.U71);
            case 72:
                return uData.getInt(this.U72);
            case 73:
                return uData.getInt(this.U73);
            default:
                return -1;
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
                this.GFX1 = (String)value;
                break;
            case 34:
                this.GFX2 = (String)value;
                break;
            case 35:
                this.GFX3 = (String)value;
                break;
            case 36:
                this.firstPower = uData.getShort((Integer)value);
                break;
            case 37:
                this.firstControl = uData.getShort((Integer)value);
                break;
            case 38:
                this.firstAccuracy = uData.getShort((Integer)value);
                break;
            case 39:
                this.firstSpin = uData.getShort((Integer)value);
                break;
            case 40:
                this.firstCurve = uData.getShort((Integer)value);
                break;
            case 41:
                this.U37 = uData.getByte((Short)value);
                break;
            case 42:
                this.U38 = uData.getByte((Short)value);
                break;
            case 43:
                this.U39 = uData.getByte((Short)value);
                break;
            case 44:
                this.U43 = uData.getByte((Short)value);
                break;
            case 45:
                this.U44 = uData.getByte((Short)value);
                break;
            case 46:
                this.U45 = uData.getByte((Short)value);
                break;
            case 47:
                this.U46 = uData.getInt((Long)value);
                break;
            case 48:
                this.initPower = uData.getByte((Short)value);
                break;
            case 49:
                this.initControl = uData.getByte((Short)value);
                break;
            case 50:
                this.initAccuracy = uData.getByte((Short)value);
                break;
            case 51:
                this.initSpin = uData.getByte((Short)value);
                break;
            case 52:
                this.initCurve = uData.getByte((Short)value);
                break;
            case 53:
                this.U52 = uData.getInt((Long)value);
                break;
            case 54:
                this.U53 = uData.getByte((Short)value);
                break;
            case 55:
                this.U55 = uData.getShort((Integer)value);
                break;
            case 56:
                this.U56 = uData.getShort((Integer)value);
                break;
            case 57:
                this.U57 = uData.getShort((Integer)value);
                break;
            case 58:
                this.U58 = uData.getShort((Integer)value);
                break;
            case 59:
                this.U59 = uData.getShort((Integer)value);
                break;
            case 60:
                this.U60 = uData.getShort((Integer)value);
                break;
            case 61:
                this.U61 = uData.getShort((Integer)value);
                break;
            case 62:
                this.U62 = uData.getShort((Integer)value);
                break;
            case 63:
                this.U63 = uData.getShort((Integer)value);
                break;
            case 64:
                this.U64 = uData.getShort((Integer)value);
                break;
            case 65:
                this.U65 = uData.getShort((Integer)value);
                break;
            case 66:
                this.U66 = uData.getShort((Integer)value);
                break;
            case 67:
                this.U67 = uData.getShort((Integer)value);
                break;
            case 68:
                this.U68 = uData.getShort((Integer)value);
                break;
            case 69:
                this.U69 = uData.getShort((Integer)value);
                break;
            case 70:
                this.U70 = uData.getShort((Integer)value);
                break;
            case 71:
                this.U71 = uData.getShort((Integer)value);
                break;
            case 72:
                this.U72 = uData.getShort((Integer)value);
                break;
            case 73:
                this.U73 = uData.getShort((Integer)value);
                break;
        }
    }
}
