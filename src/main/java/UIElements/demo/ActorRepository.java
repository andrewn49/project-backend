package UIElements.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {

    @Query(value="SELECT actor.actor_id, actor.first_name, actor.last_name FROM actor " +
            "INNER JOIN film_actor ON actor.actor_id = film_actor.actor_id " +
            "INNER JOIN film ON film_actor.film_id = film.film_id " +
            "WHERE film.film_id = :filmid ;", nativeQuery = true)
    Collection<Actor> findActorsInFilm(@Param("filmid") int filmid);
}


