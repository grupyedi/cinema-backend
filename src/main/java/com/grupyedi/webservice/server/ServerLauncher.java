package com.grupyedi.webservice.server;

import com.grupyedi.webservice.util.RegexUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ServerLauncher {
    private final Server server;
    private final ServerConfigManager serverConfigManager;

    public ServerLauncher() throws IOException {
        server = Server.getInstance();
        serverConfigManager = new ServerConfigManager(Constants.CONFIG_LOCATION);

        int portNumber = serverConfigManager.getPortNumber();
        String greet = serverConfigManager.getGreetMessage();
        String urlMap = serverConfigManager.getUrlMap();
        boolean result = server.start(portNumber, greet, urlMap);

        if(!result)
            throw new IOException();
    }

    public Server getServer() {
        return server;
    }
}
