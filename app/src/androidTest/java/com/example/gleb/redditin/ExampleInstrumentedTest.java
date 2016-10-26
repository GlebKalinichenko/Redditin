package com.example.gleb.redditin;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private FrameLayout layoutContainer;

    @Rule
    public final ActivityTestRule<MainActivity> main = new ActivityTestRule<MainActivity>(MainActivity.class, true);

    @BeforeClass
    public void init(){
        layoutContainer = (FrameLayout) main.getActivity().findViewById(R.id.layout_container);
//        fragmentHelper = FragmentHelper.getInstance(main.getActivity());
//        fragment = ListPostFragment.getInstance();
//        fragmentHelper.loadFragment(R.id.layout_container, fragment);
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.gleb.redditin", appContext.getPackageName());
    }

    @Test
    public void useContainer() {
        Assert.assertNotNull(layoutContainer);
    }


}
