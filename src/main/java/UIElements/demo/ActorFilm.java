package UIElements.demo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@IdClass(FilmActorId.class)
@Table(name="film_actor")
public class ActorFilm {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    Film film;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    Actor actor;

    public ActorFilm() {
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor act) {
        this.actor = act;
    }
}