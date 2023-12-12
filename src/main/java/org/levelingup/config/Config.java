package org.levelingup.config;

import com.google.inject.Inject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config implements IConfig{
    public Properties properties;
    @Inject
    public Config(Properties properties){
        this.properties = properties;
    }

    public void loadConfigurations (){
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")){
            if(input == null){
                System.out.println("Ooops, could not load properties");
                return;
            }

            properties.load(input);
        } catch (IOException e){
            e.printStackTrace();
        }
    }



}
