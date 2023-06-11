package movie.ticket.platform.domain.user;

import lombok.Builder;
import lombok.Getter;
import movie.ticket.platform.domain.common.Address;
import movie.ticket.platform.domain.type.UserCategory;

@Getter
@Builder
public class User {
    private String id;
    private String name;
    private Address address;
    private UserCategory userCategory;
}
