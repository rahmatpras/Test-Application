package com.simamat.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.simamat.testapplication.adapter.GithubAdapter;
import com.simamat.testapplication.helper.ServiceGenerator;
import com.simamat.testapplication.model.GithubUser;
import com.simamat.testapplication.service.GithubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_user_git);

        //panggil Interface
        GithubService githubService = ServiceGenerator.build().create(GithubService.class);
        //panggil retunrnnya GithubService
        Call<List<GithubUser>> callAsync = githubService.getUsers(10,1);

        callAsync.enqueue(new Callback<List<GithubUser>>() {
            @Override
            public void onResponse(Call<List<GithubUser>> call, Response<List<GithubUser>> response) {
                List<GithubUser> results = response.body();

                //panggil adapter
                GithubAdapter adapter = new GithubAdapter(getApplicationContext(),0, results);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<GithubUser>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
