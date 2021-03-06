/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iffClasses;

import gens.uData;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 *
 * @author hedkandi
 */
public final class iffMatch {
    public boolean isValid = false;
    public int ItemID = 0; 
    public String ItemName = ""; 
    public byte lvlReq = 0; 
    public String Icon = ""; 
    public String Icon2 = ""; 
    public String Icon3 = ""; 
    public String Icon4 = ""; 
    public String Icon5 = ""; 
    public String Icon6 = ""; 
    public String Icon7 = ""; 
    public String Icon8 = ""; 
    public byte U2 = 0; 
    public byte U3 = 0; 
    public byte U4 = 0; 
    String[] colNames = new String[] {  "Valid?",
                                        "ItemID",
                                        "ItemName",
                                        "lvlReq",
                                        "Icon",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA"};
    
    public iffMatch(byte[] inData) {
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public iffMatch(String[] inData) throws Exception {
        getItem(inData);
    }

    public iffMatch() {
        
    }

    public int getColNum() {
        return this.colNames.length;
    }

    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
    
    public void getItem(String[] inData) throws Exception {
        try {
            if (inData[0].equals("true")) {
                isValid = true;
            }
            ItemID = uData.getInt(Long.parseLong(inData[1]));
            ItemName = inData[2];
            lvlReq = uData.getByte(Short.parseShort(inData[3]));
            Icon = inData[4];
            Icon2 = inData[5];
            Icon3 = inData[6];
            Icon4 = inData[7];
            Icon5 = inData[8];
            Icon6 = inData[9];
            U2 = uData.getByte(Short.parseShort(inData[10]));
            U3 = uData.getByte(Short.parseShort(inData[11]));
            U4 = uData.getByte(Short.parseShort(inData[12]));
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private void getItem(byte[] inData) throws IOException {
        try {
            isValid = uData.getBool(inData[0]);
            ItemID = uData.getInt(new byte[]{inData[4], inData[5], inData[6], inData[7]});
            ItemName = uData.getString(new ByteArrayInputStream(inData, 8, 80));
            lvlReq = inData[88];
            Icon = uData.getString(new ByteArrayInputStream(inData, 89, uData.stringLength));
            Icon2 = uData.getString(new ByteArrayInputStream(inData, 129, uData.stringLength));
            Icon3 = uData.getString(new ByteArrayInputStream(inData, 169, uData.stringLength));
            Icon4 = uData.getString(new ByteArrayInputStream(inData, 209, uData.stringLength));
            Icon5 = uData.getString(new ByteArrayInputStream(inData, 249, uData.stringLength));
            Icon6 = uData.getString(new ByteArrayInputStream(inData, 289, uData.stringLength));
            U2 = inData[329];
            U3 = inData[330];
            U4 = inData[331];
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }

    public Object getValue(int colIndex) {
        switch (colIndex) {
            case 0:
                return this.isValid;
            case 1:
                return uData.getLong(this.ItemID);
            case 2:
                return this.ItemName;
            case 3:
                return uData.getShort(this.lvlReq);
            case 4:
                return this.Icon;
            case 5:
                return this.Icon2;
            case 6:
                return this.Icon3;
            case 7:
                return this.Icon4;
            case 8:
                return this.Icon5;
            case 9:
                return this.Icon6;
            case 10:
                return uData.getShort(this.U2);
            case 11:
                return uData.getShort(this.U3);
            case 12:
                return uData.getShort(this.U4);
            default:
                return "";
        }
    }

    public void setValue(int colIndex, Object value) {
        switch (colIndex) {
            case 0:
                this.isValid = (Boolean)value;
                break;
            case 1:
                this.ItemID = uData.getInt((Long)value);
                break;
            case 2:
                this.ItemName = (String)value;
                break;
            case 3:
                this.lvlReq = uData.getByte((Short)value);
                break;
            case 4:
                this.Icon = (String)value;
                break;
            case 5:
                this.Icon2 = (String)value;
                break;
            case 6:
                this.Icon3 = (String)value;
                break;
            case 7:
                this.Icon4 = (String)value;
                break;
            case 8:
                this.Icon5 = (String)value;
                break;
            case 9:
                this.Icon6 = (String)value;
                break;
            case 10:
                this.Icon8 = (String)value;
                break;
            case 11:
                this.U2 = uData.getByte((Short)value);
                break;
            case 12:
                this.U3 = uData.getByte((Short)value);
                break;
            case 13:
                this.U4 = uData.getByte((Short)value);
                break;
        }
    }
}
