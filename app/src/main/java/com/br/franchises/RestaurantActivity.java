package com.br.franchises;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.br.franchises.model.VO.RestaurantVO;
import com.br.franchises.recyclerView.RestaurantRecyclerView;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Toolbar toolbar = findViewById(R.id.toolbarRestaurant);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<RestaurantVO> restaurants = (ArrayList<RestaurantVO>) getIntent().getSerializableExtra("restaurants");

        RestaurantRecyclerView restaurantRecyclerView = new RestaurantRecyclerView(restaurants);
        RecyclerView cv = this.findViewById(R.id.recyclerViewRestaurant);
        cv.setLayoutManager(new LinearLayoutManager(this));
        cv.setAdapter(restaurantRecyclerView);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

        finish();

        return true;
    }
}
