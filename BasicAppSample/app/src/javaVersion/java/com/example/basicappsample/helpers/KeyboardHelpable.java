package com.example.basicappsample.helpers;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public interface KeyboardHelpable {
    default void hideKeyboard(Activity activity) {
        final View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            final InputMethodManager inputMethodManager =
                    (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }
}
