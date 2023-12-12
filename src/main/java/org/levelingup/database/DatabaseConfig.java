package org.levelingup.database;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.google.inject.Inject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.levelingup.config.Config;

import java.util.Optional;

public class DatabaseConfig implements IDatabaseConfig{
    public Config config;
    public Optional<MongoDatabase> mongoDatabase;
    @Inject
    public DatabaseConfig(Config config){
       this.config = config;
       this.config.loadConfigurations();

       this.mongoDatabase = configure();
    }
    public Optional<MongoDatabase> configure() {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        final String uri = config.properties.getProperty("DATABASE_URL");
        final String databaseName = config.properties.getProperty("DATABASE_NAME");

        try (MongoClient mongoClient = MongoClients.create(uri)){
            MongoDatabase database = mongoClient.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);
            return Optional.of(database);
        } catch  (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
