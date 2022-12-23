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
        CustFilm custfilm = new CustFilm();
        Film film = new Film();
        Customer cust = new Customer();
        custfilm.setFilm(film);
        custfilm.setCustomer(cust);
        Assertions.assertNotNull(custfilm.getFilm());
        Assertions.assertNotNull(custfilm.getCustomer());
    }
}
