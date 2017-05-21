package cn.infohuc.infohubandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends Activity {
    private TextView myTextView;
    private EditText myEditView;
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_STRING_USER = "user";
    public static final String EXTRA_STRING_GREETING = "greeting";
    public static final String EXTRA_STRING_DISPLAY = "display";
    private static final String URL = "http://api.icndb.com/jokes/random";
    private TextView jokeView;
    private RestTemplate template = new RestTemplate();

    public AsyncTask<String, Void, String> task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");

        myTextView = (TextView) findViewById(R.id.myTextView);
        myEditView = (EditText) findViewById(R.id.myEditText);
        final Button sayHi = (Button) findViewById(R.id.sayHi);

        sayHi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayHi(v);
            }
        });

        if (savedInstanceState != null) {
            myTextView.setText(savedInstanceState.getString(EXTRA_STRING_GREETING));
        }

        jokeView = (TextView) findViewById(R.id.jokeTextView);
        Button jokeButton = (Button) findViewById(R.id.getJokeButton);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task = new JokeTask().execute();
            }
        });

        template.getMessageConverters().add(new GsonHttpMessageConverter());
        if (savedInstanceState != null) {
            jokeView.setText(savedInstanceState.getString(EXTRA_STRING_DISPLAY));
        }
    }

    public void sayHi(View v){
        String buff = myEditView.getText().toString();
        myTextView.setText(String.format(getString(R.string.hiing), buff));
    }
    public void sayHello(View v){
        Log.d(TAG, "ssyHello");
        Intent newIntent = new Intent(this,Welcome.class);
        String buff = ((EditText)findViewById(R.id.myEditText)).getText().toString();
        newIntent.putExtra(EXTRA_STRING_USER, buff);
        startActivity(newIntent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EXTRA_STRING_GREETING, myTextView.getText().toString());
        outState.putString(EXTRA_STRING_DISPLAY, jokeView.getText().toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        if (task != null) {
            task.cancel(true);
        }
    }

    private class JokeTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            IcndbJoke joke = template.getForObject(URL, IcndbJoke.class);
            return joke.getJoke();
        }

        @Override
        protected void onPostExecute(String s) {
            jokeView.setText(s);
        }
    }
}
