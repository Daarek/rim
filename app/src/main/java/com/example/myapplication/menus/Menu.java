package com.example.myapplication.menus;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Character;
import com.example.myapplication.MainActivity;
import com.example.myapplication.MapData;
import com.example.myapplication.R;
import com.example.myapplication.Render;
import com.example.myapplication.Setup;
import com.example.myapplication.Tile;

public class Menu {

    MineMenu mineMenu;
    CraftMenu craftMenu;
    BuildMenu buildMenu;
    InventoryMenu inventoryMenu;
    public AlertDialog menu;
    private AlertDialog.Builder menuBuilder;

    private Button inventoryButton;
    private Button mineButton;
    private Button craftButton;
    private Button buildingButton;

    private MapData mapData;
    private Setup setup;
    private Character character;

    public Menu () {
    }

    public void setup () {
        setup = MainActivity.getSetup();
        mapData = setup.getMapData();
        character = setup.getCharacter();

        MineMenu mineMenu = new MineMenu();
        mineMenu.setup();

        CraftMenu craftMenu = new CraftMenu();
        craftMenu.setup();

        BuildMenu buildMenu = new BuildMenu();
        buildMenu.setup();

        InventoryMenu inventoryMenu = new InventoryMenu();
        inventoryMenu.setup();

        menuBuilder = new AlertDialog.Builder(MainActivity.Context());
        LayoutInflater menuInflater = LayoutInflater.from(MainActivity.Context());
        View menuView = menuInflater.inflate(R.layout.menu, null);
        menuBuilder.setView(menuView);
        menu = menuBuilder.create();

        inventoryButton = menuView.findViewById(R.id.inventory);
        mineButton = menuView.findViewById(R.id.mine);
        craftButton = menuView.findViewById(R.id.craft);
        buildingButton = menuView.findViewById(R.id.building);


        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.hide();
                inventoryMenu.alert();
            }
        });
        mineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.hide();
                mineMenu.alert();
            }
        });
        craftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.hide();
                craftMenu.alert();
            }
        });
        buildingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.hide();
                buildMenu.alert();
            }
        });




    }
    public void alert () {
        menu.show();
    }
}

