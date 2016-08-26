package in.ac.iiitd.kunal.assignment1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Cheat extends AppCompatActivity {

    private final Context mContext = this;
    private static final String TAG = "CheatActivity";
    private static final String CheatFlag = "ValueCheat";
    private int flag=0;
    private Toast mCheat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        if (savedInstanceState != null)
            flag = savedInstanceState.getInt(CheatFlag);
        else
            flag=0;

        Button mCheat_button=(Button)findViewById(R.id.cheat_button);
        mCheat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag=1;
                int number=getIntent().getIntExtra("Value",-1);
                if(number!=-1)
                {
                    if(GiveNumber.IsPrime(number))
                    {
                        mCheat.makeText(mContext,"True! Yes It Is Prime",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(mContext,"False! No It Is Not Prime",Toast.LENGTH_SHORT).show();
                    }
                }
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
        savedInstanceState.putInt(CheatFlag,flag);
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
        returnIntent.putExtra(CheatFlag,flag);
        setResult(Activity.RESULT_OK,returnIntent);
        super.onBackPressed();
    }
}
