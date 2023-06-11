package movie.ticket.platform.domain.booking;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public final class Payment {

    private UUID paymentId;
    private double amount;

}
