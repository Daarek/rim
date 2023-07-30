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
import com.example.myapplication.Setup;
import com.example.myapplication.Tile;

public class InventoryMenu {
    Character character;
    Setup setup;

    private AlertDialog inventory;
    private AlertDialog.Builder inventoryBuilder;

    private TextView amountWood;
    private TextView amountStone;
    private TextView amountThread;
    private TextView amountBerries;
    private TextView amountPlanks;
    private TextView amountStrings;
    private TextView amountSlabs;


    public void setup() {
        setup = MainActivity.getSetup();
        character = setup.getCharacter();

        inventoryBuilder = new AlertDialog.Builder(MainActivity.Context());
        LayoutInflater inventoryInflater = LayoutInflater.from(MainActivity.Context());
        View inventoryView = inventoryInflater.inflate(R.layout.inventory, null);
        inventoryBuilder.setView(inventoryView);
        inventory = inventoryBuilder.create();

        amountWood = inventoryView.findViewById(R.id.amountWood);
        amountStone = inventoryView.findViewById(R.id.amountStone);
        amountThread = inventoryView.findViewById(R.id.amountThread);
        amountBerries = inventoryView.findViewById(R.id.amountBerries);
        amountPlanks = inventoryView.findViewById(R.id.amountPlanks);
        amountStrings = inventoryView.findViewById(R.id.amountStrings);
        amountSlabs = inventoryView.findViewById(R.id.amountSlabs);

    }

    public void alert () {

        /**
         * да чего не работает-то?
         */

        amountWood.setText(character.inventory.wood);
        amountStone.setText(character.inventory.stone);
        amountThread.setText(character.inventory.thread);
        amountBerries.setText(character.inventory.berries);
        amountPlanks.setText(character.inventory.planks);
        amountStrings.setText(character.inventory.strings);
        amountSlabs.setText(character.inventory.slabs);

        inventory.show();
    }
}
