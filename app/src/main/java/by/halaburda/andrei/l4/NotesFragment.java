package by.halaburda.andrei.l4;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;


public class NotesFragment extends Fragment {

    private int statusType = Constants.STATUS_DEFAULT;

    List<Note> notes;
    RecyclerView rvNotes;

//    private TextView tvNotes;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_for_notes, container, false);

        initRCV(v);

        update();

//        switch (statusType) {
//            case Constants.STATUS_CURRENT:
//                loadCurrentNotes();
//                break;
//            case Constants.STATUS_EXECUTED:
//                loadExecutedNotes();
//                break;
//            default:
//
//        }


        return v;
    }

    public void update() {
        loadNotes();
        initNotesAdapter();
    }

    private void initNotesAdapter() {
        NotesAdapter adapter = new NotesAdapter(notes);
        rvNotes.setAdapter(adapter);
    }

    private void initRCV(View v) {

        rvNotes = v.findViewById(R.id.rvNotes);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rvNotes.setLayoutManager(llm);

    }

    private void loadNotes() {

        notes = Realm.getDefaultInstance().where(Note.class).equalTo("status",statusType).findAll();
//        notes = ListNote.getInstance().getNotes(statusType);

    }

//    private void loadExecutedNotes() {
//        final ArrayList<Note> notes = ListNote.getInstance().getNotes(statusType);
//
//    }
//
//    private void loadCurrentNotes() {
//
//        final ArrayList<Note> notes = ListNote.getInstance().getNotes(statusType);
//
//
//    }

    public int getStatusType() {
        return statusType;
    }

    public void setStatusType(int statusType) {
        this.statusType = statusType;

    }
}
