package org.hqf.tutorials.java;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hqf.tutorials.java.LocalDateTimeUtil.*;

public class Main {
    // 测试方法
    public static void main(String[] args) {
        String dateTimeStr = "2024-10-08 12:30:45";
        LocalDateTime dateTime = parseToDateTime(dateTimeStr);

        System.out.println("Parsed LocalDateTime: " + dateTime);
        System.out.println("Formatted DateTime: " + formatToDateTime(dateTime));
        System.out.println("First day of month: " + getFirstDayOfMonth(dateTime));
        System.out.println("Last day of month: " + getLastDayOfMonth(dateTime));
        System.out.println("First day of week: " + getFirstDayOfWeek(dateTime));
        System.out.println("Last day of week: " + getLastDayOfWeek(dateTime));
        System.out.println("Start of day: " + getStartOfDay(dateTime));
        System.out.println("End of day: " + getEndOfDay(dateTime));

        System.out.println("Add 5 days: " + addDays(dateTime, 5));
        System.out.println("Add 2 weeks: " + addWeeks(dateTime, 2));
        System.out.println("Add 3 months: " + addMonths(dateTime, 3));
        System.out.println("Add 1 quarter: " + addQuarters(dateTime, 1));
        System.out.println("Add 2 years: " + addYears(dateTime, 2));

        LocalDate date = parseToDate("2024-10-08");
        System.out.println("To Start of Day: " + toStartOfDay(date));
        System.out.println("To End of Day: " + toEndOfDay(date));
        System.out.println("Convert to LocalDate: " + toLocalDate(dateTime));

        LocalDateTime dateTime1 = parseToDateTime("2024-10-06 12:30:45");
        LocalDateTime dateTime2 = parseToDateTime("2024-10-08 09:15:30");
        System.out.println("Is same week (LocalDateTime): " + isSameWeek(dateTime1, dateTime2));

        LocalDate date1 = parseToDate("2024-10-08");
        LocalDate date2 = parseToDate("2024-10-10");
        System.out.println("Is same week (LocalDate): " + isSameWeek(date1, date2));

    }
}