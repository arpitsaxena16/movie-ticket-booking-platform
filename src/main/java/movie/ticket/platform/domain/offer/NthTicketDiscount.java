package movie.ticket.platform.domain.offer;

public class NthTicketDiscount implements Offer {

    @Override
    public double getDiscountPercent() {
        return isDiscountEligible() ? 50 : 0;
    }

    @Override
    public boolean isDiscountEligible() {
        // Logic to verify the discount
        return true;
    }
}
