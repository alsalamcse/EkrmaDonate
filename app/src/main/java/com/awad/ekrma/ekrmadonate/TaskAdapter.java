package com.awad.ekrma.ekrmadonate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.awad.ekrma.ekrmadonate.data.MyTask;

public class TaskAdapter extends ArrayAdapter <MyTask>
{

    public TaskAdapter(ShowAllTasksActivity context, int resource){
        super( context, resource);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView==null)
            convertView=LayoutInflater.from(getContext())
                    .inflate(R.layout.task_item,parent, false);

        MyTask m=getItem(position);


        TextView tvTitle=convertView.findViewById(R.id.itmtvTitle);
        TextView tvTitle1= convertView.findViewById(R.id.itmtvTitle1);
        TextView tvTitle2 = convertView.findViewById(R.id.itmtvTitle2);

        ImageButton ibDel=convertView.findViewById(R.id.itmbtninfo);


        tvTitle.setText(m.getText());
        return convertView;
    }

}
