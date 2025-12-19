@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employees Endpoints")
public class EmployeeController {

    @PostMapping("/register")
    public String createEmployee() {
        return "Employee created";
    }

    @GetMapping
    public String getAllEmployees() {
        return "All employees";
    }

    @GetMapping("/{id}")
    public String getEmployee(@PathVariable Long id) {
        return "Employee with id " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return "Employee deleted " + id;
    }
}