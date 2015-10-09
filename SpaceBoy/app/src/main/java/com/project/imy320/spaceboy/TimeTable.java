package com.project.imy320.spaceboy;

/**
 * Created by Element Code on 2015/10/08.
 */
public class TimeTable {
    String table[][];
    String colors[][];
    TaskTime t=new TaskTime();
    public TimeTable() {
        table = new String[10][8];
        colors = new String[10][8];
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<8;j++){
                table[i][j]=" ";
                colors[i][j]="#FFFFFF";}
        }
        table[0][0]=" ";
        table[0][1]="Monday";
        table[0][2]="Tuesday";
        table[0][3]="Wednesday";
        table[0][4]="Thursday";
        table[0][5]="Fridday";
        table[0][6]="Saterday";
        table[0][7]="Sundayday";

        t.setTaskTime(7,30,0);
        for (int i=1;i<10;i++)
        {
         table[i][0]=t.toString();
            t.incByHalfHour();
        }

    }

    public String getTableCell(int i, int j) {
        return table[i][j];
    }

    public void setTableCell(int i, int j, String cell) {
        table[i][j] = cell;
    }
    public String getColorCell(int i, int j) {
        return table[i][j];
    }

    public void setColorCell(int i, int j, String cell) {
        table[i][j] = cell;
    }
    @Override
    public TimeTable clone()
    {
        TimeTable t=new TimeTable();
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<10;j++)
            {
                t.table[i][j]=this.table[i][j];
                t.colors[i][j]=this.colors[i][j];
            }
        }
    return t;
    }
    @Override
    public boolean equals(Object obj)
    {
        TimeTable tmp=(TimeTable)obj;
        boolean flag=true;
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<10;j++)
            {
                if(!(tmp.table[i][j]==this.table[i][j]&&tmp.colors[i][j]==this.colors[i][j]))
                    flag=false;
            }
        }
        return flag;
    }


}
