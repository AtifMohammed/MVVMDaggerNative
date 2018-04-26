package android.util;

/**
 * @author atif
 * Created on 26/04/18.
 */
public final class Log{

    public static int d(String TAG, String message){
        System.out.println(TAG + " : "+message);
        return 0;
    }

}