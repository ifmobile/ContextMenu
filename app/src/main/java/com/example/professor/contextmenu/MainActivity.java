package com.example.professor.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, ActionMode.Callback {

    private TextView txtContador;
    private boolean actionModeActive;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtContador = (TextView) findViewById(R.id.txtContador);
        txtContador.setText("0");
        txtContador.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View v) {
        if(!actionModeActive) {
            startActionMode(this);
            actionModeActive = true;
        }
        return true;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (item.getItemId() == R.id.act_prox){
            count++;
            txtContador.setText(String.valueOf(count));
            mode.finish();
        } else if (item.getItemId() == R.id.act_ant){
            count--;
            txtContador.setText(String.valueOf(count));
            mode.finish();
        }
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        actionModeActive = false;
    }
}
