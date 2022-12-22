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
        Assertions.assertEquals("words", film.getTitle());
        Assertions.assertEquals("otherwords", film.getDesc());
    }

}
