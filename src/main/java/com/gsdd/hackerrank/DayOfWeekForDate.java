package com.gsdd.hackerrank;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayOfWeekForDate {

  public static void main(String[] args) {
    LocalDate localDate = LocalDate.of(2015, 8, 5);
    DayOfWeek dayOfWeek = localDate.getDayOfWeek();
    System.out.println(dayOfWeek.name());
  }
}
