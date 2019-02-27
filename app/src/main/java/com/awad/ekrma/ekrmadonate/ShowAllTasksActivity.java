package com.awad.ekrma.ekrmadonate;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.awad.ekrma.ekrmadonate.data.MyTask;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowAllTasksActivity extends AppCompatActivity {

    private ListView lvTasks;
    private TaskAdapter taskAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_tasks);


        lvTasks = findViewById(R.id.lstvTasks);


        taskAdapter = new TaskAdapter(this, R.layout.task_item);


        lvTasks.setAdapter(taskAdapter);
        readTasks();
    }










           private void readTasks() {

               DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
               reference.child("MyTasks").addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       Toast.makeText(getBaseContext(), "data changed", Toast.LENGTH_SHORT).show();
                       taskAdapter.clear();
                       for (DataSnapshot d : dataSnapshot.getChildren()) {
                           MyTask task = d.getValue(MyTask.class);
                           taskAdapter.add(task);
                       }
                       taskAdapter.notifyDataSetChanged();
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });
           }

           }


