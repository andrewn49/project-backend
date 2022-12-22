package UIElements.demo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@IdClass(CustFilmID.class)
@Table(name="customer_film")
public class CustFilm {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    Film film;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    Customer customer;

    public CustFilm() {
    }

    public CustFilm(Customer cust, Film fil){
        this.film = fil;
        this.customer = cust;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer cust) {
        this.customer = cust;
    }
}