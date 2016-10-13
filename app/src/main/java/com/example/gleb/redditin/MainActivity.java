package com.example.gleb.redditin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = this.getClass().getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPostFragment();
    }

    private void initPostFragment(){
        BaseFragment fragment = ListPostFragment.getInstance();
        FragmentHelper.loadFragment(R.id.layout_container, fragment, this);
    }
}
