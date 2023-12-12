package org.levelingup.config;

import com.google.inject.Inject;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config implements IConfig{
    public Dotenv dotenv;
    @Inject
    public Config(Dotenv dotenv){
        this.dotenv = dotenv;
    }

    public void loadConfigurations (){
        try {
             dotenv = Dotenv.configure()
                    .directory("../../../assets")
                    .filename("env")
                    .load();
        } catch (Exception e){
            e.printStackTrace();
        }
    }



}
