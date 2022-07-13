package shjeon.task.banking.user.sdo;

import java.util.ArrayList;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shjeon.task.banking.user.domian.User;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserQuery {
    private ArrayList<String> userIds = new ArrayList();

    public boolean filter(User user) {
        return contains(userIds, user.getUserId());
    }

    private boolean contains(ArrayList<String> search, String target) {
        return search == null
            || search.isEmpty()
            || search.contains(target);
    }


}
