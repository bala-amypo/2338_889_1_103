@RestController
@RequestMapping("/api/templates")
@Tag(name = "Shift Templates Endpoints")
public class ShiftTemplateController {

    @PostMapping("/department/{departmentId}")
    public String createTemplate(@PathVariable Long departmentId) {
        return "Template created for department " + departmentId;
    }

    @GetMapping("/department/{departmentId}")
    public String getTemplatesByDepartment(@PathVariable Long departmentId) {
        return "Templates for department " + departmentId;
    }

    @GetMapping("/{id}")
    public String getTemplate(@PathVariable Long id) {
        return "Template with id " + id;
    }
}