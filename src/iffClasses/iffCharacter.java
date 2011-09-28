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
public final class iffCharacter extends iffBase {
    
    // base should be equal to iffBase.getColNum()
    private static final int base = iffBase.base;
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
    String[] colNames = new String[] {  "Icon2?",
                                        "GFX1",
                                        "GFX2",
                                        "GFX3",
                                        "Power",
                                        "Control",
                                        "Accuracy",
                                        "Spin",
                                        "Curve",
                                        "Init-Power?",
                                        "Init-Control?",
                                        "Init-Accuracy?",
                                        "Init-Spin?",
                                        "Init-Curve?",
                                        "NA",
                                        "NA",
                                        "Init Power",
                                        "Init Control",
                                        "Init Accuracy",
                                        "Init Spin",
                                        "Init Curve",
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
    public iffCharacter(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffCharacter(String[] inData) throws IOException {
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
        colNames[7] = "Character ID";
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
    public void getItem(String[] inData) throws IOException {
        try {
            super.getItem(inData);
            Sprite2Name = inData[28];
            GFX1 = inData[29];
            GFX2 = inData[30];
            GFX3 = inData[31];
            firstPower = uData.getShort(Integer.parseInt(inData[32]));
            firstControl = uData.getShort(Integer.parseInt(inData[33]));
            firstAccuracy = uData.getShort(Integer.parseInt(inData[34]));
            firstSpin = uData.getShort(Integer.parseInt(inData[35]));
            firstCurve = uData.getShort(Integer.parseInt(inData[36]));
            U37 = uData.getByte(Short.parseShort(inData[37]));
            U38 = uData.getByte(Short.parseShort(inData[38]));
            U39 = uData.getByte(Short.parseShort(inData[39]));
            U43 = uData.getByte(Short.parseShort(inData[40]));
            U44 = uData.getByte(Short.parseShort(inData[41]));
            U45 = uData.getByte(Short.parseShort(inData[42]));
            U46 = uData.getInt(Long.parseLong(inData[43]));
            initPower = uData.getByte(Short.parseShort(inData[44]));
            initControl = uData.getByte(Short.parseShort(inData[45]));
            initAccuracy = uData.getByte(Short.parseShort(inData[46]));
            initSpin = uData.getByte(Short.parseShort(inData[47]));
            initCurve = uData.getByte(Short.parseShort(inData[48]));
            U52 = uData.getInt(Integer.parseInt(inData[49]));
            U53 = uData.getByte(Short.parseShort(inData[50]));
            U55 = uData.getShort(Integer.parseInt(inData[51]));
            U56 = uData.getShort(Integer.parseInt(inData[52]));
            U57 = uData.getShort(Integer.parseInt(inData[53]));
            U58 = uData.getShort(Integer.parseInt(inData[54]));
            U59 = uData.getShort(Integer.parseInt(inData[55]));
            U60 = uData.getShort(Integer.parseInt(inData[56]));
            U61 = uData.getShort(Integer.parseInt(inData[57]));
            U62 = uData.getShort(Integer.parseInt(inData[58]));
            U63 = uData.getShort(Integer.parseInt(inData[59]));
            U64 = uData.getShort(Integer.parseInt(inData[60]));
            U65 = uData.getShort(Integer.parseInt(inData[61]));
            U66 = uData.getShort(Integer.parseInt(inData[62]));
            U67 = uData.getShort(Integer.parseInt(inData[63]));
            U68 = uData.getShort(Integer.parseInt(inData[64]));
            U69 = uData.getShort(Integer.parseInt(inData[65]));
            U70 = uData.getShort(Integer.parseInt(inData[66]));
            U71 = uData.getShort(Integer.parseInt(inData[67]));
            U72 = uData.getShort(Integer.parseInt(inData[68]));
            U73 = uData.getShort(Integer.parseInt(inData[69]));
        } catch (Exception ex) {
            throw new IOException(ex);
        }
    }

    @Override
    public void getItem(byte[] inData) throws IOException {
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
                    return this.Sprite2Name;
                case (base+1):
                    return this.GFX1;
                case (base+2):
                    return this.GFX2;
                case (base+3):
                    return this.GFX3;
                case (base+4):
                    return uData.getInt(this.firstPower);
                case (base+5):
                    return uData.getInt(this.firstControl);
                case (base+6):
                    return uData.getInt(this.firstAccuracy);
                case (base+7):
                    return uData.getInt(this.firstSpin);
                case (base+8):
                    return uData.getInt(this.firstCurve);
                case (base+9):
                    return uData.getShort(this.U37);
                case (base+10):
                    return uData.getShort(this.U38);
                case (base+11):
                    return uData.getShort(this.U39);
                case (base+12):
                    return uData.getShort(this.U43);
                case (base+13):
                    return uData.getShort(this.U44);
                case (base+14):
                    return uData.getShort(this.U45);
                case (base+15):
                    return uData.getLong(this.U46);
                case (base+16):
                    return uData.getShort(this.initPower);
                case (base+17):
                    return uData.getShort(this.initControl);
                case (base+18):
                    return uData.getShort(this.initAccuracy);
                case (base+19):
                    return uData.getShort(this.initSpin);
                case (base+20):
                    return uData.getShort(this.initCurve);
                case (base+21):
                    return uData.getLong(this.U52);
                case (base+22):
                    return uData.getShort(this.U53);
                case (base+23):
                    return uData.getInt(this.U55);
                case (base+24):
                    return uData.getInt(this.U56);
                case (base+25):
                    return uData.getInt(this.U57);
                case (base+26):
                    return uData.getInt(this.U58);
                case (base+27):
                    return uData.getInt(this.U59);
                case (base+28):
                    return uData.getInt(this.U60);
                case (base+29):
                    return uData.getInt(this.U61);
                case (base+30):
                    return uData.getInt(this.U62);
                case (base+31):
                    return uData.getInt(this.U63);
                case (base+32):
                    return uData.getInt(this.U64);
                case (base+33):
                    return uData.getInt(this.U65);
                case (base+34):
                    return uData.getInt(this.U66);
                case (base+35):
                    return uData.getInt(this.U67);
                case (base+36):
                    return uData.getInt(this.U68);
                case (base+37):
                    return uData.getInt(this.U69);
                case (base+38):
                    return uData.getInt(this.U70);
                case (base+39):
                    return uData.getInt(this.U71);
                case (base+40):
                    return uData.getInt(this.U72);
                case (base+41):
                    return uData.getInt(this.U73);
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
                    this.Sprite2Name = (String)value;
                    break;
                case (base+1):
                    this.GFX1 = (String)value;
                    break;
                case (base+2):
                    this.GFX2 = (String)value;
                    break;
                case (base+3):
                    this.GFX3 = (String)value;
                    break;
                case (base+4):
                    this.firstPower = uData.getShort((Integer)value);
                    break;
                case (base+5):
                    this.firstControl = uData.getShort((Integer)value);
                    break;
                case (base+6):
                    this.firstAccuracy = uData.getShort((Integer)value);
                    break;
                case (base+7):
                    this.firstSpin = uData.getShort((Integer)value);
                    break;
                case (base+8):
                    this.firstCurve = uData.getShort((Integer)value);
                    break;
                case (base+9):
                    this.U37 = uData.getByte((Short)value);
                    break;
                case (base+10):
                    this.U38 = uData.getByte((Short)value);
                    break;
                case (base+11):
                    this.U39 = uData.getByte((Short)value);
                    break;
                case (base+12):
                    this.U43 = uData.getByte((Short)value);
                    break;
                case (base+13):
                    this.U44 = uData.getByte((Short)value);
                    break;
                case (base+14):
                    this.U45 = uData.getByte((Short)value);
                    break;
                case (base+15):
                    this.U46 = uData.getInt((Long)value);
                    break;
                case (base+16):
                    this.initPower = uData.getByte((Short)value);
                    break;
                case (base+17):
                    this.initControl = uData.getByte((Short)value);
                    break;
                case (base+18):
                    this.initAccuracy = uData.getByte((Short)value);
                    break;
                case (base+19):
                    this.initSpin = uData.getByte((Short)value);
                    break;
                case (base+20):
                    this.initCurve = uData.getByte((Short)value);
                    break;
                case (base+21):
                    this.U52 = uData.getInt((Long)value);
                    break;
                case (base+22):
                    this.U53 = uData.getByte((Short)value);
                    break;
                case (base+23):
                    this.U55 = uData.getShort((Integer)value);
                    break;
                case (base+24):
                    this.U56 = uData.getShort((Integer)value);
                    break;
                case (base+25):
                    this.U57 = uData.getShort((Integer)value);
                    break;
                case (base+26):
                    this.U58 = uData.getShort((Integer)value);
                    break;
                case (base+27):
                    this.U59 = uData.getShort((Integer)value);
                    break;
                case (base+28):
                    this.U60 = uData.getShort((Integer)value);
                    break;
                case (base+29):
                    this.U61 = uData.getShort((Integer)value);
                    break;
                case (base+30):
                    this.U62 = uData.getShort((Integer)value);
                    break;
                case (base+31):
                    this.U63 = uData.getShort((Integer)value);
                    break;
                case (base+32):
                    this.U64 = uData.getShort((Integer)value);
                    break;
                case (base+33):
                    this.U65 = uData.getShort((Integer)value);
                    break;
                case (base+34):
                    this.U66 = uData.getShort((Integer)value);
                    break;
                case (base+35):
                    this.U67 = uData.getShort((Integer)value);
                    break;
                case (base+36):
                    this.U68 = uData.getShort((Integer)value);
                    break;
                case (base+37):
                    this.U69 = uData.getShort((Integer)value);
                    break;
                case (base+38):
                    this.U70 = uData.getShort((Integer)value);
                    break;
                case (base+39):
                    this.U71 = uData.getShort((Integer)value);
                    break;
                case (base+40):
                    this.U72 = uData.getShort((Integer)value);
                    break;
                case (base+41):
                    this.U73 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
