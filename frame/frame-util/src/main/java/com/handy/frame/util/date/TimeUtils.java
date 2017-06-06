package com.handy.frame.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: TimeUtils
 * @Description:
 * @author hairen.long@hoau.net
 * @date 2015年5月24日 上午10:24:21
 */
public class TimeUtils {

	private static Calendar cale = Calendar.getInstance();
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	

	public static String getDateVersion(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		return sdf.format(new Date());
	}
	
	public static Date formateDate(String date)throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.parse(date);
	}
	
	public static String getLastMonthLastDay(){
		Calendar calendar = Calendar.getInstance();  
		int month = calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
		Date strDateTo = calendar.getTime(); 
		return format.format(strDateTo);
	}
	
	public static int getLastMonthMaxDay(){
		SimpleDateFormat f = new SimpleDateFormat("dd");
		Calendar calendar = Calendar.getInstance();  
		int month = calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
		return Integer.parseInt(f.format(calendar.getTime()));
	}

	public static int getCurrentYear() {
		return cale.get(Calendar.YEAR);
	}

	public static int getCurrentMonth() {
		return cale.get(Calendar.MONTH) + 1;
	}

	public static int getCurrentDay() {
		return cale.get(Calendar.DATE);
	}

	public static int getCurrentHour() {
		return cale.get(Calendar.HOUR_OF_DAY);
	}

	public static int getCurrentMinute() {
		return cale.get(Calendar.MINUTE);
	}

	public static int getCurrentSecond() {
		return cale.get(Calendar.SECOND);
	}

	public static int getDayOfWeek() {
		return cale.get(Calendar.DAY_OF_WEEK);
	}

	public static int getDayOfMonth() {
		return cale.get(Calendar.DAY_OF_MONTH);
	}

	public static int getDayOfYear() {
		return cale.get(Calendar.DAY_OF_YEAR);
	}

	public static String getFirstMonthDay() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return format.format(c.getTime());
	}

	public static String getEndMonthDay() {
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH,
				ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		return format.format(ca.getTime());
	}

	public static int getMaxMonthDay() {
		SimpleDateFormat f = new SimpleDateFormat("dd");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH,
				c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return Integer.parseInt(f.format(c.getTime()).startsWith("0")?f.format(c.getTime()).substring(1):f.format(c.getTime()));
	}
	
	public static String getFormatNextDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(getCurrentTimeMillis() + 24 * 60 * 60 * 1000);
	}

	public static String getFormatTheDayBeforeYesterday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(getCurrentTimeMillis() - 2 * 24 * 60 * 60 * 1000);
	}

	public static String getFormatYesterday(String date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(sdf.parse(date).getTime() - 24 * 60 * 60 * 1000);
	}
	
	public static String getFormatYesterday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(getCurrentTimeMillis() - 24 * 60 * 60 * 1000);
	}

	public static String getFormatToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(getCurrentTimeMillis());
	}

	public static String getFormatNowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(getCurrentTimeMillis());
	}

	public static long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) {
		long between_days = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(bdate);
			long time2 = cal.getTimeInMillis();
			between_days = (time2 - time1) / (1000 * 3600 * 24);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 字符串的日期格式的计算
	 */
	public static int daysBetween(String smdate, String bdate) {
		long between_days = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(smdate));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(bdate));
			long time2 = cal.getTimeInMillis();
			between_days = (time2 - time1) / (1000 * 3600 * 24);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 当月第一天
	 * 
	 * @return
	 */
	public static String getFirstDayAndTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return df.format(c.getTime()) + " 00:00:00";

	}

	/**
	 * 前月第一天
	 * 
	 * @return
	 */
	public static String getLastMonthFirstDayAndTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return df.format(c.getTime()) + " 00:00:00";

	}

	/**
	 * 当月最后一天
	 * 
	 * @return
	 */
	public static String getLastDayAndTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH,
				ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		return df.format(ca.getTime()) + " 23:59:59";

	}

}
