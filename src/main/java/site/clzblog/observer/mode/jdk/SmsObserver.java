package site.clzblog.observer.mode.jdk;

import java.util.Observable;
import java.util.Observer;

public class SmsObserver implements Observer {
    public void update(Observable o, Object arg) {
        System.out.println(String.format("Sms %s", arg));
    }
}
