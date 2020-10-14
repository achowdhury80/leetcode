package comp.prep2019.less2000;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Prob1360 {
	public int daysBetweenDates(String date1, String date2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1 = sdf.parse(date1), d2 = sdf.parse(date2);
			long diffInMillies = Math.abs(d1.getTime() - d2.getTime());
			return (int)TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return 0;
		}
    }
}
