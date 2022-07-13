package shjeon.task.banking.user.controller;

import java.util.ArrayList;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shjeon.task.banking.user.sdo.UserCdo;
import shjeon.task.banking.user.sdo.UserIdRdo;
import shjeon.task.banking.user.sdo.UserQuery;
import shjeon.task.banking.user.sdo.UserRdoListRdo;
import shjeon.task.banking.user.service.flow.UserFlowService;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserFlowService userFlowService;

    @PostMapping
    public UserIdRdo register(@Valid @RequestBody UserCdo userCdo) {
        return userFlowService.register(userCdo);
    }

    @GetMapping
    public UserRdoListRdo findAll(
        @RequestParam(defaultValue = "0", required = false) int offset,
        @RequestParam(defaultValue = "30", required = false) int limit,
        @RequestParam(defaultValue = "", required = false) ArrayList<String> userIds
    ) {
        return userFlowService.findAll(new UserQuery(userIds), offset, limit);
    }

}
