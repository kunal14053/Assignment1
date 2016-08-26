package in.ac.iiitd.kunal.assignment1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = "QuizActivity";
    private static final String Value = "Value";
    private static final String Value1 = "Hint";
    private static final String Value2 = "Cheat";
    private static final String Value3 = "Press";
    private static final String Value4 = "Check";
    private TextView mQuestion,mHintText,mCheatText;
    private int mPressFlag = 0;
    private int mCheckFlag = 0;
    private final Context mContext = this;
    private int mValue = 0;
    private Toast mMain;
    private int mFlagcheat=0,mFlaghint=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHintText=(TextView)findViewById(R.id.HintText);
        mCheatText=(TextView)findViewById(R.id.CheatText);
        mQuestion = (TextView) findViewById(R.id.textViewer);

        if (savedInstanceState == null) {
            mValue = GiveNumber.GetNumber();
            mFlagcheat=0;
            mFlaghint=0;
        }
        else {
            mValue = savedInstanceState.getInt(Value);
            mFlagcheat=savedInstanceState.getInt(Value2);
            mFlaghint=savedInstanceState.getInt(Value1);
            mCheckFlag=savedInstanceState.getInt(Value4);
            mPressFlag=savedInstanceState.getInt(Value3);
        }
        String s2="Is " + mValue + " A Prime Number";
        mQuestion.setText(s2);



        Button mFalseButton = (Button) findViewById(R.id.FalseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked False");
                if (!GiveNumber.IsPrime(mValue)) {
                    mCheckFlag = 1;

                    mMain.makeText(mContext, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    mCheckFlag = 0;

                    mMain.makeText(mContext, "Wrong!", Toast.LENGTH_SHORT).show();
                }

                mPressFlag = 1;

            }
        });

        Button mTrueButton = (Button) findViewById(R.id.TrueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked True");
                if (GiveNumber.IsPrime(mValue)) {
                    mCheckFlag=1;

                    mMain.makeText(mContext, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    mCheckFlag = 0;

                    mMain.makeText(mContext, "Wrong!", Toast.LENGTH_SHORT).show();
                }
                mPressFlag = 1;
            }
        });


        Button mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked Next");
                if (mCheckFlag == 1) {
                    mValue = GiveNumber.GetNumber();
                    String s1 = "Is " + mValue + " A Prime Number";
                    mQuestion.setText(s1);
                    mPressFlag = 0;
                    mCheckFlag = 0;
                    mFlaghint=0;
                    mFlagcheat=0;
                    mCheatText.setText("");
                    mHintText.setText("");
                }
                else if (mPressFlag == 1) {
                    mMain.makeText(mContext, "Your Answer Is Wrong", Toast.LENGTH_SHORT).show();
                }
                else {
                    mMain.makeText(mContext, "Please Make A Choice", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button mHintButton=(Button)findViewById(R.id.HintButton);
        mHintButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Hint.class);
                startActivityForResult(i, 1);
            }
        });

        Button mCheatButton=(Button)findViewById(R.id.CheatButton);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Cheat.class);
                i.putExtra(Value,mValue);
                startActivityForResult(i, 1);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
        savedInstanceState.putInt(Value, mValue);
        savedInstanceState.putInt(Value2,mFlagcheat);
        savedInstanceState.putInt(Value1,mFlaghint);
        savedInstanceState.putInt(Value3,mPressFlag);
        savedInstanceState.putInt(Value4,mCheckFlag);
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onRestoreInstance");

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
        if(mFlagcheat==1) {
            mCheatText.setText("You have Cheated");
        }
        if(mFlaghint==1) {
            mHintText.setText("You have taken Hint");
        }

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
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "Inside OnBackPressed");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "Inside onActivityResult");

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                if(mFlaghint!=1)
                    mFlaghint=data.getIntExtra("ValueHint",0);
                if(mFlagcheat!=1)
                    mFlagcheat=data.getIntExtra("ValueCheat",0);
            }
        }
    }


}
