package site.clzblog.observer.mode.initialize;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import site.clzblog.observer.mode.listener.service.FileListenerService;

@Component
public class ApplicationInitializer implements ApplicationRunner {
    private final FileListenerService fileListenerService;

    public ApplicationInitializer(FileListenerService fileListenerService) {
        this.fileListenerService = fileListenerService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        fileListenerService.startListener();
    }
}
