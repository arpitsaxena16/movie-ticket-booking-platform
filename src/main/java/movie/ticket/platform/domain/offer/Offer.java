package movie.ticket.platform.domain.offer;

public interface Offer {

    double getDiscountPercent();

    default boolean isDiscountEligible() {
        return true;
    }
}
