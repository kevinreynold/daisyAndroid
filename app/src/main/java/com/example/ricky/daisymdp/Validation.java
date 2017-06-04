package com.example.ricky.daisymdp;

/**
 * Created by Kevin on 6/4/2017.
 */

public class Validation {

    public Validation() {

    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
