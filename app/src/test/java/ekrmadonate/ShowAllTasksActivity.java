package ekrmadonate;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.awad.ekrma.ekrmadonate.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowAllTasksActivity extends ArrayAdapter implements ShowAllTasksActivity1 {

    private ListView lvTasks;
    private TaskAdapter taskAdapter;

    public ShowAllTasksActivity(@androidx.annotation.NonNull Context context, int resource) {
        super(context, resource);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Context context;
        context = super.getContext();
        setContentView(R.layout.activity_show_all_tasks);


        lvTasks = lvTasks.findViewById(0);


        taskAdapter = new TaskAdapter(this, R.layout.task_item);


        lvTasks.setAdapter(taskAdapter);
        readTasks();
    }

    private void setContentView(int activity_show_all_tasks) {
    }


    private void readTasks() {

               DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("MyTasks");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText( ShowAllTasksActivity.this, "hahah.", Toast.LENGTH_SHORT).show();
                taskAdapter.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    MyTask task = d.getValue(MyTask.class);
                    taskAdapter.add(task);
                }
                taskAdapter.notifyDataSetChanged();
            }

            private void getBaseContext() {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

           }


