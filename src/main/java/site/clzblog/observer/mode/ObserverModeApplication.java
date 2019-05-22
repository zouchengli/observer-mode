package site.clzblog.observer.mode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ObserverModeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ObserverModeApplication.class, args);
    }
}
