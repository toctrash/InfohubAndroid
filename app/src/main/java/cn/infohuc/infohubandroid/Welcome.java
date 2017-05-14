package cn.infohuc.infohubandroid;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class Welcome extends AppCompatActivity {
    private static final String TAG = Welcome.class.getSimpleName();
    private TextView greetingText;
    private DatabaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        String name = getIntent().getStringExtra(MainActivity.EXTRA_STRING_USER);
        Log.d(TAG, "onCreate: "+name);
        greetingText = (TextView) findViewById(R.id.welTextView);
        greetingText.setText(String.format(getString(R.string.greeting), name));

        adapter = new DatabaseAdapter(this);
        adapter.open();
        if (!adapter.exists(name)) {
            adapter.insertName(name);
        }

        final List<String> names = adapter.getAllNames();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        ListView listView = (ListView) findViewById(R.id.list_view);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "item at " + position + " clicked ");
                greetingText.setText(String.format(getString(R.string.greeting), names.get(position)));
            }
        });

    }
}
