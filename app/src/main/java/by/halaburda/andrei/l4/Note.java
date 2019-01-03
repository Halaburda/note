package by.halaburda.andrei.l4;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Note extends RealmObject {
    String title; // загаловок
    String description; // описание
    int status;

    @PrimaryKey
    String id;


    public int getStatus() {

        return status;
    }

    public void setStatus(int status) {
        this.status = status;

    }



    public Note(String title, String description, int status) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.id = String.valueOf(UUID.randomUUID());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Note (){}
}
