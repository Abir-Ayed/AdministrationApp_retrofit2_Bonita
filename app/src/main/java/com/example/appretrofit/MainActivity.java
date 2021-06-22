package com.example.appretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appretrofit.Api.UserService;
import com.example.appretrofit.Model.User;
import com.example.appretrofit.cookies.AddCookiesInterceptor;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextInputEditText username, password;
    TextView btnLogin;
    String userId;
    String TAG;
    Button btnGetID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.edUsername);
        password = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener((view)-> {
            login(
                username.getText().toString(),
                        password.getText().toString()


            );

        });

       // btnGetID.setOnClickListener((view)-> {
       //     GetUserById();
      //  });
    }

    public void login(String username, String password){

        ApiClient api = new ApiClient();
       UserService userService = api.getRetrofit(this).create(UserService.class);
        Map<String, String> map = new HashMap<>();
        map.put("username" , username);
        map.put("password" , password);
        Call<ResponseBody> call= userService.loginUser(map);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "success "+response.code(), Toast.LENGTH_SHORT).show();
                   // GetUserById();
                    Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(i);

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).
                        show();
            }

        });

            }


    }






