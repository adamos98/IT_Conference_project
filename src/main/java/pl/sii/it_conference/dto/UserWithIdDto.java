package pl.sii.it_conference.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserWithIdDto {
    private Long id;
    private String login;
    private String email;
}
