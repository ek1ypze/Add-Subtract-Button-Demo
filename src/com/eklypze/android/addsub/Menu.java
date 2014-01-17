package com.eklypze.android.addsub;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String menu_items[] = { "MainActivity", "Example1", "Example2",
			"Example3", "Example4", "Example5", "Example6" };

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		String selectedItem = menu_items[position];
		Class ourClass; // defines the class location for the selected item
		try {
			ourClass = Class.forName("com.eklypze.android.addsub." + selectedItem);
			Intent ourIntent = new Intent(this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, menu_items));
	}

}
