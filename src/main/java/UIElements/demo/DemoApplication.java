package UIElements.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class DemoApplication {
	@Autowired
	private ActorRepository actorrepo;
	private CategoryRepository catrepo;
	private FilmRepository filmrepo;
	private CustFilmRepo custfilmrepo;
	private CustomerRepository custrepo;

	@Autowired
	public DemoApplication(ActorRepository ar, CategoryRepository cr, FilmRepository fr, CustFilmRepo cfr, CustomerRepository custr){
		actorrepo = ar;
		catrepo = cr;
		filmrepo = fr;
		custfilmrepo = cfr;
		custrepo = custr;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/allactors")
	public @ResponseBody Iterable<Actor> getAllActors(){
		return actorrepo.findAll();
	}

	@GetMapping("/getactor/{actorid}")
	public @ResponseBody Actor getActorById(@PathVariable("actorid") int actorid){
		Actor actor = actorrepo.findById(actorid).orElseThrow(() -> new ResourceAccessException("Actor id doesn't exist in the DB: " + actorid));
		return actor;
	}

	@PostMapping("/addactor")
	public Actor newActor(@RequestBody Actor newactor){
		return actorrepo.save(newactor);
	}

	@PutMapping("updateactor/{actorid}")
	public @ResponseBody Actor updateActorById(@RequestBody Actor newactor, @PathVariable("actorid") int actorid){
		return actorrepo.findById(actorid).map(actor -> {
			actor.setFirstname(newactor.getFirstname());
			actor.setLastname(newactor.getLastname());
			return actorrepo.save(actor);
		}).orElseGet(() -> {
			newactor.setActorid(actorid);
			return actorrepo.save(newactor);
		});
	}

	@DeleteMapping("deleteactor/{actorid}")
	public void deleteActor(@PathVariable("actorid") int actorid){
		actorrepo.deleteById(actorid);
	}

	@GetMapping("/allcategories")
	public @ResponseBody Iterable<Category> getAllCategories(){
		return catrepo.findAll();
	}

	@GetMapping("/getcategory/{catid}")
	public @ResponseBody Category getCategory(@PathVariable("catid") int catid){
		Category cat = catrepo.findById(catid).orElseThrow(() -> new ResourceAccessException("Category ID doesn't exist in the DB: " + catid));
	return cat;
	}

	@PostMapping("/addcategory")
	public Category newCategory(@RequestBody Category newcat){
		return catrepo.save(newcat);
	}

	@PutMapping("/updatecategory/{catid}")
	public @ResponseBody Category updateCategoryById(@RequestBody Category newcat, @PathVariable("catid") int catid){
		return catrepo.findById(catid).map(category -> {
			category.setCatname(newcat.getCatname());
			return catrepo.save(category);
		}).orElseGet(() -> {
			newcat.setCategoryid(catid);
			return catrepo.save(newcat);
		});
	}

	@DeleteMapping("/deletecategory/{catid}")
	public void deleteCategory(@PathVariable("catid") int catid){
		catrepo.deleteById(catid);
	}

	@GetMapping("/filmsofcat/{catname}")
	public Collection<Film> filmsOfCategory(@PathVariable("catname")String catname){
		return filmrepo.findFilmsOfCategory(catname);
	}

	@GetMapping("/actorsinfilm/{filmid}")
	public Collection<Actor> actorsInFilm(@PathVariable("filmid") int filmid){
		return actorrepo.findActorsInFilm(filmid);
	}

	@GetMapping("/filmsforactor/{actorid}")
	public Collection<Film> filmsforActor(@PathVariable("actorid") int actorid){
		return filmrepo.findFilmsForActor(actorid);
	}

	@GetMapping("/allfilms")
	public @ResponseBody Iterable<Film> getAllFilms(){
		return filmrepo.findAll();
	}

	@GetMapping("/getfilm/{filmid}")
	public @ResponseBody Film getFilmById(@PathVariable("filmid") int filmid){
		Film film = filmrepo.findById(filmid).orElseThrow(() -> new ResourceAccessException("Film id doesn't exist in the DB: " + filmid));
		return film;
	}

	@PostMapping("/addfilm")
	public Film addFilm(@RequestBody Film newfilm){
		return filmrepo.save(newfilm);
	}

	@PutMapping("updatefilm/{filmid}")
	public Film updateFilmById(@RequestBody Film newfilm, @PathVariable("filmid") int filmid){
		return filmrepo.findById(filmid).map(film -> {
			film.setTitle(newfilm.title);
			film.setDesc(newfilm.desc);
			return filmrepo.save(film);
		}).orElseGet(() -> {
			newfilm.setFilmid(filmid);
			return filmrepo.save(newfilm);
		});
	}

	@DeleteMapping("/deletefilm/{filmid}")
	public void deleteFilm(@PathVariable("filmid") int filmid){
		filmrepo.deleteById(filmid);
	}

	@PostMapping("/{custid}/{filmid}/watched")
	public void hasWatched(@PathVariable("custid") int custid, @PathVariable("filmid") int filmid){
		Customer selcust = custrepo.findById(custid).orElseThrow(() -> new ResourceAccessException("Customer id doesn't exist in the DB: " + custid));
		Film selfilm = filmrepo.findById(filmid).orElseThrow(() -> new ResourceAccessException("Film id doesn't exist in the DB: " + filmid));
		CustFilm haswatched = new CustFilm(selcust, selfilm);
		custfilmrepo.save(haswatched);
	}

	@GetMapping("/haswatched/{custid}")
	public @ResponseBody Collection<Film> getWatchedFilms(@PathVariable("custid") int custid){
		return filmrepo.getWatchedFilms(custid);
	}

	@DeleteMapping("/removewatched/{custid}/{filmid}")
	public void removeWatchedFilm(@PathVariable("custid") int custid, @PathVariable("filmid") int filmid){
		custfilmrepo.removeFilm(custid, filmid);
	}
	@GetMapping("/catoffilm/{filmid}")
	public @ResponseBody Category getCatOfFilm(@PathVariable("filmid") int filmid){
		return catrepo.getFilmCat(filmid);
	}

	@GetMapping("/randomfilm/{custid}")
	public @ResponseBody FilmWithCat getRandomFilm(@PathVariable("custid") int custid){
		int randid = (int)(Math.random() * filmrepo.count() - 1) + 1;
		Collection<Film> watchedfilms = filmrepo.getWatchedFilms(custid);
		Film randfilm = null;
		for(int x = 0; x < filmrepo.getWatchedFilms(custid).size(); x++){
			for(Film films: watchedfilms)
				if(randid == films.getFilmid()){
					getRandomFilm(custid);
				}
			else{
				randfilm = getFilmById(randid);
			}
		}
		FilmWithCat newfilm = new FilmWithCat(randfilm, getCatOfFilm(randfilm.getFilmid()));
		return newfilm ;
	}
}
