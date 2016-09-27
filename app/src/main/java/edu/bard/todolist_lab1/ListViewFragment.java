package edu.bard.todolist_lab1;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

/**
 * Created by wolfk_000 on 9/23/2016.
 */
public class ListViewFragment extends Fragment {
    private static ArrayList<String> mToDoItems; // list of items
    private static ArrayAdapter<String> aa; // adapter from list to viewlist
    private ListView mListView;


    @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
        // Creation of the ArrayList and ArrayAdapter
        mToDoItems = new ArrayList<String>();
        aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mToDoItems);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_list, parent,false);
        mListView = (ListView) v.findViewById(R.id.myListView);
        mListView.setAdapter(aa);
        return v;
    }

    public void setAa(ArrayAdapter<String> aa) {
        this.aa = aa;
    }
    public void setToDoItems(ArrayList<String> toDoItems) {
        mToDoItems = toDoItems;
    }
    public static ArrayAdapter<String> getAa() {
        return aa;
    }
    public static ArrayList<String> getToDoItems() {
        return mToDoItems;
    }

}
