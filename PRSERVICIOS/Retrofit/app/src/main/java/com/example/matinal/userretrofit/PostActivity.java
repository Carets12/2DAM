package com.example.matinal.userretrofit.data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matinal.userretrofit.R;
import com.example.matinal.userretrofit.data.model.User;
import com.example.matinal.userretrofit.data.remote.APIService;
import com.example.matinal.userretrofit.data.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    private TextView mResponseTv;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        final EditText idEt = (EditText) findViewById(R.id.mitextID);
        final EditText firtsNameEt = (EditText) findViewById(R.id.editTextFirtsName);
        final EditText lasNameEt = (EditText) findViewById(R.id.editTextLastName);
        final EditText emailEt =  (EditText) findViewById(R.id.editTextLastName);

        Button btnCrearUsuario = (Button) findViewById(R.id.btnCrearUsuario);
        mResponseTv = (TextView) findViewById(R.id.tv_response);

        mAPIService = ApiUtils.getAPIService();

        btnCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id;
                if(idEt.getText().toString().trim().equals(""))
                    id = 0;
                else

                id               = Integer.parseInt(idEt.getText().toString().trim());
                String firtsName = firtsNameEt.getText().toString().trim();
                String lastName  = lasNameEt.getText().toString().trim();
                String email     = emailEt.getText().toString().trim();

                if(!TextUtils.isEmpty(firtsName) && !TextUtils.isEmpty(lastName)  && !TextUtils.isEmpty(email)) {
                   User user = new User(id, firtsName, lastName, email);
                    Log.i("UI onClick", "user" +user);
                    sendPost(user);
                }
            }
        });
    }

    private void sendPost(final User user){
        mAPIService.savePost(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e("UI sendPost", "post sudmitted to Api" + response.body().toString());
                showResponse(user);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t){
                Log.e("UI sendPost", "error en el servicio");
                Toast.makeText(getApplicationContext(),
                        "Error en el servicio", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showResponse(User user) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(user.toString());
    }

}
