package UIElements.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    @Query(value = "SELECT film.film_id, title, description FROM film " +
            "INNER JOIN film_category ON film.film_id = film_category.film_id " +
            "INNER JOIN category ON film_category.category_id = category.category_id " +
            "WHERE category.name = :catname ;", nativeQuery = true)
    Collection<Film> findFilmsOfCategory(@Param("catname") String catname);

    @Query(value = "SELECT film.film_id, film.title, film.description FROM film " +
            "INNER JOIN film_actor ON film_actor.film_id = film.film_id " +
            "INNER JOIN actor ON actor.actor_id = film_actor.actor_id " +
            "WHERE actor.actor_id = :actorid ;", nativeQuery = true)
    Collection<Film> findFilmsForActor(@Param("actorid") int actorid);

    @Query(value="SELECT film.film_id, film.title, film.description FROM film " +
            "INNER JOIN customer_film ON film.film_id = customer_film.film_id " +
            "INNER JOIN customer ON customer_film.customer_id = customer.customer_id " +
            "WHERE customer.customer_id = :custid", nativeQuery = true)
    Collection<Film> getWatchedFilms(@Param("custid") int custid);
}
