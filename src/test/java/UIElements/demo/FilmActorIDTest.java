package UIElements.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmActorIDTest {
    @Test
    public void testEmptyConstructor() {
        FilmActorId filmactorid = new FilmActorId();
        Assertions.assertNotNull(filmactorid);
    }

    @Test
    public void testConstructor(){
        Film film = new Film();
        Actor actor = new Actor();
        FilmActorId filmactorid = new FilmActorId(film, actor);
        Assertions.assertNotNull(filmactorid);
    }
}
