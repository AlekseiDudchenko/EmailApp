package studentdatabase;

import constants.Constants;

import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private int id;
    private String gradeYear;
    private ArrayList<Course> courses = new ArrayList<>();
    private int totalTuition = 0;
    private static int number = 0;

    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        id = ++number;
        gradeYear = Constants.FRESHMEN;
    }

    public void setGradeYear(String gradeYear){
        this.gradeYear = gradeYear;
    }

    public String getGradeYear(){
        return gradeYear;
    }

    public void addCourse(Course course){
        courses.add(course);
        totalTuition += course.getCost();
    }

    public int getTotalTuition(){
        return totalTuition;
    }

    public ArrayList<Course> getEnrolledCourses(){
        return courses;
    }

    public int getNumberOfEnrolledCourses(){
        return courses.size();
    }
}
