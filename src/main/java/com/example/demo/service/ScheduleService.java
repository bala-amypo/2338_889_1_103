import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {

    List<GeneratedShiftSchedule> generateForDate(LocalDate date);

    List<GeneratedShiftSchedule> getByDate(LocalDate date);
}