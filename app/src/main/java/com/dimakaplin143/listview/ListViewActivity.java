package com.dimakaplin143.listview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //Toolbar toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();

        SimpleAdapter listContentAdapter = createAdapter(values);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private SimpleAdapter createAdapter(List<Map<String, String>> data) {
        return new SimpleAdapter(this, data, R.layout.simple_adapte_text, new String[] {"title", "sub-title"}, new int[] {R.id.title, R.id.sub_title});
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        List<Map<String, String>> content = new ArrayList<>();
        String[] largeStrings = getString(R.string.large_text).split("\n\n");
        for(String str:largeStrings) {
            Map<String, String> elem = new HashMap<>();
            elem.put("title", str);
            elem.put("sub-title", Integer.toString(str.length()));
            content.add(elem);
        }

        return content;
    }
}