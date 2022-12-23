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
}
