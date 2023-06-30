package morriex.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {

    public static String toDate(Date date) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(date);
    }

}
