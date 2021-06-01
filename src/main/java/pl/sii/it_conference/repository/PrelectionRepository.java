package pl.sii.it_conference.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sii.it_conference.entity.Prelection;

@Repository
public interface PrelectionRepository extends JpaRepository<Prelection,Long> {
}
