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

    @Override
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
}
