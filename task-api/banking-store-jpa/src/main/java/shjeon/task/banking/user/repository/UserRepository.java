package shjeon.task.banking.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import shjeon.task.banking.user.jpo.UserJpo;

@Transactional
public interface UserRepository extends CrudRepository<UserJpo, String> {

}
