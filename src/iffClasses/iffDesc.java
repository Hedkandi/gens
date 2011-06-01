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
public class iffDesc {
    public int itemID = 0;
    public String ItemName = "";
    String[] colNames = new String[] {  "ItemID",
                                    "ItemDescription"};

    public iffDesc(byte[] inData) {
        try {
            getItem(inData);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public iffDesc() {
        
    }

    public int getColNum() {
        return this.colNames.length;
    }

    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
        
    private void getItem(byte[] inData) throws IOException {
        try {
            itemID = uData.getInt(new byte[]{inData[0], inData[1], inData[2], inData[3]});
            ItemName = uData.getString(new ByteArrayInputStream(inData, 4, iffHandler.longStringLength));
        } catch (IOException ex) {
            throw new IOException(ex);
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
