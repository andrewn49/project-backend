package UIElements.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Repository
public interface FilmActorRepo extends JpaRepository<ActorFilm, Integer>{
}
