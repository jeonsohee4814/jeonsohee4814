package shjeon.task.banking.user.sdo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shjeon.task.banking.user.domian.User;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCdo {
    @NotBlank
    @Size(min = 3, max = 20)
    private String userId;

    @NotBlank
    @Size(min = 1, max = 20)
    private String name;

    private int age;

    public User toDomain() {
        return new User(
            userId,
            name,
            age
        );
    }
}
