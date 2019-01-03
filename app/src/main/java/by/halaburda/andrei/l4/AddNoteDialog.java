package by.halaburda.andrei.l4;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;


public class AddNoteDialog {

    Realm realm;
    String title;
    String description;
    NotesFragment fragment;

    private Context context;

    public AddNoteDialog(NotesFragment notesFragment) {
       this.context = notesFragment.getContext();
       this.fragment = notesFragment;
       realm = Realm.getDefaultInstance();


    }

    public void showDialog(){

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_note);


        EditText edtTitle = dialog.findViewById(R.id.edtTitle);
        EditText edtDescription = dialog.findViewById(R.id.edtDescription);

        Button btnOk = dialog.findViewById(R.id.btnOk);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(description)){

                    saveNote();
                    fragment.update();
                    dialog.dismiss();
                }else {

                    Toast.makeText(context,"Не корректные данные",Toast.LENGTH_LONG).show();

                }


            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });


        edtTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                title = String.valueOf(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                description = String.valueOf(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        dialog.show();
    }

    private void saveNote() {

       final Note note = new Note(title,description, Constants.STATUS_CURRENT);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(@NonNull Realm realm) {
                realm.copyToRealmOrUpdate(note);
            }
        });

       /* ArrayList<Note> notes = ListNote.getInstance().getNotes();
        Note note = new Note(title,description, Constants.STATUS_CURRENT);
        notes.add(note);*/
    }
}
