package com.dblanco.nicestart;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainBab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bab);

        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);
        FloatingActionButton myfab = findViewById(R.id.fab);

        // Click event for the FAB (Floating Action Button)
        myfab.setOnClickListener(view -> {
            // You can add more actions here if needed
            Toast.makeText(MainBab.this, "FAB Clicked", Toast.LENGTH_SHORT).show();
        });

        // Click event for the Hamburguer Menu
        bottomAppBar.setNavigationOnClickListener(view -> {
            // Handle navigation drawer opening or other actions
            Toast.makeText(MainBab.this, "Menu clicked", Toast.LENGTH_SHORT).show();
        });

        // Click event for the BottomBar menu items
        bottomAppBar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.heart) {
                Toast.makeText(MainBab.this, "Favorites clicked", Toast.LENGTH_SHORT).show();
            }
            if (item.getItemId() == R.id.search) {
                Toast.makeText(MainBab.this, "Search clicked", Toast.LENGTH_SHORT).show();
            }
            return true;
        });
    }
}
