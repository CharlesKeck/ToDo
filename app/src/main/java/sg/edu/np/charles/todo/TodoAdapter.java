package sg.edu.np.charles.todo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewHolder> {

    private List<String> todoList;
    private Context context;

    public TodoAdapter(List<String> tdl, Context c){
        todoList = tdl;
        context = c;
    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.todo_view_holder, viewGroup, false);
        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder todoViewHolder, int i) {
        final int position = todoViewHolder.getAdapterPosition();
        String s = todoList.get(position);
        todoViewHolder.name.setText(s);
        todoViewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alert(position);
            }
        });
    }

    public void Alert(final int i){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                int unicode = 0x1F5D1;
                String garbage = getEmojiByUnicode(unicode) + "\n";
                builder
                        .setTitle("Delete")
                        .setMessage("Are you sure you want to delete" + garbage + todoList.get(i) + "?" )
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                todoList.remove(i);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
    }


    @Override
    public int getItemCount() {
        return todoList.size();
    }



}

