package com.seedotech.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class NewItemFragment extends Fragment {
	public interface OnNewItemAddedListener {
		public void onNewItemAdded(String newItem);
	}

	private OnNewItemAddedListener mItemAddedListener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View view =  inflater.inflate(R.layout.new_item_fragment, container, false);

		final EditText editText = (EditText)view.findViewById(R.id.edit_text);

		editText.setOnKeyListener(new View.OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(event.getAction() == KeyEvent.ACTION_DOWN){
					if(keyCode == KeyEvent.KEYCODE_ENTER){
						String newItem = editText.getText().toString();
						mItemAddedListener.onNewItemAdded(newItem);
						editText.setText("");
						return true;
					}
					return false;
				}
				return false;
			}
		});

		return view;
	}

	@Override
	public void onAttach(Activity a){
		super.onAttach(a);
		try {
			mItemAddedListener = (OnNewItemAddedListener) a;
		} catch (ClassCastException e) {
			throw new ClassCastException(a.toString() + 
					" must implement OnNewItemAddedListener");
		}
	}
}
