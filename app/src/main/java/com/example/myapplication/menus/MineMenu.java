package com.example.myapplication.menus;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.MapData;
import com.example.myapplication.R;
import com.example.myapplication.Render;
import com.example.myapplication.Setup;
import com.example.myapplication.Tile;
import com.example.myapplication.Character;

public class MineMenu {

    MapData mapData;
    Render render;
    Character character;
    Setup setup;

    private AlertDialog mine;
    private AlertDialog.Builder mineBuilder;

    private Button mCurrent;
    private Button mTop;
    private Button mBottom;
    private Button mRight;
    private Button mLeft;

    public void setup () {
        setup = MainActivity.getSetup();
        mapData = setup.getMapData();
        render = setup.getRender();
        character = setup.getCharacter();

        mineBuilder = new AlertDialog.Builder(MainActivity.Context());
        LayoutInflater mineInflater = LayoutInflater.from(MainActivity.Context());
        View mineView = mineInflater.inflate(R.layout.mine, null);
        mineBuilder.setView(mineView);
        mine = mineBuilder.create();

        mCurrent = mineView.findViewById(R.id.mCurrent);
        mTop = mineView.findViewById(R.id.mTop);
        mBottom = mineView.findViewById(R.id.mDown);
        mRight = mineView.findViewById(R.id.mRight);
        mLeft = mineView.findViewById(R.id.mLeft);

        mCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(MainActivity.Context());
                switch (mapData.floor[mapData.playerPos[0]][mapData.playerPos[1]]){
                    case EMPTY: toast.setText("Тут нечего добыть"); toast.show(); break;
                    case WALL: toast.setText("Тут нечего добыть"); toast.show(); break;
                    case TREE: toast.setText("Дерево + " + mapData.amount[mapData.playerPos[0]][mapData.playerPos[1]]);toast.show(); character.inventory.wood += mapData.amount[mapData.playerPos[0]][mapData.playerPos[1]]; mapData.amount[mapData.playerPos[0]][mapData.playerPos[1]] = 0; mapData.floor[mapData.playerPos[0]][mapData.playerPos[1]] = Tile.EMPTY; break;
                    case STONE: toast.setText("Камень + " + mapData.amount[mapData.playerPos[0]][mapData.playerPos[1]]); toast.show(); character.inventory.stone += mapData.amount[mapData.playerPos[0]][mapData.playerPos[1]]; mapData.amount[mapData.playerPos[0]][mapData.playerPos[1]] = 0; mapData.floor[mapData.playerPos[0]][mapData.playerPos[1]] = Tile.EMPTY; break;
                    case BUSH: toast.setText(" + " + mapData.amount[mapData.playerPos[0]][mapData.playerPos[1]]); toast.show(); character.inventory.berries += mapData.amount[mapData.playerPos[0]][mapData.playerPos[1]]; mapData.amount[mapData.playerPos[0]][mapData.playerPos[1]] = 0; mapData.floor[mapData.playerPos[0]][mapData.playerPos[1]] = Tile.EMPTY; break;
                    case GRASS: toast.setText("Волокно + " + mapData.amount[mapData.playerPos[0]][mapData.playerPos[1]]); toast.show(); character.inventory.thread += mapData.amount[mapData.playerPos[0]][mapData.playerPos[1]]; mapData.amount[mapData.playerPos[0]][mapData.playerPos[1]] = 0; mapData.floor[mapData.playerPos[0]][mapData.playerPos[1]] = Tile.EMPTY; break;
                }
                mine.hide();
            }

        });
        mTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(MainActivity.Context());
                switch (mapData.floor[mapData.playerPos[0]][mapData.playerPos[1] - 1]){
                    case EMPTY: toast.setText("Тут нечего добыть"); toast.show(); break;
                    case WALL: toast.setText("Тут нечего добыть"); toast.show(); break;
                    case TREE: toast.setText("Дерево + " + mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] - 1]); toast.show(); character.inventory.wood += mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] - 1]; mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] - 1] = 0; mapData.floor[mapData.playerPos[0]][mapData.playerPos[1] - 1] = Tile.EMPTY; mapData.type[character.x][character.y - 1] = Tile.EMPTY; break;
                    case STONE: toast.setText("Камень + " + mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] - 1]); toast.show(); character.inventory.stone += mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] - 1]; mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] - 1] = 0; mapData.floor[mapData.playerPos[0]][mapData.playerPos[1] - 1] = Tile.EMPTY; mapData.type[character.x][character.y - 1] = Tile.EMPTY; break;
                    case BUSH: toast.setText(" + " + mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] - 1]); toast.show(); character.inventory.berries += mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] - 1]; mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] - 1] = 0; mapData.floor[mapData.playerPos[0]][mapData.playerPos[1] - 1] = Tile.EMPTY; mapData.type[character.x][character.y - 1] = Tile.EMPTY; break;
                    case GRASS: toast.setText("Волокно + " + mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] - 1]); toast.show(); character.inventory.thread += mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] - 1]; mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] - 1] = 0; mapData.floor[mapData.playerPos[0]][mapData.playerPos[1] - 1] = Tile.EMPTY; mapData.type[character.x][character.y - 1] = Tile.EMPTY; break;
                }
                render.update();
                render.generate(character.x, character.y, setup.colors.player);
                render.finish();
                mine.hide();
            }
        });
        mBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(MainActivity.Context());
                switch (mapData.floor[mapData.playerPos[0]][mapData.playerPos[1] + 1]){
                    case EMPTY: toast.setText("Тут нечего добыть"); toast.show(); break;
                    case WALL: toast.setText("Тут нечего добыть"); toast.show(); break;
                    case TREE: toast.setText("Дерево + " + mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] + 1]); toast.show(); character.inventory.wood += mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] + 1]; mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] + 1] = 0; mapData.floor[mapData.playerPos[0]][mapData.playerPos[1] + 1] = Tile.EMPTY; mapData.type[character.x][character.y + 1] = Tile.EMPTY; break;
                    case STONE: toast.setText("Камень + " + mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] + 1]); toast.show(); character.inventory.stone += mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] + 1]; mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] + 1] = 0; mapData.floor[mapData.playerPos[0]][mapData.playerPos[1] + 1] = Tile.EMPTY; mapData.type[character.x][character.y + 1] = Tile.EMPTY; break;
                    case BUSH: toast.setText(" + " + mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] + 1]); toast.show(); character.inventory.berries += mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] + 1]; mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] + 1] = 0; mapData.floor[mapData.playerPos[0]][mapData.playerPos[1] + 1] = Tile.EMPTY; mapData.type[character.x][character.y + 1] = Tile.EMPTY; break;
                    case GRASS: toast.setText("Волокно + " + mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] + 1]); toast.show(); character.inventory.thread += mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] + 1]; mapData.amount[mapData.playerPos[0]][mapData.playerPos[1] + 1] = 0; mapData.floor[mapData.playerPos[0]][mapData.playerPos[1] + 1] = Tile.EMPTY; mapData.type[character.x][character.y + 1] = Tile.EMPTY; break;
                }

                render.update();
                render.generate(character.x, character.y, setup.colors.player);
                render.finish();
                mine.hide();
            }
        });
        mLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(MainActivity.Context());
                switch (mapData.floor[mapData.playerPos[0] - 1][mapData.playerPos[1]]){
                    case EMPTY: toast.setText("Тут нечего добыть"); toast.show(); break;
                    case WALL: toast.setText("Тут нечего добыть"); toast.show(); break;
                    case TREE: toast.setText("Дерево + " + mapData.amount[mapData.playerPos[0] - 1][mapData.playerPos[1]]); toast.show(); character.inventory.wood += mapData.amount[mapData.playerPos[0] - 1][mapData.playerPos[1]]; mapData.amount[mapData.playerPos[0] - 1][mapData.playerPos[1]] = 0; mapData.floor[mapData.playerPos[0] - 1][mapData.playerPos[1]] = Tile.EMPTY; mapData.type[character.x - 1][character.y] = Tile.EMPTY; break;
                    case STONE: toast.setText("Камень + " + mapData.amount[mapData.playerPos[0] - 1][mapData.playerPos[1]]); toast.show(); character.inventory.stone += mapData.amount[mapData.playerPos[0] - 1][mapData.playerPos[1]]; mapData.amount[mapData.playerPos[0] - 1][mapData.playerPos[1]] = 0; mapData.floor[mapData.playerPos[0] - 1][mapData.playerPos[1]] = Tile.EMPTY; mapData.type[character.x - 1][character.y] = Tile.EMPTY; break;
                    case BUSH: toast.setText(" + " + mapData.amount[mapData.playerPos[0] - 1][mapData.playerPos[1]]); toast.show(); character.inventory.berries += mapData.amount[mapData.playerPos[0] - 1][mapData.playerPos[1]]; mapData.amount[mapData.playerPos[0] - 1][mapData.playerPos[1]] = 0; mapData.floor[mapData.playerPos[0] - 1][mapData.playerPos[1]] = Tile.EMPTY; mapData.type[character.x - 1][character.y] = Tile.EMPTY; break;
                    case GRASS: toast.setText("Волокно + " + mapData.amount[mapData.playerPos[0] - 1][mapData.playerPos[1]]); toast.show(); character.inventory.thread += mapData.amount[mapData.playerPos[0] - 1][mapData.playerPos[1]]; mapData.amount[mapData.playerPos[0] - 1][mapData.playerPos[1]] = 0; mapData.floor[mapData.playerPos[0] - 1][mapData.playerPos[1]] = Tile.EMPTY; mapData.type[character.x - 1][character.y] = Tile.EMPTY; break;
                }

                render.update();
                render.generate(character.x, character.y, setup.colors.player);
                render.finish();
                mine.hide();
            }
        });
        mRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(MainActivity.Context());
                switch (mapData.floor[mapData.playerPos[0] + 1][mapData.playerPos[1]]){
                    case EMPTY: toast.setText("Тут нечего добыть"); toast.show(); break;
                    case WALL: toast.setText("Тут нечего добыть"); toast.show(); break;
                    case TREE: toast.setText("Дерево + " + mapData.amount[mapData.playerPos[0] + 1][mapData.playerPos[1]]); toast.show(); character.inventory.wood += mapData.amount[mapData.playerPos[0] + 1][mapData.playerPos[1]]; mapData.amount[mapData.playerPos[0] + 1][mapData.playerPos[1]] = 0; mapData.floor[mapData.playerPos[0] + 1][mapData.playerPos[1]] = Tile.EMPTY; mapData.type[character.x + 1][character.y] = Tile.EMPTY; break;
                    case STONE: toast.setText("Камень + " + mapData.amount[mapData.playerPos[0] + 1][mapData.playerPos[1]]); toast.show(); character.inventory.stone += mapData.amount[mapData.playerPos[0] + 1][mapData.playerPos[1]]; mapData.amount[mapData.playerPos[0] + 1][mapData.playerPos[1]] = 0; mapData.floor[mapData.playerPos[0] + 1][mapData.playerPos[1]] = Tile.EMPTY; mapData.type[character.x + 1][character.y] = Tile.EMPTY; break;
                    case BUSH: toast.setText(" + " + mapData.amount[mapData.playerPos[0] + 1][mapData.playerPos[1]]); toast.show(); character.inventory.berries += mapData.amount[mapData.playerPos[0] + 1][mapData.playerPos[1]]; mapData.amount[mapData.playerPos[0] + 1][mapData.playerPos[1]] = 0; mapData.floor[mapData.playerPos[0] + 1][mapData.playerPos[1]] = Tile.EMPTY; mapData.type[character.x + 1][character.y] = Tile.EMPTY; break;
                    case GRASS: toast.setText("Волокно + " + mapData.amount[mapData.playerPos[0] + 1][mapData.playerPos[1]]); toast.show(); character.inventory.thread += mapData.amount[mapData.playerPos[0] + 1][mapData.playerPos[1]]; mapData.amount[mapData.playerPos[0] + 1][mapData.playerPos[1]] = 0; mapData.floor[mapData.playerPos[0] + 1][mapData.playerPos[1]] = Tile.EMPTY; mapData.type[character.x + 1][character.y] = Tile.EMPTY; break;
                }

                render.update();
                render.generate(character.x, character.y, setup.colors.player);
                render.finish();
                mine.hide();
            }
        });
    }


    public void alert () {
        mine.show();
    }
}
