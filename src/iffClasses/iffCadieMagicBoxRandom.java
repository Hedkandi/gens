/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iffClasses;

import gens.uData;
import java.io.IOException;

/**
 *
 * @author hedkandi
 */
public class iffCadieMagicBoxRandom {
    
    // All bytes are +1 since hex fiend starts count at 0
    public int numItemOne = 0;
    public int itemOne = 0;
    public int numItemTwo = 0;
    public int itemTwo = 0;
    String[] colNames = new String[] {  "Num item?",
                                        "Item?",
                                        "Amount?",
                                        "Probability"};
    
    public iffCadieMagicBoxRandom(byte[] inData) {
        getItem(inData);
    }

    public iffCadieMagicBoxRandom(String[] inData) throws IOException {
        getItem(inData);
    }

    public iffCadieMagicBoxRandom() {
        
    }

    public int getColNum() {
        return this.colNames.length;
    }

    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
    
    public void getItem(String[] inData) throws IOException {
        try {
            numItemOne = uData.getInt(Long.parseLong(inData[0]));
            itemOne = uData.getInt(Long.parseLong(inData[1]));
            numItemTwo = uData.getInt(Long.parseLong(inData[2]));
            itemTwo = uData.getInt(Long.parseLong(inData[3]));
        } catch (Exception ex) {
            throw new IOException(ex);
        }
    }

    private void getItem(byte[] inData) {
        numItemOne = uData.getInt(new byte[] {inData[0], inData[1], inData[2], inData[3]});
        itemOne = uData.getInt(new byte[] {inData[4], inData[5], inData[6], inData[7]});
        numItemTwo = uData.getInt(new byte[] {inData[8], inData[9], inData[10], inData[11]});
        itemTwo = uData.getInt(new byte[] {inData[12], inData[13], inData[14], inData[15]});
    }

    public Object getValue(int colIndex) {
        switch (colIndex) {
            case 0:
                return uData.getLong(this.numItemOne);
            case 1:
                return uData.getLong(this.itemOne);
            case 2:
                return uData.getLong(this.numItemTwo);
            case 3:
                return uData.getLong(this.itemTwo);
            default:
                return "";
        }
    }

        public void setValue(int colIndex, Object value) {
        switch (colIndex) {
            case 0:
                this.numItemOne = uData.getInt((Long)value);
                break;
            case 1:
                this.itemOne = uData.getInt((Long)value);
                break;
            case 2:
                this.numItemTwo = uData.getInt((Long)value);
                break;
            case 3:
                this.itemTwo = uData.getInt((Long)value);
                break;
        }
    }
}
