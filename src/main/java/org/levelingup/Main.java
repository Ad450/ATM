package org.levelingup;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.levelingup.config.Config;
import org.levelingup.database.DatabaseConfig;
import org.levelingup.di.Locator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Locator());
        final Config config = injector.getInstance(Config.class);
        final DatabaseConfig databaseConfig = injector.getInstance(DatabaseConfig.class);

        config.loadConfigurations();
        //databaseConfig.configure();

        System.out.println("........ Application started ............");
    }
}