package in.ac.iiitd.kunal.assignment1;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Hint extends AppCompatActivity {

    private final Context mContext = this;
    private static final String TAG = "HintActivity";
    private static final String HintFlag = "ValueHint";
    private int flag=0;
    private Toast mHint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        if (savedInstanceState != null)
            flag = savedInstanceState.getInt(HintFlag);
        else
            flag=0;

        Button mHint_button=(Button)findViewById(R.id.hint_button);
        mHint_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag=1;
                mHint.makeText(mContext,"A prime number is a whole number greater than 1, whose only two whole-number factors are 1 and itself",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.d(TAG, "Inside OnStart");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Inside OnPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Inside OnResume");

    }

    @Override
    public void onStop() {
        super.onStop();

        Log.d(TAG, "Inside OnSTop");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
        savedInstanceState.putInt(HintFlag,flag);
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onRestoreInstance");

    }




    @Override
    public void onBackPressed() {
        Log.d(TAG, "Inside OnBackPressed");
        Intent returnIntent = new Intent();
        returnIntent.putExtra(HintFlag,flag);
        setResult(Activity.RESULT_OK,returnIntent);
        super.onBackPressed();
    }

}
