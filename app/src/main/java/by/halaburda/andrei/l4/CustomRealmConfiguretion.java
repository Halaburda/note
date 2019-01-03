package by.halaburda.andrei.l4;

import io.realm.RealmConfiguration;

public class CustomRealmConfiguretion {
    static final int VERSION_1 = 0;

    static RealmConfiguration getRealmConfiguration(){
        return new RealmConfiguration.Builder()
                .schemaVersion(VERSION_1)
                .migration(new MigrationManager())
                .build();
    }

}
