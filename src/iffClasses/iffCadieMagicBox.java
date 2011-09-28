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
public class iffCadieMagicBox {
    
    public int Index = 0;
    public int Valid = 0;
    public int showOnPage = 0;
    public int U4 = 0;
    public int levelReq = 0;
    public int prodItem = 0;
    public int numProdItem = 0;
    public int itemOne = 0;
    public int itemTwo = 0;
    public int itemThree = 0;
    public int itemFour = 0;
    public int numItemOne = 0;
    public int numItemTwo = 0;
    public int numItemThree = 0;
    public int numItemFour = 0;
    public int U16 = 0;
    public int U17 = 0;
    public int U18 = 0;
    public int U19 = 0;
    public int U20 = 0;
    public int U21 = 0;
    public int U22 = 0;
    public int U23 = 0;
    public int U24 = 0;
    public int U25 = 0;
    public int U26 = 0;
    String[] colNames = new String[] {  "Index?",
                                            "ItemID",
                                            "Page?",
                                            "NA",
                                            "Level?",
                                            "Produced Item",
                                            "# Produced Item?",
                                            "Item 1",
                                            "Item 2",
                                            "Item 3",
                                            "Item 4",
                                            "# Item 1",
                                            "# Item 2",
                                            "# Item 3",
                                            "# Item 4",
                                            "NA",
                                            "NA",
                                            "NA",
                                            "NA",
                                            "NA",
                                            "NA",
                                            "NA",
                                            "NA",
                                            "NA",
                                            "NA",
                                            "NA"};
    
    public iffCadieMagicBox(byte[] inData) {
        getItem(inData);
    }

    public iffCadieMagicBox(String[] inData) throws IOException {
        getItem(inData);
    }

    public iffCadieMagicBox() {
        
    }

    public int getColNum() {
        return this.colNames.length;
    }

    public String getTitle(int titleIndex) {
        return colNames[titleIndex];
    }
    
    public void getItem(String[] inData) throws IOException {
        try {
            Index = uData.getInt(Long.parseLong(inData[0]));
            Valid = uData.getInt(Long.parseLong(inData[1]));
            showOnPage = uData.getInt(Long.parseLong(inData[2]));
            U4 = uData.getInt(Long.parseLong(inData[3]));
            levelReq = uData.getInt(Long.parseLong(inData[4]));
            prodItem = uData.getInt(Long.parseLong(inData[5]));
            numProdItem = uData.getInt(Long.parseLong(inData[6]));
            itemOne = uData.getInt(Long.parseLong(inData[7]));
            itemTwo = uData.getInt(Long.parseLong(inData[8]));
            itemThree = uData.getInt(Long.parseLong(inData[9]));
            itemFour = uData.getInt(Long.parseLong(inData[10]));
            numItemOne = uData.getInt(Long.parseLong(inData[11]));
            numItemTwo = uData.getInt(Long.parseLong(inData[12]));
            numItemThree = uData.getInt(Long.parseLong(inData[13]));
            numItemFour = uData.getInt(Long.parseLong(inData[14]));
            U16 = uData.getInt(Long.parseLong(inData[15]));
            U17 = uData.getInt(Long.parseLong(inData[16]));
            U18 = uData.getInt(Long.parseLong(inData[17]));
            U19 = uData.getInt(Long.parseLong(inData[18]));
            U20 = uData.getInt(Long.parseLong(inData[19]));
            U21 = uData.getInt(Long.parseLong(inData[20]));
            U22 = uData.getInt(Long.parseLong(inData[21]));
            U23 = uData.getInt(Long.parseLong(inData[22]));
            U24 = uData.getInt(Long.parseLong(inData[23]));
            U25 = uData.getInt(Long.parseLong(inData[24]));
            U26 = uData.getInt(Long.parseLong(inData[25]));
        } catch (Exception ex) {
            throw new IOException(ex);
        }
    }

