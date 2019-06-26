package sg.edu.np.charles.todo;

import android.os.Debug;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public CheckBox chkbox;

        public TodoViewHolder(@NonNull View itemView) {

            super(itemView);
            name = itemView.findViewById(R.id.text1);
            chkbox = itemView.findViewById(R.id.chkbox);


        }


    }
