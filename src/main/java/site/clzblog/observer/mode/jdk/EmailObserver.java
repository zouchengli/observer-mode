package site.clzblog.observer.mode.jdk;

import java.util.Observable;
import java.util.Observer;

public class EmailObserver implements Observer {
    public void update(Observable o, Object arg) {
        System.out.println(String.format("Email %s", arg));
    }
}
