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
import com.example.myapplication.Render;
import com.example.myapplication.Setup;

public class CraftMenu {

    Character character;
    Setup setup;

    private AlertDialog craft;
    private AlertDialog.Builder craftBuilder;

    private Button craftPlanks;
    private Button craftStrings;
    private Button craftSlabs;

    public void setup() {
        setup = MainActivity.getSetup();
        character = setup.getCharacter();

        craftBuilder = new AlertDialog.Builder(MainActivity.Context());
        LayoutInflater craftInflater = LayoutInflater.from(MainActivity.Context());
        View craftView = craftInflater.inflate(R.layout.craft, null);
        craftBuilder.setView(craftView);
        craft = craftBuilder.create();

        craftPlanks = craftView.findViewById(R.id.planksCraft);
        craftStrings = craftView.findViewById(R.id.stringsCraft);
        craftSlabs = craftView.findViewById(R.id.slabsCraft);

        craftPlanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(MainActivity.Context());
                if (character.inventory.wood >= 2){
                    character.inventory.wood -= 2;
                    character.inventory.planks += 1;
                    toast.setText("Успешно");
                } else {
                    toast.setText("Нет ресурсов");
                }
                toast.show();
            }
        });
        craftStrings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(MainActivity.Context());
                if (character.inventory.thread >= 1){
                    character.inventory.thread -= 1;
                    character.inventory.strings += 1;
                    toast.setText("Успешно");
                } else {
                    toast.setText("Нет ресурсов");
                }
                toast.show();
            }
        });
        craftSlabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(MainActivity.Context());
                if (character.inventory.stone >= 4){
                    character.inventory.stone -= 4;
                    character.inventory.slabs += 1;
                    toast.setText("Успешно");
                } else {
                    toast.setText("Нет ресурсов");
                }
                toast.show();
            }
        });
    }

    public void alert () {
        craft.show();
    }
}
