package com.e4.chronic_care_mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.text.TextUtils;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText weightInput;
    private TextInputEditText heightInput;
    private TextView resultText;
    private TextView categoryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize views
        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        resultText = findViewById(R.id.resultText);
        categoryText = findViewById(R.id.categoryText);
        Button calculateButton = findViewById(R.id.calculateButton);

        // Set up window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up button click listener
        calculateButton.setOnClickListener(v -> calculateBMI());
    }

    private void calculateBMI() {
        String weightStr = Objects.requireNonNull(weightInput.getText()).toString();
        String heightStr = Objects.requireNonNull(heightInput.getText()).toString();

        if (TextUtils.isEmpty(weightStr) || TextUtils.isEmpty(heightStr)) {
            resultText.setText("Please enter both weight and height");
            categoryText.setText("");
            return;
        }

        try {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr);

            if (weight <= 0 || height <= 0) {
                resultText.setText("Please enter valid values");
                categoryText.setText("");
                return;
            }

            float bmi = calculateBMIValue(weight, height);
            String category = getBMICategory(bmi);

            resultText.setText(String.format("Your BMI: %.1f", bmi));
            categoryText.setText(category);

        } catch (NumberFormatException e) {
            resultText.setText("Please enter valid numbers");
            categoryText.setText("");
        }
    }

    private float calculateBMIValue(float weight, float height) {
        return weight / (height * height);
    }

    private String getBMICategory(float bmi) {
        if (bmi < 18.5) {
            return "Category: Underweight";
        } else if (bmi < 25) {
            return "Category: Normal weight";
        } else if (bmi < 30) {
            return "Category: Overweight";
        } else {
            return "Category: Obese";
        }
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