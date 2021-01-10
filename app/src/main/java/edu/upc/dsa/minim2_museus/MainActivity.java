package edu.upc.dsa.minim2_museus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import edu.upc.dsa.minim2_museus.models.Element;
import edu.upc.dsa.minim2_museus.models.Museums;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    ApiInterface apiInterface;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        recyclerView = findViewById(R.id.museumView);

        Call<Museums> museumsCall = apiInterface.getMuseums();
        museumsCall.enqueue(new Callback<Museums>() {
            @Override
            public void onResponse(Call<Museums> call, Response<Museums> response) {
                Museums museums = response.body();
                progressBar.setVisibility(View.GONE);
                setMuseumView(museums);
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<Museums> call, Throwable t) {

            }
        });

    }

    public void setMuseumView(Museums museums) {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<Element> input = museums.getElements();
        mAdapter = new RecyclerAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }
}