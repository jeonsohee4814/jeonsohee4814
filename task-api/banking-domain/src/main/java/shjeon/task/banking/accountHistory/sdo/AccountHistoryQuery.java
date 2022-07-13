package shjeon.task.banking.accountHistory.sdo;

import java.util.ArrayList;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shjeon.task.banking.accountHistory.domain.AccountHistory;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountHistoryQuery {
    private ArrayList<String> accountIds = new ArrayList();

    public boolean filter(AccountHistory accountHistory) {
        return contains(accountIds, accountHistory.getAccountId());
    }

    private boolean contains(ArrayList<String> search, String target) {
        return search == null
            || search.isEmpty()
            || search.contains(target);
    }


}
