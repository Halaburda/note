package by.halaburda.andrei.l4;

import java.util.ArrayList;

public class ListNote {
    ArrayList<Note> notes = new ArrayList<>(); // создали список
    private static ListNote instance;

    public ArrayList<Note> getNotes() {

        return notes;
    }

    public static ListNote getInstance(){
        if(instance == null){
            instance = new ListNote();
        }
        return instance;
    }
    private ListNote() {


    }
}
