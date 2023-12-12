package org.levelingup.di;


import io.github.cdimascio.dotenv.Dotenv;
import org.levelingup.AutomatedTellerMachine;
import org.levelingup.IAutomatedTellerMachine;
import org.levelingup.config.Config;
import org.levelingup.config.IConfig;
import org.levelingup.database.DatabaseConfig;
import org.levelingup.database.IDatabaseConfig;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Locator {
    private static Map<String, Object> singletonMap = new HashMap<>();
    private static Map<String, Class<?>> factoryMap = new HashMap<>();



    public static <I, T extends I> void registerFactory(I contract, Class<T> impl) {
        String key = impl.getSimpleName();
        factoryMap.put(key, impl);
    }

    public static  <I, T extends I> void registerSingleton(I contract , Class<T> impl) {
        String key = impl.getSimpleName();
        try {

            if (singletonMap.putIfAbsent(key, impl) == null) {
                singletonMap.put(key, impl.getDeclaredConstructor().newInstance());
            }

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            System.out.println(e);
        }
    }

    public static <I, T extends I> T getFactory(Class<I> contract) {
        try {
            String key = contract.getSimpleName();
            var factory = factoryMap.get(key);
            if (factory != null && contract.isAssignableFrom(factory)) {
                return (T) factory.getDeclaredConstructor().newInstance();
            }
            return null;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            System.out.println(e);
            return null;
        }
    }

    public static <I, T extends I> T getSingleton(Class<I> contract) {
        try {
            String key = contract.getSimpleName();
            var singleton = factoryMap.get(key);
            if (singleton != null && contract.isAssignableFrom(singleton)) {
                return (T) singleton;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

