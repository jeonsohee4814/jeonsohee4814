package shjeon.task.banking.sample;

import java.io.InputStream;
import java.io.InputStreamReader;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import shjeon.task.banking.account.sdo.AccountCdo;
import shjeon.task.banking.account.service.flow.AccountFlowService;

@Component
@Order(2)
@RequiredArgsConstructor
public class AccountSampleLoader implements CommandLineRunner {

    @Autowired
    ResourceLoader resourceLoader;

    private final AccountFlowService accountFlowService;

    private final int COLUMN_COUNT = 2;

    @Override
    public void run(String[] args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:csv/account.csv");
        if (resource.exists()) {
            InputStream inputStream = resource.getInputStream();
            String row[] = FileCopyUtils.copyToString(new InputStreamReader(inputStream)).split("\n");

            for(int i=1; i<row.length; i++) {
                String accountInfo[] = row[i].split(",");
                try {
                    if (accountInfo.length >= COLUMN_COUNT) {
                        accountFlowService.register(
                            new AccountCdo(
                                accountInfo[0].trim(),
                                accountInfo[1].trim()
                            )
                        );
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    }
}
