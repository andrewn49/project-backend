package UIElements.demo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface CustFilmRepo extends JpaRepository<CustFilm, Integer>{
    @Modifying
    @Transactional
    @Query(value="DELETE FROM customer_film " +
            "WHERE customer_id = :custid " +
            "AND film_id = :filmid", nativeQuery = true)
    void removeFilm(@Param("custid") int custid, @Param("filmid") int filmid);
}
