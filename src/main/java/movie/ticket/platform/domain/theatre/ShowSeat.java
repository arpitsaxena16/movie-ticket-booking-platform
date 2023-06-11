package movie.ticket.platform.domain.theatre;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import movie.ticket.platform.domain.type.SeatCategory;

@Getter
public class ShowSeat extends Seat {
    private boolean isLocked;
    private double price;

    @Builder
    public ShowSeat(String seatNum, SeatCategory seatCategory, boolean isLocked, double price) {
        super(seatNum, seatCategory);
        this.isLocked = isLocked;
        this.price = price;
    }
}
