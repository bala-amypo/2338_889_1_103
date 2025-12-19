@RestController
@RequestMapping("/api/availability")
@Tag(name = "Employee Availability Endpoints")
public class AvailabilityController {

    @PostMapping("/employee/{employeeId}")
    public String setAvailability(@PathVariable Long employeeId) {
        return "Availability set for employee " + employeeId;
    }

    @GetMapping("/employee/{employeeId}")
    public String getAvailabilityByEmployee(@PathVariable Long employeeId) {
        return "Availability for employee " + employeeId;
    }

    @GetMapping("/{availabilityId}")
    public String getAvailability(@PathVariable Long availabilityId) {
        return "Availability with id " + availabilityId;
    }

    @GetMapping("/date/{date}")
    public String getAvailabilityByDate(@PathVariable String date) {
        return "Availability for date " + date;
    }
}