package com.example.order;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordFragment extends Fragment {



    public ResetPasswordFragment() {
        // Required empty public constructor
    }

    private EditText registeredEmail;
    private Button restartBtn;
    private TextView goBack;
    private FrameLayout parentFrameLayout;
    private FirebaseAuth firebaseAuth;

    private ViewGroup emailIconContainer;
    private ImageView emailIcon;
    private TextView emailIconText;
    private ProgressBar progressBar;

    private ImageView emailGreenIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view = inflater.inflate(R.layout.fragment_reset_password, container, false);

       registeredEmail = view.findViewById(R.id.forgot_password_email);
       restartBtn = view.findViewById(R.id.reset_btn);
       goBack = view.findViewById(R.id.forgot_password_go_back);
        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);

        emailIconContainer = view.findViewById(R.id.forgot_password_email_icon_container);
        emailGreenIcon = view.findViewById(R.id.forgot_password_Greenemail_icon);
        emailIcon = view.findViewById(R.id.forgot_password_redemail_icon);
        emailIconText = view.findViewById(R.id.forgot_password_Greenemail_text);
        progressBar = view.findViewById(R.id.forgot_password_progressbar);

        firebaseAuth = FirebaseAuth.getInstance();


       return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registeredEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkInput();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TransitionManager.beginDelayedTransition(emailIconContainer);
                emailIconText.setVisibility(View.GONE);

                TransitionManager.beginDelayedTransition(emailIconContainer);
                emailIcon.setVisibility(view.VISIBLE);
                progressBar.setVisibility(view.VISIBLE);
                restartBtn.setEnabled(false);

                firebaseAuth.sendPasswordResetEmail(registeredEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){

                                    Toast.makeText(getActivity(),"email sent successfully ",Toast.LENGTH_LONG).show();
                                    emailIcon.setVisibility(view.GONE);

                                   emailGreenIcon.setVisibility(view.VISIBLE);



                                }else {
                                    String error = task.getException().getMessage();

                                    restartBtn.setEnabled(true);
                                    emailGreenIcon.setVisibility(view.GONE);
                                    emailIconText.setText(error);
                                    emailIconText.setTextColor(getResources().getColor(R.color.btnRed));
                                    TransitionManager.beginDelayedTransition(emailIconContainer);
                                    emailIconText.setVisibility(view.VISIBLE);


                                }
                                progressBar.setVisibility(view.GONE);


                            }
                        });
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new SigninFragment());
            }
        });

    }
    private void checkInput(){
        if (TextUtils.isEmpty(registeredEmail.getText())){

            restartBtn.setEnabled(false);

        }else {
            restartBtn.setEnabled(true);
        }

    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_form_left,R.anim.slideout_form_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();

    }



}