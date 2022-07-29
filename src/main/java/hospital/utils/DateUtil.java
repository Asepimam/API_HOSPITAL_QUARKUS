package hospital.utils;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.sql.Timestamp;
public class DateUtil {
    public static @NotNull Timestamp stringToDate(String strdate){
        return Optional.ofNullable(strdate)
                        .map(str -> LocalDate.parse(str).atStartOfDay())
                        .map(Timestamp::valueOf)
                        .orElse(null);
    }
    public static @NotNull Timestamp stringToLocalTime(String strs){
        final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm");
        return Optional.ofNullable(strs)
                        .map(str -> LocalDateTime.parse(str,format))
                        .map(Timestamp::valueOf)
                        .orElse(null);
    }
    public static @NotNull ZonedDateTime stringToZoneDateTime(String str, String format){
        return ZonedDateTime.parse(str,DateTimeFormatter.ofPattern(format));
    }
}
