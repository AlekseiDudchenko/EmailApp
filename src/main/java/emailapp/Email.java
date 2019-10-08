package emailapp;

import java.util.Random;
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
    protected static int minPasswordLength = 7;
    protected static int maxPasswordLength = 12;

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
    }

    Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = UNKNOWN;
        this.password = generatePassword(randomIntFromRange(minPasswordLength, maxPasswordLength));
        this.id = ++number;
    }

    protected static int randomIntFromRange(int min, int max){
        return new Random().nextInt((max - min) + 1) + min;
    }

    Email(String firstName, String lastName, boolean enterDepartmentFromKeyboard){
        this(firstName, lastName);
        department = (enterDepartmentFromKeyboard) ? enterDepartment() : UNKNOWN;
    }

    @Override
    public String toString() {
        String string = "ID: " + id +  //TODO use stringBuilder and/or formater
                "Name: " +  getFirstName() + " " + getLastName();
        return string;
    }

    /**
     * Generates email address
     */
    public String generateEmailAddress() throws Exception {
        if (departmentSetAndKnown())
            return firstName.toLowerCase() + "." +
                lastName.toLowerCase() + "@" +
                department.toLowerCase() + "." +
                EMAILCOMPANYSUFFIX;
        else throw new Exception();
    }

    private boolean departmentSetAndKnown(){
        return (department != null && !department.isEmpty() && !OTHER.equals(department) && !UNKNOWN.equals(department));
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

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void changeFirstNameTo(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void changeLastNameTo(String lastName) {
        this.lastName = lastName;
    }

    private String getPassword() {
        return password;
    }

    public boolean passwordValid(String password) throws Exception {
        if (this.password != null && password != null)
            return this.password.equals(password);
        else throw new Exception();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment(){
        return department;
    }

    private String enterDepartment() {
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

    //TODO specify exception
    public void changePassword (String password) throws Exception {
        if (password.length() > 7)
            this.password = password;
        else throw new Exception();
    }

    /**
     * Generates pseudo random password
     * @param length
     * @return new password
     */
    protected static String generatePassword(int length){
        String passwordSet = "QWERTYUIOPASDFGHJKLZXCVBNM!@#$%^&*()_+1234567890";
        char[] password = new char[length];
        for (int i = 0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return  new String(password);
    }






}
