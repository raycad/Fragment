package com.seedotech.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class ToDoListActivity extends FragmentActivity implements NewItemFragment.OnNewItemAddedListener {
	private ArrayList<String> mTodoItems;
	private ArrayAdapter<String> mArrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);
        
        //Get references to Fragments
        FragmentManager fm = getSupportFragmentManager();
        ToDoListFragment todoListFragment = (ToDoListFragment)fm.findFragmentById(R.id.TodoListFragment);
        
        mTodoItems = new ArrayList<String>();
        
        mArrayAdapter = new ArrayAdapter<String>(this, 
        		android.R.layout.simple_list_item_1,
        		mTodoItems);
        
        todoListFragment.setListAdapter(mArrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_view, menu);
        return true;
    }
    
	public void onNewItemAdded(String newItem) {
		mTodoItems.add(newItem);
		mArrayAdapter.notifyDataSetChanged();
	}
}
