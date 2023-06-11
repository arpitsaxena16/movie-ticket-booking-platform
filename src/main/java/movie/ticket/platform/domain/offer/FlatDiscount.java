package movie.ticket.platform.domain.offer;

public class FlatDiscount implements Offer {

    @Override
    public double getDiscountPercent() {
        return isDiscountEligible() ? 10 : 0;
    }

}
