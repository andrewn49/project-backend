package UIElements.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmTest {
    @Test
    public void testEmptyConstructor(){
        Film film = new Film();
        Assertions.assertNotNull(film);
    }

    @Test
    public void testConstructor(){
        Film film = new Film("words", "otherwords");
        Assertions.assertEquals("words", film.getTitle(), "Film title is not set correctly");
        Assertions.assertEquals("otherwords", film.getDesc(), "Film description is not set correctly");
    }

    @Test
    public void testSettersAndGetters(){
        Film film = new Film();
        film.setFilmid(2);
        Assertions.assertEquals(2, film.getFilmid(), "Film id is not set correctly");
        film.setTitle("test");
        Assertions.assertEquals("test", film.getTitle(), "Film title is not set correctly");
        film.setDesc("test description");
        Assertions.assertEquals("test description", film.getDesc(), "Film description is not set correctly");
    }
}
