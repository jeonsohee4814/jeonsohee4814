package shjeon.task.banking.account.sdo;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shjeon.task.banking.account.domain.Account;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountQuery {
    private List<String> userIds = new ArrayList();

    public boolean filter(Account account) {
        return contains(userIds, account.getUserId());
    }

    private boolean contains(List<String> search, String target) {
        return search == null
            || search.isEmpty()
            || search.contains(target);
    }


}
