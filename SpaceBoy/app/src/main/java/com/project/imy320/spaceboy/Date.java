package com.project.imy320.spaceboy;

import java.util.ArrayList;
/**
 * Created by Patience Mtsweni on 10/9/2015.
 */
public class Date {


    private ArrayList<SBTask> tasks;

    private String Month;

    private String year;

    private int day;

    private int size;

    public Date(){

        tasks = new ArrayList<SBTask>();
        this.Month = "";
        this.year = "";
        this.day = 0;
        this.size = 0;

    }

    public Date(String mo, String yr, int day){
        Month = mo;
        year = yr;
        this.day = day;
    }

    public ArrayList<SBTask> getTasks(){

        if(tasks.isEmpty())
       return null;
        else
            return tasks;
    }

    public void setTask(ArrayList<SBTask> tasks){
        this.tasks = tasks;
    }

    public void addTask(SBTask task){

        tasks.add(task);
    }

    public void deleteTask(SBTask task){

        boolean found = tasks.contains(task);

        if(found){
            tasks.remove(task);
        }
    }
}
