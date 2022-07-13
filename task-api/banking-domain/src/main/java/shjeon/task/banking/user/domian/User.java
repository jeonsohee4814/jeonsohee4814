package shjeon.task.banking.user.domian;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class User {
    private String userId;

    private String name;

    private int age;

    private String createdAt;

    public User(String userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.createdAt = getCurrentDate();
    }

    private String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = format.format(date);
        return currentDate;
    }

}
