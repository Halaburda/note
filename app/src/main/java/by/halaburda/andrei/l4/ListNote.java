package by.halaburda.andrei.l4;

import java.util.ArrayList;

@Deprecated
public class ListNote {
    ArrayList<Note> notes = new ArrayList<>(); // создали список
    private static ListNote instance;

    public ArrayList<Note> getNotes( int statusType) {

      ArrayList<Note> necNotes = new ArrayList<>();  //necessary (нужные, необходимые заметки)
        for(Note note : notes) {
            if ( note.getStatus() == statusType){
                necNotes.add(note);
            }

        }

        return necNotes;
    }



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
