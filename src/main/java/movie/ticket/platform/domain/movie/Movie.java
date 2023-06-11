package movie.ticket.platform.domain.movie;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@Data
public class Movie {

    private UUID movieId;
    private String movieName;
    private Duration movieDurationInMinutes;
    private String language;
    private String genre;
    private ZonedDateTime releaseDate;

}
