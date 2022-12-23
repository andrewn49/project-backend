package UIElements.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmCatTest {

    @Test
    public void testEmptyConstructor(){
        FilmCat filmcat = new FilmCat();
        Assertions.assertNotNull(filmcat);
    }

    @Test
    public void testSettersAndGetters(){
        FilmCat filmcat = new FilmCat();
        Film film = new Film();
        Category cat = new Category();
        filmcat.setFilm(film);
        filmcat.setCat(cat);
        Assertions.assertNotNull(filmcat.getFilm());
        Assertions.assertNotNull(filmcat.getCat());
    }
}
