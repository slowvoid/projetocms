package cca.dsoo.ufscar.cms.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConfigManager {
    private static ConfigManager _instance;

    private final JSONObject configObj;

    private ConfigManager() throws IOException, ParseException {
        // Read file
        JSONParser parser = new JSONParser();
        InputStream stream = getClass().getClassLoader().getResourceAsStream("config.json");
        if(stream == null) {
            configObj = new JSONObject();
            return;
        }

        InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        configObj = (JSONObject) parser.parse(reader);
    }

    public static ConfigManager getInstance() throws IOException, ParseException {
        if(_instance == null) {
            _instance = new ConfigManager();
        }

        return _instance;
    }

    public String getProperty(String name) {
        return configObj.get(name).toString();
    }

    public Object getPropertyAsObject(String name) {
        return configObj.get(name);
    }
}
