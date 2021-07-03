package com.demo;

import org.springframework.context.ConfigurableApplicationContext;

public class SetCtx {
    private ConfigurableApplicationContext ct;

    public SetCtx() {
    }

    public void setCt(ConfigurableApplicationContext ct1) {
        ct = ct1;
        PetApp.ctx = ct;
        StartFX.starts();
    }
}
