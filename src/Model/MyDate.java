package Model;

import java.time.LocalDate;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate(LocalDate localDate) {
        this.day = localDate.getDayOfMonth();
        this.month = localDate.getMonthValue();
        this.year = localDate.getYear();
    }

    // Getters and Setters
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFormattedDate() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public static MyDate fromLocalDate(LocalDate localDate) {
        return new MyDate(localDate);
    }

    public boolean isBefore(MyDate other) {
        if (this.year < other.year) {
            return true;
        } else if (this.year == other.year) {
            if (this.month < other.month) {
                return true;
            } else if (this.month == other.month) {
                return this.day < other.day;
            }
        }
        return false;
    }

    public MyDate plusDays(int days) {
        int totalDays = day + days;
       int day = (totalDays - 1) % 30 + 1;
        int extraMonths = (totalDays - 1) / 30;
        int totalMonths = month + extraMonths;
        int  month = (totalMonths - 1) % 12 + 1;
     int year = this.year += (totalMonths - 1) / 12;

     return new MyDate(day, month, year);
    }

    public boolean isEqual(MyDate other) {
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }

    public boolean isAfter(MyDate other) {
        if (this.year > other.year) {
            return true;
        } else if (this.year == other.year) {
            if (this.month > other.month) {
                return true;
            } else if (this.month == other.month) {
                return this.day > other.day;
            }
        }
        return false;
    }

    public LocalDate toLocalDate() {
        return LocalDate.of(year, month, day);
    }

    @Override
    public String toString() {
        return + day +
                "/" + month +
                "/" + year
                ;
    }
}
