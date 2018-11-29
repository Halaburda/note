package by.halaburda.andrei.l4;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;



public class NotesFragment extends Fragment {

    private int statusType = Constants.STATUS_DEFAULT;
    private String strNote;
    private TextView tvNotes;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_for_notes, container, false);
        tvNotes = v.findViewById(R.id.tvNotes);
        switch (statusType) {
            case Constants.STATUS_CURRENT:
                loadCurrentNotes();
                break;
            case Constants.STATUS_EXECUTEO:
                loadExecutedNotes();
                break;
            default:

        }
        tvNotes.setText(strNote);

        return v;
    }

    private void loadExecutedNotes() {
        final ArrayList<Note> notes = ListNote.getInstance().getNotes();
        for (Note note : notes) {
            int status = note.getStatus();
            if (status != Constants.STATUS_CURRENT) {
                continue;
            }
            String title = note.getTitle();
            String description = note.getDescription();
            strNote += (title + " " + description + "\n");

        }
    }

    private void loadCurrentNotes() {

        final ArrayList<Note> notes = ListNote.getInstance().getNotes();
        for (Note note : notes) {
            int status = note.getStatus();
            if (status != Constants.STATUS_EXECUTEO) {
                continue;
            }
            String title = note.getTitle();
            String description = note.getDescription();
            strNote += (title + " " + description + "\n");

        }

    }

    public int getStatusType() {
        return statusType;
    }

    public void setStatusType(int statusType) {
        this.statusType = statusType;

    }
}
