package movie.ticket.platform.domain.common;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Address {

    private String city;
    private String postalCode;
    private String country;
    private String streetAddress;

}
