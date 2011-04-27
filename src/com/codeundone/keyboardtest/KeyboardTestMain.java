package com.codeundone.keyboardtest;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class KeyboardTestMain extends Activity {
    /** Called when the activity is first created. */
    @Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    
	    // Programmatic way for 1st solution
//		EditText editText1 = (EditText) findViewById(R.id.my_edit_text1);
//		editText.setRawInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
//		editText.setImeOptions(EditorInfo.IME_ACTION_DONE);
	    
		final EditText editText2 = (EditText) findViewById(R.id.my_edit_text2);
		editText2.addTextChangedListener(new TextWatcher() {
	    	@Override
	    	public void onTextChanged(CharSequence s, int start, int before, int count) {
	    		// hide the keyboard (not functioning properly)
	    		InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
	    		imm.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
	    	}
	    	@Override
	    	public void afterTextChanged(Editable s) {}
	    	@Override
	    	public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
	    });
		
		final EditText editText3 = (EditText) findViewById(R.id.my_edit_text3);
		editText3.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// hide the keyboard (not functioning properly)
				InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(editText3.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
			}
			@Override
			public void afterTextChanged(Editable s) {}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
		});
	}
    
}
