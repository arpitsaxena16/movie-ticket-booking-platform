package movie.ticket.platform.service;

import movie.ticket.platform.domain.theatre.*;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * All the logic here is due to the in memory data, it will be replaced by a repository call in actual world
 */
@Service
public class TheatreShowsService {

    private List<MovieTheatre> allTheatres;

    public TheatreShowsService(List<MovieTheatre> allTheatres) {
        this.allTheatres = allTheatres;
    }

    public Optional<MovieTheatre> upsertShows(UUID theatreId, UUID screenId, List<Show> shows) {
        Optional<MovieTheatre> theatre = getMovieTheatre(theatreId);
        Optional<Screen> screen = getScreen(screenId, theatre);

        if(screen.isPresent()) {
            List<Screen> l = new ArrayList<>(theatre.get().getScreen());
            l.remove(screen.get());
            List<Show> sh = new ArrayList<>(screen.get().getShows());
            sh.addAll(shows);
            screen.get().setShows(sh);
            l.add(screen.get());
            theatre.get().setScreen(l);
        }
        return theatre;
    }

    public Optional<MovieTheatre> deleteShows(UUID theatreId, UUID screenId, List<Show> shows) {
        Optional<MovieTheatre> theatre = getMovieTheatre(theatreId);
        Optional<Screen> screen = getScreen(screenId, theatre);
        if(screen.isPresent()) {
            List<Screen> l = new ArrayList<>(theatre.get().getScreen());
            l.remove(screen.get());
            List<Show> sh = new ArrayList<>(screen.get().getShows());
            sh.removeAll(shows);
            screen.get().setShows(sh);
            l.add(screen.get());
            theatre.get().setScreen(l);
        }
        return theatre;
    }

    public Optional<MovieTheatre> updateSeats(UUID theatreId, UUID screenId, UUID showId, List<ShowSeat> seats) {
        Optional<MovieTheatre> theatre = getMovieTheatre(theatreId);
        Optional<Screen> screen = getScreen(screenId, theatre);
        Optional<Show> show = getShow(showId, screen);
        if(show.isPresent()) {
            List<Screen> l = new ArrayList<>(theatre.get().getScreen());
            l.remove(screen.get());
            List<Show> sh = new ArrayList<>(screen.get().getShows());
            sh.remove(show.get());
            show.get().setBookedSeatIds(seats);
            sh.add(show.get());
            screen.get().setShows(sh);
            l.add(screen.get());
            theatre.get().setScreen(l);
        }
        return theatre;
    }

    private Optional<MovieTheatre> getMovieTheatre(UUID theatreId) {
        Optional<MovieTheatre> theatre = allTheatres.stream()
                .filter(th -> th.getTheatreId().equals(theatreId))
                .findFirst();
        return theatre;
    }

    private Optional<Screen> getScreen(UUID screenId, Optional<MovieTheatre> theatre) {
        Optional<Screen> screen = theatre.isPresent() ?
                theatre.get().getScreen().stream()
                        .filter(sc -> sc.getScreenId().equals(screenId))
                        .findFirst(): Optional.empty();
        return screen;
    }

    private Optional<Show> getShow(UUID showId, Optional<Screen> screen) {
        Optional<Show> show = screen.isPresent() ?
                screen.get().getShows().stream()
                        .filter(sc -> sc.getShowId().equals(showId))
                        .findFirst(): Optional.empty();
        return show;
    }
}
