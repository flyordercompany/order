package com.example.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;

public class Register_Activity extends AppCompatActivity
{

    private FrameLayout frameLayout;
    public static boolean onResetPasswordFragment = false;

protected void onCreate(Bundle savedInstancestate)


{

    super.onCreate(savedInstancestate);
    setContentView(R.layout.activity_register);
    frameLayout = findViewById(R.id.register_framelayout);

   setDefaultFragment(new SigninFragment());




}

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

    if (keyCode == KeyEvent.KEYCODE_BACK){
        if (onResetPasswordFragment){
            onResetPasswordFragment = false;
            setFragment(new SigninFragment());

            return false;
        }
    }
        return super.onKeyDown(keyCode, event);


    }


    private void setDefaultFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_form_left,R.anim.slideout_form_right);
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();

    }

}