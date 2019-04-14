package challenge.utils;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class DateUtils {
    
    public static OffsetDateTime getCurrentDateTimeInUTC() {
        return OffsetDateTime.now(ZoneOffset.UTC);
    }
}
