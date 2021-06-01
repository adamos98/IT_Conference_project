package pl.sii.it_conference.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sii.it_conference.entity.Reservation;

import java.util.List;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    List<Reservation> findAllByUser_Login(String login);

}
