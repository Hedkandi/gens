/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iffClasses;

import gens.uData;

/**
 *
 * @author hedkandi
 */
public class iffEnchant {
    
    public int Valid = 0;
    public int EnchantID = 0;
    public int Price = 0;
    public int U1 = 0;
    String[] colNames = new String[] {  "Valid",
                                    "Enchant ID",
                                    "Price",
                                    "NA"};
    
    public iffEnchant(byte[] inData) {
        getItem(inData);
    }

    public iffEnchant() {
        
    }

    public int getColNum() {
        return this.colNames.length;
    }
    
    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
    
    private void getItem(byte[] inData) {
        Valid = uData.getInt(new byte[] {inData[0], inData[1], inData[2], inData[3]});
        EnchantID = uData.getInt(new byte[] {inData[4], inData[5], inData[6], inData[7]});
        Price = uData.getInt(new byte[] {inData[8], inData[9], inData[10], inData[11]});
        U1 = uData.getInt(new byte[] {inData[12], inData[13], inData[14], inData[15]});
    }

    public Object getValue(int colIndex) {
        switch (colIndex) {
            case 0:
                return uData.getLong(this.Valid);
            case 1:
                return uData.getLong(this.EnchantID);
            case 2:
                return uData.getLong(this.Price);
            case 3:
                return uData.getLong(this.U1);
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
                this.EnchantID = uData.getInt((Long)value);
                break;
            case 2:
                this.Price = uData.getInt((Long)value);
                break;
            case 3:
                this.U1 = uData.getInt((Long)value);
                break;
        }
    }
}
