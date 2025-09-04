
import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exam {
    int id;
    String title;
    Course course;
    Instant date;
    int coefficient;

}
