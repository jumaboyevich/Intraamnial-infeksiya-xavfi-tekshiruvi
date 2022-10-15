package uz.crud.intraamnialinfeksiyaxavfitekshiruvi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv, userName;
    Button submitbutton, previusbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;
    CheckBox chb1, chb2, chb3;
    LinearLayout checkboxGroup;
    List<Note> questionss = new ArrayList<>();

    String questions[] = {
            "Asoratlangan akusherlik/ginekologik anamnez",
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
            " - bachadon bo'ynida surtmada leykotsitlar balandligi", " - qinda leykotsitlar surtmada balandligi", " - uretrada surtmada leykotsitlar balandligi",
            " - 1b daraja", " - 2 daraja", " - 3 daraja",
            " - qog'onoq parda tug'ruqdan oldin yorilishi", " - suvsiz davr 6 soatgacha", " - suvsiz davr 6 soatdan ko'p"
    };

    int flag = 0;
    public static int marks = 0, lastBall = 0, correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        questionss.add(new Note(1, "Asoratlangan akusherlik/ginekologik anamnez", 1, new String[]{" - qayta artifitsial abort", " - bachadon chandig'i", " - jinsiy a'zolar yallig'lanish kasalliklari"}, new int[]{1, 1, 1}));
        questionss.add(new Note(2, "Isitma+ona yoki boladagi taxikardiya", 1, new String[]{" - 37.5 C va undan yuqori", " - onada taxikardiya (minutiga 100 va undan ko'p)", " - homilada taxikardiya ()minutiga 160 va undan yuqori"}, new int[]{1, 1, 1}));
        questionss.add(new Note(3, "Ultratovush tekshiruvi xulosalari", 1, new String[]{" - kamsuvlilik/ko'psuvlilik", " - yo'ldosh qalinligi oshishi (50mmdan) ", " - vorsinkalar aro bo'shliqni kengayishi"}, new int[]{1, 1, 1}));
        questionss.add(new Note(4, "Pastki jinsiy a'zolar surtmasida yallig'lanish belgilari", 1, new String[]{" - bachadon bo'ynida surtmada leykotsitlar balandligi", " - qinda leykotsitlar surtmada balandligi", " - uretrada surtmada leykotsitlar balandligi"}, new int[]{1, 1, 1}));
        questionss.add(new Note(5, "Ona-yo'ldosh-homila tizimidagi qon aylanish buzilishi", 2, new String[]{" - 1b daraja", " - 2 daraja", " - 3 daraja"}, new int[]{1, 1, 1}));
        questionss.add(new Note(6, "Qog'onoq parda tug'ruqdan oldin yoki erta yorilishidan keyingi suvsiz davr davomiyligi", 2, new String[]{" - qog'onoq parda tug'ruqdan oldin yorilishi", " - suvsiz davr 6 soatgacha", " - suvsiz davr 6 soatdan ko'p"}, new int[]{1, 2, 3}));


         submitbutton = (Button) findViewById(R.id.buttonNextQuestion);
        quitbutton = (Button) findViewById(R.id.buttonQuit);
        previusbutton = (Button) findViewById(R.id.buttonPreviousQuestion);
        tv = (TextView) findViewById(R.id.txtQuestion);
        userName = (TextView) findViewById(R.id.userName);

        radio_g = (RadioGroup) findViewById(R.id.radioButtonGroup);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);

        checkboxGroup = (LinearLayout) findViewById(R.id.checkboxGroup);
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


                nextQuestion(checkBall(), ++flag);

            }
        });

        previusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                marks = lastBall;
                nextQuestion(true, --flag);

            }
        });

    }

    boolean checkBall() {
        lastBall = marks;
        switch (questionss.get(flag).getQuestionType()) {
            case 1: {
                if (chb1.isChecked() || chb2.isChecked() || chb3.isChecked()) {
                    if (chb1.isChecked())
                        marks += questionss.get(flag).getQuestionOptionsBall()[0];
                    if (chb2.isChecked())
                        marks += questionss.get(flag).getQuestionOptionsBall()[1];
                    if (chb3.isChecked())
                        marks += questionss.get(flag).getQuestionOptionsBall()[2];

                } else {
                    Toast.makeText(MainActivity.this, "Variantlardan hech bo'lmaganda birini tanlang", Toast.LENGTH_SHORT).show();
                    return false;
                }
                break;
            }
            case 2: {
                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Variantlardan birini tanlang", Toast.LENGTH_SHORT).show();
                    return false;
                } else {
                    marks += questionss.get(flag).getQuestionOptionsBall()[radio_g.indexOfChild(findViewById(radio_g.getCheckedRadioButtonId()))];
                }
                break;
            }
            case 3:
        }
        return true;
    }

    void nextQuestion(boolean enabled, int flag) {
        userName.setText("Ball: "+marks);

        if (flag >= 0 && enabled) {
            tv.setText(questionss.get(flag).getQuestionTitle());
            switch (questionss.get(flag).getQuestionType()) {
                case 1: {
                    checkboxGroup.setVisibility(View.VISIBLE);

                    chb1.setText(questionss.get(flag).getQuestionOptions()[0]);
                    chb2.setText(questionss.get(flag).getQuestionOptions()[1]);
                    chb3.setText(questionss.get(flag).getQuestionOptions()[2]);
                    chb1.setChecked(false);
                    chb2.setChecked(false);
                    chb3.setChecked(false);
                    radio_g.setVisibility(View.GONE);
                    rb1.setVisibility(View.VISIBLE);
                    rb2.setVisibility(View.VISIBLE);
                    rb3.setVisibility(View.VISIBLE);
                    break;
                }
                case 2: {
                    radio_g.setVisibility(View.VISIBLE);
                    if (questionss.get(flag).getQuestionOptions().length > 0)
                        rb1.setText(questionss.get(flag).getQuestionOptions()[0]);
                    else
                        rb1.setVisibility(View.GONE);
                    if (questionss.get(flag).getQuestionOptions().length > 1)
                        rb2.setText(questionss.get(flag).getQuestionOptions()[1]);
                    else
                        rb2.setVisibility(View.GONE);
                    if (questionss.get(flag).getQuestionOptions().length > 2)
                        rb3.setText(questionss.get(flag).getQuestionOptions()[2]);
                    else
                        rb3.setVisibility(View.GONE);
                    radio_g.clearCheck();
                    checkboxGroup.setVisibility(View.GONE);
                    break;
                }
            }
        }
    }
}