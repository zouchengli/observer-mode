package site.clzblog.observer.mode.event;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MessageEvent(Object source) {
        super(source);
    }
}
