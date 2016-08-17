package in.ac.iiitd.kunal.assignment1;


import android.util.Log;
import java.util.ArrayList;


class GiveNumber {
    private static final String TAG = "GiveNumber";
    private static final ArrayList<Integer>sNumbers ;
    private static final int sMAXIMUM=1000;
    private static final int sMINIMUM=1;
    @SuppressWarnings("FieldCanBeLocal")
    private static int sRandomNum;
    private static final ArrayList<Integer>sPrime;

    public static int GetNumber()
    {
        sRandomNum = sMINIMUM + (int)(Math.random() * sMAXIMUM);
        while(sNumbers.contains(sRandomNum))
            sRandomNum = sMINIMUM + (int)(Math.random() * sMAXIMUM);
        sNumbers.add(sRandomNum);
        return sRandomNum;

    }

    static {

        //Need to Implement More Efficient Algorithm
        sPrime=new ArrayList<>();
        sNumbers=new ArrayList<>();
        int i,k,j;
        Log.d(TAG,"I am in Static method");
        for(i=sMINIMUM;i<sMAXIMUM;i++)
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
                sPrime.add(i);
            }
        }
    }

    public static boolean IsPrime(int n)
    {
        return sPrime.contains(n);

    }

}
