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
public final class iffCaddie extends iffBase {
    
    public int Salary = 0; // 2 bytes - byte 110-111
    public String Icon2 = ""; // 40 bytes - bytes 144-184
    public short Power = 0; // 2 bytes COM1? - bytes 187-188
    public short Control = 0; // 2 bytes COM2? - bytes 189-190
    public short Accuracy = 0; // 2 bytes COM3? - bytes 191-192
    public short Spin = 0; // 2 bytes COM4? - bytes 193-194
    public short Curve = 0; // 2 bytes COM4? - bytes 193-194
    public short U39 = 0; // 2 bytes COM4? - bytes 193-194
    String[] colNames = new String[] {  "Salary",
                                        "Icon2",
                                        "Power",
                                        "Control",
                                        "Accuracy",
                                        "Spin",
                                        "Curve",
                                        "NA"};

    public iffCaddie(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffCaddie(String[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffCaddie() {
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
        Salary = uData.getInt(Long.parseLong(inData[32]));
        Icon2 = inData[33];
        Power = uData.getShort(Integer.parseInt(inData[34]));
        Control = uData.getShort(Integer.parseInt(inData[35]));
        Accuracy = uData.getShort(Integer.parseInt(inData[36]));
        Spin = uData.getShort(Integer.parseInt(inData[37]));
        Curve = uData.getShort(Integer.parseInt(inData[38]));
        U39 = uData.getShort(Integer.parseInt(inData[39]));
    }

    @Override
    public void getItem(byte[] inData) throws IOException {
        super.getItem(inData);
        Salary = uData.getInt(new byte[] {inData[144], inData[145], inData[146], inData[147]});
        Icon2 = uData.getString(new ByteArrayInputStream(inData,148,uData.stringLength));
        Power = uData.getShort(new byte[] {inData[188], inData[189]});
        Control = uData.getShort(new byte[] {inData[190], inData[191]});
        Accuracy = uData.getShort(new byte[] {inData[192], inData[193]});
        Spin = uData.getShort(new byte[] {inData[194], inData[195]});
        Curve = uData.getShort(new byte[] {inData[196], inData[197]});
        U39 = uData.getShort(new byte[] {inData[198], inData[199]});
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
                return uData.getLong(this.Salary);
            case 33:
                return this.Icon2;
            case 34:
                return uData.getInt(this.Power);
            case 35:
                return uData.getInt(this.Control);
            case 36:
                return uData.getInt(this.Accuracy);
            case 37:
                return uData.getInt(this.Spin);
            case 38:
                return uData.getInt(this.Curve);
            case 39:
                return uData.getInt(this.U39);
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
                this.Salary = uData.getInt((Long)value);
                break;
            case 33:
                this.Icon2 = (String)value;
                break;
            case 34:
                this.Power = uData.getShort((Integer)value);
                break;
            case 35:
                this.Control = uData.getShort((Integer)value);
                break;
            case 36:
                this.Accuracy = uData.getShort((Integer)value);
                break;
            case 37:
                this.Spin = uData.getShort((Integer)value);
                break;
            case 38:
                this.Curve = uData.getShort((Integer)value);
                break;
            case 39:
                this.U39 = uData.getShort((Integer)value);
                break;
        }
    }
}
