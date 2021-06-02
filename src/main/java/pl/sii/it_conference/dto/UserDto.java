package pl.sii.it_conference.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class UserDto {
    private String login;
    private String email;
}
