package org.levelingup.di;

import com.google.inject.AbstractModule;
import org.levelingup.AutomatedTellerMachine;
import org.levelingup.IAutomatedTellerMachine;
import org.levelingup.config.Config;
import org.levelingup.config.IConfig;
import org.levelingup.database.DatabaseConfig;
import org.levelingup.database.IDatabaseConfig;

public class Locator extends AbstractModule {

    @Override
    protected void configure(){
        bind(IAutomatedTellerMachine.class).to(AutomatedTellerMachine.class);
        bind(IConfig.class).to(Config.class);
        bind(IDatabaseConfig.class).to(DatabaseConfig.class);

    }
}
