package com.grupyedi.webservice.server;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import io.javalin.Javalin;

public class Server {
    private static final Server instance = new Server();
    private Javalin app;
    private boolean running = false;

    private Server() {}

    public static Server getInstance() {
        return instance;
    }

    public boolean start(int portNumber, String greet, String urlMap) {
        if(!running) {
            app = Javalin.create().start(portNumber);
            app.get("/", ctx -> ctx.html(Constants.GREET_HTML));

            running = true;
        }

        return running;
    }

    public boolean stop() {
        if(running) {
            app.stop();
            return true;
        }

        return false;
    }

    public boolean getStatus() {
        return running;
    }

    public Javalin getApp() {
        return app;
    }
}
