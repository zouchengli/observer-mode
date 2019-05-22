package site.clzblog.observer.mode.custom.impl;

import site.clzblog.observer.mode.custom.Observer;

public class UserObserver implements Observer {
    private String name;

    public UserObserver(String name) {
        this.name = name;
    }

    public void send(String msg) {
        System.out.println(String.format("%s,%s", name, msg));
    }
}
