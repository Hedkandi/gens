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
public final class iffDesc {
    public int itemID = 0;
    public String ItemName = "";
    String[] colNames = new String[] {  "ItemID",
                                    "ItemDescription"};

    public iffDesc(byte[] inData) throws Exception {
        getItem(inData);
    }

    public iffDesc(String[] inData) throws Exception {
        getItem(inData);
    }
        
    public iffDesc() {
        
    }

    public int getColNum() {
        return this.colNames.length;
    }

    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
        
    public void getItem(String[] inData) throws Exception {
        try {
            itemID = uData.getInt(Long.parseLong(inData[0]));
            ItemName = inData[1];
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private void getItem(byte[] inData) throws Exception {
        try {
            itemID = uData.getInt(new byte[]{inData[0], inData[1], inData[2], inData[3]});
            ItemName = uData.getString(new ByteArrayInputStream(inData, 4, iffHandler.longStringLength));
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Object getValue(int colIndex) {
        switch (colIndex) {
            case 0:
                return uData.getLong(this.itemID);
            case 1:
                return this.ItemName;
            default:
                return "";
        }
    }

    public void setValue(int colIndex, Object value) {
        switch (colIndex) {
            case 0:
                this.itemID = uData.getInt((Long)value);
                break;
            case 1:
                this.ItemName = (String)value;
                break;
        }
    }
}
