package UIElements.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmCatIdTest {

    @Test
    public void testConstructor(){
        FilmCatId filmcatid = new FilmCatId();
        Assertions.assertNotNull(filmcatid);
    }
}
