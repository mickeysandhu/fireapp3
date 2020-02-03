package com.example.fireapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class menu_layout extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDatabase mdatabase;
    private DatabaseReference mref;
    Button regular, medium, large, place_order;
    String Coffee = "";
    String Size = "";
    float Total = 0;
    detail details = new detail();
    RadioButton CoffeeBtn;
    RadioGroup radioGroup;
    EditText name;
    TextView paisa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_layout);
        regular = findViewById(R.id.regular);
        medium = findViewById(R.id.medium);
        large = findViewById(R.id.large);
        paisa = findViewById(R.id.paisa);
        place_order = findViewById(R.id.placeOrder);
        name = findViewById(R.id.name);
        radioGroup = findViewById(R.id.RGroup);
        mdatabase = FirebaseDatabase.getInstance();
        mref = mdatabase.getReference("user");
        int selected = radioGroup.getCheckedRadioButtonId();
        regular.setOnClickListener(this);
        medium.setOnClickListener(this);
        large.setOnClickListener(this);
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
        final String dateTime = simpleDateFormat.format(calender.getTime());


        CoffeeBtn = findViewById(selected);
        try {
            Coffee = CoffeeBtn.getText().toString();

        } catch (NullPointerException ignored) {
        }
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.espresso) {
                    Coffee = "Espresso";
                } else if (checkedId == R.id.capetuno) {
                    Coffee = "Capetuno";

                } else if (checkedId == R.id.latte) {
                    Coffee = "Latte";
                }
            }

        });
        place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        details.setName(name.getText().toString());
                        details.setCoffeeType(Coffee);
                        details.setSize(Size);
                        details.setPaisa(Total);
                        details.setDate(dateTime);
                        mref.push().setValue(details);
                        Toast.makeText(menu_layout.this, "Order Placed", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(menu_layout.this, MainActivity.class);
                        startActivity(i);
                        finish();;


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regular:
                Size = "regular";
                Toast.makeText(this, "Regular is selected", Toast.LENGTH_SHORT).show();
                if (Coffee == "Espresso") {
                    Total = (float) (75 * 1.1);
                } else if (Coffee == "Capetuno") {
                    Total = (float) (110 * 1.1);
                } else if (Coffee == "Latte") {
                    Total = (float) (50 * 1.1);
                }
                paisa.setText(String.valueOf(Total));
                break;
            case R.id.medium:
                Size = "medium";
                Toast.makeText(this, "Medium is selected", Toast.LENGTH_SHORT).show();
                if (Coffee == "Espresso") {
                    Total = (float) (75 * 2.5);
                } else if (Coffee == "Capetuno") {
                    Total = (float) (110 * 2.5);
                } else if (Coffee == "Latte") {
                    Total = (float) (50 * 2.5);
                }
                paisa.setText(String.valueOf(Total));
                break;
            case R.id.large:
                Size = "large";
                Toast.makeText(this, "Large is selected", Toast.LENGTH_SHORT).show();
                if (Coffee == "Espresso") {
                    Total = (float) (75 * 3.1);
                } else if (Coffee == "Capetuno") {
                    Total = (float) (110 * 3.1);
                } else if (Coffee == "Latte") {
                    Total = (float) (50 * 3.1);
                }
                paisa.setText(String.valueOf(Total));
                break;

        }

    }
}



