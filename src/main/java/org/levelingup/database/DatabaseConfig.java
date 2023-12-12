package org.levelingup.database;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.github.shyiko.dotenv.guice.DotEnvValue;
import com.google.inject.Inject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.levelingup.config.Config;

import java.util.Optional;

public class DatabaseConfig implements IDatabaseConfig {
    public Optional<MongoDatabase> mongoDatabase;
    public String databaseURL;
    public String databaseName;

    public void setDatabaseName(Optional<String> databaseName) {
        this.databaseName = databaseName.orElse("");
    }

    public void setDatabaseURL(Optional<String> databaseURL) {
        this.databaseURL = databaseURL.orElse("");
    }

    @Inject
    public DatabaseConfig() {
        this.mongoDatabase = configure();

    }

    public Optional<MongoDatabase> configure() {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        if(databaseURL == null || databaseName == null){
            System.out.println("The database url is "+ databaseURL);
            System.out.println("The database url is "+ databaseName);
        }

        try (MongoClient mongoClient = MongoClients.create(databaseURL)) {
            MongoDatabase database = mongoClient.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);
            return Optional.of(database);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
