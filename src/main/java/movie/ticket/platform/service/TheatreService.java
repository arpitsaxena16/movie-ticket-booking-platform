package movie.ticket.platform.service;

import movie.ticket.platform.domain.theatre.MovieTheatre;
import movie.ticket.platform.domain.theatre.Screen;
import movie.ticket.platform.filter.TheatreFilterCriteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * All the logic here is due to the in memory data, it will be replaced by a repository call in actual world
 */
@Service
public class TheatreService {
    private List<MovieTheatre> allTheatres;

    public TheatreService(List<MovieTheatre> allTheatres) {
        this.allTheatres = allTheatres;
    }

    public Optional<List<MovieTheatre>> findTheatres(TheatreFilterCriteria filterCriteria) {
        List<MovieTheatre> movieTheatres = filterCriteria != null ? allTheatres.stream()
                .filter(t -> filterCriteria.getCity() == null || t.getAddress().getCity().equals(filterCriteria.getCity()))
                .filter(t -> filterCriteria.getMovie() == null || t.getScreen().stream()
                        .filter(s -> !s.getShows().stream()
                                .filter(sh -> !sh.getMovie().getMovieName().equalsIgnoreCase(filterCriteria.getMovie()))
                                .collect(Collectors.toList()).isEmpty()).collect(Collectors.toList()).isEmpty())
                .filter(t -> filterCriteria.getDate() == null || t.getScreen().stream()
                        .filter(s -> !s.getShows().stream()
                                .filter(sh -> !(sh.getStartDate().isBefore(filterCriteria.getDate()) && sh.getEndDate().isAfter(filterCriteria.getDate())))
                                .collect(Collectors.toList()).isEmpty()).collect(Collectors.toList()).isEmpty())
                .collect(Collectors.toList()) : allTheatres;

        return Optional.of(movieTheatres);
    }

    public Optional<List<Screen>> findScreens(UUID theatreId) {
        Optional<MovieTheatre> theatre = allTheatres.stream()
                .filter(th -> th.getTheatreId().equals(theatreId))
                .findFirst();
        return theatre.isPresent() ?
                Optional.ofNullable(theatre.get().getScreen())
                : Optional.empty();
    }
}
