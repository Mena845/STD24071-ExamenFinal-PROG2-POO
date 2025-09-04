import java.time.Instant;
import java.util.List;

public class GradeCalculator {
    List<Grade> grades;
    public GradeCalculator(List<Grade> grades) {
        this.grades = grades;
    }

    public String getExamGrade(Exam exam, Student student, Instant t) {
        double grade = grades.stream()
                .filter(g -> g.getStudent().equals(student) && g.getExam().equals(exam))
                .findFirst()
                .map(g -> g.getValueAt(t))
                .orElse(0.0);

        return "The grade of " + student.getFirstName() + " " + student.getLastName() +
                " for the exam '" + exam.getTitle() + "' is " + grade;
    }


    public String getCourseGrade(Course course, Student student, Instant t) {
        List<Grade> courseGrades = grades.stream()
                .filter(g -> g.getStudent().equals(student) && g.getExam().getCourse().equals(course))
                .toList();

        double total = 0;
        int totalCoeff = 0;

        for (Grade g : courseGrades) {
            double val = g.getValueAt(t);
            int coeff = g.getExam().getCoefficient();
            total += val * coeff;
            totalCoeff += coeff;
        }

        double finalGrade = totalCoeff == 0 ? 0.0 : total / totalCoeff;

        return "The final grade of " + student.getFirstName() + " " + student.getLastName() +
                " for the course '" + course.getLabel() + "' is " + finalGrade;
    }


}

