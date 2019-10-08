package emailapp;


import constants.Constants;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void twoArgumentConstructorTest(){
        Email email = new Email("Ivan", "Ivanov");
        assertEquals("Ivan", email.getFirstName());
        assertEquals("Ivanov", email.getLastName());
        assertEquals(Email.getNumber(), email.getId());
    }

    @Test
    void threeArgumentConstructorTest(){
        Email salesEmail = new Email("Petr", "Petrov", 1);
        assertEquals("Petr", salesEmail.getFirstName());
        assertEquals("Petrov", salesEmail.getLastName());
        assertEquals(Email.getNumber(), salesEmail.getId());
        assertEquals(Constants.SALES , salesEmail.getDepartment());

        Email developmentEmail = new Email("Petr", "Petrov", 2);
        assertEquals(Constants.DEVELOPMENT , developmentEmail.getDepartment());

        Email accountingEmail = new Email("Petr", "Petrov", 3);
        assertEquals(Constants.ACCOUNTING , accountingEmail.getDepartment());

        Email otherEmail = new Email("Petr", "Petrov", 4);
        assertEquals(Constants.OTHER , otherEmail.getDepartment());

        Email unknownDepartmentEmail = new Email("San", "Sanich", 5);
        assertEquals(Constants.UNKNOWN , unknownDepartmentEmail.getDepartment());
    }

    @Test
    void constructorWithWrongDepartment() {
        Email email = new Email("Ivan", "Ivanov", "Adef");
        assertEquals(Constants.UNKNOWN, email.getDepartment());
    }

    @Test
    void constructorWithLowerCasedDepartment(){
       Email email = new Email("Ivan", "Ivanov", "development");
       assertEquals(Constants.DEVELOPMENT, email.getDepartment());
       Email email2 = new Email("Ivan", "Ivanov", "sales");
       assertEquals(Constants.SALES, email2.getDepartment());
       Email email3 = new Email("Ivan", "Ivanov", "accounting");
       assertEquals(Constants.ACCOUNTING, email3.getDepartment());
       Email email4 = new Email("Ivan", "Ivanov", "other");
       assertEquals(Constants.OTHER, email4.getDepartment());
    }

    @Test
    void constructorWithUpperCaseDepartment(){
        Email email = new Email("Ivan", "Ivanov", "Development");
        assertEquals(Constants.DEVELOPMENT, email.getDepartment());
        Email email2 = new Email("Ivan", "Ivanov", "sALES");
        assertEquals(Constants.SALES, email2.getDepartment());
        Email email3 = new Email("Ivan", "Ivanov", "AccountING");
        assertEquals(Constants.ACCOUNTING, email3.getDepartment());
        Email email4 = new Email("Ivan", "Ivanov", "OTHER");
        assertEquals(Constants.OTHER, email4.getDepartment());
    }

    @Test
    void generatePasswordTest(){
        IntStream.range(0, 100000).forEach(n -> {
            assertNotEquals(Email.generatePassword(Email.randomIntFromRange(Email.minPasswordLength, Email.maxPasswordLength)),
                    Email.generatePassword(Email.randomIntFromRange(Email.minPasswordLength, Email.maxPasswordLength)));
        });
    }

    @Test
    void toStringTest(){
        Email email = new Email("Ivan", "Sidorov");
        String expectedString = "ID: " + Email.getNumber() + "Name: Ivan Sidorov";
        assertEquals(expectedString, email.toString());
    }

    @Test
    void constructorWithEnterDepartmentTest() {
        //TODO mock Scanner
//        Email email = new Email("Vladimir", "Medvedev", true);
    }

    @Test
    void generateEmailAddressNoDepartmentTest() throws Exception {
        Email email =  new Email("Bill", "Bucsh");
        assertEquals(Constants.UNKNOWN, email.getDepartment());
        assertThrows(Exception.class, email::generateEmailAddress);
    }

    @Test
    void generateEmailAddressWrongDepartmentTest() throws Exception {
        Email email =  new Email("Bill", "Bucsh", "adfsd");
        assertEquals(Constants.UNKNOWN, email.getDepartment());
        assertThrows(Exception.class, email::generateEmailAddress);
    }

    @Test
    void generateEmailAddressWrongDepartmentNumberTest(){
        Email email = new Email("adfasd", "asdfd", 6);
        assertEquals(Constants.UNKNOWN, email.getDepartment());
        assertThrows(Exception.class, email::generateEmailAddress);
    }

    @Test
    void generateEmailAddressTest() throws Exception {
        Email email =  new Email("Adsa", "QWDSFASDF", Constants.SALES);
        assertEquals("adsa.qwdsfasdf@sales.thecompany.de", email.generateEmailAddress());
    }






}