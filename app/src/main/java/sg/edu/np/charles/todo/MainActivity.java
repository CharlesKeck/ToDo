package sg.edu.np.charles.todo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView todoList;
    List<String> stringList = new ArrayList<>();
    Button Add;
    EditText editText;
    TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Data
        stringList.add("Buy Milk");
        stringList.add("Send Postage");
        stringList.add("Buy Android Dev Book");

        todoList = (RecyclerView)findViewById(R.id.todoList);
        editText = (EditText)findViewById(R.id.editText);

        Add = (Button)findViewById(R.id.button);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(editText.getText()).trim();
                if (!s.isEmpty()) {
                    stringList.add(String.valueOf(editText.getText()));
                    editText.setText("");
                    todoAdapter.notifyDataSetChanged();
                }
            }
        });

        todoAdapter = new TodoAdapter(stringList, this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        todoList.setLayoutManager(mLayoutManager);
        todoList.setItemAnimator(new DefaultItemAnimator());
        todoList.setAdapter(todoAdapter);
    }













}
