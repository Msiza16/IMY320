package com.project.imy320.spaceboy;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.sql.Time;

/**
 * Created by Element Code on 2015/10/08.
 */
public class TimeTableFrag extends Fragment {
    // Required empty public constructor
    int Ccount=8;
    int Rcount=10;
    TableLayout timeTable;
    Button btn;
    View rootView;
    Fragment fragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.time_table, container, false);
        timeTable= (TableLayout) rootView.findViewById(R.id.TimeTable);
        Construct();
        format();
        return rootView;
    }

    public void Construct()
    {
        timeTable = (TableLayout) rootView.findViewById(R.id.TimeTable);
        timeTable.setStretchAllColumns(true);
        timeTable.bringToFront();


        TableRow tr;
        for(int i = 0; i <Rcount; i++){
            tr= new TableRow(rootView.getContext());
            for(int j=0;j<Ccount;j++) {

                btn = new Button(rootView.getContext());
                //setLayoutParams();
                if(i==0||j==0)
                btn.setBackground(getResources().getDrawable(R.drawable.cell_heading));
                else
                    btn.setBackground(getResources().getDrawable(R.drawable.table_cell));
                btn.setOnClickListener(new View.OnClickListener() {
                                           public void onClick(View v) {
                                               Button btn1 = (Button) v;
                                               ViewSwitcher vS= (ViewSwitcher) rootView.findViewById(R.id.profileSwitcher);
                                            vS.showNext();
                                           }
                                       }

                );
                tr.addView(btn);
            }
            timeTable.addView(tr);
        }
    }

    private void displayView(int position) {
        fragment= null;
        fragment = new TimeTableEditor();

        if (fragment != null) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.Container, fragment);
                fragmentTransaction.addToBackStack(null).commit();
                fragmentTransaction.commit();
            // set the toolbar title
        }
    }


    public void format()
    {
        try {
            timeTable = (TableLayout) rootView.findViewById(R.id.TimeTable);
            if (SpaceBoy_Globals.SBTimeTable == null) {
                SpaceBoy_Globals.SBTimeTable = new TimeTable();
            }
            for (int i = 0; i < 10; i++) {
                TableRow par = (TableRow) timeTable.getChildAt(i);
                for (int j = 0; j < 8; j++) {
                    Button temp = (Button) par.getChildAt(j);
                    temp.setText(SpaceBoy_Globals.SBTimeTable.getTableCell(i, j));
                }
            }
        }
        catch (Exception e)
        {
            Toast.makeText(rootView.getContext(),e.toString(),Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
