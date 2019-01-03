package by.halaburda.andrei.l4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabs;
    Button btnSettings;
    Button btnPlus;

    NotesFragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);



        btnSettings = findViewById(R.id.btnSettings);
        btnPlus = findViewById(R.id.btnPlus);
        initViewPager();
        initTabs();



        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentFragment == null){
                    return;
                }
                AddNoteDialog dialog = new AddNoteDialog(currentFragment);
                dialog.showDialog();
            }
        });


    }


        private void initViewPager(){
            viewPager = findViewById(R.id.viewPager);
            currentFragment = new NotesFragment();
            NotesFragment executedFragment = new NotesFragment();

            currentFragment.setStatusType(Constants.STATUS_CURRENT);
            executedFragment.setStatusType(Constants.STATUS_EXECUTED);

            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(currentFragment, "current");
            adapter.addFragment(executedFragment, "executed");
            viewPager.setAdapter(adapter);
        }


        private void initTabs(){
            tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);
            tabs.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

            for ( int i = 0; i < tabs.getTabCount(); i++){
                TabLayout.Tab currentTab = tabs.getTabAt(i);
                if(currentTab != null){
                    currentTab.setCustomView(R.layout.custom_view_tab);
                    View customView = currentTab.getCustomView();
                    if ( customView != null){
                        TextView tabTextView = customView.findViewById(R.id.tabTextView);
                        ImageView tabImageView = customView.findViewById(R.id.tabImageView);
                        switch (i){
                            case Constants.CURRENT_TAB:
                                tabTextView.setText(getString(R.string.current));
                                tabImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.options));
                                break;
                                case Constants.EXECUTED_TAB:
                                tabTextView.setText(getString(R.string.executet));
                                tabImageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.uzor));
                                break;
                        }
                    }
                }
            }

            tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                // вкладка выбрана
                public void onTabSelected(TabLayout.Tab tab) {
                    int currentTab = viewPager.getCurrentItem();
                    if (currentTab == Constants.CURRENT_TAB){
                        btnPlus.setVisibility(View.VISIBLE);
                    }else {
                        btnPlus.setVisibility(View.GONE);
                    }

                    View customView = tab.getCustomView();
                    if ( customView != null){
                        TextView tabTextView = customView.findViewById(R.id.tabTextView);
                        if (tabTextView != null){
                            tabTextView.setTextSize(14);
                        }
                    }
                }

                @Override
                // вкладка не выбрана
                public void onTabUnselected(TabLayout.Tab tab) {
                    View customView = tab.getCustomView();
                    if ( customView != null){
                        TextView tabTextView = customView.findViewById(R.id.tabTextView);
                        if (tabTextView != null){
                            tabTextView.setTextSize(10);
                        }
                    }
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
            viewPager.setCurrentItem(Constants.CURRENT_TAB);

        }





    class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> fragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
        private void addFragment(Fragment fragment,String title){
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }
    }
}




/* void addNotes() {
        Note note1 = new Note("Title", "Description", Constants.STATUS_CURRENT);
        Note note2 = new Note("запись1:", "описание1", Constants.STATUS_EXECUTED);
        Note note3 = new Note("запись2:", "описание2", Constants.STATUS_CURRENT);
        Note note4 = new Note("запись3:", "описание3", Constants.STATUS_EXECUTED);
        Note note5 = new Note("запись4:", "описание4", Constants.STATUS_CURRENT);
        Note note6 = new Note("запись5:", "описание5", Constants.STATUS_EXECUTED);
        Note note7 = new Note("запись6:", "описание6", Constants.STATUS_CURRENT);
        Note note8 = new Note("запись7:", "описание7", Constants.STATUS_CURRENT);
        Note note9 = new Note("запись8:", "описание8", Constants.STATUS_EXECUTED);
        Note note10 = new Note("запись9:", "описание9", Constants.STATUS_CURRENT);

//        String str = note1.getTitle() + " "+ note1.getDescription();
        ArrayList<Note> notes = ListNote.getInstance().getNotes();
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
    }*/


/*    TextView tvNotes;
        TextView textOglavlenie;
        String strNote = new String();
        Button btStCurrent;
        Button btStExecuteo;
        Button btAllList;
        String current = new String();
        String executeo = new String();*/

 /*fragmentManager   //код для добавления фрагмента
                        .beginTransaction()
                        .replace(R.id.flContainer, fragment, null)
                        .commit();*/

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
                            if (status == Constants.STATUS_EXECUTED) {
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
                    if(status == Constants.STATUS_EXECUTED){
                        executeo += (note.getTitle() + " " + note.getDescription() + "\n");
                        tvNotes.setText(executeo);

                    }
                }
            }
        });
       */



        /* for (Note note : notes) {
            int status = note.getStatus();
            if (status != Constants.STATUS_EXECUTED) {
                continue;
            }
            String title = note.getTitle();
            String description = note.getDescription();
            strNote += (title + " " + description + "\n");

        }


        tvNotes.setText(strNote);
        */