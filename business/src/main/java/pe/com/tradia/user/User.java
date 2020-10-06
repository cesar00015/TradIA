package pe.com.tradia.user;


import lombok.*;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
public class User {

    @NonNull
    private Long id;
    @NonNull
    private String username;
    private String displayName;

}
