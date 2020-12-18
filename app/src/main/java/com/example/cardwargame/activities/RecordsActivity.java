package com.example.cardwargame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.cardwargame.fragments.Fragment_Map;
import com.example.cardwargame.utilities.GameManager;
import com.example.cardwargame.R;
import com.example.cardwargame.fragments.Fragment_List;

public class RecordsActivity extends AppCompatActivity {
    private FrameLayout list;
    private FrameLayout map;
    private Fragment_List fragment_list;
    private Fragment_Map fragment_map;

    public RecordsActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        GameManager manager = new GameManager(this);
        initViews();

        manager.enterFullScreen(this);
        fragment_list = new Fragment_List();
        Intent intent = this.getIntent();
        String winnerName = intent.getStringExtra("winnerName");
        int winnerScore = intent.getIntExtra("winnerScore", 0);

        Bundle bundle = new Bundle();
        bundle.putString("winnerName", winnerName);
        bundle.putInt("winnerScore", winnerScore);
        fragment_list.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.records_LAY_list, fragment_list).commit();


        //todo: finish ma
        fragment_map = new Fragment_Map();
        getSupportFragmentManager().beginTransaction().add(R.id.records_LAY_map,fragment_map).commit();


    }

    private void initViews() {
        list = findViewById(R.id.records_LAY_list);
        map = findViewById(R.id.records_LAY_map);
    }
}