package com.example.lanea07outlookcom.shoppingmallswizarddemo;

import android.content.Intent;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Restaurants extends AppCompatActivity {

    String[] itemname ={
            "Il Forno",
            "Burger King",
            "Crepes & Waffles",
            "El Garaje",
            "Frisby",
            "McDonalds",
            "Presto",
            "Jenos Pizza"
    };

    int[] imgid={
            R.mipmap.pic1,
            R.mipmap.pic2,
            R.mipmap.pic3,
            R.mipmap.pic4,
            R.mipmap.pic5,
            R.mipmap.pic6,
            R.mipmap.pic7,
            R.mipmap.pic8,
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        //final String[] opciones = { "Opción 1", "Opción 2", "Opción 3", "Opción 4" };
        ListView listView = (ListView) findViewById(R.id.lvwRestaurants);
        final DrawerLayout drawLayout = (DrawerLayout) findViewById(R.id.draw_layout);

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        listView = (ListView)findViewById(R.id.lvwRestaurants);
        listView.setAdapter(adapter);

        /*listView.setAdapter(new ArrayAdapter<String>(
                this, R.layout.mylist,
                R.id.Itemname,itemname));*/

        /*listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                opciones));*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(Restaurants.this, "Item: " + itemname[arg2],
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Restaurants.this,RestsDetail.class);
                intent.putExtra("Tienda", itemname[arg2]);
                intent.putExtra("Logo", imgid);
                intent.putExtra("Position", arg2);


                startActivity(intent);
                drawLayout.closeDrawers();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        ListView listView = (ListView) findViewById(R.id.lvwRestaurants);
        DrawerLayout drawLayout = (DrawerLayout) findViewById(R.id.draw_layout);
        switch (item.getItemId()) {
            case android.R.id.home:
                if (drawLayout.isDrawerOpen(listView)) {
                    drawLayout.closeDrawers();
                } else {
                    drawLayout.openDrawer(listView);
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
