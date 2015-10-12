package com.project.imy320.spaceboy;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NPMsiza on 10/9/2015.
 */
public class SpaceBoy_Globals {
    public static TimeTable SBTimeTable = null;
    public static ArrayList<SB_Date> Dates = null;
    public static int TaskFragState=0;
    public static int StringtoDrawable(String Color) {
        if (Color.equals("red")) {
            return R.drawable.table_cell_red;
        } else if (Color.equals("orange")) {
            return R.drawable.table_cell_orange;
        } else if (Color.equals("pink")) {
            return R.drawable.table_cell_pink;
        } else if (Color.equals("yellow")) {
            return R.drawable.table_cell_yellow;
        } else if (Color.equals("purple")) {
            return R.drawable.table_cell_purple;
        } else if (Color.equals("blue")) {
            return R.drawable.table_cell_blue;
        } else if (Color.equals("indego")) {
            return R.drawable.table_cell_indego;
        } else if (Color.equals("green")) {
            return R.drawable.table_cell_green;
        } else if (Color.equals("grey")) {
            return R.drawable.table_cell_grey;
        } else if (Color.equals("brown")) {
            return R.drawable.table_cell_brown;
        } else if (Color.equals("white")) {
            return R.drawable.table_cell;
        }
        else if (Color.equals("heading")) {
            return R.drawable.cell_heading;
        }
        return -1;
    }

public void InitTableFromDB()
{
    ParseQuery<ParseObject> query = ParseQuery.getQuery("SB_TimeTable");
    query.findInBackground(new FindCallback<ParseObject>() {
        public void done(List<ParseObject> objects, ParseException e) {
            if (e == null) {
                populate2(objects);
            } else {
                objectRetrievalFailed();
            }
        }
    });
}

    public void InitTaskFromDB()
    {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("SBDates");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    populate(objects);
                } else {
                    objectRetrievalFailed();
                }
            }
        });
    }

 public void Persist()
 {
     for(int i=0;i<10;i++)
         for(int j=0;j<8;j++) {
             ParseObject testObject = new ParseObject("SB_TimTable");
             testObject.put("X",i+"");
             testObject.put("Y",j+"");
             testObject.put("table",SBTimeTable.getTableCell(i,j));
             testObject.put("color",SBTimeTable.getColorCell(i,j));
             testObject.saveInBackground();
         }
     for(int i=0;i<Dates.size();i++)
     {
         ParseObject testObject = new ParseObject("SBDate");
         testObject.put("Date",Dates.get(i).getDay()+"/"+Dates.get(i).getMonth()+"/"+Dates.get(i).getYear());
         testObject.put("TaskId",Dates.get(i).getTasks().getTaskId());
         testObject.put("TaskName",Dates.get(i).getTasks().getTaskName());
         testObject.put("TaskDescr",Dates.get(i).getTasks().getTaskDesc());
         testObject.put("Time",Dates.get(i).getTasks().getTTime().toString());
         testObject.saveInBackground();
     }

 }
    public void populate(List<ParseObject> objects)
    {
        int a,b;
        if(SBTimeTable==null)
            SBTimeTable=new TimeTable();
        for(int i=0;i<objects.size();i++)
        {
            b=Integer.parseInt(objects.get(i).get("X")+"");
            a=Integer.parseInt(objects.get(i).get("Y")+"");
            SBTimeTable.setColorCell(a, b, objects.get(i).get("color") + "");
            SBTimeTable.setTableCell(a, b, objects.get(i).get("table") + "");
        }
    }
    public void populate2(List<ParseObject> objects)
    {
	    int a,b;
	    String arr[],arr2[];
        if(Dates==null)
            Dates=new ArrayList<SB_Date>();
        for(int i=0;i<objects.size();i++)
        {
            SB_Date t=new SB_Date();
            SBTask t2=new SBTask();
	    arr[]=((String)objects.get(i).get("Date")).split('/');
	    arr2[]=((String)objects.get(i).get("Time")).split(':')
	    t.setDate(arr[1],arr[2],Integer.parseIn(arr[0]));
	    t2.setTask(objects.get(i).get("TaskName")+"",objects.get(i).get("TaskDescr")+"",objects.get(i).get("TaskId")+"",arr[0],arr[1]," ");
	    t.setTask(t2);
	    Dates.add(t);	
	}
    }


    public void objectRetrievalFailed()
    {

    }
public String getTextColor(String Color)
{
    if(Color.equals("red"))

    {
        return "black";
    }

    else if(Color.equals("orange"))

    {
        return "black";
    }

    else if(Color.equals("pink"))

    {
        return "black";
    }

    else if(Color.equals("yellow"))

    {
        return "black";
    }

    else if(Color.equals("purple"))

    {
        return "white";
    }

    else if(Color.equals("blue"))

    {
        return "black";
    }

    else if(Color.equals("indego"))

    {
        return "white";
    }

    else if(Color.equals("green"))

    {
        return "black";
    }

    else if(Color.equals("grey"))
    {
        return "black";
    }

    else if(Color.equals("brown"))

    {
        return "white";
    }

    else if(Color.equals("white"))
    {
        return "black";
    }

    return "Nan";
}

    public static String getString(int Color) {
        if (Color==R.id.reddot) {
            return "red";
        } else if (Color==R.id.orangedot) {
            return "orange";
        } else if (Color==R.id.pinkdot) {
            return "pink";
        } else if (Color==R.id.yellowdot) {
            return "yellow";
        } else if (Color==R.id.purpledot) {
            return "purple";
        } else if (Color==R.id.bluedot) {
            return "blue";
        } else if (Color==R.id.indegodot) {
            return "indego";
        } else if (Color==R.id.greendot) {
            return "green";
        } else if (Color==R.id.greydot) {
            return "grey";
        } else if (Color==R.drawable.browndot) {
            return "brown";
        } else if (Color==R.drawable.table_cell) {
            return"white";
        }
        return "Nan";
    }

}
/*
<color name="red">#F44336</color>
<color name="blue">#2196F3</color>
<color name="yellow">#FFEB3B</color>
<color name="green">#4CAF50</color>
<color name="purple">#9C27B0</color>
<color name="pink">#EC407A</color>
<color name="orange">#FF9800</color>
<color name="brown">#795548</color>
<color name="indigo">#3F51B5</color>
<color name="grey">#AAA</color>
<color name="lightgrey">#DDD</color>*/