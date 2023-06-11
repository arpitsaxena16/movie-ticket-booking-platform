package movie.ticket.platform.domain.offer;

public class NoonSlotDiscount implements Offer {

    @Override
    public double getDiscountPercent() {
        return isDiscountEligible() ? 20 : 0;
    }

    @Override
    public boolean isDiscountEligible() {
        // Logic to verify the discount
        return true;
    }
}
