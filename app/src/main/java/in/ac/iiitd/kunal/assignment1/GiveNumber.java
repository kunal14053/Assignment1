package in.ac.iiitd.kunal.assignment1;


import android.util.Log;
import java.util.ArrayList;


/**
 * Created by KunalSaini on 13-Aug-16.
 */



public class GiveNumber {
    private static final String TAG = "GiveNumber";
    private static ArrayList<Integer>Numbers ;
    private static final int MAXIMUM=1000;
    private static final int MINIMUM=1;
    private static int randomNum;
    private static ArrayList<Integer>Prime;

    public static int GetNumber()
    {
        randomNum = MINIMUM + (int)(Math.random() * MAXIMUM);
        while(Numbers.contains(randomNum))
            randomNum = MINIMUM + (int)(Math.random() * MAXIMUM);
        Numbers.add(randomNum);
        return randomNum;

    }

    static {

        //Need to Implement More Efficient Algorithm
        Prime=new ArrayList<Integer>();
        Numbers=new ArrayList<Integer>();
        int i,k,j;
        Log.d(TAG,"I am in Static method");
        for(i=MINIMUM;i<MAXIMUM;i++)
        {
            k=0;
            for(j=2;j<i;j++)
            {
                if(i%j==0)
                {
                    k=1;
                    break;
                }
            }
            if(k==0)
            {
                Prime.add(i);
            }
        }
    }

    public static boolean IsPrime(int n)
    {
        if(Prime.contains(n))
            return  true;
        else
            return false;
    }

}
