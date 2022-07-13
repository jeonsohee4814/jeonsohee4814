package shjeon.task.banking.user.sdo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shjeon.task.banking.user.domian.User;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRdo {
    private String userId;

    private String name;

    private int age;

    private String createdAt;

    public UserRdo(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.age = user.getAge();
        this.createdAt = user.getCreatedAt();
    }
}
