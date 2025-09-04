import lombok.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Grade {
    Student student;
    Exam exam;
    double initialValue;
    List<GradeHistory> history = new ArrayList<>();

    public void addHistory(GradeHistory gradeHistory) {
        history.add(gradeHistory);
    }

    public double getValueAt(Instant instant) {
        return history.stream()
                .filter(h -> !h.getUpdatedDate().isAfter(instant))
                .max(Comparator.comparing(GradeHistory::getUpdatedDate))
                .map(GradeHistory::getValue)
                .orElse(initialValue);
    }
}

