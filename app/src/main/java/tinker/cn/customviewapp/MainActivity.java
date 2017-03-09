package tinker.cn.customviewapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.activity_main);
        RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.rl_container);
        View view= LayoutInflater.from(this).inflate(R.layout.text_view,null,false);
        linearLayout.addView(view);
    }
}
