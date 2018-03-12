package cn.com.ulic.op.util;

import org.apache.commons.lang.time.DateUtils;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ruanhua on 2017/6/30.
 */
public class DateUtil extends DateUtils {
    private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" ,"yyyyMMddHHmmss"};


    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 获取两个日期之间的分钟数
     * @return
     */
    public static BigDecimal pastDays(Date startDate, Date endDate) {
        long t = endDate.getTime()-startDate.getTime();
        BigDecimal f = new BigDecimal(t/(60*1000)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return f ;
    }

    /**
     * 格式化时间
     * @param timestamp
     * @return
     */
    public static String dateFormat(Date timestamp,String formatString){
        SimpleDateFormat format=new SimpleDateFormat(formatString);
        return format.format(timestamp);
    }

    /**
     * 操作时间
     * @param date
     * @return
     */
    public static Date getBeforeDate(Date date){
        Calendar calendar = Calendar.getInstance();  //得到日历
        calendar.setTime(date);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
        return calendar.getTime();   //得到前一天的时间
    }
    /**
     * transfer a string to a date
     * @param strDate
     * @return
     */
    public static Date str2Date(String strDate){
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static String date2str(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        return strDate;
    }

    public static Time str2Time(String strTime){
        return Time.valueOf(strTime);
    }

    public static String getYear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.YEAR));
    }

    public static String getMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.MONTH));
    }

    public static String getBeforeDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(calendar.getTime());
    }

    public static String getDayByNum(Date date,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, num);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(calendar.getTime());
    }

    public static String getNextDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(calendar.getTime());
    }

    public static String getToday(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        return formatter.format(calendar.getTime());
    }

    public static String getYesterday(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(calendar.getTime());
        calendar.add(Calendar.DATE, -1);
        return formatter.format(calendar.getTime());
    }

    public static int getThisYear(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static String timestamp2Date(String timestamp){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(timestamp);
    }

    public static String timestamp2Time(String timestamp){
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        return formatter.format(timestamp);
    }

    /**
     * 判断时间格式 格式必须为strFormat
     * @param str
     * @return
     */
    public static boolean isValidDate(String str,String strFormat) {
        DateFormat formatter = new SimpleDateFormat(strFormat);
        try{
            Date date = (Date)formatter.parse(str);
            return str.equals(formatter.format(date));
        }catch(ParseException e){
            return false;
        }
    }


    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        Date endDate = DateUtil.parseDate("2017-07-12 14:29:00");
    }

    public static String getMinuteDate(int num ){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, num);//30分钟前的时间
        return sdf.format(nowTime.getTime());
    }
}
