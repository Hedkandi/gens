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
public final class iffPart extends iffBase {
    
    // base should be equal to iffBase.getColNum()
    private static final int base = iffBase.base;
    public String Sprite2Name = ""; 
    public byte PartCategory = 0; 
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
    public short PowerUp = 0; 
    public short ControlUp = 0; 
    public short AccuracyUp = 0; 
    public short SpinUp = 0; 
    public short CurveUp = 0; 
    public short PowerSlotUp = 0; 
    public short ControlSlotUp = 0; 
    public short AccuracySlotUp = 0; 
    public short SpinSlotUp = 0; 
    public short CurveSlotUp = 0; 
    public String UString1 = "";
    public int equipWith1 = 0;
    public int equipWith2 = 0;
    public short U67 = 0; 
    public short U68 = 0; 
    public short U69 = 0; 
    public short U70 = 0; 
    String[] colNames = new String[] {  "Model",
                                        "Part Category",
                                        "PosMask",
                                        "HideMask",
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
                                        "Power Up",
                                        "Control Up",
                                        "Accuracy Up",
                                        "Spin Up",
                                        "Curve Up",
                                        "Power Slot Up",
                                        "Control Slot Up",
                                        "Accuracy Slot Up",
                                        "Spin Slot Up",
                                        "Curve Slot Up",
                                        "Equippable With",
                                        "Subpart #1",
                                        "Subpart #2",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA"};
    
    public iffPart(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
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
            PartCategory = uData.getByte(inData[29]);
            numStat2 =  uData.getByte(inData[30]);
            numStat3 =  uData.getByte(inData[31]);
            numStat4 =  uData.getByte(inData[32]);
            numStat5 =  uData.getByte(inData[33]);
            numStat6 =  uData.getByte(inData[34]);
            numStat7 =  uData.getByte(inData[35]);
            numStat8 =  uData.getByte(inData[36]);
            numStat9 =  uData.getByte(inData[37]);
            numStat10 =  uData.getByte(inData[38]);
            numStat11 =  uData.getByte(inData[39]);
            numStat12 =  uData.getByte(inData[40]);
            Sprite3Name = inData[41];
            Sprite4Name = inData[42];
            Sprite5Name = inData[43];
            Sprite6Name = inData[44];
            Sprite7Name = inData[45];
            Sprite8Name = inData[46];
            PowerUp = uData.getShort(inData[47]);
            ControlUp = uData.getShort(inData[48]);
            AccuracyUp = uData.getShort(inData[49]);
            SpinUp = uData.getShort(inData[50]);
            CurveUp = uData.getShort(inData[51]);
            PowerSlotUp = uData.getShort(inData[52]);
            ControlSlotUp = uData.getShort(inData[53]);
            AccuracySlotUp = uData.getShort(inData[54]);
            SpinSlotUp = uData.getShort(inData[55]);
            CurveSlotUp = uData.getShort(inData[56]);
            UString1 = inData[57];
            equipWith1 = uData.getInt(inData[58]);
            equipWith2 = uData.getInt(inData[59]);
            U67 = uData.getShort(inData[60]);
            U68 = uData.getShort(inData[61]);
            U69 = uData.getShort(inData[62]);
            U70 = uData.getShort(inData[63]);
            //throw new IOException("not done");
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }
            
    @Override
    public void getItem(byte[] inData) throws IOException {
        try {
            super.getItem(inData);
            Sprite2Name = uData.getString(new ByteArrayInputStream(inData, 144, uData.stringLength));
            PartCategory = inData[184];
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
            PowerUp = uData.getShort(new byte[]{inData[436], inData[437]});
            ControlUp = uData.getShort(new byte[]{inData[438], inData[439]});
            AccuracyUp = uData.getShort(new byte[]{inData[440], inData[441]});
            SpinUp = uData.getShort(new byte[]{inData[442], inData[443]});
            CurveUp = uData.getShort(new byte[]{inData[444], inData[445]});
            PowerSlotUp = uData.getShort(new byte[]{inData[446], inData[447]});
            ControlSlotUp = uData.getShort(new byte[]{inData[448], inData[449]});
            AccuracySlotUp = uData.getShort(new byte[]{inData[450], inData[451]});
            SpinSlotUp = uData.getShort(new byte[]{inData[452], inData[453]});
            CurveSlotUp = uData.getShort(new byte[]{inData[454], inData[455]});
            UString1 = uData.getString(new ByteArrayInputStream(inData, 456, uData.stringLength));
            equipWith1 = uData.getInt(new byte[]{inData[496], inData[497], inData[498], inData[499]});
            equipWith2 = uData.getInt(new byte[]{inData[500], inData[501], inData[502], inData[503]});
            U67 = uData.getShort(new byte[]{inData[504], inData[505]});
            U68 = uData.getShort(new byte[]{inData[506], inData[507]});
            U69 = uData.getShort(new byte[]{inData[508], inData[509]});
            U70 = uData.getShort(new byte[]{inData[510], inData[511]});
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
                    return uData.getShort(this.PartCategory);
                case (base+2):
                    return uData.getShort(this.numStat2);
                case (base+3):
                    return uData.getShort(this.numStat3);
                case (base+4):
                    return uData.getShort(this.numStat4);
                case (base+5):
                    return uData.getShort(this.numStat5);
                case (base+6):
                    return uData.getShort(this.numStat6);
                case (base+7):
                    return uData.getShort(this.numStat7);
                case (base+8):
                    return uData.getShort(this.numStat8);
                case (base+9):
                    return uData.getShort(this.numStat9);
                case (base+10):
                    return uData.getShort(this.numStat10);
                case (base+11):
                    return uData.getShort(this.numStat11);
                case (base+12):
                    return uData.getShort(this.numStat12);
                case (base+13):
                    return this.Sprite3Name;
                case (base+14):
                    return this.Sprite4Name;
                case (base+15):
                    return this.Sprite5Name;
                case (base+16):
                    return this.Sprite6Name;
                case (base+17):
                    return this.Sprite7Name;
                case (base+18):
                    return this.Sprite8Name;
                case (base+19):
                    return uData.getInt(this.PowerUp);
                case (base+20):
                    return uData.getInt(this.ControlUp);
                case (base+21):
                    return uData.getInt(this.AccuracyUp);
                case (base+22):
                    return uData.getInt(this.SpinUp);
                case (base+23):
                    return uData.getInt(this.CurveUp);
                case (base+24):
                    return uData.getInt(this.PowerSlotUp);
                case (base+25):
                    return uData.getInt(this.ControlSlotUp);
                case (base+26):
                    return uData.getInt(this.AccuracySlotUp);
                case (base+27):
                    return uData.getInt(this.SpinSlotUp);
                case (base+28):
                    return uData.getInt(this.CurveSlotUp);
                case (base+29):
                    return this.UString1;
                case (base+30):
                    return uData.getLong(this.equipWith1);
                case (base+31):
                    return uData.getLong(this.equipWith2);
                case (base+32):
                    return uData.getInt(this.U67);
                case (base+33):
                    return uData.getInt(this.U68);
                case (base+34):
                    return uData.getInt(this.U69);
                case (base+35):
                    return uData.getInt(this.U70);
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
                case base:
                    this.Sprite2Name = (String)value;
                    break;
                case (base+1):
                    this.PartCategory = uData.getByte((Short)value);
                    break;
                case (base+2):
                    this.numStat2 = uData.getByte((Short)value);
                    break;
                case (base+3):
                    this.numStat3 = uData.getByte((Short)value);
                    break;
                case (base+4):
                    this.numStat4 = uData.getByte((Short)value);
                    break;
                case (base+5):
                    this.numStat5 = uData.getByte((Short)value);
                    break;
                case (base+6):
                    this.numStat6 = uData.getByte((Short)value);
                    break;
                case (base+7):
                    this.numStat7 = uData.getByte((Short)value);
                    break;
                case (base+8):
                    this.numStat8 = uData.getByte((Short)value);
                    break;
                case (base+9):
                    this.numStat9 = uData.getByte((Short)value);
                    break;
                case (base+10):
                    this.numStat10 = uData.getByte((Short)value);
                    break;
                case (base+11):
                    this.numStat11 = uData.getByte((Short)value);
                    break;
                case (base+12):
                    this.numStat12 = uData.getByte((Short)value);
                    break;
                case (base+13):
                    this.Sprite3Name = (String)value;
                    break;
                case (base+14):
                    this.Sprite4Name = (String)value;
                    break;
                case (base+15):
                    this.Sprite5Name = (String)value;
                    break;
                case (base+16):
                    this.Sprite6Name = (String)value;
                    break;
                case (base+17):
                    this.Sprite7Name = (String)value;
                    break;
                case (base+18):
                    this.Sprite8Name = (String)value;
                    break;
                case (base+19):
                    this.PowerUp = uData.getShort((Integer)value);
                    break;
                case (base+20):
                    this.ControlUp = uData.getShort((Integer)value);
                    break;
                case (base+21):
                    this.AccuracyUp = uData.getShort((Integer)value);
                    break;
                case (base+22):
                    this.SpinUp = uData.getShort((Integer)value);
                    break;
                case (base+23):
                    this.CurveUp = uData.getShort((Integer)value);
                    break;
                case (base+24):
                    this.PowerSlotUp = uData.getShort((Integer)value);
                    break;
                case (base+25):
                    this.ControlSlotUp = uData.getShort((Integer)value);
                    break;
                case (base+26):
                    this.AccuracySlotUp = uData.getShort((Integer)value);
                    break;
                case (base+27):
                    this.SpinSlotUp = uData.getShort((Integer)value);
                    break;
                case (base+28):
                    this.CurveSlotUp = uData.getShort((Integer)value);
                    break;
                case (base+29):
                    this.UString1 = (String)value;
                    break;
                case (base+30):
                    this.equipWith1 = uData.getInt((Long)value);
                    break;
                case (base+31):
                    this.equipWith2 = uData.getInt((Long)value);
                    break;
                case (base+32):
                    this.U67 = uData.getShort((Integer)value);
                    break;
                case (base+33):
                    this.U68 = uData.getShort((Integer)value);
                    break;
                case (base+34):
                    this.U69 = uData.getShort((Integer)value);
                    break;
                case (base+35):
                    this.U70 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
