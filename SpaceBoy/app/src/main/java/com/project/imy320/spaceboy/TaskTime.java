package com.project.imy320.spaceboy;

public class TaskTime
{

int Hour;
int Minute;
int Second;

public TaskTime()
{
 Hour=0;
 Second=0;
 Minute=0;
}
public TaskTime(TaskTime t)
{
	this.Hour=t.Hour;
	this.Minute=t.Minute;
	this.Second=t.Second;
}
public void setTaskTime(int h,int m, int s)
{
 Hour=h;
 Minute=m;
 Second=s;
}
public void incByHour()
{
    if(Hour+1>=24)
    {
        Hour=0;
    }
    else
    {
        Hour++;
    }
}
    public void incByHalfHour()
    {
        if(Minute+30>=60)
        {
            Minute=0;
            incByHour();
        }
        else
        {
            Minute+=30;
        }
    }

public int getHour()
{
 return	this.Hour;
}
public  int getMinute()
{
	return this.Minute;
}
public int getSecond()
{
	return this.Second;
}
@Override
public String toString()
{
    String h="",m="",s="";
    if(Hour<9)
        h="0";
    if(Minute<9)
        m="0";
    if(Second<9)
        s="0";
	return h+this.Hour+":"+m+this.Minute+":"+s+this.Second;
}
@Override 
public boolean equals(Object t)
{
	TaskTime temp=(TaskTime)t;
   return this.Hour==temp.Hour&&this.Minute==temp.Minute&&this.Second==temp.Second;
}

public boolean equalsHM(Object t)
{
	TaskTime temp=(TaskTime)t;
   return this.Hour==temp.Hour&&this.Minute==temp.Minute;
}

public boolean equalsH(Object t)
{
	TaskTime temp=(TaskTime)t;
   return this.Hour==temp.Hour;
}

}