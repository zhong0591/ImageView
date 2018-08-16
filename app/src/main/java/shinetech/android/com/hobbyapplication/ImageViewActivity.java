package shinetech.android.com.hobbyapplication;

import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgView;
    Button btnNext;
    Button btnPre;
    private  int position = 0;
    private int[] imgIds = new int[]{
      R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_image_view);

        imgView = findViewById(R.id.img_view);
        btnNext = findViewById(R.id.btn_next);
        btnPre = findViewById(R.id.btn_pre);

        btnNext.setOnClickListener(this);
        btnPre.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        switch ((view.getId())) {
            case R.id.btn_pre:
                position --;
                if(position <= 0){
                    position = 0;
                }
                imgView.setImageResource( imgIds[position]);
                break;
            case R.id.btn_next:
                position ++;
                if(position >=  imgIds.length -1  ){
                    position = imgIds.length -1;
                }
                imgView.setImageResource( imgIds[position]);
                break;
        }

    }
}
