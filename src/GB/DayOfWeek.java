package GB;

public enum DayOfWeek {
    MONDAY("Понедельник", 8), TUESDAY("Вторник", 8), WEDNESDAY("Среда", 8), THURSDAY("Четверг", 8),
    FRIDAY("Пятница", 8), SATURDAY("Суббота", 0), SUNDAY("Воскресенье", 0);
    private final String RUS_TITLE;
    private final int HOURS;

    DayOfWeek(String rus, int hours) {
        RUS_TITLE = rus;
        this.HOURS = hours;
    }
    public String getRusDayOfWeek(){
        return RUS_TITLE;
    }

    public int getRemainingWorkingHours(DayOfWeek day){
        DayOfWeek[] days = DayOfWeek.values();
        int hours = 0;
        for (int i = day.ordinal(); i < 7; i++) {
            hours += days[i].HOURS;
        }
        return hours;
    }

}
