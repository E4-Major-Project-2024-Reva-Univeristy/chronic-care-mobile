package com.e4.chronic_care_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private final List<Task> tasks;

    public TaskAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView taskName;
        TextView streakCount;
        ChipGroup daysContainer;

        public ViewHolder(View view) {
            super(view);
            taskName = view.findViewById(R.id.taskNameTextView);
            streakCount = view.findViewById(R.id.streakCountTextView);
            daysContainer = view.findViewById(R.id.daysContainer);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.streak_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.taskName.setText(task.getName());
        holder.streakCount.setText(String.format("%d day streak", task.getCurrentStreak()));

        holder.daysContainer.removeAllViews();
        List<Boolean> days = task.getLastSevenDays();
        for (int i = 0; i < days.size(); i++) {
            Chip chip = new Chip(holder.itemView.getContext());
            chip.setText(String.valueOf(i + 1));
            chip.setChecked(days.get(i));
            chip.setCheckable(false);
            holder.daysContainer.addView(chip);
        }
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
