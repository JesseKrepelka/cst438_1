package cst438_1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class Cont {
	@Autowired
	MovieRepo movieRepo;
	
	@GetMapping("/movies/new")
	public String createPerson( Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "movie_form";
	}
	
	@PostMapping("/movies")
	public String processMovieForm(@Valid Movie rating,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "movie_form";
		}
		movieRepo.save(rating);
		return "movie_show";
	}
	
	@GetMapping("/movies")
	public String getAllMovies(Model model) {
		Iterable<Movie> movies = movieRepo.findAllMovieRatingsOrderByTitleDateDesc();
		model.addAttribute("movies", movies);
		return "movie_list";
	}
}
