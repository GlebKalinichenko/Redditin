package com.example.gleb.redditin;

import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/*Class for push and pop fragments to containers*/
public class FragmentHelper {
    private static FragmentHelper instance = null;
    private FragmentActivity context;

    public static FragmentHelper getInstance(FragmentActivity context) {
        if (instance == null){
            instance = new FragmentHelper(context);
        }
        return instance;
    }

    private FragmentHelper(FragmentActivity context) {
        this.context = context;
    }

    /*
    * Load fragment on container
    * @param int containerId            Id container in layout file
    * @param BaseFragment fragment      Fragment that will be push on container by id
    */
    public void loadFragment(int containerId, BaseFragment fragment){
        FragmentManager fm = context.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(containerId, fragment).addToBackStack(null);
        transaction.commit();
    }

    /*
    * Replace fragment on container
    * @param int containerId                  Id container in layout file
    * @param PreferenceFragment fragment      Preference fragment that will be push on container by id
    * */
    public void replaceFragment(int containerId, PreferenceFragment fragment){
        android.app.FragmentManager fm = context.getFragmentManager();
        android.app.FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(containerId, fragment).addToBackStack(null);
        transaction.commit();
    }

    /*
    * Replace fragment on container
    * @param int containerId                  Id container in layout file
    * @param PreferenceFragment fragment      Preference fragment that will be push on container by id
    * */
    public void replaceFragment(int containerId, BaseFragment fragment){
        FragmentManager fm = context.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(containerId, fragment).addToBackStack(null);
        transaction.commit();
    }
}
