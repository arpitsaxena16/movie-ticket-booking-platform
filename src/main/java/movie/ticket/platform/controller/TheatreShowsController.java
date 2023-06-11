package movie.ticket.platform.controller;

import movie.ticket.platform.domain.theatre.MovieTheatre;
import movie.ticket.platform.domain.theatre.Show;
import movie.ticket.platform.domain.theatre.ShowSeat;
import movie.ticket.platform.service.TheatreShowsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/theatre-shows")
public class TheatreShowsController {

    private final TheatreShowsService theatreShowsService;

    public TheatreShowsController(TheatreShowsService theatreShowsService) {
        this.theatreShowsService = theatreShowsService;
    }

    @DeleteMapping("/{theatreId}/screens/{screenId}")
    ResponseEntity<MovieTheatre> deleteShows(@PathVariable UUID theatreId, @PathVariable UUID screenId, @RequestBody List<Show> shows) {
        return ResponseEntity.of(theatreShowsService.deleteShows(theatreId, screenId, shows));
    }

    @PatchMapping("/{theatreId}/screens/{screenId}")
    ResponseEntity<MovieTheatre> upsertShows(@PathVariable UUID theatreId, @PathVariable UUID screenId, @RequestBody List<Show> shows) {
        return ResponseEntity.of(theatreShowsService.upsertShows(theatreId, screenId, shows));
    }

    @PutMapping("/{theatreId}/screens/{screenId}/shows/{showId}")
    ResponseEntity<?> updateSeats(@PathVariable UUID theatreId, @PathVariable UUID screenId, @PathVariable UUID showId,
                                  @RequestBody List<ShowSeat> seats) {
        return ResponseEntity.of(theatreShowsService.updateSeats(theatreId, screenId, showId, seats));
    }

}
