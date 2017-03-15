package alvi17.marbleone;


import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by Kadir on 9/8/2016.
 */
public class Util
{
    private final static String TAG="Util";

    public static void saveInfo(Context context, String key, String value )
    {
        try
        {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(key, value).apply();
        }
        catch (Exception ex)
        {
            Log.e(TAG," saveInfo "+ex+"");
        }
    }
    public static String getInfo(Context context, String key)
    {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context).getString(key,"");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }

}
