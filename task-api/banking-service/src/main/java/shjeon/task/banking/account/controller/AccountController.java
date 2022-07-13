package shjeon.task.banking.account.controller;

import java.util.ArrayList;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shjeon.task.banking.account.sdo.AccountCdo;
import shjeon.task.banking.account.sdo.AccountIdRdo;
import shjeon.task.banking.account.sdo.AccountQuery;
import shjeon.task.banking.account.sdo.AccountRdoListRdo;
import shjeon.task.banking.account.service.flow.AccountFlowService;

@RestController
@RequiredArgsConstructor
@RequestMapping("accounts")
public class AccountController {
    private final AccountFlowService accountFlowService;

    @PostMapping
    public AccountIdRdo register(@Valid @RequestBody AccountCdo accountCdo) {
        return accountFlowService.register(accountCdo);
    }

    @GetMapping
    public AccountRdoListRdo findAll(
        @RequestParam(defaultValue = "0", required = false) int offset,
        @RequestParam(defaultValue = "30", required = false) int limit,
        @RequestParam(defaultValue = "", required = false) ArrayList<String> userIds
    ) {
        return accountFlowService.findAll(new AccountQuery(userIds), offset, limit);
    }

}
