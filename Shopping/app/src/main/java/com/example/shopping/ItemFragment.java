package com.example.shopping;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.shopping.ShoppingManager.Shopping;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;


import static com.example.shopping.MainActivity.manager;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ItemFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    private ListView listView;
    private ArrayAdapter<String> listViewAdapter;
    private ShoppingManager.Shopping currentItem;

    ShoppingDbHelper shoppingDbHelper = null;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ItemFragment newInstance(int columnCount) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        shoppingDbHelper = new ShoppingDbHelper(getActivity());
        final SQLiteDatabase db = shoppingDbHelper.getReadableDatabase();
        Cursor res = shoppingDbHelper.getAllItems(db);

        listView = (ListView) view.findViewById(R.id.listViewItems);
        final ArrayList list = ShoppingManager.ITEMS;

        if(res.getCount() == 0) {

            listViewAdapter = new ArrayAdapter<String>(
                    getActivity(),
                    android.R.layout.simple_expandable_list_item_1,
                    list
            );
        } else {

            if(list.isEmpty()) {

                ShoppingManager.Shopping item;

                while (res.moveToNext()) {
                    String i = res.getString(res.getColumnIndexOrThrow(
                            ShoppingStatement.Queries.COLUMN_NAME_ID));
                    String w = res.getString(res.getColumnIndexOrThrow(
                            ShoppingStatement.Queries.COLUMN_NAME_SHOPPING_ITEM));
                    item = ShoppingManager.createElement(i, w);
                }

            }

            listViewAdapter = new ArrayAdapter<String>(
                    getActivity(),
                    android.R.layout.simple_expandable_list_item_1,
                    list
            );
        }
        res.close();

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String index = ShoppingManager.ITEMS.get(i).id;

                Log.d("ItemFragment", " > listView.setOnItemClickListener itemId: " + index + " - " + list.get(i).toString());

                ShoppingManager.Shopping shopping = new ShoppingManager.Shopping(index, list.get(i).toString());

                mListener.onListFragmentInteraction(shopping);
                manager.beginTransaction().replace(R.id.container, new DetailsItemFragment(), null).commit();

            }
        });


        FloatingActionButton fabAddItem = view.findViewById(R.id.fabAddItem);
        fabAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                manager.beginTransaction().replace(R.id.container, new AddItemFragment(), null ).commit();
            }
        });

        return view;
    }

    public ShoppingManager.Shopping  getItem(){
        return currentItem;
    }

    public void updateView(Shopping item) {

        Log.d("ItemFragment", " > updateView Shopping item: " + item);

    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("ItemFragment", " > onResume");

         }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }




    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Shopping item);

    }
}
