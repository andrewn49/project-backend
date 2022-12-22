package UIElements.demo;

public class FilmWithCat {
    int filmid;
    int catid;
    String title;
    String genre;
    String desc;

    public FilmWithCat(Film fm, Category ct){
       filmid = fm.getFilmid();
       catid = ct.getCategoryid();
       title = fm.getTitle();
       genre = ct.getCatname();
       desc = fm.getDesc();
    }

    public int getFilmid() {
        return filmid;
    }

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
