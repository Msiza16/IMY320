package com.project.imy320.spaceboy;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TaskListFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TaskListFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskListFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Fragment fragment;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TaskListFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static TaskListFrag newInstance(String param1, String param2) {
        TaskListFrag fragment = new TaskListFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TaskListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




      /**  if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //This is here for testing only.
        Date d = new Date();
        SBTask task = new SBTask("Buy Lunch","Go to Pie City and buy lunch", "LunchID",13,30,00);
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_task_list, container, false);
        ListView tasklist = (ListView)v.findViewById(R.id.listView);

       final ArrayList<SBTask> tk = new ArrayList<SBTask>();
        d.addTask(task);

        ArrayAdapter<SBTask> arrayAdapter = new ArrayAdapter<SBTask>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1 , tk);
        tasklist.setAdapter(arrayAdapter);

        tasklist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {

                SBTask selectedTask = tk.get(position);
                Toast.makeText(getActivity().getApplicationContext(), selectedTask.toString(), Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
    private void displayView(int position) {
        fragment= null;
        fragment = new TaskListFrag();

        if (fragment != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.Container, fragment);
            fragmentTransaction.addToBackStack(null).commit();
            fragmentTransaction.commit();
            // set the toolbar title
        }
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
