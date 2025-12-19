import java.util.List;

public interface ShiftTemplateService {

    ShiftTemplate create(ShiftTemplate template);

    List<ShiftTemplate> getByDepartment(Long departmentId);
}