package com.e4.chronic_care_mobile;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<Task> tasksList = Arrays.asList(
                new Task("Drinking Water", 5, Arrays.asList(true, true, true, true, true, false, false)),
                new Task("Take Medications", 3, Arrays.asList(true, true, true, false, false, true, false)),
                new Task("Do Exercise", 7, Arrays.asList(true, true, true, true, true, true, true)),
                new Task("Meet Doctor", 3, Arrays.asList(true, true, true, true, true, true, true))
        );

        TaskAdapter adapter = new TaskAdapter(tasksList);
        RecyclerView recyclerView = findViewById(R.id.tasksRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        TextView totalStreak = findViewById(R.id.totalStreakTextView);
        totalStreak.setText("7 days");
    }
}

// SQL Lite Database Integration
// Class with data memebers
// class Streak {
// int currentStreak
// func IncrementStreak()
// func CheckTodays Streak()
// }

// 1. Streak Manage
// 2. Tablet Remainder


//1. Quiz for the patient
//2. Streak for doing tasks of patients
//3. Remainder and alarm for the patient
