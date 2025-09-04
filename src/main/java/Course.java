import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    int id;
    String label;
    int credits;
    Teacher teacher;
}
