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
public final class iffOfflineShop extends iffBase {
    
    // base should be equal to iffBase.getColNum()
    private static final int base = iffBase.base;
    public int numRef = 0;
    public int ref1 = 0;
    public int ref2 = 0;
    public int ref3 = 0;
    public int ref4 = 0;
    public int ref5 = 0;
    public int ref6 = 0;
    public int ref7 = 0;
    public int ref8 = 0;
    public int ref9 = 0;
    public int ref10 = 0;
    public int ref11 = 0;
    public int ref12 = 0;
    public int ref13 = 0;
    String[] colNames = new String[] {  "Num Refs",
                                        "Ref 1",
                                        "Ref 2",
                                        "Ref 3",
                                        "Ref 4",
                                        "Ref 5",
                                        "Ref 6",
                                        "Ref 7",
                                        "Ref 8",
                                        "Ref 9",
                                        "Ref 10",
                                        "Ref 11",
                                        "Ref 12",
                                        "Ref 13"};

    public iffOfflineShop(byte[] inData) {
        super();
        buildColNames();
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public iffOfflineShop(String[] inData) throws IOException {
        super();
        buildColNames();
        getItem(inData);
    }

    public iffOfflineShop() {
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
            numRef = uData.getInt(Long.parseLong(inData[28]));
            ref1 = uData.getInt(Long.parseLong(inData[29]));
            ref2 = uData.getInt(Long.parseLong(inData[30]));
            ref3 = uData.getInt(Long.parseLong(inData[31]));
            ref4 = uData.getInt(Long.parseLong(inData[32]));
            ref5 = uData.getInt(Long.parseLong(inData[33]));
            ref6 = uData.getInt(Long.parseLong(inData[34]));
            ref7 = uData.getInt(Long.parseLong(inData[35]));
            ref8 = uData.getInt(Long.parseLong(inData[36]));
            ref9 = uData.getInt(Long.parseLong(inData[37]));
            ref10 = uData.getInt(Long.parseLong(inData[38]));
            ref11 = uData.getInt(Long.parseLong(inData[39]));
            ref12 = uData.getInt(Long.parseLong(inData[40]));
            ref13 = uData.getInt(Long.parseLong(inData[41]));
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }
    
    @Override
    public void getItem(byte[] inData) throws IOException {
        try {
            super.getItem(inData);
            numRef = uData.getInt(new byte[]{inData[144], inData[145], inData[146], inData[147]});
            ref1 = uData.getInt(new byte[]{inData[148], inData[149], inData[150], inData[151]});
            ref2 = uData.getInt(new byte[]{inData[152], inData[153], inData[154], inData[155]});
            ref3 = uData.getInt(new byte[]{inData[156], inData[157], inData[158], inData[159]});
            ref4 = uData.getInt(new byte[]{inData[160], inData[161], inData[162], inData[163]});
            ref5 = uData.getInt(new byte[]{inData[164], inData[165], inData[166], inData[167]});
            ref6 = uData.getInt(new byte[]{inData[168], inData[169], inData[170], inData[171]});
            ref7 = uData.getInt(new byte[]{inData[172], inData[173], inData[174], inData[175]});
            ref8 = uData.getInt(new byte[]{inData[176], inData[177], inData[178], inData[179]});
            ref9 = uData.getInt(new byte[]{inData[180], inData[181], inData[182], inData[183]});
            ref10 = uData.getInt(new byte[]{inData[184], inData[185], inData[186], inData[187]});
            ref11 = uData.getInt(new byte[]{inData[188], inData[189], inData[190], inData[191]});
            ref12 = uData.getInt(new byte[]{inData[192], inData[193], inData[194], inData[195]});
            ref13 = uData.getInt(new byte[]{inData[194], inData[197], inData[198], inData[199]});
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
                    return uData.getLong(this.numRef);
                case (base+1):
                    return uData.getLong(this.ref1);
                case (base+2):
                    return uData.getLong(this.ref2);
                case (base+3):
                    return uData.getLong(this.ref3);
                case (base+4):
                    return uData.getLong(this.ref4);
                case (base+5):
                    return uData.getLong(this.ref5);
                case (base+6):
                    return uData.getLong(this.ref6);
                case (base+7):
                    return uData.getLong(this.ref7);
                case (base+8):
                    return uData.getLong(this.ref8);
                case (base+9):
                    return uData.getLong(this.ref9);
                case (base+10):
                    return uData.getLong(this.ref10);
                case (base+11):
                    return uData.getLong(this.ref11);
                case (base+12):
                    return uData.getLong(this.ref12);
                case (base+13):
                    return uData.getLong(this.ref13);
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
                    this.numRef = uData.getInt((Long)value);
                    break;
                case (base+1):
                    this.ref1 = uData.getInt((Long)value);
                    break;
                case (base+2):
                    this.ref2 = uData.getInt((Long)value);
                    break;
                case (base+3):
                    this.ref3 = uData.getInt((Long)value);
                    break;
                case (base+4):
                    this.ref4 = uData.getInt((Long)value);
                    break;
                case (base+5):
                    this.ref6 = uData.getInt((Long)value);
                    break;
                case (base+6):
                    this.ref7 = uData.getInt((Long)value);
                    break;
                case (base+7):
                    this.ref8 = uData.getInt((Long)value);
                    break;
                case (base+8):
                    this.ref9 = uData.getInt((Long)value);
                    break;
                case (base+9):
                    this.ref10 = uData.getInt((Long)value);
                    break;
                case (base+10):
                    this.ref11 = uData.getInt((Long)value);
                    break;
                case (base+11):
                    this.ref12 = uData.getInt((Long)value);
                    break;
                case (base+12):
                    this.ref13 = uData.getInt((Long)value);
                    break;
            }
        }
    }
}
