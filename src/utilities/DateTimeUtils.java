package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 1.一般时间分成三类：数据库中DateTime类型的格式一般是"yyyy-MM-dd HH:mm:ss"；
 * 2.Java程序中LocalDateTime数据类型；
 * 3.一种是用户输入的时间（一般用于搜索）String，格式一般是：MM.dd.HH.mm
 *   该工具类旨在将三个时间随意转换
 */
public class DateTimeUtils {
    // 时间转换类

    // 从数据库中的时间转换成LocalDateTime
    private static final DateTimeFormatter DB_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 用于将用户输入的String和LocalDateTime之间转换
    private static final DateTimeFormatter USER_INPUT_FORMATTER = DateTimeFormatter.ofPattern("MM.dd.HH.mm");

    private DateTimeUtils() {
        // 私有构造方法，防止实例化
    }

    // 将数据库中的日期时间字符串转换为 LocalDateTime
    public static LocalDateTime fromDbDateTime(String dbDateTime) {
        return LocalDateTime.parse(dbDateTime, DB_DATE_TIME_FORMATTER);
    }

    // 将 LocalDateTime 转换为数据库中的日期时间字符串
    public static String toDbDateTime(LocalDateTime dateTime) {
        return dateTime.format(DB_DATE_TIME_FORMATTER);
    }

    // 将用户输入的时间字符串转换为 LocalDateTime
    public static LocalDateTime fromUserInput(String userInput) {
        return LocalDateTime.parse(userInput, USER_INPUT_FORMATTER);
    }

    // 将 LocalDateTime 转换为用户输入的时间字符串
    public static String toUserInput(LocalDateTime dateTime) {

        return dateTime.format(USER_INPUT_FORMATTER);
    }

    public static void main(String[] args) {

    }
}