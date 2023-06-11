package movie.ticket.platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import movie.ticket.platform.domain.common.Address;
import movie.ticket.platform.domain.movie.Movie;
import movie.ticket.platform.domain.theatre.MovieTheatre;
import movie.ticket.platform.domain.theatre.Screen;
import movie.ticket.platform.domain.theatre.Seat;
import movie.ticket.platform.domain.theatre.Show;
import movie.ticket.platform.domain.type.OfferCategory;
import movie.ticket.platform.domain.type.SeatCategory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * Created just to create a dummy data for run
 */
@Configuration
public class SeedingApplicationDataConfiguration {

    @Bean
    public List<MovieTheatre> allTheatres() {

        Show s1 = Show.builder().showId(UUID.randomUUID()).showTime(LocalTime.NOON)
                .startDate(LocalDate.now().minusDays(10))
                .endDate(LocalDate.now().plusDays(10))
                .movie(Movie.builder().movieId(UUID.randomUUID()).movieName("Kal Ho Na Ho").language("Hindi").build())
                .bookedSeatIds(Collections.emptyList())
                .build();

        Show s2 = Show.builder().showId(UUID.randomUUID()).showTime(LocalTime.NOON)
                .startDate(LocalDate.now().minusDays(10))
                .endDate(LocalDate.now().plusDays(10))
                .movie(Movie.builder().movieId(UUID.randomUUID()).movieName("Kal Parson").language("Hindi").build())
                .bookedSeatIds(Collections.emptyList())
                .build();

        MovieTheatre mt1 = MovieTheatre.builder()
                .theatreId(UUID.randomUUID())
                .offers(Arrays.asList(OfferCategory.NOON_SLOT_DISCOUNT))
                .address(Address.builder().city("Pune").country("India").postalCode("111222").build())
                .screen(Arrays.asList(Screen.builder().screenId(UUID.randomUUID())
                        .seats(Arrays.asList(new Seat("A1", SeatCategory.GOLD)))
                        .shows(Arrays.asList(s1)).build()))
                .build();

        MovieTheatre mt2 = MovieTheatre.builder()
                .theatreId(UUID.randomUUID())
                .offers(Arrays.asList(OfferCategory.NOON_SLOT_DISCOUNT))
                .address(Address.builder().city("Pune").country("India").postalCode("111222").build())
                .screen(Arrays.asList(Screen.builder().screenId(UUID.randomUUID())
                        .seats(Arrays.asList(new Seat("A1", SeatCategory.GOLD)))
                        .shows(Arrays.asList(s1)).build()))
                .build();

        MovieTheatre mt3 = MovieTheatre.builder()
                .theatreId(UUID.randomUUID())
                .offers(Arrays.asList(OfferCategory.NOON_SLOT_DISCOUNT))
                .address(Address.builder().city("Pune").country("India").postalCode("111222").build())
                .screen(Arrays.asList(Screen.builder().screenId(UUID.randomUUID())
                        .seats(Arrays.asList(new Seat("A1", SeatCategory.GOLD)))
                        .shows(Arrays.asList(s2)).build()))
                .build();

        System.out.println(Arrays.asList(mt1, mt2, mt3));
        return Arrays.asList(mt1, mt2, mt3);

    }

    @Bean
    @Primary
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }
}
