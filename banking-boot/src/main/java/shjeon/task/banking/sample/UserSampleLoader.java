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
import shjeon.task.banking.user.sdo.UserCdo;
import shjeon.task.banking.user.service.flow.UserFlowService;

@Component
@Order(1)
@RequiredArgsConstructor
public class UserSampleLoader implements CommandLineRunner {

    @Autowired
    ResourceLoader resourceLoader;

    private final UserFlowService userFlowService;

    private final int COLUMN_COUNT = 4;

    @Override
    public void run(String[] args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:csv/user.csv");
        if (resource.exists()) {
            InputStream inputStream = resource.getInputStream();
            String row[] = FileCopyUtils.copyToString(new InputStreamReader(inputStream)).split("\n");

            for(int i=1; i<row.length; i++) {
                String userInfo[] = row[i].split(",");
                try {
                    if (userInfo.length >= COLUMN_COUNT) {
                        userFlowService.register(
                            new UserCdo(
                                userInfo[0].trim(),
                                userInfo[1].trim(),
                                Integer.parseInt(userInfo[2].trim())
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
