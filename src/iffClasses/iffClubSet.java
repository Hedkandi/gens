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

/**
 *
 * @author hedkandi
 */
public final class iffClubSet extends iffBase {
    
    public int clubWood = 0; // 40 bytes - bytes 144-184
    public int clubIron = 0; // 40 bytes - bytes 144-184
    public int clubWedge = 0; // 40 bytes - bytes 144-184
    public int clubPutter = 0; // 40 bytes - bytes 144-184
    public short initPower = 0; // 2 bytes COM0? - bytes 185-186
    public short initControl = 0; // 2 bytes COM1? - bytes 187-188
    public short initAccuracy = 0; // 2 bytes COM2? - bytes 189-190
    public short initSpin = 0; // 2 bytes COM3? - bytes 191-192
    public short initCurve = 0; // 2 bytes COM4? - bytes 193-194
    public short maxPower = 0; // 2 bytes COM4? - bytes 193-194
    public short maxControl = 0; // 2 bytes COM4? - bytes 193-194
    public short maxAccuracy = 0; // 2 bytes COM4? - bytes 193-194
    public short maxSpin = 0; // 2 bytes COM4? - bytes 193-194
    public short maxCurve = 0; // 2 bytes COM4? - bytes 193-194
    String[] colNames = new String[] {  "Wood Club",
                                        "Iron Club",
                                        "Wedge Club",
                                        "Putter Club",
                                        "Init Power",
                                        "Init Control",
                                        "Init Accuracy",
                                        "Init Spin",
                                        "Init Curve",
                                        "Max Power",
                                        "Max Control",
                                        "Max Accuracy",
                                        "Max Spin",
                                        "Max Curve"};


    //public short U38 = -1; // 2 bytes - bytes 195-196

    public iffClubSet(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffClubSet() {
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
    public int getColNum() {
        return this.colNames.length;
    }

    @Override
    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
    
    @Override
    public void getItem(byte[] inData) throws IOException {
        try {
            super.getItem(inData);
            clubWood = uData.getInt(new byte[]{inData[144], inData[145], inData[146], inData[147]});
            clubIron = uData.getInt(new byte[]{inData[148], inData[149], inData[150], inData[151]});
            clubWedge = uData.getInt(new byte[]{inData[152], inData[153], inData[154], inData[155]});
            clubPutter = uData.getInt(new byte[]{inData[156], inData[157], inData[158], inData[159]});
            initPower = uData.getShort(new byte[]{inData[160], 0x0});
            initControl = uData.getShort(new byte[]{inData[162], 0x0});
            initAccuracy = uData.getShort(new byte[]{inData[164], 0x0});
            initSpin = uData.getShort(new byte[]{inData[166], 0x0});
            initCurve = uData.getShort(new byte[]{inData[168], 0x0});
            maxPower = uData.getShort(new byte[]{inData[170], 0x0});
            maxControl = uData.getShort(new byte[]{inData[172], 0x0});
            maxAccuracy = uData.getShort(new byte[]{inData[174], 0x0});
            maxSpin = uData.getShort(new byte[]{inData[176], 0x0});
            maxCurve = uData.getShort(new byte[]{inData[178], 0x0});
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
                case 32:
                    return uData.getLong(this.clubWood);
                case 33:
                    return uData.getLong(this.clubIron);
                case 34:
                    return uData.getLong(this.clubWedge);
                case 35:
                    return uData.getLong(this.clubPutter);
                case 36:
                    return uData.getInt(this.initPower);
                case 37:
                    return uData.getInt(this.initControl);
                case 38:
                    return uData.getInt(this.initAccuracy);
                case 39:
                    return uData.getInt(this.initSpin);
                case 40:
                    return uData.getInt(this.initCurve);
                case 41:
                    return uData.getInt(this.maxPower);
                case 42:
                    return uData.getInt(this.maxControl);
                case 43:
                    return uData.getInt(this.maxAccuracy);
                case 44:
                    return uData.getInt(this.maxSpin);
                case 45:
                    return uData.getInt(this.maxCurve);
                default:
                    return "";
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
                case 32:
                    this.clubWood = uData.getInt((Long)value);
                    break;
                case 33:
                    this.clubIron = uData.getInt((Long)value);
                    break;
                case 34:
                    this.clubWedge = uData.getInt((Long)value);
                    break;
                case 35:
                    this.clubPutter = uData.getInt((Long)value);
                    break;
                case 36:
                    this.initPower = uData.getShort((Integer)value);
                    break;
                case 37:
                    this.initControl = uData.getShort((Integer)value);
                    break;
                case 38:
                    this.initAccuracy = uData.getShort((Integer)value);
                    break;
                case 39:
                    this.initSpin = uData.getShort((Integer)value);
                    break;
                case 40:
                    this.initCurve = uData.getShort((Integer)value);
                    break;
                case 41:
                    this.maxPower = uData.getShort((Integer)value);
                    break;
                case 42:
                    this.maxControl = uData.getShort((Integer)value);
                    break;
                case 43:
                    this.maxAccuracy = uData.getShort((Integer)value);
                    break;
                case 44:
                    this.maxSpin = uData.getShort((Integer)value);
                    break;
                case 45:
                    this.maxCurve = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
