package movie.ticket.platform.domain.booking;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import movie.ticket.platform.domain.theatre.Show;
import movie.ticket.platform.domain.theatre.ShowSeat;
import movie.ticket.platform.domain.type.BookingStatus;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Data
public class Booking {

    private UUID bookingId;
    private UUID userId;
    private Show show;
    private List<ShowSeat> bookedSeats;
    private Payment payment;
    private BookingStatus status;

}
