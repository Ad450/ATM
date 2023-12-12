package org.levelingup;


import com.github.shyiko.dotenv.guice.DotEnvModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.github.cdimascio.dotenv.Dotenv;
import org.levelingup.config.Config;
import org.levelingup.database.DatabaseConfig;
import org.levelingup.database.IDatabaseConfig;
import org.levelingup.di.Locator;

import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        Locator.registerSingleton(IDatabaseConfig.class, DatabaseConfig.class);
        DatabaseConfig db  = Locator.getSingleton(IDatabaseConfig.class);

        db.setDatabaseName(Optional.ofNullable(dotenv.get("DB-NAME")));
        db.setDatabaseURL(Optional.ofNullable(dotenv.get("DB-URL")));

        System.out.println(".......App started successfully.......");

    }
}