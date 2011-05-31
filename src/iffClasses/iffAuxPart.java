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
public final class iffAuxPart extends iffClasses.iffBase {

    // base should be equal to iffBase.getColNum()
    private final int base = iffBase.base;
    public short Amount = 0; 
    public short U33 = 0; 
    public short U34 = 0; 
    public short U35 = 0; 
    public short U36 = 0; 
    public byte Power = 0; 
    public byte Control = 0;
    public byte Accuracy = 0;
    public byte Spin = 0;
    public byte Curve = 0; 
    public byte PowerSlot = 0;
    public byte ControlSlot = 0;
    public byte AccuracySlot = 0;
    public byte SpinSlot = 0; 
    public byte CurveSlot = 0;
    public short DriveUp = 0; 
    public short ItemDropUp = 0; 
    public short ComboUp = 0; 
    public short PangUp = 0; 
    public short Exp = 0; 
    public short U47 = 0;
    
    public String[] colNames = new String[] {  "Amount",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "Power Up",
                                        "Control Up",
                                        "Accuracy Up",
                                        "Spin Up",
                                        "Curve Up",
                                        "Power Slot",
                                        "Control Slot",
                                        "Accuracy Slot",
                                        "Spin Slot",
                                        "Curve Slot",
                                        "YDrive Up",
                                        "Itemdrop Up",
                                        "Combo Up",
                                        "Pang Up",
                                        "EXP Up",
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
        List<String> temp = new ArrayList<String>(super.getColNum() + this.getColNum());
        temp.addAll(Arrays.asList(super.colNames));
        temp.addAll(Arrays.asList(this.colNames));
        this.colNames = (String[]) temp.toArray(new String[temp.size()]);
        temp.clear();
        temp = null;
    }

    @Override
    public void getItem(String[] inData) {
        super.getItem(inData);
        this.Amount = uData.getShort(Integer.parseInt(inData[33]));
        this.U33 = uData.getShort(Integer.parseInt(inData[34]));
        this.U34 = uData.getShort(Integer.parseInt(inData[35]));
        this.U35 = uData.getShort(Integer.parseInt(inData[36]));
        this.U36 = uData.getShort(Integer.parseInt(inData[37]));
        //this.U37 = uData.getShort(Integer.parseInt(inData[38]));
        //this.U38 = uData.getShort(Integer.parseInt(inData[39]));
        //this.U39 = uData.getShort(Integer.parseInt(inData[40]));
        //this.U40 = uData.getShort(Integer.parseInt(inData[41]));
        //this.U41 = uData.getShort(Integer.parseInt(inData[42]));
        this.DriveUp = uData.getShort(Integer.parseInt(inData[43]));
        this.ItemDropUp = uData.getShort(Integer.parseInt(inData[44]));
        this.ComboUp = uData.getShort(Integer.parseInt(inData[45]));
        this.PangUp = uData.getShort(Integer.parseInt(inData[46]));
        this.Exp = uData.getShort(Integer.parseInt(inData[47]));
        this.U47 = uData.getShort(Integer.parseInt(inData[48]));
    }

    @Override
    public final void getItem(byte[] inData) throws IOException {
        try {
            super.getItem(inData);
            this.Amount = uData.getShort(new byte[]{inData[144], inData[145]});
            this.U33 = uData.getShort(new byte[]{inData[146], inData[147]});
            this.U34 = uData.getShort(new byte[]{inData[148], inData[149]});
            this.U35 = uData.getShort(new byte[]{inData[150], inData[151]});
            this.U36 = uData.getShort(new byte[]{inData[152], inData[153]});
            this.Power = inData[154];
            this.Control = inData[155];
            this.Accuracy = inData[156];
            this.Spin = inData[157];
            this.Curve = inData[158];   
            this.PowerSlot = inData[159];
            this.ControlSlot = inData[160];
            this.AccuracySlot = inData[161];
            this.SpinSlot = inData[162];
            this.CurveSlot = inData[163];
            this.DriveUp = uData.getShort(new byte[]{inData[164], inData[165]});
            this.ItemDropUp = uData.getShort(new byte[]{inData[166], inData[167]});
            this.ComboUp = uData.getShort(new byte[]{inData[168], inData[169]});
            this.PangUp = uData.getShort(new byte[]{inData[170], inData[171]});
            this.Exp = uData.getShort(new byte[]{inData[172], inData[173]});
            this.U47 = uData.getShort(new byte[]{inData[174], inData[175]});
        } catch (IOException ex) {
            throw new IOException(ex);
        }
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
    public Object getValue(int colIndex) {
        if (colIndex < super.getColNum()) {
            return super.getValue(colIndex);
        }
        else {
            switch (colIndex) {
                case base:
                    return uData.getInt(this.Amount);
                case (base+1):
                    return uData.getInt(this.U33);
                case (base+2):
                    return uData.getInt(this.U34);
                case (base+3):
                    return uData.getInt(this.U35);
                case (base+4):
                    return uData.getInt(this.U36);
                case (base+5):
                    return uData.getShort(this.Power);
                case (base+6):
                    return uData.getShort(this.Control);
                case (base+7):
                    return uData.getShort(this.Accuracy);
                case (base+8):
                    return uData.getShort(this.Spin);
                case (base+9):
                    return uData.getShort(this.Curve);
                case (base+10):
                    return uData.getShort(this.PowerSlot);
                case (base+11):
                    return uData.getShort(this.ControlSlot);
                case (base+12):
                    return uData.getShort(this.AccuracySlot);
                case (base+13):
                    return uData.getShort(this.SpinSlot);
                case (base+14):
                    return uData.getShort(this.CurveSlot);
                case (base+15):
                    return uData.getInt(this.DriveUp);
                case (base+16):
                    return uData.getInt(this.ItemDropUp);
                case (base+17):
                    return uData.getInt(this.ComboUp);
                case (base+18):
                    return uData.getInt(this.PangUp);
                case (base+19):
                    return uData.getInt(this.Exp);
                case (base+20):
                    return uData.getInt(this.U47);
                default:
                    // Return something that easily can identify missed values
                    return "&";
            }
        }
    }

    @Override
    public void setValue(int colIndex, Object value) {
        if (colIndex <= super.getColNum()) {
            super.setValue(colIndex, value);
        }
        else {
            switch (colIndex) {
                case base:
                    this.Amount = uData.getShort((Integer)value);
                    break;
                case (base+1):
                    this.U33 = uData.getShort((Integer)value);
                    break;
                case (base+2):
                    this.U34 = uData.getShort((Integer)value);
                    break;
                case (base+3):
                    this.U35 = uData.getShort((Integer)value);
                    break;
                case (base+4):
                    this.U36 = uData.getShort((Integer)value);
                    break;
                case (base+5):
                    this.Power = uData.getByte((Short)value);
                    break;
                case (base+6):
                    this.Accuracy = uData.getByte((Short)value);
                    break;
                case (base+7):
                    this.Curve = uData.getByte((Short)value);
                    break;
                case (base+8):
                    this.ControlSlot = uData.getByte((Short)value);
                    break;
                case (base+9):
                    this.SpinSlot = uData.getByte((Short)value);
                    break;
                case (base+10):
                    this.DriveUp = uData.getShort((Integer)value);
                    break;
                case (base+11):
                    this.ItemDropUp = uData.getShort((Integer)value);
                    break;
                case (base+12):
                    this.ComboUp = uData.getShort((Integer)value);
                    break;
                case (base+13):
                    this.PangUp = uData.getShort((Integer)value);
                    break;
                case (base+14):
                    this.Exp = uData.getShort((Integer)value);
                    break;
                case (base+15):
                    this.U47 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
