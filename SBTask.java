package com.project.imy320.spaceboy;

/**
 * Created by Element Code on 2015/10/08.
 */
 public class SBTask {
    private String TaskName;
    private String TaskID;
    private String TaskDesc;
    private TaskTime tTime;

    public SBTask() {
        this.TaskID = "";
        this.TaskDesc = "";
        this.TaskName = "";
        this.tTime = new TaskTime();
    }

    public SBTask(SBTask t) {
        this.TaskID = t.TaskID;
        this.TaskName = t.TaskName;
        this.TaskID = t.TaskID;
        this.tTime=new TaskTime(t.tTime);
    }

    public SBTask(String tn, String td, String ti, int h, int m, String s) {
        this.tTime=new TaskTime();
        this.SetTask(tn, td, ti, h, m, s);
    }

    public void SetTask(String tn, String td, String ti, int h, int m, String s) {
        this.TaskID = ti;
        this.TaskName = tn;
        this.TaskDesc = td;
        this.tTime.setTaskTime(h, m, s);
    }

    public String getTaskName() {
        return this.TaskName;
    }

    public String getTaskDesc() {
        return this.TaskDesc;
    }

    public String getTaskId() {
        return this.TaskID;
    }

    public TaskTime getTTime() {
        return this.tTime;
    }

    @Override
    public boolean equals(Object t) {
        SBTask temp = (SBTask) t;
        return temp.TaskID == temp.TaskID;
    }

    @Override
    public String toString() {
        return "TaskID: " + this.TaskID + "\n Task Name:" + this.TaskName + "\n Task Description: " + this.TaskDesc + "\n Time: " + this.tTime.toString();
    }


}