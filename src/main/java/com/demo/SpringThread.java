package com.demo;

import org.springframework.boot.SpringApplication;

public class SpringThread extends Thread{

    private final SetCtx comp;

    public SpringThread(SetCtx comp) {
        this.comp = comp;
    }

    @Override
    public void run() {
        synchronized (comp) {
            comp.setCt(SpringApplication.run(PetApp.class));
        }
    }
}
