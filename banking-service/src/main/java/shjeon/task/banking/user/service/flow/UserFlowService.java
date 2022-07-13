package shjeon.task.banking.user.service.flow;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shjeon.task.banking.user.sdo.UserCdo;
import shjeon.task.banking.user.sdo.UserIdRdo;
import shjeon.task.banking.user.sdo.UserQuery;
import shjeon.task.banking.user.sdo.UserRdoListRdo;
import shjeon.task.banking.user.service.crud.UserService;

@Service
@RequiredArgsConstructor
public class UserFlowService {
    private final UserService userService;

    public UserRdoListRdo findAll(UserQuery query, int offset, int limit) {
        return new UserRdoListRdo(userService.findAll(query, offset, limit), offset + limit);
    }

    public UserIdRdo register(UserCdo userCdo) {
        userService.register(userCdo.toDomain());
        return new UserIdRdo(userCdo.getUserId());
    }
}
