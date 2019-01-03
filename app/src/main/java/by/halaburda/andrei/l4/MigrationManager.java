package by.halaburda.andrei.l4;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

public class MigrationManager implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();

        RealmObjectSchema note = schema.get(Constants.NOTE);

        switch ((int) oldVersion) {
            case CustomRealmConfiguretion.VERSION_1:
                note = upgradeNoteInfo(schema, note);
        }

    }

    private RealmObjectSchema upgradeNoteInfo(RealmSchema schema, RealmObjectSchema note) {
        if (note == null) {
            note = schema.create(Constants.NOTE)
                    .addField("title", String.class)
                    .addField("description", String.class)
                    .addField("status", Integer.class)
                    .addField("id", String.class);
        } else {
            if (!note.hasField("title")) {
                note = schema.create(Constants.NOTE)
                        .addField("title", String.class);
            }
            if (!note.hasField("description")) {
                note = schema.create(Constants.NOTE)
                        .addField("description", String.class);
            }
            if (!note.hasField("status")) {
                note = schema.create(Constants.NOTE)
                        .addField("status", Integer.class);
            }
            if (!note.hasField("id")) {
                note = schema.create(Constants.NOTE)
                        .addField("id", String.class);

            }
        }
        return note;
    }
}
