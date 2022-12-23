package UIElements.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmWithCatTest {
    @Test
    public void testConstructor(){
        Film film = new Film();
        Category cat = new Category();
        FilmWithCat filmwithcat = new FilmWithCat(film, cat);
        Assertions.assertNotNull(filmwithcat);
    }

    @Test
    public void testSettersAndGetters(){
        Film film = new Film();
        Category cat = new Category();
        FilmWithCat filmwithcat = new FilmWithCat(film, cat);
        filmwithcat.setFilmid(2);
        filmwithcat.setDesc("Description");
        filmwithcat.setCatid(1);
        filmwithcat.setGenre("Genre");
        filmwithcat.setTitle("Title");
        Assertions.assertEquals(2, filmwithcat.getFilmid(), "Film id is not set correctly");
        Assertions.assertEquals(1, filmwithcat.getCatid(), "Cat id is not set correctly");
        Assertions.assertEquals("Genre", filmwithcat.getGenre(), "Genre is not set correctly");
        Assertions.assertEquals("Title", filmwithcat.getTitle(), "Title is not set correctly");
        Assertions.assertEquals("Description", filmwithcat.getDesc(), "Description is not set correctly");
    }
}
