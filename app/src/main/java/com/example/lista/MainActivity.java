package com.example.lista;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lista.modelo.ApiService;
import com.example.lista.modelo.MyAdapter;
import com.example.lista.modelo.User;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //private static final String BASE_URL = "https://jsonplaceholder.typicode.com/" ;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<String> itemList;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        fetchUsers(apiService);
    }
    private void setupAdapter() {
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the position of the clicked item
                int position = recyclerView.getChildAdapterPosition(v);
                String clickedItem = itemList.get(position);


                // Handle the click event (e.g., show a Toast)
                Log.d("Item Clicked", "You clicked: " + clickedItem);
                // Optionally, you could start another activity or show more details
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("ITEM_DETAIL", clickedItem);
                intent.putExtra("ITEM_NAME",users.get(position).getName());
                intent.putExtra("ITEM_EMAIL",users.get(position).getEmail());
                intent.putExtra("ITEM_PHONE",users.get(position).getPhone());
                //intent.putExtra("ITEM_ADDRESS",users.get(position).getAddress());
                //intent.putExtra("ITEM_COMPANY",users.get(position).getCompany());
                intent.putExtra("ITEM_WEBSITE",users.get(position).getWebsite());

                startActivity(intent);
            }
        };

        myAdapter = new MyAdapter(itemList, clickListener);
        recyclerView.setAdapter(myAdapter);
    }
    private void fetchUsers(ApiService apiService) {
        Call<List<User>> call = apiService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    users = response.body();
                    itemList = new ArrayList<>();
                    for (User user : users) {
                        itemList.add(user.getUserName());
                        Log.d("User Info", "ID: " + user.getId() + ", Name: " + user.getName() + ", User Name: " + user.getUserName() + ", Email: " + user.getEmail());
                    }
                    setupAdapter(); // Call setupAdapter to set the new adapter
                } else {
                    Log.e("Error", "Código de respuesta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("Error", "Error en la llamada a la API: " + t.getMessage());
            }
        });
    }
}