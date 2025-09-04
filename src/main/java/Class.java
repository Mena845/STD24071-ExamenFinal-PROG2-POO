import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Class {
    String name;
    List<String> groups;
}
