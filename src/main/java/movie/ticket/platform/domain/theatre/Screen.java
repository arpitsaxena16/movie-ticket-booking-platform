package movie.ticket.platform.domain.theatre;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@Data
public class Screen {

    private UUID screenId;
    private List<Seat> seats;
    private List<Show> shows;

}
