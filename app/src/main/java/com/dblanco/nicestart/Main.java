package com.dblanco.nicestart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Main extends AppCompatActivity {

    private WebView miVisorWeb;
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // casting a la vista a la que aplicamos un menu contextual
        WebView mycontext = (WebView) findViewById(R.id.vistaweb);
        registerForContextMenu(mycontext);

        // Cast al Layout SwipeRefresh
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        // La vista dentro es un webview con permiso para zoom
        miVisorWeb = (WebView) findViewById(R.id.vistaweb);

        WebSettings webSettings = miVisorWeb.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");

        // Doble registro del SwipeRefreshLayout (lo había repetido)
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
    }

    // Método que se llama al hacer clic en el botón del menú
    public void showAlertDialogButtonClicked(Main MainActivity) {

        // setup the alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity);

        builder.setTitle("Achtung!");
        builder.setMessage("Where do you go?");
        builder.setIcon(R.drawable.usericon);
        builder.setCancelable(false);
        builder.setPositiveButton("Scrolling", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(Main.this, Login.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

        // add the buttons

    }

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(Main.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
            toast0.show();
            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1) {
            // showAlertDialogButtonClicked(Main.this);  // Si deseas que el diálogo se muestre cuando se hace clic en este ítem, descomenta esta línea
            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();
        }

        if (id == R.id.item2) {
            Toast toast = Toast.makeText(this, "Fixing", Toast.LENGTH_LONG);
            toast.show();
        }

        if (id == R.id.item5) {
            showAlertDialogButtonClicked(Main.this);
        }

        return super.onOptionsItemSelected(item);
    }

    // Implementando menú contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id = item.getItemId();

        if (id == R.id.item1) {
            Toast toast = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
            toast.show();
            return true;
        }

        if (id == R.id.item2) {
            Toast toast2 = Toast.makeText(this, "Downloading item...", Toast.LENGTH_LONG);
            toast2.show();
            return true;
        }

        return super.onContextItemSelected(item);
    }
}
