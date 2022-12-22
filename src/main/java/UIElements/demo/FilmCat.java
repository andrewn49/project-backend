package UIElements.demo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@IdClass(FilmCatId.class)
@Table(name="film_category")
public class FilmCat {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    Film film;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    Category category;

    public FilmCat(){}

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Category getCat() {
        return category;
    }

    public void setCat(Category cat) {
        this.category = cat;
    }
}
