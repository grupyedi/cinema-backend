package com.grupyedi.webservice.server;

import com.grupyedi.webservice.util.RegexUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ServerConfigManager {
    private final Map<String, String> configMap;
    private final File configFile;

    public ServerConfigManager(String configResource) throws IOException {
        configMap = new HashMap<>();
        configFile = new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource(configResource)).getFile());
        if(configFile == null)
            throw new FileNotFoundException();

        boolean success = constructConfigMap();
        if(!success)
            throw new IOException();
    }

    public int getPortNumber() {
        String value = configMap.get("port");
        if(value == null)
            return -1;

        int port;
        try {
            port = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }

        return port;
    }

    public String getGreetMessage() {
        String value = configMap.get("greet");
        if(value == null)
            return null;

        return value.replace("_", " ");
    }

    public String getUrlMap() {
        String value = configMap.get("url-map");
        if(value == null)
            return null;

        return value.replace("_", " ");
    }

    private boolean constructConfigMap() {
        try {
            Scanner fileScanner = new Scanner(configFile);
            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                line = line.trim();
                String[] tokens = line.split(RegexUtil.whiteSpaceRegex);
                if(tokens.length != 2) {
                    return false;
                }
                String option = tokens[0];
                String value = tokens[1];
                configMap.put(option, value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
