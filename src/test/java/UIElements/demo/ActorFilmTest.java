package UIElements.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorFilmTest {

    @Test
    public void testConstructor(){
        ActorFilm actorfilm = new ActorFilm();
        Assertions.assertNotNull(actorfilm);
    }

    @Test
    public void testSettersAndGetters(){
        ActorFilm actorfilm = new ActorFilm();
        Film film = new Film();
        Actor actor = new Actor();
        actorfilm.setFilm(film);
        actorfilm.setActor(actor);
        Assertions.assertNotNull(actorfilm.getFilm());
        Assertions.assertNotNull(actorfilm.getActor());
        Assertions.assertInstanceOf(ActorFilm.class, actorfilm);
    }
}
