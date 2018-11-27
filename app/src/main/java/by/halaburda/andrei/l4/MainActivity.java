package by.halaburda.andrei.l4;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

/*    TextView tvNotes;
    TextView textOglavlenie;
    String strNote = new String();
    Button btStCurrent;
    Button btStExecuteo;
    Button btAllList;
    String current = new String();
    String executeo = new String();*/
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        fragmentManager = getSupportFragmentManager();


        addNotes();

        Button btnExecutetNotes = findViewById(R.id.btnCurrentNotes);
        Button btnCurrentNotes = findViewById(R.id.btnExecutetNotes);

        btnCurrentNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Click Current",Toast.LENGTH_LONG).show();

                fragmentManager
                        .beginTransaction()
                        .replace(R.id.flContainer, new NotesFragment(),null)
                        .commit();
            }
        });
        btnExecutetNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Click Executet",Toast.LENGTH_LONG).show();
                Log.i("MY_TAG","Click Executet log");

                fragmentManager
                        .beginTransaction()
                        .replace(R.id.flContainer, new NotesFragment(),null)
                        .commit();
            }
        });

/*        tvNotes = findViewById(R.id.tv_notes);
        textOglavlenie = findViewById(R.id.text_1);
        btStCurrent = findViewById(R.id.button_statusCurrent);
        btStExecuteo = findViewById(R.id.button_statusExecuteo);
        btAllList = findViewById(R.id.button_allList);
        tvNotes.setText("Hello Andrei");
        */




       /* View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_statusExecuteo:
                        for (Note note : notes) {
                            int status = note.getStatus();
                            if (status == Constants.STATUS_EXECUTEO) {
                                executeo += (note.getTitle() + " " + note.getDescription() + "    " + note.getStatus() + "\n");
                                tvNotes.setText(executeo);
                                textOglavlenie.setText(R.string.textOgl2);
                            }
                        }
                        break;
                    case R.id.button_statusCurrent:
                        for (Note note : notes) {
                            int status = note.getStatus();
                            if (status == Constants.STATUS_CURRENT) {
                                current += (note.getTitle() + " " + note.getDescription() + "    " + note.getStatus() + "\n");
                                tvNotes.setText(current);
                                textOglavlenie.setText(R.string.textOgl3);
                            }
                        }
                        break;
                    case R.id.button_allList:
                        for (Note note : notes) {

                            strNote += (note.getTitle() + " " + note.getDescription() + "    " + note.getStatus() + "\n");
                            tvNotes.setText(strNote);
                        }
                        textOglavlenie.setText(R.string.textOgl1);
                        break;

                }
            }
        };
        btStExecuteo.setOnClickListener(onClickListener);
        btStCurrent.setOnClickListener(onClickListener);
        btAllList.setOnClickListener(onClickListener);

*/
    /*    btAllList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Note note: notes){

                    strNote += (note.getTitle() + " " + note.getDescription() + " "+ note.getStatus() +"\n");
                    tvNotes.setText(strNote);

                }
            }
        });

        btStCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Note note: notes){
                    int status = note.getStatus();

                    if(status == Constants.STATUS_CURRENT){
                        current += (note.getTitle() + " " + note.getDescription() + "\n");
                        tvNotes.setText(current);
                    }
                }

            }
        });
        btStExecuteo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Note note: notes){
                    int status = note.getStatus();
                    if(status == Constants.STATUS_EXECUTEO){
                        executeo += (note.getTitle() + " " + note.getDescription() + "\n");
                        tvNotes.setText(executeo);

                    }
                }
            }
        });
       */



        /* for (Note note : notes) {
            int status = note.getStatus();
            if (status != Constants.STATUS_EXECUTEO) {
                continue;
            }
            String title = note.getTitle();
            String description = note.getDescription();
            strNote += (title + " " + description + "\n");

        }


        tvNotes.setText(strNote);
        */

    }
    void addNotes(){
        Note note1 = new Note("Title", "Description", Constants.STATUS_CURRENT);
        Note note2 = new Note("запись1:", "описание1", Constants.STATUS_EXECUTEO);
        Note note3 = new Note("запись2:", "описание2", Constants.STATUS_CURRENT);
        Note note4 = new Note("запись3:", "описание3", Constants.STATUS_EXECUTEO);
        Note note5 = new Note("запись4:", "описание4", Constants.STATUS_CURRENT);
        Note note6 = new Note("запись5:", "описание5", Constants.STATUS_EXECUTEO);
        Note note7 = new Note("запись6:", "описание6", Constants.STATUS_CURRENT);
        Note note8 = new Note("запись7:", "описание7", Constants.STATUS_CURRENT);
        Note note9 = new Note("запись8:", "описание8", Constants.STATUS_EXECUTEO);
        Note note10 = new Note("запись9:", "описание9", Constants.STATUS_CURRENT);

//        String str = note1.getTitle() + " "+ note1.getDescription();
        final ArrayList<Note> notes = ListNote.getInstance().getNotes();
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notes.add(note4);
        notes.add(note5);
        notes.add(note6);
        notes.add(note7);
        notes.add(note8);
        notes.add(note9);
        notes.add(note10);
    }
}
