package studentdatabase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseTest {

    @Test
    void constructorTest(){
        Course math = new Course("Math");
        assertEquals(100, math.getCost());
        assertEquals("Math", math.getName());
        assertEquals(Course.getNumberOfAvailableCourses(), math.getCourseId());
        Course engl = new Course(("English"));
        assertEquals(Course.getNumberOfAvailableCourses(), engl.getCourseId());
    }



}