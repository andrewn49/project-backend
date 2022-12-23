package UIElements.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustFilmTest {
    @Test
    public void testConstructor(){
        CustFilm custfilm = new CustFilm();
        Assertions.assertNotNull(custfilm);
    }

    @Test
    public void testSettersAndGetters(){
        Film film = new Film();
        Customer cust = new Customer();
        CustFilm custfilm = new CustFilm(cust, film);
        Assertions.assertNotNull(custfilm);
        custfilm.setFilm(film);
        custfilm.setCustomer(cust);
        Assertions.assertNotNull(custfilm.getFilm());
        Assertions.assertNotNull(custfilm.getCustomer());
    }
}
