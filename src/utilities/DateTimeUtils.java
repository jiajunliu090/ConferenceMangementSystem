package utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 1.一般时间分成三类：数据库中DateTime类型的格式一般是"yyyy-MM-dd HH:mm:ss"；
 * 2.Java程序中LocalDateTime数据类型；
 * 3.一种是用户输入的时间（一般用于搜索）String，格式一般是：MM.dd.HH.mm
 *   该工具类旨在将三个时间随意转换
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    private static final DateTimeFormatter DB_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter USER_INPUT_FORMATTER = DateTimeFormatter.ofPattern("MM.dd.HH.mm");

    private DateTimeUtils() {
        // 私有构造方法，防止实例化
    }

    public static LocalDateTime fromDbDateTime(String dbDateTime) {
        return LocalDateTime.parse(dbDateTime, DB_DATE_TIME_FORMATTER);
    }

    public static String toDbDateTime(LocalDateTime dateTime) {
        return dateTime.format(DB_DATE_TIME_FORMATTER);
    }

    public static LocalDateTime fromUserInput(String userInput) {
        // 解析日期和时间部分
        String[] parts = userInput.split("\\.");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int hour = Integer.parseInt(parts[2]);
        int minute = Integer.parseInt(parts[3]);

        // 获取当前日期时间并将日期和时间部分替换为用户输入的值
        LocalDateTime currentDateTime = LocalDateTime.now();
        return LocalDateTime.of(currentDateTime.getYear(), month, day, hour, minute);
    }

    public static String toUserInput(LocalDateTime dateTime) {
        return dateTime.format(USER_INPUT_FORMATTER);
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = DateTimeUtils.fromUserInput("03.31.00.00");
        System.out.println(localDateTime);
    }
}
