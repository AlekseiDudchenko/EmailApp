package studentdatabase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourseTest {

    @Test
    void constructorTest() throws Exception {
        Course math = new Course("Music");
        assertEquals(100, math.getCost());
        assertEquals("Music", math.getName());
        assertEquals(Course.getNumberOfAvailableCourses(), math.getCourseId());
        Course engl = new Course(("English"));
        assertEquals(Course.getNumberOfAvailableCourses(), engl.getCourseId());
    }

    @Test
    void addCourseThrowExceptionAndChangeNameToTest() throws Exception {
        Course ioT = new Course("IoT");
        Course biology = new Course("Biology");
        assertThrows(Exception.class, () -> {
            Course emptyNameCourse = new Course("");
        });

        assertThrows(Exception.class, () -> {
            Course againIoT = new Course("IoT");
        });

        assertThrows(Exception.class, () -> {
            biology.changeNameTo("IoT");
        });

        assertThrows(Exception.class, () -> {
            biology.changeNameTo("iot");
        });

        assertThrows(Exception.class, () -> {
            biology.changeNameTo("");
        });

        biology.changeNameTo("Biology 101");
        assertEquals("Biology 101", biology.getName());
    }
}