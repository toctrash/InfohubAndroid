package cn.infohuc.infohubandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private EditText myEditText;
    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myTextView = (TextView) findViewById(R.id.myTextView);
//        myEditText = (EditText) findViewById(R.id.myEditText);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button myButton = (Button) findViewById(R.id.myButton);

//        myButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String buff = myEditText.getText().toString();
////                myTextView.setText(buff);
//            }
//        });



    }
    public void sayHello(View v){
        Log.d("myTag", "ssyHello: ssss");
        Intent newIntent = new Intent(this,Welcome.class);
        String buff = ((EditText)findViewById(R.id.myEditText)).getText().toString();
        newIntent.putExtra("name", buff);
        startActivity(newIntent);
    }
}
