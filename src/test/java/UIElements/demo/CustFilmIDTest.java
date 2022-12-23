package UIElements.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustFilmIDTest {
    @Test
    public void testConstructor(){
        CustFilmID custfilmid = new CustFilmID();
        Assertions.assertNotNull(custfilmid);
    }
}
