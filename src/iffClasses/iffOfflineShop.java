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
                case 32:
                    return uData.getLong(this.numRef);
                case 33:
                    return uData.getLong(this.ref1);
                case 34:
                    return uData.getLong(this.ref2);
                case 35:
                    return uData.getLong(this.ref3);
                case 36:
                    return uData.getLong(this.ref4);
                case 37:
                    return uData.getLong(this.ref5);
                case 38:
                    return uData.getLong(this.ref6);
                case 39:
                    return uData.getLong(this.ref7);
                case 40:
                    return uData.getLong(this.ref8);
                case 41:
                    return uData.getLong(this.ref9);
                case 42:
                    return uData.getLong(this.ref10);
                case 43:
                    return uData.getLong(this.ref11);
                case 44:
                    return uData.getLong(this.ref12);
                case 45:
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
                case 32:
                    this.numRef = uData.getInt((Long)value);
                    break;
                case 33:
                    this.ref1 = uData.getInt((Long)value);
                    break;
                case 34:
                    this.ref2 = uData.getInt((Long)value);
                    break;
                case 35:
                    this.ref3 = uData.getInt((Long)value);
                    break;
                case 36:
                    this.ref4 = uData.getInt((Long)value);
                    break;
                case 37:
                    this.ref6 = uData.getInt((Long)value);
                    break;
                case 38:
                    this.ref7 = uData.getInt((Long)value);
                    break;
                case 39:
                    this.ref8 = uData.getInt((Long)value);
                    break;
                case 40:
                    this.ref9 = uData.getInt((Long)value);
                    break;
                case 41:
                    this.ref10 = uData.getInt((Long)value);
                    break;
                case 42:
                    this.ref11 = uData.getInt((Long)value);
                    break;
                case 43:
                    this.ref12 = uData.getInt((Long)value);
                    break;
                case 44:
                    this.ref13 = uData.getInt((Long)value);
                    break;
            }
        }
    }
}
