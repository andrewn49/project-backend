package UIElements.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmActorIDTest {
    @Test
    public void testConstructor(){
        FilmActorId filmactorid = new FilmActorId();
        Assertions.assertNotNull(filmactorid);
    }
}
