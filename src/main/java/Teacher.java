import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    int id;
    String firstName;
    String lastName;
    LocalDate birthDate;
    String email;
    String phoneNumber;
    String specialty;
}
