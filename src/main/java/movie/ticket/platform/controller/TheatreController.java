package movie.ticket.platform.controller;

import movie.ticket.platform.domain.theatre.MovieTheatre;
import movie.ticket.platform.domain.theatre.Screen;
import movie.ticket.platform.filter.TheatreFilterCriteria;
import movie.ticket.platform.service.TheatreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping
    ResponseEntity<List<MovieTheatre>> allTheatres(TheatreFilterCriteria filterCriteria) {
        return ResponseEntity.of(theatreService.findTheatres(filterCriteria));
    }

    @GetMapping("/{theatreId}/screens")
    ResponseEntity<List<Screen>> allScreensForTheatre(@PathVariable UUID theatreId) {
        return ResponseEntity.of(theatreService.findScreens(theatreId));
    }

}
