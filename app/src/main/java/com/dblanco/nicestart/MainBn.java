package com.dblanco.nicestart;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.dblanco.nicestart.main.SectionsPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainBn extends AppCompatActivity {

    private MenuItem prevMenuItem;
    private SectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bn);

        // Inicializar adaptador
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager1 = findViewById(R.id.view_pager);
        viewPager1.setAdapter(sectionsPagerAdapter);

        // Inicializar BottomNavigationView
        BottomNavigationView mybottomNavView = findViewById(R.id.bottom_navigation);

        // Crear badges
        @SuppressLint("RestrictedApi") BottomNavigationMenuView bottomNavigationMenuView =
                (BottomNavigationMenuView) mybottomNavView.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(2);
        @SuppressLint("RestrictedApi") BottomNavigationItemView itemView = (BottomNavigationItemView) v;

        LayoutInflater.from(this)
                .inflate(R.layout.layout_badge, itemView, true);

        // Configurar listener para los elementos del BottomNavigationView
        mybottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.likes) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
               //     removeBadge(mybottomNavView, itemId);
                    viewPager1.setCurrentItem(0);
                } else if (itemId == R.id.add) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Add clicked.", Toast.LENGTH_SHORT).show();
             //       removeBadge(mybottomNavView, itemId);
                    viewPager1.setCurrentItem(1);
                } else if (itemId == R.id.browse) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Browse clicked.", Toast.LENGTH_SHORT).show();
          //          removeBadge(mybottomNavView, itemId);
                    viewPager1.setCurrentItem(2);
                } else if (itemId == R.id.personal) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Personal clicked.", Toast.LENGTH_SHORT).show();
             //       removeBadge(mybottomNavView, itemId);
                    viewPager1.setCurrentItem(3);
                }

                return true;
            }
        });

        // Listener para los cambios de página en el ViewPager
        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                mybottomNavView.getMenu().getItem(position).setChecked(true);
          //      removeBadge(mybottomNavView, mybottomNavView.getMenu().getItem(position).getItemId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    /**
     * Método para eliminar el badge de un elemento del BottomNavigationView.
     *
     * @param bottomNavigationView la vista de navegación inferior
     * @param itemId               el ID del elemento del menú
     */
    //public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
      //  @SuppressLint("RestrictedApi") BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
       // if (itemView != null && itemView.getChildCount() == 3) {
         //   itemView.removeViewAt(2);
        //}
    //}
}
