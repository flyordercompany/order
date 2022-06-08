package com.example.order;

import static com.example.order.Register_Activity.onResetPasswordFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninFragment extends Fragment
{

    private TextView dontHaveAnAccount;
    private FrameLayout parentFrameLayout;

    private EditText email;
    private EditText password;


    private ProgressBar progressBar;

    private TextView forgotpassword;
    private  Button signinBtn;
    private Button skipBtn;

    private FirebaseAuth firebaseAuth;
    private String emailpatten = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_signin, container, false);
        dontHaveAnAccount = view.findViewById(R.id.tv_dont_have_an_account);

        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);

        forgotpassword = view.findViewById(R.id.sing_in_forgotpassword);

        email = view.findViewById(R.id.sign_in_email);
        password = view.findViewById(R.id.sing_in_password);

        skipBtn = view.findViewById(R.id.sign_in_skip_btn);
        signinBtn = view.findViewById(R.id.sign_in_btn);
        progressBar = view.findViewById(R.id.sig_in_progressBar);

        firebaseAuth = FirebaseAuth.getInstance();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dontHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignupFragment());
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onResetPasswordFragment = true;
                setFragment(new ResetPasswordFragment());
            }
        });
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainIntent();
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInputs();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkEmailAndPassword();
            }
        });

    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right,R.anim.slideout_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();

    }
    private void checkInputs() {

        if (!TextUtils.isEmpty(email.getText())){
            if (!TextUtils.isEmpty(password.getText())){
                signinBtn.setEnabled(true);

            }else {
                signinBtn.setEnabled(false);

            }

        }else {
            signinBtn.setEnabled(false);

        }
    }
    private void checkEmailAndPassword(){
        if (email.getText().toString().matches(emailpatten)){
            if (password.length() >= 8){

                progressBar.setVisibility(View.VISIBLE);
                signinBtn.setEnabled(false);

                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()){
                                    mainIntent();

                                }else {

                                    progressBar.setVisibility(View.INVISIBLE);
                                    signinBtn.setEnabled(true);

                                    String error = task.getException().getMessage();
                                    Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }else {
                Toast.makeText(getActivity(),"Incorrect email or Password",Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(getActivity(),"Incorrect email or Password",Toast.LENGTH_SHORT).show();

        }

    }


      private void mainIntent(){
          Intent mainIntent = new Intent(getActivity(),MainActivity.class);
          startActivity(mainIntent);
          getActivity().finish();

      }



}

