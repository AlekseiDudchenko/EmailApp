package studentdatabase;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static constants.Constants.FRESHMEN;
import static constants.Constants.JUNIOR;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    void setGradeYearTest() {
        Student student = new Student("Bill", "C");
        assertEquals(FRESHMEN, student.getGradeYear());
        student.setGradeYear(JUNIOR);
        assertEquals(JUNIOR, student.getGradeYear());
    }

    @Test
    void addCourseTest() throws Exception {
        Student student = new Student("Ivan","Ivanov");
        assertEquals(new ArrayList<>(), student.getEnrolledCourses());

        Course math = new Course("Math");
        student.addCourse(math);
        ArrayList<Course> expectedArrayList = new ArrayList<>();
        expectedArrayList.add(math);
        assertEquals(expectedArrayList, student.getEnrolledCourses());

        Course history = new Course("History");
        expectedArrayList.add(history);
        student.addCourse(history);
        assertEquals(expectedArrayList, student.getEnrolledCourses());
    }

    @Test
    void addCourseThrowExceptionTest() throws Exception {
        Student student = new Student("Ivan", "Ivanov");
    }

    @Test
    void getTotalTuition() throws Exception {
        Student student = new Student("Moe", "Armstrong");
        Course math = new Course("PE");
        assertEquals(0, student.getTotalTuition());
        student.addCourse(math);
        assertEquals(100, student.getTotalTuition());
        math.setCost(600);
        assertEquals(600, student.getTotalTuition());
    }

    @Test
    void getEnrolledCoursesAndGetNumberOfEnrolledCourses() throws Exception {
        Student student = new Student("Bart", "Simpson");
        assertEquals(0, student.getNumberOfEnrolledCourses());
        Course philosophy = new Course("Philosophy");
        Course art = new Course("Art");
        student.addCourse(philosophy);
        assertEquals(1, student.getNumberOfEnrolledCourses());
        ArrayList<Course> expectedCourses = new ArrayList<>();
        expectedCourses.add(philosophy);
        assertEquals(expectedCourses, student.getEnrolledCourses());
        student.addCourse(art);
        expectedCourses.add(art);
        assertEquals(expectedCourses, student.getEnrolledCourses());
        assertEquals(2, student.getNumberOfEnrolledCourses());
    }
}