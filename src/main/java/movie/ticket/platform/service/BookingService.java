package movie.ticket.platform.service;

import movie.ticket.platform.facade.PaymentGatewayService;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private PaymentGatewayService paymentGatewayService;

    public BookingService(PaymentGatewayService paymentGatewayService) {
        this.paymentGatewayService = paymentGatewayService;
    }



    private boolean lockSeat() {
        return true;
    }

    private double getDiscountedPrice() {
        return 0;
    }
}
