package emailapp;

import java.util.Scanner;

import static emailapp.Constants.*;

public class Email {

    static private int number = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;

    Email(String firstName, String lastName, int departmentCode){
        this(firstName,lastName);
        switch (departmentCode){
            case 1:
                this.department = SALES;
                break;
            case 2:
                this.department = DEVELOPMENT;
                break;
            case 3:
                this.department = ACCOUNTING;
                break;
            case 4:
                this.department = OTHER;
                break;
            default:
                this.department = UNKNOWN;
                break;
        }

    }

    Email(String firstName, String lastName, String department){
        this(firstName, lastName);
        if (department.equalsIgnoreCase(SALES) ||
        department.equalsIgnoreCase(DEVELOPMENT) ||
        department.equalsIgnoreCase(ACCOUNTING) ||
        department.equalsIgnoreCase(OTHER)) {
            this.department = department.substring(0, 1).toUpperCase() +
                    department.substring(1).toLowerCase();
        }
        else this.department = UNKNOWN;
    }

    Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = ++number;
    }

    @Override
    public String toString() {
        String st = "ID: " +
                id;
        return st;
    }

    public void print(){
        System.out.println(this.toString());
    };

    static int getNumber(){
        return number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment(){
        return department;
    }

    public String enterDepartment() {
        System.out.println("Enter the department code.\n " +
                "1 - Sales\n " +
                "2 - Development\n " +
                "3 - Accounting\n " +
                "4 - other");
        Scanner in = new Scanner(System.in);
        int department = in.nextInt();
         switch (department){
             case 1:
                 return SALES;
             case 2:
                 return DEVELOPMENT;
             case 3:
                 return ACCOUNTING;
             case 4:
                 return OTHER;
             default:
                 return UNKNOWN;
         }
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }








}
