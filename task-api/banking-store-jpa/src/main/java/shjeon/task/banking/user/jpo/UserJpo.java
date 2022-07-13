package shjeon.task.banking.user.jpo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shjeon.task.banking.user.domian.User;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJpo {
    @Id
    @Column(length = 80)
    private String userId;

    @Column(length = 128)
    private String name;

    @Column(length = 128)
    private int age;

    private String createdAt;

    public UserJpo(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.age = user.getAge();
        this.createdAt = user.getCreatedAt();
    }

    public User toDomain() {
        return new User(userId, name, age, createdAt);
    }
}
