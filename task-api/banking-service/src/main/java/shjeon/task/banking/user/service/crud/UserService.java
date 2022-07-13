package shjeon.task.banking.user.service.crud;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shjeon.task.banking.user.domian.User;
import shjeon.task.banking.user.exception.UserAlreadyExistsException;
import shjeon.task.banking.user.sdo.UserQuery;
import shjeon.task.banking.user.sdo.UserRdo;
import shjeon.task.banking.user.store.UserStore;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserStore userStore;

    public boolean exists(String userId) {
        return userStore.exists(userId);
    }

    public List<UserRdo> findAll(UserQuery query, int offset, int limit) {
        return userStore.findAll()
            .stream().filter(query::filter)
            .skip(offset)
            .limit(limit)
            .map(UserRdo::new)
            .collect(Collectors.toList());
    }

    @Transactional
    public User register(User user) {
        if (exists(user.getUserId())) {
            throw new UserAlreadyExistsException(user.getUserId());
        }
        userStore.save(user);
        return user;
    }

}
