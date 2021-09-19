package com.br.franchises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.br.franchises.mock.Mock;
import com.br.franchises.recyclerView.FranchiseRecyclerView;

public class MainActivity extends AppCompatActivity {
    private FranchiseRecyclerView franchiseRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_franchise);

        Toolbar toolbar = findViewById(R.id.toolbarFranchise);
        setSupportActionBar(toolbar);

        this.franchiseRecyclerView = new FranchiseRecyclerView(Mock.data());
        RecyclerView cv = this.findViewById(R.id.recyclerViewFranchise);
        cv.setLayoutManager(new LinearLayoutManager(this));
        cv.setAdapter(franchiseRecyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                franchiseRecyclerView.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}