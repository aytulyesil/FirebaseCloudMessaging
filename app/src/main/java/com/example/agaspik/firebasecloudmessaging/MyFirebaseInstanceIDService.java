package com.example.agaspik.firebasecloudmessaging;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by agaspik on 15.12.2016.
 */


public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {

        //token_id alma
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //token_id görüntüleme
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        //calling the method store token and passing token
        storeToken(refreshedToken);
    }

    private void storeToken(String token) {
        // token_id paylaşılan cihazlara kaydedilir.
        SharedPrefManager.getInstance(getApplicationContext()).saveDeviceToken(token);

    }
}
