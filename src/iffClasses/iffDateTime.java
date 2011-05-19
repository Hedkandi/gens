/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iffClasses;

import gens.uData;
import java.util.Calendar;

/**
 *
 * @author hedkandi
 */
public class iffDateTime {
    
    public short Year = 0;
    public short Month = 0;
    public short dayOfWeek = 0;
    public short Day = 0;
    public short Hour = 0;
    public short Minute = 0;
    public short Second = 0;
    public short Millisecond = 0;
    
    iffDateTime(byte[] inDate) {

    }

    iffDateTime() {
        
    }

    
    private void getTime(byte[] inDate) {
        setValue(0,uData.getShort(new byte[] {inDate[0], inDate[1]}));
        setValue(1,uData.getShort(new byte[] {inDate[2], inDate[3]}));
        setValue(2,uData.getShort(new byte[] {inDate[4], inDate[5]}));
        setValue(3,uData.getShort(new byte[] {inDate[6], inDate[7]}));
        setValue(4,uData.getShort(new byte[] {inDate[8], inDate[9]}));
        setValue(5,uData.getShort(new byte[] {inDate[10], inDate[11]}));
        setValue(6,uData.getShort(new byte[] {inDate[12], inDate[13]}));
        setValue(7,uData.getShort(new byte[] {inDate[14], inDate[15]}));
    }
    
    public String getTime() {
        if (Year > 0) {
            Calendar c = Calendar.getInstance();
            c.clear();
            c.add(Calendar.YEAR, (Year-1970));
            c.add(Calendar.MONTH, Month);
            c.add(Calendar.DAY_OF_WEEK, dayOfWeek);
            c.add(Calendar.DATE, Day);
            c.add(Calendar.HOUR_OF_DAY, Hour);
            c.add(Calendar.MINUTE, Minute);
            c.add(Calendar.SECOND, Second);
            c.add(Calendar.MILLISECOND, Millisecond);
            return c.getTime().toString();
        }
        else {
            return "";
        }
    }
    
    public short getValue(int index) {
        switch (index) {
            case 0:
                return Year;
            case 1:
                return Month;
            case 2:
                return dayOfWeek;
            case 3:
                return Day;
            case 4:
                return Hour;
            case 5:
                return Minute;
            case 6:
                return Second;
            case 7:
                return Millisecond;
            default:
                return Short.MIN_VALUE;
        }
    }
    
    public void setValue(int index, short value) {
        switch (index) {
            case 0:
                Year = value;
            case 1:
                Month = value;
            case 2:
                dayOfWeek = value;
            case 3:
                Day = value;
            case 4:
                Hour = value;
            case 5:
                Minute = value;
            case 6:
                Second = value;
            case 7:
                Millisecond = value;
        }
    }

    void setTime(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
