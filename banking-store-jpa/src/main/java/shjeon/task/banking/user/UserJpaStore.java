package shjeon.task.banking.user;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shjeon.task.banking.user.domian.User;
import shjeon.task.banking.user.jpo.UserJpo;
import shjeon.task.banking.user.repository.UserRepository;
import shjeon.task.banking.user.store.UserStore;

@Repository
@RequiredArgsConstructor
public class UserJpaStore implements UserStore {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return StreamSupport.stream(this.userRepository.findAll().spliterator(), false)
            .map(UserJpo::toDomain)
            .collect(Collectors.toList());
    }

    public boolean exists(String userId) {
        return userRepository.existsById(userId);
    }

    public void save(shjeon.task.banking.user.domian.User user) {
        userRepository.save(new UserJpo(user));
    }
}
