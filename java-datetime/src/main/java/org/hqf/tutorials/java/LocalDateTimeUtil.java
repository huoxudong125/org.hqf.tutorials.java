package org.hqf.tutorials.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;

public class LocalDateTimeUtil {

    // 日期时间格式化器
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // 将字符串转换为 LocalDateTime
    public static LocalDateTime parseToDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DATE_TIME_FORMATTER);
    }

    // 将 LocalDateTime 转换为字符串
    public static String formatToDateTime(LocalDateTime dateTime) {
        return dateTime.format(DATE_TIME_FORMATTER);
    }

    // 将字符串转换为 LocalDate
    public static LocalDate parseToDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    // 将 LocalDate 转换为字符串
    public static String formatToDate(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    // 获取指定日期所在月的第一天
    public static LocalDateTime getFirstDayOfMonth(LocalDateTime dateTime) {
        return dateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
    }

    // 获取指定日期所在月的最后一天
    public static LocalDateTime getLastDayOfMonth(LocalDateTime dateTime) {
        return dateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.of(23, 59, 59));
    }

    // 获取指定日期所在周的第一天（以周一为一周的开始）
    public static LocalDateTime getFirstDayOfWeek(LocalDateTime dateTime) {
        return dateTime.with(DayOfWeek.MONDAY).with(LocalTime.MIN);
    }

    // 获取指定日期所在周的最后一天（以周日为一周的结束）
    public static LocalDateTime getLastDayOfWeek(LocalDateTime dateTime) {
        return dateTime.with(DayOfWeek.SUNDAY).with(LocalTime.of(23, 59, 59));
    }

    // 获取指定日期的一天的开始时间
    public static LocalDateTime getStartOfDay(LocalDateTime dateTime) {
        return dateTime.with(LocalTime.MIN);
    }

    // 获取指定日期的一天的结束时间
    public static LocalDateTime getEndOfDay(LocalDateTime dateTime) {
        return dateTime.with(LocalTime.of(23, 59, 59));
    }

    // 增加天数
    public static LocalDateTime addDays(LocalDateTime dateTime, long days) {
        return dateTime.plusDays(days);
    }

    // 增加周数
    public static LocalDateTime addWeeks(LocalDateTime dateTime, long weeks) {
        return dateTime.plusWeeks(weeks);
    }

    // 增加月数
    public static LocalDateTime addMonths(LocalDateTime dateTime, long months) {
        return dateTime.plusMonths(months);
    }

    // 增加季度数
    public static LocalDateTime addQuarters(LocalDateTime dateTime, long quarters) {
        return dateTime.plusMonths(quarters * 3);
    }

    // 增加年数
    public static LocalDateTime addYears(LocalDateTime dateTime, long years) {
        return dateTime.plusYears(years);
    }

    // 将 LocalDate 转换为 LocalDateTime（时间设为开始时间）
    public static LocalDateTime toStartOfDay(LocalDate date) {
        return date.atStartOfDay();
    }

    // 将 LocalDate 转换为 LocalDateTime（时间设为结束时间）
    public static LocalDateTime toEndOfDay(LocalDate date) {
        return date.atTime(23, 59, 59);
    }

    // 将 LocalDateTime 转换为 LocalDate
    public static LocalDate toLocalDate(LocalDateTime dateTime) {
        return dateTime.toLocalDate();
    }

    // 判断两天是否在同一个周
    public static boolean isSameWeek(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        LocalDate firstDayOfWeek1 = dateTime1.with(DayOfWeek.MONDAY).toLocalDate();
        LocalDate firstDayOfWeek2 = dateTime2.with(DayOfWeek.MONDAY).toLocalDate();
        return firstDayOfWeek1.equals(firstDayOfWeek2);
    }

    // 判断两个 LocalDate 是否在同一周
    public static boolean isSameWeek(LocalDate date1, LocalDate date2) {
        LocalDate firstDayOfWeek1 = date1.with(DayOfWeek.MONDAY);
        LocalDate firstDayOfWeek2 = date2.with(DayOfWeek.MONDAY);
        return firstDayOfWeek1.equals(firstDayOfWeek2);
    }

}
