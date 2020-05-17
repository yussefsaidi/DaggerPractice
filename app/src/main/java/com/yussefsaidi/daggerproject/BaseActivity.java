package com.yussefsaidi.daggerproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.sax.StartElementListener;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.yussefsaidi.daggerproject.models.User;
import com.yussefsaidi.daggerproject.ui.auth.AuthActivity;
import com.yussefsaidi.daggerproject.ui.auth.AuthResource;
import javax.inject.Inject;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Inject
    public SessionManager sessionManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeObservers();
    }

    private void subscribeObservers(){
        sessionManager.getAuthUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if(userAuthResource != null){
                    switch(userAuthResource.status){
                        case LOADING:{
                            break;
                        }
                        case AUTHENTICATED:{
                            Log.d(TAG, "onChanged: LOGIN SUCCESS: " + userAuthResource.data.getEmail());
                            break;
                        }
                        case NOT_AUTHENTICATED:{
                            navLoginScreen();
                            break;
                        }
                        case ERROR:{
                            Log.e(TAG, "onChanged: " + userAuthResource.message);
                            break;
                        }
                    }
                }
            }
        });
    }

    private void navLoginScreen(){
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }

}
