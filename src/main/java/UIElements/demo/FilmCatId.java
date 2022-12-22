package UIElements.demo;

import java.io.Serializable;
import java.util.Objects;

public class FilmCatId implements Serializable {

    private Film film;
    private Category category;

    public FilmCatId(){}

    public FilmCatId(Film fid, Category cid){
        film = fid;
        category = cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCatId filmCatId = (FilmCatId) o;
        return Objects.equals(film, filmCatId.film) && Objects.equals(category, filmCatId.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(film, category);
    }
}
