package shjeon.task.banking.account.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import shjeon.task.banking.account.jpo.AccountJpo;

@Transactional
public interface AccountRepository extends CrudRepository<AccountJpo, String> {

}
