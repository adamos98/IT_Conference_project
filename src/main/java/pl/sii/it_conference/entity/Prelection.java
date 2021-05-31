package pl.sii.it_conference.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prelection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectOfPrelection;

    @ManyToOne
    @JoinColumn(name = "time_of_prelection_id")
    private TimeOfPrelection timeOfPrelection;
}
