package movie.ticket.platform.factory;

import movie.ticket.platform.domain.offer.FlatDiscount;
import movie.ticket.platform.domain.offer.NoonSlotDiscount;
import movie.ticket.platform.domain.offer.NthTicketDiscount;
import movie.ticket.platform.domain.offer.Offer;
import movie.ticket.platform.domain.type.OfferCategory;

public class OfferFactory {

    public Offer getOfferByCategory(OfferCategory category) {
        switch (category) {
            case _3RD_TICKET_DISCOUNT:
                return new NthTicketDiscount();
            case NOON_SLOT_DISCOUNT:
                return new NoonSlotDiscount();
            default:
                return new FlatDiscount();
        }
    }
}
