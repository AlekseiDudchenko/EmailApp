package studentdatabase;

import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private int id;
    private String gradeYear;
    private int studentID;
    private ArrayList<Course> courses;
    private int tuitionBalance;
    private int totalTuition = 0;
    private static int number = 0;

    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        gradeYear = "first";
    }

    public void setGradeYear(String gradeYear){
        this.gradeYear = gradeYear;
        id = ++number;
    }

    public void addCourse(Course course){
        courses.add(course);
        totalTuition += course.getCost();
    }

    public int getTotalTuition(){
        return totalTuition;
    }

    public int getNumberOfEnrolledCourses(){
        return courses.size();
    }
}
