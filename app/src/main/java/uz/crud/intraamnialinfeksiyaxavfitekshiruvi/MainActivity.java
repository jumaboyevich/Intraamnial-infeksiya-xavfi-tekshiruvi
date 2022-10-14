package uz.crud.intraamnialinfeksiyaxavfitekshiruvi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;
    CheckBox chb1, chb2, chb3;

    String questions[] = {
            "1. Asoratlangan akusherlik/ginekologik anamnez",
            "Isitma+ona yoki boladagi taxikardiya",
            "Ultratovush tekshiruvi xulosalari",
            "Pastki jinsiy a'zolar surtmasida yallig'lanish belgilari",
            "Ona-yo'ldosh-homila tizimidagi qon aylanish buzilishi",
            "Qog'onoq parda tug'ruqdan oldin yoki erta yorilishidan keyingi suvsiz davr davomiyligi",

    };

    String options[] = {
            " - qayta artifitsial abort", " - bachadon chandig'i", " - jinsiy a'zolar yallig'lanish kasalliklari",
            " - 37.5 C va undan yuqori", " - onada taxikardiya (minutiga 100 va undan ko'p)", " - homilada taxikardiya ()minutiga 160 va undan yuqori",
            " - kamsuvlilik/ko'psuvlilik", " - yo'ldosh qalinligi oshishi (50mmdan) ", " - vorsinkalar aro bo'shliqni kengayishi",
            " - Bachadon bo'ynida surtmada leykotsitlar balandligi", " - qinda leykotsitlar surtmada balandligi", " - uretrada surtmada leykotsitlar balandligi",
            " - 1b daraja"," - 2 daraja"," - 3 daraja",
            " - qog'onoq parda tug'ruqdan oldin yorilishi", " - suvsiz davr 6 soatgacha", " - suvsiz davr 6 soatdan ko'p"
    };

    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.userName);

        submitbutton = (Button) findViewById(R.id.buttonNextQuestion);
        quitbutton = (Button) findViewById(R.id.buttonQuit);
        tv = (TextView) findViewById(R.id.txtQuestion);

        radio_g = (RadioGroup) findViewById(R.id.radioButtonGroup);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);

        chb1 = (CheckBox) findViewById(R.id.checkbox1);
        chb2 = (CheckBox) findViewById(R.id.checkbox2);
        chb3 = (CheckBox) findViewById(R.id.checkbox3);

        tv.setText(questions[flag]);
        chb1.setText(options[0]);
        chb2.setText(options[1]);
        chb3.setText(options[2]);


        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

//                if(radio_g.getCheckedRadioButtonId()==-1)
//                {
//                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
//                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
//                if(ansText.equals(answers[flag])) {
//                    correct++;
//                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    wrong++;
//                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
//                }
//
                flag++;
//
//                if (score != null)
//                    score.setText(""+correct);
//
//                if(flag<questions.length)
//                {
                tv.setText(questions[flag]);
                chb1.setText(options[flag * 3]);
                chb2.setText(options[flag * 3 + 1]);
                chb3.setText(options[flag * 3 + 2]);
//                    rb4.setText(options[flag*3 +3]);
//                }
//                else
//                {
//                    marks=correct;
//                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
//                    startActivity(in);
//                }
                chb1.setChecked(false);
                chb2.setChecked(false);
                chb3.setChecked(false);
                radio_g.clearCheck();
            }
        });

    }
}