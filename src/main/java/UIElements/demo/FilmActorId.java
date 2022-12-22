package UIElements.demo;

import java.io.Serializable;
import java.util.Objects;

public class FilmActorId implements Serializable {

    private Film film;
    private Actor actor;

    public FilmActorId(){}

    public FilmActorId(Film fid, Actor aid){
        film = fid;
        actor = aid;
    }
}
