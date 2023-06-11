package movie.ticket.platform.domain.theatre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import movie.ticket.platform.domain.type.SeatCategory;

@Getter
@AllArgsConstructor
@Data
public class Seat {

    private String seatNum;
    private SeatCategory seatCategory;

}
