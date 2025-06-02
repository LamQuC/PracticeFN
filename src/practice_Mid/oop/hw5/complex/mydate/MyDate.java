package practice_Mid.oop.hw5.complex.mydate;

public class MyDate {
    private int year;
    private int month;
    private int day;
    public static final  String[] MONTHS = {"Jan", "Feb", "Mar","Apr", "May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    public static final String[] DAYS = {"Sunday", "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    public static final int[] DAYS_IN_MONTHS = {31,28,31,30,31,30,31,31,30,31,30,31};

    public MyDate(int year, int month, int day) {
        setDate(year,month,day);
    }
    public boolean isLeapYear(int year){
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            return true;
        }
        return false;
    }
    public boolean isValidDate(int year, int month,int day){
        if (year < 1 || year > 9999 || month < 1 || month > 12){
            return false;
        }
        int maxDay = DAYS_IN_MONTHS[month];
        if (month == 2 && isLeapYear(year)){
            maxDay =28;
        }
        return day >=1 && day <= maxDay;

    }
    public static int getDayOfWeek(int year, int month, int day) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int K = year % 100;
        int J = year / 100;
        int dayOfWeek = (day + (13 * (month + 1)) / 5 + K + (K / 4) + (J / 4) - (2 * J)) % 7;
        return (dayOfWeek + 6) % 7; // Adjust to match Sunday = 0
    }
    public void setDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return getDayOfWeek(year,month,day) + " " + day + " " + month + " " + year;
    }
    public MyDate nextDay(){
        if (isValidDate(year,month,day+1)){
            day++;
        }
        else {
            day=1;
            if (month == 12) {
                month = 1;
                year++;
            }
            else {
                month++;
            }
        }

        return this;
    }
    public MyDate nextMonth(){
        if (isValidDate(year,month+1,day)){
            month ++;
        }
        if (month > 12) {
            month = 1;
            year++;
        }
        int maxDay = DAYS_IN_MONTHS[month];
        if ( month == 2 && isLeapYear(year)){
            maxDay = 29;
        }
        if (day > maxDay){
            day = maxDay;
        }
        return this;
    }
    public MyDate nextYear(){
        if(isValidDate(year + 1,month,day)){
            year++;
        }
        if(!isLeapYear(year)){
            if (month ==2 ){
                month =3;
                day =1;
            }
            int maxDay = DAYS_IN_MONTHS[month];
            if (day > maxDay){
                day = maxDay;
            }
        }
        return this;
    }
    public MyDate previousDay() {
        if (isValidDate(year, month, day - 1)) {
            day--;
        } else {
            if (month == 1) {
                month = 12;
                year--;
            } else {
                month--;
            }
            int maxDay = DAYS_IN_MONTHS[month];
            if (month == 2 && isLeapYear(year)) {
                maxDay = 29;
            }
            day = maxDay;
        }
        return this;
    }
    public MyDate previousMonth(){
        if (isValidDate(year,month-1,day)){
            month --;
        }
        if (month < 1) {
            month = 12;
            year--;
        }
        int maxDay = DAYS_IN_MONTHS[month];
        if ( month == 2 && isLeapYear(year)){
            maxDay = 29;
        }
        if (day > maxDay){
            day = maxDay;
        }
        return this;
    }
    public MyDate previousYear(){
        year--;
        if(!isLeapYear(year)){
            if (month ==2 ){
                month =3;
                day =1;
            }
            int maxDay = DAYS_IN_MONTHS[month];
            if (day > maxDay){
                day = maxDay;
            }
        }
        return this;
    }
}

