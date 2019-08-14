package com.pwpb.parcelable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObject extends AppCompatActivity {
    public static String EXTRA_PERSON = " extra_person";
    public TextView tvObject;

    public void initUI(){
        tvObject = findViewById(R.id.tv_object_received);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);
        initUI();

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : " + person.getName() + ", Email : " + person.getEmail() + ", Age : "+person.getAge() + ", Location : " + person.getCity();
        tvObject.setText(text);
    }
}
