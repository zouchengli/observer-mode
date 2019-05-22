package site.clzblog.observer.mode.listener.msg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import site.clzblog.observer.mode.event.MessageEvent;

@Slf4j
@Component
public class EmailListener implements ApplicationListener<MessageEvent> {
    @Override
    @Async
    public void onApplicationEvent(MessageEvent event) {
        log.info("Email {}", event.getSource());
    }
}
