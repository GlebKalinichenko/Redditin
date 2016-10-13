package com.example.gleb.redditin;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/*Class for push and pop fragments to containers*/
public class FragmentHelper {

    /*
    * Load fragment on container
    * @param int containerId            Id container in layout file
    * @param BaseFragment fragment      Fragment that will be push on container by od
    * @param FragmentActivity context   Context of activity
    * */
    public static void loadFragment(int containerId, BaseFragment fragment, FragmentActivity context){
        FragmentManager fm = context.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(containerId, fragment).addToBackStack(null);
        transaction.commit();
    }
}
