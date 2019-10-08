package studentdatabase;

public class Course {

    private  int courseId;
    private String name;
    private int cost;
    private static int number = 0;
    private static int defaultPrice = 100;

    Course(String name){
        this.name = name;
        this.cost = defaultPrice;
        this.courseId = ++number;
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


}
