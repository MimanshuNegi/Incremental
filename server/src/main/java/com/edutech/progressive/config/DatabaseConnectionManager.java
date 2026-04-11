package com.edutech.progressive.config;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static final Properties properties = new Properties();

    static{
        loadProperties();
    }
    private static void loadProperties(){
        try (InputStream input = DatabaseConnectionManager.class.getClassLoader().getResourceAsStream("application.properties")){
            if(input != null){
                properties.load(input);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

