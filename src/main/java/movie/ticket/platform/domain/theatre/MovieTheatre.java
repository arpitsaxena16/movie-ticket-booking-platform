package movie.ticket.platform.domain.theatre;

import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import movie.ticket.platform.domain.common.Address;
import movie.ticket.platform.domain.type.OfferCategory;

@Getter
@Builder
@Setter
@Data
public class MovieTheatre {

    private UUID theatreId;
    private Address address;
    private List<Screen> screen;
    private List<OfferCategory> offers;

}
