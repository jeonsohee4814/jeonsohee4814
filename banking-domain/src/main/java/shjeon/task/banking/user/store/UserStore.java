package shjeon.task.banking.user.store;

import java.util.List;

import shjeon.task.banking.user.domian.User;

public interface UserStore {
    List<User> findAll();

    boolean exists(String userId);

    void save(User user);
}
