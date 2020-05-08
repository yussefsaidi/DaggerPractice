package com.yussefsaidi.daggerproject.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.yussefsaidi.daggerproject.R;
import com.yussefsaidi.daggerproject.models.User;
import com.yussefsaidi.daggerproject.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AuthActivity";
    
    private AuthViewModel viewModel;

    private EditText userId;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        userId = findViewById(R.id.user_id_input);
        findViewById(R.id.login_button).setOnClickListener(this);

        viewModel = new ViewModelProvider(this, providerFactory).get(AuthViewModel.class);
        setLogo();
    }

    private void setLogo(){
        requestManager
                .load(logo)
                .into((ImageView)findViewById(R.id.login_logo));
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            
            case R.id.login_button:{
                attemptLogin();
                break;
            }
        }
    }

    private void attemptLogin() {
        if(TextUtils.isEmpty(userId.getText().toString())){
            return;
        }
        viewModel.authenticateWithId(Integer.parseInt(userId.getText().toString()))
                .observe(this, new Observer<User>() {
                    @Override
                    public void onChanged(User user) {
                        if(user != null){
                            Log.d(TAG, "onChanged: " + user.getEmail());
                        }
                    }
                });
    }
}
