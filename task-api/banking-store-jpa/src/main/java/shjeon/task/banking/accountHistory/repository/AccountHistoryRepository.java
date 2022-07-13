package shjeon.task.banking.accountHistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import shjeon.task.banking.accountHistory.jpo.AccountHistoryJpo;
import shjeon.task.banking.balance.sdo.AccountBalance;
import shjeon.task.banking.balance.sdo.Balance;

@Transactional
public interface AccountHistoryRepository extends CrudRepository<AccountHistoryJpo, String> {
    @Query("select new shjeon.task.banking.balance.sdo.AccountBalance(accountHistory.accountId, sum(accountHistory.amount), (" +
        "select sum(amount) " +
        "from AccountHistoryJpo " +
        "where accountId=accountHistory.accountId " +
        "and division = shjeon.task.banking.accountHistory.domain.enumtype.Division.N)) " +
        "from AccountHistoryJpo as accountHistory " +
        "where accountHistory.accountId in :accountIds " +
        "and accountHistory.division = shjeon.task.banking.accountHistory.domain.enumtype.Division.Y " +
        "group by accountHistory.accountId "
    )
    List<AccountBalance> findBalanceByAccountId(@Param("accountIds") List<String> accountIds);

    @Query("select new shjeon.task.banking.balance.sdo.Balance(sum(accountHistory.amount), (" +
        "select sum(amount) " +
        "from AccountHistoryJpo " +
        "where SUBSTRING(createdAt, 1, 4) = :year " +
        "and division = shjeon.task.banking.accountHistory.domain.enumtype.Division.N)) " +
        "from AccountHistoryJpo as accountHistory " +
        "where SUBSTRING(accountHistory.createdAt, 1, 4) = :year " +
        "and accountHistory.division = shjeon.task.banking.accountHistory.domain.enumtype.Division.Y "
    )
    Balance findTotalBalancePerYear(@Param("year") String year);
}
