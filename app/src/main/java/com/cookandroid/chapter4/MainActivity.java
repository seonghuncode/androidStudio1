package com.cookandroid.chapter4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Switch chkAgree;
    RadioGroup rGroup1;
    RadioButton radioArray[] = new RadioButton[3];
    Button button1, button2;
    ImageView imgPet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("애완동물 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (Switch) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        radioArray[0] = (RadioButton) findViewById(R.id.RdoDog);
        radioArray[1] = (RadioButton) findViewById(R.id.RdoCat);
        radioArray[2] = (RadioButton) findViewById(R.id.RdoRabbit);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(chkAgree.isChecked() == true){
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    button1.setVisibility(android.view.View.VISIBLE);
                    button1.setVisibility(android.view.View.VISIBLE);
                    imgPet.setVisibility(android.view.View.VISIBLE);
                }else{
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    button1.setVisibility(android.view.View.INVISIBLE);
                    button1.setVisibility(android.view.View.INVISIBLE);
                    imgPet.setVisibility(android.view.View.INVISIBLE);
                }

            }
        });



        // 라디오버튼을 클릭할 때, 이미지 뷰를 변경시킴 ==> 배열로 처리함.
        final int draw[] = { R.drawable.dog3,
                R.drawable.cat1, R.drawable.rabbit2};

        for (int i = 0; i < radioArray.length; i++) {
            final int index; // 주의! 꼭 필요함.
            index = i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    imgPet.setImageResource(draw[index]);
                }
            });
        }

        // 종료 버튼을 클릭하면
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                finish();
            }
        });

        // 처음으로 버튼을 클릭하면
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                text2.setVisibility(android.view.View.INVISIBLE);
                rGroup1.setVisibility(android.view.View.INVISIBLE);
                imgPet.setVisibility(android.view.View.INVISIBLE);
                button1.setVisibility(android.view.View.INVISIBLE);
                button2.setVisibility(android.view.View.INVISIBLE);

                rGroup1.clearCheck();
                chkAgree.setChecked(false);

            }
        });




    }
}