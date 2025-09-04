import lombok.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GradeHistory {
      double value;
      Instant updatedDate;
      String reason;
}