    private void getItem(byte[] inData) {
        Index = uData.getInt(new byte[] {inData[0], inData[1], inData[2], inData[3]});
        Valid = uData.getInt(new byte[] {inData[4], inData[5], inData[6], inData[7]});
        showOnPage = uData.getInt(new byte[] {inData[8], inData[9], inData[10], inData[11]});
        U4 = uData.getInt(new byte[]{inData[12], inData[13], inData[14], inData[15]});
        levelReq = uData.getInt(new byte[] {inData[16], inData[17], inData[18], inData[19]});
        prodItem = uData.getInt(new byte[] {inData[20], inData[21], inData[22], inData[23]});
        numProdItem = uData.getInt(new byte[] {inData[24], inData[25], inData[26], inData[27]});
        itemOne = uData.getInt(new byte[] {inData[28], inData[29], inData[30], inData[31]});
        itemTwo = uData.getInt(new byte[] {inData[32], inData[33], inData[34], inData[35]});
        itemThree = uData.getInt(new byte[] {inData[36], inData[37], inData[38], inData[39]});
        itemFour = uData.getInt(new byte[] {inData[40], inData[41], inData[42], inData[43]});
        numItemOne = uData.getInt(new byte[] {inData[44], inData[45], inData[46], inData[47]});
        numItemTwo = uData.getInt(new byte[] {inData[48], inData[49], inData[50], inData[51]});
        numItemThree = uData.getInt(new byte[] {inData[52], inData[53], inData[54], inData[55]});
        numItemFour = uData.getInt(new byte[] {inData[56], inData[57], inData[58], inData[59]});
        U16 = uData.getInt(new byte[] {inData[60], inData[61], inData[62], inData[63]});
        U17 = uData.getInt(new byte[] {inData[64], inData[65], inData[66], inData[67]});
        U18 = uData.getInt(new byte[] {inData[68], inData[69], inData[70], inData[71]});
        U19 = uData.getInt(new byte[] {inData[72], inData[73], inData[74], inData[75]});
        U20 = uData.getInt(new byte[] {inData[76], inData[77], inData[78], inData[79]});
        U21 = uData.getInt(new byte[] {inData[80], inData[81], inData[82], inData[83]});
        U22 = uData.getInt(new byte[] {inData[84], inData[85], inData[86], inData[87]});
        U23 = uData.getInt(new byte[] {inData[88], inData[89], inData[90], inData[91]});
        U24 = uData.getInt(new byte[] {inData[92], inData[93], inData[94], inData[95]});
        U25 = uData.getInt(new byte[] {inData[96], inData[97], inData[98], inData[99]});
        U26 = uData.getInt(new byte[] {inData[100], inData[101], inData[102], inData[103]});

    }

    public Object getValue(int colIndex) {
        switch (colIndex) {
            case 0:
                return uData.getLong(this.Index);
            case 1:
                return uData.getLong(this.Valid);
            case 2:
                return uData.getLong(this.showOnPage);
            case 3:
                return uData.getLong(this.U4);
            case 4:
                return uData.getLong(this.levelReq);
            case 5:
                return uData.getLong(this.prodItem);
            case 6:
                return uData.getLong(this.numProdItem);
            case 7:
                return uData.getLong(this.itemOne);
            case 8:
                return uData.getLong(this.itemTwo);
            case 9:
                return uData.getLong(this.itemThree);
            case 10:
                return uData.getLong(this.itemFour);
            case 11:
                return uData.getLong(this.numItemOne);
            case 12:
                return uData.getLong(this.numItemTwo);
            case 13:
                return uData.getLong(this.numItemThree);
            case 14:
                return uData.getLong(this.numItemFour);
            case 15:
                return uData.getLong(this.U16);
            case 16:
                return uData.getLong(this.U17);
            case 17:
                return uData.getLong(this.U18);
            case 18:
                return uData.getLong(this.U19);
            case 19:
                return uData.getLong(this.U20);
            case 20:
                return uData.getLong(this.U21);
            case 21:
                return uData.getLong(this.U22);
            case 22:
                return uData.getLong(this.U23);
            case 23:
                return uData.getLong(this.U24);
            case 24:
                return uData.getLong(this.U25);
            case 25:
                return uData.getLong(this.U26);
            default:
                return "";
        }
    }

        public void setValue(int colIndex, Object value) {
        switch (colIndex) {
            case 0:
                this.Index = uData.getInt((Long)value);
                break;
            case 1:
                this.Valid = uData.getInt((Long)value);
                break;
            case 2:
                this.showOnPage = uData.getInt((Long)value);
                break;
            case 3:
                this.U4 = uData.getInt((Long)value);
                break;
            case 4:
                this.levelReq = uData.getInt((Long)value);
                break;
            case 5:
                this.prodItem = uData.getInt((Long)value);
                break;
            case 6:
                this.numProdItem = uData.getInt((Long)value);
                break;
            case 7:
                this.itemOne = uData.getInt((Long)value);
                break;
            case 8:
                this.itemTwo = uData.getInt((Long)value);
                break;
            case 9:
                this.itemThree = uData.getInt((Long)value);
                break;
            case 10:
                this.itemFour = uData.getInt((Long)value);
                break;
            case 11:
                this.numItemOne = uData.getInt((Long)value);
                break;
            case 12:
                this.numItemTwo = uData.getInt((Long)value);
                break;
            case 13:
                this.numItemThree = uData.getInt((Long)value);
                break;
            case 14:
                this.numItemFour = uData.getInt((Long)value);
                break;
            case 15:
                this.U16 = uData.getInt((Long)value);
                break;
            case 16:
                this.U17 = uData.getInt((Long)value);
                break;
            case 17:
                this.U18 = uData.getInt((Long)value);
                break;
            case 18:
                this.U19 = uData.getInt((Long)value);
                break;
            case 19:
                this.U20 = uData.getInt((Long)value);
                break;
            case 20:
                this.U21 = uData.getInt((Long)value);
                break;
            case 21:
                this.U22 = uData.getInt((Long)value);
                break;
            case 22:
                this.U23 = uData.getInt((Long)value);
                break;
            case 23:
                this.U24 = uData.getInt((Long)value);
                break;
            case 24:
                this.U25 = uData.getInt((Long)value);
                break;
            case 25:
                this.U26 = uData.getInt((Long)value);
                break;
        }
    }
}
