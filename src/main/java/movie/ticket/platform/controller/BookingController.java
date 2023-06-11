package movie.ticket.platform.controller;

import movie.ticket.platform.domain.booking.Booking;
import movie.ticket.platform.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie-bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/theatre/{theatreId}")
    ResponseEntity<Booking> booking(@RequestParam String theatreId, @RequestBody Booking bookingRequest) {
        // TODO: The implementation to save a booking
        return ResponseEntity.of(Optional.of(Booking.builder().build()));
    }

    @PostMapping("/theatre/{theatreId}/bulk")
    ResponseEntity<List<Booking>> booking(@RequestParam String theatreId, @RequestBody List<Booking> bookingRequest) {
        // TODO: The implementation to save multiple bookings
        return ResponseEntity.of(Optional.of(Arrays.asList(Booking.builder().build())));
    }

    @DeleteMapping("/theatre/{theatreId}/booking/{bookingId}")
    ResponseEntity<Void> cancelBooking(@RequestParam String theatreId, @RequestParam String bookingId) {
        // TODO: The implementation of cancelling a booking
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/theatre/{theatreId}")
    ResponseEntity<Void> cancelBookings(@RequestParam String theatreId, @RequestBody List<String> bookingIds) {
        // TODO: The implementation of cancelling multiple bookings
        return ResponseEntity.noContent().build();
    }

}
