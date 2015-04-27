package inei.asistencia;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import inei.asistencia.utils.DrawerItem;
import inei.asistencia.fragments.BusquedaFragment;
import inei.asistencia.fragments.ListadoFragment;
import inei.asistencia.fragments.RegistroFragment;
import inei.asistencia.fragments.ReporteFragment;


public class MainActivity extends Activity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerToogle;
    private RelativeLayout relativeLayout;
    private CharSequence charSequenceDrawerTitle;
    private CharSequence charSequenceTitle;

    private String[] menuTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TypedArray menuIcons;
        ArrayList<DrawerItem> drawerItems;
        DrawerListAdapter adapter;
        charSequenceTitle = charSequenceDrawerTitle = getTitle();

        //Carga los titulos del menu del navdrawer
        menuTitles = getResources().getStringArray(R.array.menu_titles);

        // Carga los iconos del navdrawer
        menuIcons = getResources().obtainTypedArray(R.array.menu_icons);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        relativeLayout = (RelativeLayout)findViewById(R.id.layout_relative);
        listView = (ListView) findViewById(R.id.list_slidermenu);

        drawerItems = new ArrayList<DrawerItem>();
        drawerItems.add(new DrawerItem(menuTitles[0], menuIcons.getResourceId(0, -1)));
        drawerItems.add(new DrawerItem(menuTitles[1], menuIcons.getResourceId(1, -1)));
        drawerItems.add(new DrawerItem(menuTitles[2], menuIcons.getResourceId(2, -1)));
        drawerItems.add(new DrawerItem(menuTitles[3], menuIcons.getResourceId(3, -1)));

        menuIcons.recycle();
        adapter = new DrawerListAdapter(getApplicationContext(), drawerItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new MenuClickListener());
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        drawerToogle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close ){
            @Override
            public void onDrawerClosed(View drawerView) {
                getActionBar().setTitle(charSequenceTitle);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(charSequenceDrawerTitle);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawerToogle);
        if (savedInstanceState == null){
            displayView(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (drawerToogle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MenuClickListener implements ListView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            displayView(position);
        }
    }

    private void displayView(int position){
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment;
        switch (position) {

            case 1:
                fragment = new RegistroFragment();
                break;
            case 2:
                fragment = new ListadoFragment();
                break;
            case 3:
                fragment = new ReporteFragment();
                break;
            case 4:
                fragment = new BusquedaFragment();
                break;
            default:
                fragment = new RegistroFragment();
                break;
        }
        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
        listView.setItemChecked(position, true);
        listView.setSelection(position);
        setTitle(menuTitles[position]);
        drawerLayout.closeDrawer(relativeLayout);
    }

    @Override
    public void setTitle(CharSequence title) {
        charSequenceTitle = title;
        getActionBar().setTitle(charSequenceTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToogle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToogle.onConfigurationChanged(newConfig);
    }
}
