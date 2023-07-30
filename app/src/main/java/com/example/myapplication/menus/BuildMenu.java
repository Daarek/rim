package com.example.myapplication.menus;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Character;
import com.example.myapplication.MainActivity;
import com.example.myapplication.MapData;
import com.example.myapplication.R;
import com.example.myapplication.Setup;
import com.example.myapplication.Tile;

public class BuildMenu {
    Character character;
    Setup setup;
    MapData mapData;

    private AlertDialog build;
    private AlertDialog.Builder buildBuilder;

    private Button buildWall;

    public void setup() {
        setup = MainActivity.getSetup();
        character = setup.getCharacter();
        mapData = setup.getMapData();

        buildBuilder = new AlertDialog.Builder(MainActivity.Context());
        LayoutInflater buildInflater = LayoutInflater.from(MainActivity.Context());
        View buildView = buildInflater.inflate(R.layout.building, null);
        buildBuilder.setView(buildView);
        build = buildBuilder.create();

        buildWall = buildView.findViewById(R.id.wall);

        buildWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(MainActivity.Context());
                if (character.inventory.slabs >= 1 && character.inventory.planks >= 2 && character.inventory.strings >= 8){
                    character.inventory.slabs -= 1;
                    character.inventory.planks -= 2;
                    character.inventory.strings -= 8;
                    mapData.floor[mapData.playerPos[0]][mapData.playerPos[1]] = Tile.WALL;
                    toast.setText("Успешно");
                    toast.show();
                } else {
                    toast.setText("Нет ресурсов");
                    toast.show();
                }
            }
        });
    }

    public void alert () {
        build.show();
    }
}
