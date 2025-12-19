@RestController
@RequestMapping("/api/schedules")
@Tag(name = "Shift Schedules Endpoints")
public class ScheduleController {

    @PostMapping("/generate/{date}")
    public String generateSchedule(@PathVariable String date) {
        return "Schedule generated for " + date;
    }

    @GetMapping("/{date}")
    public String getSchedule(@PathVariable String date) {
        return "Schedule for " + date;
    }
}