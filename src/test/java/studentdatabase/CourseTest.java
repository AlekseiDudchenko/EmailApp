package studentdatabase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourseTest {

    @Test
    void constructorTest() throws Exception {
        Course math = new Course("Math");
        assertEquals(100, math.getCost());
        assertEquals("Math", math.getName());
        assertEquals(Course.getNumberOfAvailableCourses(), math.getCourseId());
        Course engl = new Course(("English"));
        assertEquals(Course.getNumberOfAvailableCourses(), engl.getCourseId());
    }

    @Test
    void addCourseThrowExceptionTest() throws Exception {
        Course math = new Course("Math");
        Course history = new Course("History");
        assertThrows(Exception.class, () -> {
            Course emptyNameCourse = new Course("");
        });

        assertThrows(Exception.class, () -> {
            Course againMath = new Course("Math");
        });
    }



}