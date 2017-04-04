package com.bigmacdev.pharmacy_app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bigmacdev.pharmacy_app.dummy.DummyContent;
import com.bigmacdev.pharmacy_app.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class PerscriptionFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PerscriptionFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PerscriptionFragment newInstance(int columnCount) {
        PerscriptionFragment fragment = new PerscriptionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    private ArrayList<Perscription> perscriptions = new ArrayList<Perscription>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        perscriptions.add(new Perscription("Doe", "John", "SomeDrug", "Smith", "12-03-2016", "123456", "90", 10));
        perscriptions.add(new Perscription("Smith", "Will", "SomeOtherDrug", "Man", "04-03-2016", "123456", "30", 20));
        perscriptions.add(new Perscription("Jordan", "Hal", "GreekNamedDrug", "Boyz", "01-25-2016", "123456", "60", 15));
        perscriptions.add(new Perscription("Stark", "Tony", "LatinNamedDrug", "Smyth", "03-03-2016", "123456", "30", 5));
        perscriptions.add(new Perscription("Queen", "Oliver", "Asprin", "Roy", "02-03-2016", "123456", "60", 12));
        perscriptions.add(new Perscription("Snark", "Leonard", "CoolDrug", "Williamson", "01-03-2016", "123456", "90", 13));

        new Thread(){
            @Override
            public void run() {
                //Todo: get new perscriptions
                while(perscriptions.size()>0){
                    for (int i=0; i<perscriptions.size(); i++){
                        perscriptions.get(i).updateTimeDue();
                    }
                    try {
                        sleep(30000);
                    }catch(Exception e){}
                }
            }
        }.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perscription_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyPerscriptionRecyclerViewAdapter(perscriptions, mListener));
        }
        return view;
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
        void onListFragmentInteraction(Perscription item);

    }
}
