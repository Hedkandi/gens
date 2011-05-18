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
                                        "COM0?",
                                        "COM1?",
                                        "COM2?",
                                        "COM3?",
                                        "COM4?",
                                        "COM4?",
                                        "COM4?",
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
                case 32:
                    return this.Sprite2Name;
                case 33:
                    return uData.getInt(this.U14);
                case 34:
                    return uData.getInt(this.U33);
                case 35:
                    return uData.getInt(this.U34);
                case 36:
                    return uData.getInt(this.U35);
                case 37:
                    return this.GFX1;
                case 38:
                    return this.GFX2;
                case 39:
                    return this.GFX3;
                case 40:
                    return this.GFX4;
                case 41:
                    return this.GFX5;
                case 42:
                    return this.GFX6;
                case 43:
                    return this.GFX7;
                case 44:
                    return this.GFX8;
                case 45:
                    return this.GFX9;
                case 46:
                    return this.GFX10;
                case 47:
                    return this.GFX11;
                case 48:
                    return this.GFX12;
                case 49:
                    return this.GFX13;
                case 50:
                    return this.GFX14;
                case 51:
                    return uData.getInt(this.U36);
                case 52:
                    return uData.getInt(this.U37);
                case 53:
                    return uData.getInt(this.U38);
                case 54:
                    return uData.getInt(this.U39);
                case 55:
                    return uData.getInt(this.U40);
                case 56:
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
                case 32:
                    this.Sprite2Name = (String)value;
                    break;
                case 33:
                    this.U14 = uData.getShort((Integer)value);
                    break;
                case 34:
                    this.U33 = uData.getShort((Integer)value);
                    break;
                case 35:
                    this.U34 = uData.getShort((Integer)value);
                    break;
                case 36:
                    this.U35 = uData.getShort((Integer)value);
                    break;
                case 37:
                    this.GFX1 = (String)value;
                    break;
                case 38:
                    this.GFX2 = (String)value;
                    break;
                case 39:
                    this.GFX3 = (String)value;
                    break;
                case 40:
                    this.GFX4 = (String)value;
                    break;
                case 41:
                    this.GFX5 = (String)value;
                    break;
                case 42:
                    this.GFX6 = (String)value;
                    break;
                case 43:
                    this.GFX7 = (String)value;
                    break;
                case 44:
                    this.GFX8 = (String)value;
                    break;
                case 45:
                    this.GFX9 = (String)value;
                    break;
                case 46:
                    this.GFX10 = (String)value;
                    break;
                case 47:
                    this.GFX11 = (String)value;
                    break;
                case 48:
                    this.GFX12 = (String)value;
                    break;
                case 49:
                    this.GFX13 = (String)value;
                    break;
                case 50:
                    this.GFX14 = (String)value;
                    break;
                case 51:
                    this.U36 = uData.getShort((Integer)value);
                    break;
                case 52:
                    this.U37 = uData.getShort((Integer)value);
                    break;
                case 53:
                    this.U38 = uData.getShort((Integer)value);
                    break;
                case 54:
                    this.U39 = uData.getShort((Integer)value);
                    break;
                case 55:
                    this.U40 = uData.getShort((Integer)value);
                    break;
                case 56:
                    this.U41 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
