package attendance.manas.edu.kg.extra;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    private Date date;

    Time() {
        date = new Date();
    }

    public String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }

}
