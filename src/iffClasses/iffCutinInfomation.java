/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iffClasses;

import gens.uData;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hedkandi
 */
public final class iffCutinInfomation {
    
    public int U1 = 0;
    public int U2 = 0;
    public int U3 = 0;
    public int U4 = 0;
    public int U5 = 0;
    public int U6 = 0;
    public int U7 = 0;
    public String picChar = "";
    public int U8 = 0;
    public String picBG = "";
    public int U9 = 0;
    public String picOverlay = "";
    public int U10 = 0;
    public String picUnknown = "";
    public int U11 = 0;
    public int U12 = 0;
    String[] colNames = new String[] {  "Valid?",
                                        "ItemID",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "Index",
                                        "Character Pic",
                                        "Price",
                                        "Background Pic",
                                        "NA",
                                        "Overlay Pic",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA"};
    
    public iffCutinInfomation(byte[] inData) {
        getItem(inData);
    }

    public iffCutinInfomation() {
        
    }

    public int getColNum() {
        return this.colNames.length;
    }
    
    public void getItem(byte[] inData) {
        try {
            U1 = uData.getInt(new byte[]{inData[0], inData[1], inData[2], inData[3]});
            U2 = uData.getInt(new byte[]{inData[4], inData[5], inData[6], inData[7]});
            U3 = uData.getInt(new byte[]{inData[8], inData[9], inData[10], inData[11]});
            U4 = uData.getInt(new byte[]{inData[12], inData[13], inData[14], inData[15]});
            U5 = uData.getInt(new byte[]{inData[16], inData[17], inData[18], inData[19]});
            U6 = uData.getInt(new byte[]{inData[20], inData[21], inData[22], inData[23]});
            U7 = uData.getInt(new byte[]{inData[24], inData[25], inData[26], inData[27]});
            picChar = uData.getString(new ByteArrayInputStream(inData, 28, 40));
            U8 = uData.getInt(new byte[]{inData[68], inData[69], inData[70], inData[71]});
            picBG = uData.getString(new ByteArrayInputStream(inData, 72, 40));
            U9 = uData.getInt(new byte[]{inData[112], inData[113], inData[114], inData[115]});
            picOverlay = uData.getString(new ByteArrayInputStream(inData, 116, 40));
            U10 = uData.getInt(new byte[]{inData[156], inData[157], inData[158], inData[159]});
            picUnknown = uData.getString(new ByteArrayInputStream(inData, 160, 40));
            U11 = uData.getInt(new byte[]{inData[200], inData[201], inData[202], inData[203]});
            U12 = uData.getInt(new byte[]{inData[204], inData[205], inData[206], inData[207]});
        } catch (IOException ex) {
            Logger.getLogger(iffCutinInfomation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object getValue(int colIndex) {
        switch (colIndex) {
            case 0:
                return uData.getLong(this.U1);
            case 1:
                return uData.getLong(this.U2);
            case 2:
                return uData.getLong(this.U3);
            case 3:
                return uData.getLong(this.U4);
            case 4:
                return uData.getLong(this.U5);
            case 5:
                return uData.getLong(this.U6);
            case 6:
                return uData.getLong(this.U7);
            case 7:
                return this.picChar;
            case 8:
                return uData.getLong(this.U8);
            case 9:
                return this.picBG;
            case 10:
                return uData.getLong(this.U9);
            case 11:
                return this.picOverlay;
            case 12:
                return uData.getLong(this.U10);
            case 13:
                return this.picUnknown;
            case 14:
                return uData.getLong(this.U11);
            case 15:
                return uData.getLong(this.U12);
            default:
                return "";
        }
    }

        public void setValue(int colIndex, Object value) {
        switch (colIndex) {
            case 0:
                this.U1 = uData.getInt((Long)value);
                break;
            case 1:
                this.U2 = uData.getInt((Long)value);
                break;
            case 2:
                this.U3 = uData.getInt((Long)value);
                break;
            case 3:
                this.U4 = uData.getInt((Long)value);
                break;
            case 4:
                this.U5 = uData.getInt((Long)value);
                break;
            case 5:
                this.U6 = uData.getInt((Long)value);
                break;
            case 6:
                this.U7 = uData.getInt((Long)value);
                break;
            case 7:
                this.picChar = (String)value;
                break;
            case 8:
                this.U8 = uData.getInt((Long)value);
                break;
            case 9:
                this.picBG = (String)value;
                break;
            case 10:
                this.U9 = uData.getInt((Long)value);
                break;
            case 11:
                this.picOverlay = (String)value;
                break;
            case 12:
                this.U10 = uData.getInt((Long)value);
                break;
            case 13:
                this.picUnknown = (String)value;
                break;
            case 14:
                this.U11 = uData.getInt((Long)value);
                break;
            case 15:
                this.U12 = uData.getInt((Long)value);
                break;
        }
    }
}
