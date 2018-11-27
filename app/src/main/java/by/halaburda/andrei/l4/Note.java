package by.halaburda.andrei.l4;

public class Note {
    String title; // загаловок
    String description; // описание
    int status;


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
