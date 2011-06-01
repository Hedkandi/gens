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

/**
 *
 * @author hedkandi
 */
public final class iffCard extends iffBase {

    // base should be equal to iffBase.getColNum()
    private static final int base = iffBase.base;
    public byte cardType = 0;
    public String Sprite2Name = "";
    public short PowerUp = 0;
    public short ControlUp = 0;
    public short AccuracyUp = 0;
    public short SpinUp = 0;
    public short CurveUp = 0;
    private short BonusType;
    public short BonusAmount = 0;
    public byte U28 = 0; // 2 bytes COM4? - bytes 193-194
    public String SubIcon = ""; // 2 bytes COM4? - bytes 193-194
    public String SlotImage = ""; // 2 bytes COM4? - bytes 193-194
    public String BuffImage = ""; // 2 bytes COM4? - bytes 193-194
    public short BonusTime = 0; // 2 bytes COM4? - bytes 193-194
    public short CardPack = 0; // 2 bytes COM4? - bytes 193-194
    public short CardNum = 0; // 2 bytes COM4? - bytes 193-194
    public short U43 = 0; // 2 bytes COM4? - bytes 193-194
    private byte U22;
    
    String[] colNames = new String[] {  "Rarity",
                                            "Card GFX",
                                            "NA",
                                            "Power Slot Up",
                                            "Control Slot Up",
                                            "Accuracy Slot Up",
                                            "Spin Slot Up",
                                            "Curve Slot Up",
                                            "Bonus Type",
                                            "Bonus Amount",
                                            "SubIcon",
                                            "Slot Image",
                                            "Buff Image",
                                            "Time",
                                            "Card Pack",
                                            "Card Number",
                                            "NA"};

    public iffCard(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
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
        colNames[3] = "Category";
    }

    @Override
    public int getColNum() {
        return this.colNames.length;
    }

    @Override
    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
    
    @Override
    public void getItem(String[] inData) {
        super.getItem(inData);
        cardType = uData.getByte(Short.parseShort(inData[32]));
        Sprite2Name = inData[33];
        PowerUp = uData.getByte(Short.parseShort(inData[34]));
        ControlUp = uData.getByte(Short.parseShort(inData[36]));
        BonusType = uData.getByte(Short.parseShort(inData[39]));
        AccuracyUp = uData.getByte(Short.parseShort(inData[40]));
        SpinUp = uData.getByte(Short.parseShort(inData[43]));
        CurveUp = uData.getByte(Short.parseShort(inData[45]));
        BonusAmount = uData.getByte(Short.parseShort(inData[47]));
        U28 = uData.getByte(Short.parseShort(inData[48]));
        SubIcon = inData[49];
        SlotImage = inData[50];
        BuffImage = inData[51];
        BonusTime = uData.getShort(Integer.parseInt(inData[52]));
        CardPack = uData.getShort(Integer.parseInt(inData[53]));
        CardNum = uData.getShort(Integer.parseInt(inData[54]));
        U43 = uData.getShort(Integer.parseInt(inData[55]));
    }
    
    @Override
    public void getItem(byte[] inData) throws IOException {
        try {
            super.getItem(inData);
            cardType = inData[144];
            Sprite2Name = uData.getString(new ByteArrayInputStream(inData, 145, uData.stringLength));
            U28 = inData[185];
            PowerUp = uData.getShort(new byte[]{inData[186], inData[187]});
            ControlUp = uData.getShort(new byte[]{inData[188], inData[189]});
            AccuracyUp = uData.getShort(new byte[]{inData[190], inData[191]});
            SpinUp = uData.getShort(new byte[]{inData[192], inData[193]});
            CurveUp = uData.getShort(new byte[]{inData[194], inData[195]});
            BonusType = uData.getShort(new byte[]{inData[196], inData[197]});
            BonusAmount = uData.getShort(new byte[]{inData[198], inData[199]});
            SubIcon = uData.getString(new ByteArrayInputStream(inData, 200, uData.stringLength));
            SlotImage = uData.getString(new ByteArrayInputStream(inData, 240, uData.stringLength));
            BuffImage = uData.getString(new ByteArrayInputStream(inData, 280, uData.stringLength));
            BonusTime = uData.getShort(new byte[]{inData[320], inData[321]});
            CardPack = uData.getShort(new byte[]{inData[322], inData[323]});
            CardNum = uData.getShort(new byte[]{inData[324], inData[325]});
            U43 = uData.getShort(new byte[]{inData[326], inData[327]});
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }

    @Override
    public Object getValue(int colIndex) {
        if (colIndex < super.getColNum()) {
            return super.getValue(colIndex);
        }
        else {
            switch (colIndex) {
                case base:
                    return uData.getShort(this.cardType);
                case (base+1):
                    return this.Sprite2Name;
                case (base+2):
                    return uData.getShort(this.U28);
                case (base+3):
                    return uData.getInt(this.PowerUp);
                case (base+4):
                    return uData.getInt(this.ControlUp);
                case (base+5):
                    return uData.getInt(this.AccuracyUp);
                case (base+6):
                    return uData.getInt(this.SpinUp);
                case (base+7):
                    return uData.getInt(this.CurveUp);
                case (base+8):
                    return uData.getInt(this.BonusType);
                case (base+9):
                    return uData.getInt(this.BonusAmount);
                case (base+10):
                    return this.SubIcon;
                case (base+11):
                    return this.SlotImage;
                case (base+12):
                    return this.BuffImage;
                case (base+13):
                    return uData.getInt(this.BonusTime);
                case (base+14):
                    return uData.getInt(this.CardPack);
                case (base+15):
                    return uData.getInt(this.CardNum);
                case (base+16):
                    return uData.getInt(this.U43);
                default:
                    return "&";
            }
        }
    }

    @Override
    public void setValue(int colIndex, Object value) {
        if (colIndex < super.getColNum()) {
            super.setValue(colIndex,value);
        }
        else {
            switch (colIndex) {
                case base:
                    this.cardType = uData.getByte((Short)value);
                    break;
                case (base+1):
                    this.Sprite2Name = (String)value;
                    break;
                case (base+2):
                    this.U28 = uData.getByte((Short)value);
                    break;
                case (base+3):
                    this.PowerUp = uData.getByte((Short)value);
                    break;
                case (base+4):
                    this.ControlUp = uData.getByte((Short)value);
                    break;
                case (base+5):
                    this.AccuracyUp = uData.getByte((Short)value);
                    break;
                case (base+6):
                    this.U22 = uData.getByte((Short)value);
                    break;
                case (base+7):
                    this.SpinUp = uData.getByte((Short)value);
                    break;
                case (base+8):
                    this.CurveUp = uData.getByte((Short)value);
                    break;
                case (base+9):
                    this.BonusType = uData.getByte((Short)value);
                    break;
                case (base+10):
                    this.BonusAmount = uData.getByte((Short)value);
                    break;
                case (base+11):
                    this.SubIcon = (String)value;
                    break;
                case (base+12):
                    this.SlotImage = (String)value;
                    break;
                case (base+13):
                    this.BuffImage = (String)value;
                    break;
                case (base+14):
                    this.BonusTime = uData.getShort((Integer)value);
                    break;
                case (base+15):
                    this.CardPack = uData.getShort((Integer)value);
                    break;
                case (base+16):
                    this.CardNum = uData.getShort((Integer)value);
                    break;
                case (base+17):
                    this.U43 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
