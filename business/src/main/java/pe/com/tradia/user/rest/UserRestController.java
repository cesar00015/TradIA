package pe.com.tradia.user.rest;

import lombok.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.tradia.user.User;
import pe.com.tradia.user.service.UserService;

@RestController
@RequestMapping(
        value = "/users",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/{idUser}")
    public UserResponseDto getById(@PathVariable(value = "idUser") Long idUser) {
        User user = this.userService.getById(idUser);
        return UserResponseDto.buildFrom(user);
    }

    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    @Setter
    public static class UserResponseDto {
        private Long id;
        private String username;
        private String displayName;

        public static UserResponseDto buildFrom(final User user) {
            return new UserResponseDto(user.getId(), user.getUsername(), user.getDisplayName());
        }

    }

}
