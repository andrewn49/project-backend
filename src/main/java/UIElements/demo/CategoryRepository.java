package UIElements.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    @Query(value="SELECT category.category_id, category.name FROM category INNER JOIN film_category ON category.category_id = film_category.category_id INNER JOIN film ON film_category.film_id = film.film_id WHERE film.film_id = :filmid ", nativeQuery = true)
    Category getFilmCat(@Param("filmid") int filmid);
}
