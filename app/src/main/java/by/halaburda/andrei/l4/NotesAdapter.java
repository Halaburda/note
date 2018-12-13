package by.halaburda.andrei.l4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NoteViewHolder> {


    private ArrayList<Note> notes;

    public NotesAdapter(ArrayList<Note>notes){
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_note,viewGroup, false);

        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int position) {

        Note note = notes.get(position);

        noteViewHolder.tvTittle.setText(note.getTitle());
        noteViewHolder.tvDescription.setText(note.getDescription());


    }

    @Override
    public int getItemCount() {

        return notes.size();
    }
}
