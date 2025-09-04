
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
public class GradCalculatorTest {


        @Test
        void testGetExamGradeAndCourseGrade() {
            Teacher prof = Teacher.builder().id(1).firstName("RAMAROZAKA").lastName("Toky").birthDate(LocalDate.of(1999 , 12 ,12)).email("toky@gamil.com").specialty("Java").build();
            Course prog2 = Course.builder().id(1).label("PROG2").credits(6).teacher(prof).build();
            Exam exam1 = Exam.builder().id(1).title("DS1").course(prog2).date(Instant.now()).coefficient(2).build();
            Exam exam2 = Exam.builder().id(2).title("DS2").course(prog2).date(Instant.now()).coefficient(3).build();

            Student etu = Student.builder().id(1).firstName("NOMENJANAHARY").lastName("Tsikiniaina Tsilavina")
                    .dateOfBirth(LocalDate.of(2007, 5, 9)).email("tsikiniainatsilavina@gmail.com").group("K1").build();

            Grade L1 = new Grade(etu, exam1, 10.0, new ArrayList<>());
            Grade L2 = new Grade(etu, exam2, 15.0, new ArrayList<>());

            List<Grade> grades = List.of(L1, L2);
            GradeCalculator service = new GradeCalculator(grades);

            double noteExam1 = service.getExamGrade(exam1, etu, Instant.now());
            double noteFinale = service.getCourseGrade(prog2, etu, Instant.now());

            assertEquals(10.0, noteExam1);
            assertEquals(13.0, noteFinale);
        }
}
