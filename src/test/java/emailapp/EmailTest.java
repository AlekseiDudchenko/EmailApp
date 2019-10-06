package emailapp;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Email email = new Email("Petr", "Petrov", 3);
        assertEquals("Accounting", email.getDepartment());
        assertEquals("Petr", email.getFirstName());
        assertEquals("Petrov", email.getLastName());
        assertEquals(Email.getNumber(), email.getId());
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

}