package site.clzblog.observer.mode.custom;

import java.util.ArrayList;
import java.util.List;

public interface AbstractObserver {
    List<Observer> observerList = new ArrayList<Observer>();

    void add(Observer observer);

    void remove(Observer observer);

    void notifyObserverAll(String msg);

    void setMsg(String msg);

    String getMsg();
}
