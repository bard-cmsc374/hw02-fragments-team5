package edu.bard.todolist_lab1;
/*
  Most basic Todo List in one activity, no fragments.





CMSC 374
HW #2 Fragments: Feedback

Names: Jack and Eli

      Rubric
----------------------------------------------------------
40	1. App functions correctly from end user perspective.
20	2. Fragments are correctly created.
10	3. Fragments share information on the adapter arraylist.
10	4. Code is clearly commented.
20	5. Code is readable and well constructed.

Score: 50 (each of you get this score)


----------------

Comments

My comments in your code are marked with XX in a comment.

I see only one branch (Jack) that had work on it.  This seems to
implement a ListFragment, which is about 50% of the entire assigment.
You need an item fragment and you need to merge the two and
communicate between them.


1. App functions correctly from end user perspective. YES, resources used, too.

2. Fragments are correctly created. Only one is.

3. Fragments share information on the adapter arraylist. NO

4. Code is clearly commented.
You ignore commenting important methods.  Also leave an unused class
in the code base.

5. Code is readable and well constructed.
Yes...good throughout.





 */
import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;


public class ToDoList extends Activity {
    public static String TAG = "todolab";
    private EditText mEditText; // enter todo item
    private Button mItemButton; // add the item to the list
    private ArrayList<String> tempList; // temp list of items
    private ArrayAdapter<String> tempAa; // temp adapter

    @Override
    public void onCreate(Bundle stuff) {
        super.onCreate(stuff);

        setContentView(R.layout.main); // Extracts resources, autogenerates R.java from XML file

        FragmentManager manager = this.getFragmentManager();
        Fragment fragment1 = manager.findFragmentById(R.id.listFragmentContainer);
        if(fragment1 == null) {
            ListViewFragment fragmentList = new ListViewFragment();
            manager.beginTransaction()
                    .add(R.id.listFragmentContainer, fragmentList)
                    .commit();
        }

        // Get references to UI widgets
        mEditText = (EditText) findViewById(R.id.myEditText);
        mItemButton = (Button) findViewById(R.id.addButton);


        // Add key listener to add the new todo item
        // when the middle D-pad button is pressed.
        mItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ListViewFragment.getToDoItems().add(0, mEditText.getText().toString());
                ListViewFragment.getAa().notifyDataSetChanged();
                mEditText.setText("");
            }
        });

        Log.i(TAG, "Entered onCreate");
    }


    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Entered onStart");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Entered onRestart");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Entered onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Entered onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Entered onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Entered onDestroy");
    }


}


