package cst438_1;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie, Long> {
	
	@Query("select m from Movie m order by title, date desc")
	
	List<Movie> findAllMovieRatingsOrderByTitleDateDesc();
}
