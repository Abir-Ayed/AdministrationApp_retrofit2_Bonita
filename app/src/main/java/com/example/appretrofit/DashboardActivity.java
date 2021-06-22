package com.example.appretrofit;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appretrofit.Api.UserService;
import com.example.appretrofit.Model.User;
import com.example.appretrofit.cookies.AddCookiesInterceptor;
import java.util.ArrayList;
import java.util.List;
import com.example.appretrofit.Model.Processus;
public class DashboardActivity extends AppCompatActivity {
    TextView proc1;
    String userId;
    List<Processus> process;
    AdapterDashboard adapter;
    RecyclerView recyclerView;
    Context cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setTitle("Process ");
        Intent intent = getIntent();
        cont= this;
        proc1 = (TextView) findViewById(R.id.proc);
        GetUserById();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //  TextView  unusedId = (TextView)findViewById(R.id.usern);
        //GetProcess();
    }
    private void GetUserById() {
        //  ApiClient apiclient = new ApiClient();
        // UserService userService = apiclient.getRetrofit(this).create(UserService.class);
        OkHttpClient client = new OkHttpClient();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new AddCookiesInterceptor(this)); // VERY VERY IMPORTANT
        client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://digitalisi.tn:8080/bonita/") // REQUIRED
                .client(client) // VERY VERY IMPORTANT
                .addConverterFactory(GsonConverterFactory.create())
                .build(); // REQUIRED
        UserService userService = retrofit.create(UserService.class);
        // get user by id
        Call<User> call1= userService.getUserId();
        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    userId = response.body().getUser_id();
                    Toast.makeText(DashboardActivity.this, "success "+response.code() + " userId= " + userId, Toast.LENGTH_SHORT).show();
                    GetProcess();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(DashboardActivity.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).
                        show();
            }
        });
    }
    private void GetProcess() {
        OkHttpClient client = new OkHttpClient();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new AddCookiesInterceptor(this)); // VERY VERY IMPORTANT
        client = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://digitalisi.tn:8080/bonita/") // REQUIRED
                .client(client) // VERY VERY IMPORTANT
                .addConverterFactory(GsonConverterFactory.create())
                .build(); // REQUIRED
        UserService UserService  = retrofit.create(UserService .class);
        // get user by id
        Call<List<Processus>> listeProc=  UserService.getProcessus("0", "100" , "version%20desc" , "activationState=ENABLED", "user_id=" + userId);
        listeProc.enqueue(new Callback<List<Processus>>() {
            @Override
            public void onResponse(Call<List<Processus>> call, Response<List<Processus>> response) {
                if (response.isSuccessful()) {
                    List<Processus> processus = response.body();
                    String content = "";
                    process=  new ArrayList<>();
                    process=response.body();
                    adapter= new AdapterDashboard(cont,process);
                    recyclerView.setLayoutManager(new LinearLayoutManager(cont));
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(adapter);

                    // content += "Id: " + processus.get(0).getId();
                    content += "Name: " + processus.get(0).getName();
                    // content += "deploymentDate: " + processus.get(0).getDeploymentDate();
                    // content += "last_update_date: " + processus.get(0).getLast_update_date();

                    Toast.makeText(DashboardActivity.this, "process loading "+response.code() + content, Toast.LENGTH_SHORT).show();

                    // proc1.setText(content);
                    // adapter.setListProcess(process);
                    Toast.makeText(DashboardActivity.this, "Bienvenue" , Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(DashboardActivity.this, "failure "+response.code() , Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<Processus>> call, Throwable t) {
                Toast.makeText(DashboardActivity.this,"Throwable ", Toast.LENGTH_LONG).
                        show();
            }

        });
    }
}