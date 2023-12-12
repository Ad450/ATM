package org.levelingup.database;

import com.mongodb.client.MongoDatabase;

import java.util.Optional;

public interface IDatabaseConfig {
    public Optional<MongoDatabase> configure();
}
