package site.clzblog.observer.mode.api;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.clzblog.observer.mode.event.MessageEvent;

@RequestMapping("api/test")
@RestController
public class TestApi {
    private final ApplicationContext context;

    public TestApi(ApplicationContext context) {
        this.context = context;
    }

    @PostMapping("start-send-msg")
    public String startSendMsg(@RequestParam("msg") String msg) {
        MessageEvent messageEvent = new MessageEvent(msg);
        context.publishEvent(messageEvent);
        return "success";
    }
}
