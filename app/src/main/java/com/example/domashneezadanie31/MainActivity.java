package com.example.domashneezadanie31;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    TextView textCount;
    Button btnCount;
    private int count = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textCount = findViewById(R.id.textCount);
        textCount.setText(Integer.toString(count));
        btnCount = findViewById(R.id.btnCount);
        btnCount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count++; textCount.setText(Integer.toString(count));
            }
        });
    }

    @Override
    protected void onStart() {
        Toast toast = Toast.makeText(this, "Старт активности", Toast.LENGTH_SHORT);
        toast.show();
        super.onStart();

    }

    @Override
    protected void onStop() {
        Toast toast = Toast.makeText(this, "Стоп активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.LEFT, 0, 0);
        toast.show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast toast = Toast.makeText(this, "Уничтожение активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast toast = Toast.makeText(this, "Пауза активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast toast = Toast.makeText(this, "Активити готово к работе", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        ImageView cat = new ImageView(this);
        cat.setImageResource(R.drawable.cat);
        toast.setView(cat);
        toast.show();
        super.onResume();
    }
        protected void onSaveInstanceState (@NonNull Bundle outState){
            super.onSaveInstanceState(outState);
            outState.putInt("count", count);
        }
        protected void onRestoreInstanceState (@NonNull Bundle savedInstanceState){
            super.onRestoreInstanceState(savedInstanceState);
            count = savedInstanceState.getInt("count");
            textCount.setText(Integer.toString(count));
    }
}