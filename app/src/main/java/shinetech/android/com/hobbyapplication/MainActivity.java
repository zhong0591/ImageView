package shinetech.android.com.hobbyapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.KeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button btn;
    public CheckBox swim;
    public CheckBox run;
    public CheckBox footboll;
    public CheckBox read;

    public  CheckBox view_pwd;
    public EditText txt_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_submit) ;
        swim = findViewById(R.id.swim);
        run = findViewById(R.id.run);
        footboll = findViewById(R.id.footboll);
        read = findViewById(R.id.read);

        view_pwd = findViewById(R.id.view_pwd);
        txt_pwd = findViewById(R.id.txt_pwd);

        txt_pwd.addTextChangedListener(new TextWatcher() {
            @Override
            /*
            * charSequence 原始字符串
            * i 原始字符串长度
            * I1 原始字符串开始位置
            * I2输入后字符串所在位置
            * */
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("参数","charSequenece:" + charSequence);
                Log.i("参数2","i:" + i);
                Log.i("参数3","i1:" + i1);
                Log.i("参数4","i2:" + i2);
            }

            @Override
               /*
            * charSequence 原始字符串
            * i 插入字符串的位置
            * I1 原始字符串开始位置
            * I2输入后字符串所在位置
            * */
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("参数","charSequenece:" + charSequence);
                Log.i("参数2","i:" + i);
                Log.i("参数3","i1:" + i1);
                Log.i("参数4","i2:" + i2);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i("参数","Editable:" + editable);
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectHobbies();
            }
        });

        view_pwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    txt_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    txt_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });



    }

    private void SelectHobbies() {
        String hobbies = "";

        if(swim.isChecked()){
            Log.i("swim:",swim.getText().toString());
            hobbies += swim.getText() + ",";
        }

        if(footboll.isChecked()){
            Log.i("footboll:",footboll.getText().toString());
            hobbies += footboll.getText() + ",";
        }

        if(run.isChecked()){
            Log.i("run:",run.getText().toString());
            hobbies += run.getText() + ",";
        }

        if(read.isChecked()){
            Log.i("read:",read.getText().toString());
            hobbies += read.getText() + ",";
        }

        if(hobbies.length() > 0){

            Toast.makeText(this,hobbies.substring(0, hobbies.length() -1 ), Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"请选择你的爱好！", Toast.LENGTH_LONG).show();

        }

    }
}
