package site.clzblog.observer.mode.custom.impl;

import site.clzblog.observer.mode.custom.AbstractObserver;
import site.clzblog.observer.mode.custom.Observer;

public class WeChatObserver implements AbstractObserver {
    private String msg;

    public void add(Observer observer) {
        observerList.add(observer);
    }

    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObserverAll(String msg) {
        for (Observer observer : observerList) observer.send(msg);
    }

    public void setMsg(String msg) {
        this.msg = msg;
        notifyObserverAll(msg);
    }

    public String getMsg() {
        return msg;
    }
}
