package com.pwpb.parcelable;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {
    Button btnMoveAct;
    Button btnMoveWithDataAct;
    Button btnMoveWithObjectAct;
    Button btnDialNumber;
    Button btnMoveResult;
    TextView tvResult;

    private int REQUEST_CODE = 100;

    public void initUI() {
        btnMoveAct = findViewById(R.id.btn_move_activity);
        btnMoveWithObjectAct = findViewById(R.id.btn_move_activity_object);
        btnMoveWithDataAct = findViewById(R.id.btn_move_with_data_activity);
        btnDialNumber = findViewById(R.id.btn_dial_number);
        btnMoveResult = findViewById(R.id.btn_move_for_result);
        tvResult = findViewById(R.id.tv_result);
    }

    public void initButtonFun() {
        btnMoveAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(MainActivity.this, MoveAct.class);
                startActivity(moveIntent);
            }
        });
        btnMoveWithDataAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithData.class);
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_NAME, "Fakhri Maulana Falah");
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_AGE, 17);
                startActivity(moveWithDataIntent);
            }
        });
        btnMoveWithObjectAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                person.setName("Fakhri Maulana Falah");
                person.setAge(17);
                person.setEmail("fakhrimf23@gmail.com");
                person.setCity("Bandung");
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObject.class);
                moveWithObjectIntent.putExtra(MoveWithObject.EXTRA_PERSON, person);
                startActivity(moveWithObjectIntent);
            }
        });
        btnDialNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "081394566373";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);
            }
        });
        btnMoveResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResult.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initButtonFun();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResult.RESULT_CODE) {
                int selectedValue =
                        data.getIntExtra(MoveForResult.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}
