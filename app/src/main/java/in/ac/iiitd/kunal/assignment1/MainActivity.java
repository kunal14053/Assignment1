package in.ac.iiitd.kunal.assignment1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    /*
    Include Images
    Variable Assignment
    Strings in Values
    Change Icon
    Save Instance Bundle On Back Press;
    */
    private static final String TAG = "QuizActivity";
    private static final String Value = "Value";
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestion;
    private int mPressFlag=0;
    private int mCheckFlag=0;
    private Context mContext=this;
    private int mValue=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestion = (TextView) findViewById(R.id.textViewer);

        if(savedInstanceState==null)
            mValue = GiveNumber.GetNumber();
        else
            mValue=savedInstanceState.getInt(Value);

        mQuestion.setText("Is " + mValue + " A Prime Number");

        mFalseButton = (Button) findViewById(R.id.FalseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked False");
                if(mCheckFlag==0 && !GiveNumber.IsPrime(mValue)) {
                    mCheckFlag = 1;
                    Toast.makeText(mContext,"Correct!",Toast.LENGTH_SHORT).show();
                }
                else {
                    mCheckFlag = 0;
                    Toast.makeText(mContext,"Wrong!",Toast.LENGTH_SHORT).show();
                }

                mPressFlag=1;

            }
        });

        mTrueButton = (Button) findViewById(R.id.TrueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked False");
                if(mCheckFlag==0 && GiveNumber.IsPrime(mValue)) {
                    mCheckFlag = 1;
                    Toast.makeText(mContext,"Correct!",Toast.LENGTH_SHORT).show();
                }
                else {
                    mCheckFlag = 0;
                    Toast.makeText(mContext,"Wrong!",Toast.LENGTH_SHORT).show();
                }
                mPressFlag=1;
            }
        });


        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Clicked Next");
                if(mCheckFlag==1){
                    mValue=GiveNumber.GetNumber();
                    mQuestion.setText("Is"+" "+mValue+" "+"A Prime Number");
                    mPressFlag=0;
                    mCheckFlag=0;
                }
                else if(mPressFlag==1)
                    Toast.makeText(mContext,"Your Answer Is Wrong",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(mContext,"Please Make A Choice",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
        savedInstanceState.putInt(Value,mValue);
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

}
