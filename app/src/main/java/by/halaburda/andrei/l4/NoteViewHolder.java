package by.halaburda.andrei.l4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    TextView tvTittle;
    TextView tvDescription;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTittle = itemView.findViewById(R.id.tvTittle);
        tvDescription = itemView.findViewById(R.id.tvDescription);

    }
}
