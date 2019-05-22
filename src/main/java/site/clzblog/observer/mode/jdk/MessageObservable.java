package site.clzblog.observer.mode.jdk;

import java.util.Observable;

public class MessageObservable extends Observable {
    @Override
    public void notifyObservers(Object arg) {
        setChanged();
        super.notifyObservers(arg);
    }
}
