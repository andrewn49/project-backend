package UIElements.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmCatIdTest {

    @Test
    public void testEmptyConstructor(){
        FilmCatId filmcatid = new FilmCatId();
        Assertions.assertNotNull(filmcatid);
    }

    @Test
    public void testConstructor(){
        Film film = new Film();
        Category cat = new Category();
        FilmCatId filmcatid = new FilmCatId(film, cat);
        Assertions.assertNotNull(filmcatid);
    }
}
