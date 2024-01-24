package org.hqf.tutorials.java.basic;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TimeRangeOverlapExample {
    public static void main(String[] args) {
        List<TimeRange> timeRanges = new ArrayList<>();
        timeRanges.add(new TimeRange(LocalDateTime.of(2022, 1, 1, 9, 0), LocalDateTime.of(2022, 1, 1, 12, 0)));
        timeRanges.add(new TimeRange(LocalDateTime.of(2022, 1, 1, 10, 0), LocalDateTime.of(2022, 1, 1, 14, 0)));
        timeRanges.add(new TimeRange(LocalDateTime.of(2022, 1, 1, 13, 0), LocalDateTime.of(2022, 1, 1, 16, 0)));

        timeRanges.add(new TimeRange(LocalDateTime.of(2022, 2, 1, 13, 0), LocalDateTime.of(2022, 2, 1, 16, 0)));

        List<TimeRange> mergedTimeRanges = mergeTimeRanges(timeRanges);

        System.out.println("Merged Time Ranges:");
        for (TimeRange range : mergedTimeRanges) {
            System.out.println(range.getStart() + " - " + range.getEnd());
        }
    }

    static List<TimeRange> mergeTimeRanges(List<TimeRange> timeRanges) {
        timeRanges.sort(Comparator.comparing(TimeRange::getStart));

        List<TimeRange> mergedRanges = new ArrayList<>();
        TimeRange currentRange = null;

        for (TimeRange range : timeRanges) {
            if (currentRange == null || currentRange.getEnd().isBefore(range.getStart())) {
                currentRange = range;
                mergedRanges.add(currentRange);
            } else if (range.getEnd().isAfter(currentRange.getEnd())) {
                currentRange.setEnd(range.getEnd());
            }
        }

        return mergedRanges;
    }

    static class TimeRange {
        private LocalDateTime start;
        private LocalDateTime end;

        public TimeRange(LocalDateTime start, LocalDateTime end) {
            this.start = start;
            this.end = end;
        }

        public LocalDateTime getStart() {
            return start;
        }

        public LocalDateTime getEnd() {
            return end;
        }

        public void setEnd(LocalDateTime end) {
            this.end = end;
        }
    }
}