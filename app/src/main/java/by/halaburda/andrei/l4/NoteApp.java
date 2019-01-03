package by.halaburda.andrei.l4;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class NoteApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());
        RealmConfiguration realmConfig = CustomRealmConfiguretion.getRealmConfiguration();
        Realm.setDefaultConfiguration(realmConfig);


    }
}
