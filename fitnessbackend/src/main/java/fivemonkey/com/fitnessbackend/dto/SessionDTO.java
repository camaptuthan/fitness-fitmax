package fivemonkey.com.fitnessbackend.dto;

import lombok.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SessionDTO {
    private String id;
    private String weekDay;
    private String name;
    private String classId;
    private Date happenedDate;

    public String getWeekDay() {
        return "" + getWeekday(happenedDate);
    }

    private int getWeekday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int dayOfWeekNum = cal.get(Calendar.DAY_OF_WEEK);

        DateFormat formatter = new SimpleDateFormat("EEEE");
        String dayOfWeekString = formatter.format(cal.getTime());
//        System.out.println("Day of the Week - in Number :: " + dayOfWeekNum);
//        System.out.println("Day of the Week - in Text :: " + dayOfWeekString);

        return dayOfWeekNum;
    }
}
