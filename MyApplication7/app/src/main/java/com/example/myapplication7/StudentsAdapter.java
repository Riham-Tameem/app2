package com.example.myapplication7;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.NoteVh> {


    Context context ;
    List<Student> students ;

    public StudentsAdapter(Context context  , List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public NoteVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_student ,parent , false );
        return new NoteVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteVh holder, int position) {
        holder.setData(students.get(position));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }




    class NoteVh extends RecyclerView.ViewHolder{

        TextView student_name , student_level , student_avg;
        public NoteVh(@NonNull View itemView) {
            super(itemView);
            student_name = itemView.findViewById(R.id.student_name);
            student_level = itemView.findViewById(R.id.student_level);
            student_avg =itemView.findViewById(R.id.student_avg);

        }

        public void setData(final Student std) {
            student_name.setText(std.getName());
            student_level.setText(std.getLevel());
            student_avg.setText(std.getAvg());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, std.getName(), Toast.LENGTH_SHORT).show();
                    Intent  intent = new Intent(itemView.getContext() ,StudentActivity.class);
                    intent.putExtra("id",std.getId());
                    intent.putExtra("name",std.getName());
                    intent.putExtra("level",std.getLevel());
                    intent.putExtra("avg",std.getAvg());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
