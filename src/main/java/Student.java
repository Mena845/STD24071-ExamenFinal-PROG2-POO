import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    int id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String email;
    String phoneNumber;
    String group;
    Tutors tutor;
}
