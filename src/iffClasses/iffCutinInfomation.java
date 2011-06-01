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
    
    public int Valid = 0;
    public int ItemID = 0;
    public int U3 = 0;
    public int U4 = 0;
    public int U5 = 0;
    public int U6 = 0;
    public int CharacterID = 0;
    public String picChar = "";
    public int picCharLayer = 0;
    public String picBG = "";
    public int picBGLayer = 0;
    public String picOverlay = "";
    public int picOverlayLayer = 0;
    public String picUnknown = "";
    public int U11 = 0;
    public int U12 = 0;
    String[] colNames = new String[] {  "Valid?",
                                        "ItemID",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "NA",
                                        "Character ID",
                                        "Character Pic",
                                        "Character Pic Layer",
                                        "Background Pic",
                                        "Background Pic Layer",
                                        "Overlay Pic",
                                        "Overlay Pic Layer",
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
    
    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
    
    public void getItem(byte[] inData) {
        try {
            Valid = uData.getInt(new byte[]{inData[0], inData[1], inData[2], inData[3]});
            ItemID = uData.getInt(new byte[]{inData[4], inData[5], inData[6], inData[7]});
            U3 = uData.getInt(new byte[]{inData[8], inData[9], inData[10], inData[11]});
            U4 = uData.getInt(new byte[]{inData[12], inData[13], inData[14], inData[15]});
            U5 = uData.getInt(new byte[]{inData[16], inData[17], inData[18], inData[19]});
            U6 = uData.getInt(new byte[]{inData[20], inData[21], inData[22], inData[23]});
            CharacterID = uData.getInt(new byte[]{inData[24], inData[25], inData[26], inData[27]});
            picChar = uData.getString(new ByteArrayInputStream(inData, 28, 40));
            picCharLayer = uData.getInt(new byte[]{inData[68], inData[69], inData[70], inData[71]});
            picBG = uData.getString(new ByteArrayInputStream(inData, 72, 40));
            picBGLayer = uData.getInt(new byte[]{inData[112], inData[113], inData[114], inData[115]});
            picOverlay = uData.getString(new ByteArrayInputStream(inData, 116, 40));
            picOverlayLayer = uData.getInt(new byte[]{inData[156], inData[157], inData[158], inData[159]});
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
                return uData.getLong(this.Valid);
            case 1:
                return uData.getLong(this.ItemID);
            case 2:
                return uData.getLong(this.U3);
            case 3:
                return uData.getLong(this.U4);
            case 4:
                return uData.getLong(this.U5);
            case 5:
                return uData.getLong(this.U6);
            case 6:
                return uData.getLong(this.CharacterID);
            case 7:
                return this.picChar;
            case 8:
                return uData.getLong(this.picCharLayer);
            case 9:
                return this.picBG;
            case 10:
                return uData.getLong(this.picBGLayer);
            case 11:
                return this.picOverlay;
            case 12:
                return uData.getLong(this.picOverlayLayer);
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
                this.Valid = uData.getInt((Long)value);
                break;
            case 1:
                this.ItemID = uData.getInt((Long)value);
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
                this.CharacterID = uData.getInt((Long)value);
                break;
            case 7:
                this.picChar = (String)value;
                break;
            case 8:
                this.picCharLayer = uData.getInt((Long)value);
                break;
            case 9:
                this.picBG = (String)value;
                break;
            case 10:
                this.picBGLayer = uData.getInt((Long)value);
                break;
            case 11:
                this.picOverlay = (String)value;
                break;
            case 12:
                this.picOverlayLayer = uData.getInt((Long)value);
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
