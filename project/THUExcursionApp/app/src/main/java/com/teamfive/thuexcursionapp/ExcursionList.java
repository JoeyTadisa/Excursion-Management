package com.teamfive.thuexcursionapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ExcursionList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excursion_list);

        String[] excursions = { "Explore Augsburg - 13.11.2021",
                "BMW visit - Ulm - 20.11.2021",
                "Explore Münich - 29.11.2021",
                "Mercedes visit - Stuttgart - 08.12.2021",
                "Explore Mannheim - 12.12.2021",
                "Neuschwanstein - 12.13.2021",
                "Explore Konstanz - 10.04.2022"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.excursion_listview_entry,
                R.id.singleEntryExcursion,
                excursions
        );

        ListView listView = (ListView) findViewById(R.id.excursionListView);
        listView.setAdapter(adapter);

    }
}
