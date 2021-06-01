package pl.sii.it_conference.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prelection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String subjectOfPrelection;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "time_of_prelection_id")
    private TimeOfPrelection timeOfPrelection;

    private Long amountOfUsers;
}
