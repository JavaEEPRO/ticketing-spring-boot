package si.inspirited.util.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeFormatter {

    private LocalDate date;
    private LocalTime time;
    private Separator separator;

    private String result;

    public LocalDateTimeFormatter(LocalDateTime dateTime, String separator) {
        LocalDate date = dateTime.toLocalDate();
        LocalTime time = dateTime.toLocalTime();
        this.date = date;
        this.time = time;
        this.separator = new Separator(separator);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Separator getSeparator() {
        return separator;
    }

    public void setSeparator(Separator separator) {
        this.separator = separator;
    }

    public String getResult() {
        String res = this.date + this.separator.getCurrentSeparator() + this.time;
        return res;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return this.getResult();
    }

    class Separator {
        private String currentSeparator;

        public Separator(String newSeparator) {
            this.currentSeparator = newSeparator;
        }

        public String getCurrentSeparator() {
            return currentSeparator;
        }
    }
}
