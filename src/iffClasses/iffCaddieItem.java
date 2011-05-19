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
public final class iffCaddieItem extends iffBase {
    
    // base should be equal to iffBase.getColNum()
    private static final int base = iffBase.base;
    public String GFX1 = ""; // 40 bytes - bytes 144-184
    public String GFX2 = ""; // 40 bytes - bytes 144-184
    public short price1Day = 0; // 2 bytes - byte 110-111
    public short U33 = 0; // 2 bytes COM0? - bytes 185-186
    public short price7Days = 0; // 2 bytes COM1? - bytes 187-188
    public short price30Days = 0; // 2 bytes COM2? - bytes 189-190
    public short Amount = 0; // 2 bytes COM3? - bytes 191-192
    public short U37 = 0; // 2 bytes COM4? - bytes 193-194
    String[] colNames = new String[] {  "GFX1",
                                        "GFX2",
                                        "Price 1 Day",
                                        "NA",
                                        "Price 7 Days",
                                        "Price 30 Days",
                                        "Amount",
                                        "NA"};
    
    public iffCaddieItem(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffCaddieItem(String[] inData) {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffCaddieItem() {
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
    public void getItem(String[] inData) {
        super.getItem(inData);
        GFX1 = inData[32];
        GFX2 = inData[33];
        price1Day = uData.getShort(Integer.parseInt(inData[34]));
        U33 = uData.getShort(Integer.parseInt(inData[35]));
        price7Days = uData.getShort(Integer.parseInt(inData[36]));
        price30Days = uData.getShort(Integer.parseInt(inData[37]));
        Amount = uData.getShort(Integer.parseInt(inData[38]));
        U37 = uData.getShort(Integer.parseInt(inData[39]));
    }

    @Override
    public void getItem(byte[] inData) throws IOException {
        super.getItem(inData);
        GFX1 = uData.getString(new ByteArrayInputStream(inData,144,40));
        GFX2 = uData.getString(new ByteArrayInputStream(inData,184,40));
        price1Day = uData.getShort(new byte[] {inData[224], inData[225]});
        U33 = uData.getShort(new byte[] {inData[226], inData[227]});
        price7Days = uData.getShort(new byte[] {inData[228], inData[229]});
        price30Days = uData.getShort(new byte[] {inData[230], inData[231]});
        Amount = uData.getShort(new byte[] {inData[232], inData[233]});
        U37 = uData.getShort(new byte[] {inData[234], inData[235]});
    }

    @Override
    public Object getValue(int colIndex) {
        if (colIndex < super.getColNum()) {
            return super.getValue(colIndex);
        }
        else {
            switch (colIndex) {
                case base:
                    return this.GFX1;
                case (base+1):
                    return this.GFX2;
                case (base+2):
                    return uData.getInt(this.price1Day);
                case (base+3):
                    return uData.getInt(this.U33);
                case (base+4):
                    return uData.getInt(this.price7Days);
                case (base+5):
                    return uData.getInt(this.price30Days);
                case (base+6):
                    return uData.getInt(this.Amount);
                case (base+7):
                    return uData.getInt(this.U37);
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
                    this.GFX1 = (String)value;
                    break;
                case (base+1):
                    this.GFX2 = (String)value;
                    break;
                case (base+2):
                    this.price1Day = uData.getShort((Integer)value);
                    break;
                case (base+3):
                    this.U33 = uData.getShort((Integer)value);
                    break;
                case (base+4):
                    this.price7Days = uData.getShort((Integer)value);
                    break;
                case (base+5):
                    this.price30Days = uData.getShort((Integer)value);
                    break;
                case (base+6):
                    this.Amount = uData.getShort((Integer)value);
                    break;
                case (base+7):
                    this.U37 = uData.getShort((Integer)value);
                    break;
            }
        }
    }
}
