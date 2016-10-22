package com.example.gleb.redditin;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;

public class CommentsBottomSheetCallback extends BottomSheetBehavior.BottomSheetCallback {
    private View view;

    public CommentsBottomSheetCallback(View view) {
        this.view = view;
    }

    @Override
    public void onStateChanged(@NonNull View bottomSheet, int newState) {

    }

    @Override
    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        view.animate().scaleX(1 - slideOffset).scaleY(1 - slideOffset).setDuration(0).start();
    }
}
