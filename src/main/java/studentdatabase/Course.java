package studentdatabase;

import java.util.ArrayList;

public class Course {

    private  int courseId;
    private String name;
    private int cost;
    private static int number = 0;
    private static int defaultCost = 100;
    private static ArrayList<Course> existingCourses = new ArrayList<>();

    Course(String name) throws Exception {
        if (name.equals("")) throw new Exception();
        else if (containsCourseWithName(name)) throw new Exception();
        else {
            this.name = name;
            this.cost = defaultCost;
            this.courseId = ++number;
            existingCourses.add(this);
        }
    }

    private boolean containsCourseWithName(String name){
        for (Course course:existingCourses)
            if (course.name.equalsIgnoreCase(name)) return true;
        return false;
    }

    public static int getNumberOfAvailableCourses(){
        return number;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public void changeNameTo(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public static ArrayList<Course> getExistingCourses() {
        return existingCourses;
    }



}
