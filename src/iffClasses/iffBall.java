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
public final class iffBall extends iffBase {

    // base should be equal to iffBase.getColNum()
    private final int base = iffBase.base;
    public String Sprite2Name = ""; // 40 bytes - bytes 144-184
    public short U14 = 0; // 2 bytes - byte 110-111
    public short U33 = 0; // 2 bytes COM0? - bytes 185-186
    public short U34 = 0; // 2 bytes COM1? - bytes 187-188
    public short U35 = 0; // 2 bytes COM2? - bytes 189-190
    public String GFX1 = ""; // 40 bytes - bytes 144-184
    public String GFX2 = ""; // 40 bytes - bytes 144-184
    public String GFX3 = ""; // 40 bytes - bytes 144-184
    public String GFX4 = ""; // 40 bytes - bytes 144-184
    public String GFX5 = ""; // 40 bytes - bytes 144-184
    public String GFX6 = ""; // 40 bytes - bytes 144-184
    public String GFX7 = ""; // 40 bytes - bytes 144-184
    public String GFX8 = ""; // 40 bytes - bytes 144-184
    public String GFX9 = ""; // 40 bytes - bytes 144-184
    public String GFX10 = ""; // 40 bytes - bytes 144-184
    public String GFX11 = ""; // 40 bytes - bytes 144-184
    public String GFX12 = ""; // 40 bytes - bytes 144-184
    public String GFX13 = ""; // 40 bytes - bytes 144-184
    public String GFX14 = ""; // 40 bytes - bytes 144-184
    public short U36 = 0; // 2 bytes COM3? - bytes 191-192
    public short U37 = 0; // 2 bytes COM4? - bytes 193-194
    public short U38 = 0; // 2 bytes COM4? - bytes 193-194
    public short U39 = 0; // 2 bytes COM4? - bytes 193-194
    public short U40 = 0; // 2 bytes COM4? - bytes 193-194
    public short U41 = 0; // 2 bytes COM4? - bytes 193-194
    String[] colNames = new String[] {  "Icon2?",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "GFX1",
                                        "GFX2",
                                        "GFX3",
                                        "GFX4",
                                        "GFX5",
                                        "GFX6",
                                        "GFX7",
                                        "GFX8",
                                        "GFX9",
                                        "GFX10",
                                        "GFX11",
                                        "GFX12",
                                        "GFX13",
                                        "GFX14",
                                        "GFX15",
                                        "Amount",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA"};

    public iffBall(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffBall(String[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffBall() {
        super();
        buildColNames();
    }

    @Override
    public int getColNum() {
        return this.colNames.length;
    }

    public void buildColNames() {
        List<String> temp =
        new ArrayList<String>(super.colNames.length + this.colNames.length);
        temp.addAll(Arrays.asList(super.colNames));
        temp.addAll(Arrays.asList(this.colNames));
        this.colNames = (String[]) temp.toArray(new String[temp.size()]);
    }

    @Override
    public void getItem(String[] inData) {
        super.getItem(inData);
        Sprite2Name = inData[32];
        U14 = uData.getShort(Integer.parseInt(inData[33]));
        U33 = uData.getShort(Integer.parseInt(inData[34]));
        U34 = uData.getShort(Integer.parseInt(inData[35]));
        U35 = uData.getShort(Integer.parseInt(inData[36]));
        GFX1 = inData[37];
        GFX2 = inData[38];
        GFX3 = inData[39];
        GFX4 = inData[40];
        GFX5 = inData[41];
        GFX6 = inData[42];
        GFX7 = inData[43];
        GFX8 = inData[44];
        GFX9 = inData[45];
        GFX10 = inData[46];
        GFX11 = inData[47];
        GFX12 = inData[48];
        GFX13 = inData[49];
        GFX14 = inData[50];
        U36 = uData.getShort(Integer.parseInt(inData[51]));
        U37 = uData.getShort(Integer.parseInt(inData[52]));
        U38 = uData.getShort(Integer.parseInt(inData[53]));
        U39 = uData.getShort(Integer.parseInt(inData[54]));
        U40 = uData.getShort(Integer.parseInt(inData[55]));
        U41 = uData.getShort(Integer.parseInt(inData[56]));
    }
    
    @Override
    public void getItem(byte[] inData) throws IOException {
        try {
            super.getItem(inData);
            Sprite2Name = uData.getString(new ByteArrayInputStream(inData, 144, uData.stringLength));
            U14 = uData.getShort(new byte[]{inData[184], inData[185]});
            U33 = uData.getShort(new byte[]{inData[186], inData[187]});
            U34 = uData.getShort(new byte[]{inData[188], inData[189]});
            U35 = uData.getShort(new byte[]{inData[190], inData[191]});
            GFX1 = uData.getString(new ByteArrayInputStream(inData, 192, uData.stringLength));
            GFX2 = uData.getString(new ByteArrayInputStream(inData, 232, uData.stringLength));
            GFX3 = uData.getString(new ByteArrayInputStream(inData, 272, uData.stringLength));
            GFX4 = uData.getString(new ByteArrayInputStream(inData, 312, uData.stringLength));
            GFX5 = uData.getString(new ByteArrayInputStream(inData, 352, uData.stringLength));
            GFX6 = uData.getString(new ByteArrayInputStream(inData, 392, uData.stringLength));
            GFX7 = uData.getString(new ByteArrayInputStream(inData, 432, uData.stringLength));
            GFX8 = uData.getString(new ByteArrayInputStream(inData, 472, uData.stringLength));
            GFX9 = uData.getString(new ByteArrayInputStream(inData, 512, uData.stringLength));
            GFX10 = uData.getString(new ByteArrayInputStream(inData, 552, uData.stringLength));
            GFX11 = uData.getString(new ByteArrayInputStream(inData, 592, uData.stringLength));
            GFX12 = uData.getString(new ByteArrayInputStream(inData, 632, uData.stringLength));
            GFX13 = uData.getString(new ByteArrayInputStream(inData, 672, uData.stringLength));
            GFX14 = uData.getString(new ByteArrayInputStream(inData, 712, uData.stringLength));
            U36 = uData.getShort(new byte[]{inData[752], inData[753]});
            U37 = uData.getShort(new byte[]{inData[754], inData[755]});
            U38 = uData.getShort(new byte[]{inData[756], inData[757]});
            U39 = uData.getShort(new byte[]{inData[758], inData[759]});
            U40 = uData.getShort(new byte[]{inData[760], inData[761]});
            U41 = uData.getShort(new byte[]{inData[762], inData[763]});
        } catch (IOException ex) {
            throw new IOException("Failed to read all data.");
        }
    }

    @Override
    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
        
    @Override
    public Object getValue(int colIndex) {
        if (colIndex < super.getColNum()) {
            return super.getValue(colIndex);
        }
        else {
            switch (colIndex) {
                case base:
                    return this.Sprite2Name;
                case (base+1):
                    return uData.getInt(this.U14);
                case (base+2):
                    return uData.getInt(this.U33);
                case (base+3):
                    return uData.getInt(this.U34);
                case (base+4):
                    return uData.getInt(this.U35);
                case (base+5):
                    return this.GFX1;
                case (base+6):
                    return this.GFX2;
                case (base+7):
                    return this.GFX3;
                case (base+8):
                    return this.GFX4;
                case (base+9):
                    return this.GFX5;
                case (base+10):
                    return this.GFX6;
                case (base+11):
                    return this.GFX7;
                case (base+12):
                    return this.GFX8;
                case (base+13):
                    return this.GFX9;
                case (base+14):
                    return this.GFX10;
                case (base+15):
                    return this.GFX11;
                case (base+16):
                    return this.GFX12;
                case (base+17):
                    return this.GFX13;
                case (base+18):
                    return this.GFX14;
                case (base+19):
                    return uData.getInt(this.U36);
                case (base+20):
                    return uData.getInt(this.U37);
                case (base+21):
                    return uData.getInt(this.U38);
                case (base+22):
                    return uData.getInt(this.U39);
                case (base+23):
                    return uData.getInt(this.U40);
                case (base+24):
                    return uData.getInt(this.U41);
                default:
                    return "&";
            }
        }
    }

    @Override
    public void setValue(int colIndex, Object value) {
        if (colIndex < super.getColNum()) {
            super.setValue(colIndex, value);
        }
        else {
            switch (colIndex) {
                case base:
                    this.Sprite2Name = (String)value;
                    break;
                case (base+1):
                    this.U14 = uData.getShort((Integer)value);
                    break;
                case (base+2):
                    this.U33 = uData.getShort((Integer)value);
                    break;
                case (base+3):
                    this.U34 = uData.getShort((Integer)value);
                    break;
                case (base+4):
                    this.U35 = uData.getShort((Integer)value);
                    break;
                case (base+5):
                    this.GFX1 = (String)value;
                    break;
                case (base+6):
                    this.GFX2 = (String)value;
                    break;
                case (base+7):
                    this.GFX3 = (String)value;
                    break;
                case (base+8):
                    this.GFX4 = (String)value;
                    break;
                case (base+9):
                    this.GFX5 = (String)value;
                    break;
                case (base+10):
                    this.GFX6 = (String)value;
                    break;
                case (base+11):
                    this.GFX7 = (String)value;
                    break;
                case (base+12):
                    this.GFX8 = (String)value;
                    break;
                case (base+13):
                    this.GFX9 = (String)value;
                    break;
                case (base+14):
                    this.GFX10 = (String)value;
                    break;
                case (base+15):
                    this.GFX11 = (String)value;
                    break;
                case (base+16):
                    this.GFX12 = (String)value;
                    break;
                case (base+17):
                    this.GFX13 = (String)value;
                    break;
                case (base+18):
                    this.GFX14 = (String)value;
                    break;
                case (base+19):
                    this.U36 = uData.getShort((Integer)value);
                    break;
                case (base+20):
                    this.U37 = uData.getShort((Integer)value);
                    break;
                case (base+21):
                    this.U38 = uData.getShort((Integer)value);
                    break;
                case (base+22):
                    this.U39 = uData.getShort((Integer)value);
                    break;
                case (base+23):
                    this.U40 = uData.getShort((Integer)value);
                    break;
                case (base+24):
                    this.U41 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
