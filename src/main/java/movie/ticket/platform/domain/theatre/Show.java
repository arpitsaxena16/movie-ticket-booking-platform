package movie.ticket.platform.domain.theatre;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import movie.ticket.platform.domain.movie.Movie;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@Data
public class Show {

    private UUID showId;
    private Movie movie;
    private LocalTime showTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<ShowSeat> bookedSeatIds;
}
