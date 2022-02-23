package hu.wup.geobookxchanger.gw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableFeignClients(basePackages = "hu.wup.geobookxchanger.ms.api")
public class GeoBookXChangerGwApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoBookXChangerGwApplication.class, args);
    }

}
