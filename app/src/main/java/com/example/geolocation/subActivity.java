package com.example.geolocation;


import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class subActivity extends AppCompatActivity {
    public Structure A1,A2,A3,A4,A5 = new Structure();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
        Date currentTime = new Date();
        String mTime = simpleDateFormat.format(currentTime);

        getAPIData Datagetter = new getAPIData();

        Structure A1 = (Structure) Datagetter.APIDatagetter(36,129,1);
        Structure A2 = (Structure) Datagetter.APIDatagetter(36,129,2);
        Structure A3 = (Structure) Datagetter.APIDatagetter(36,129,3);
        Structure A4 = (Structure) Datagetter.APIDatagetter(36,129,4);
        Structure A5 = (Structure) Datagetter.APIDatagetter(36,129,5);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView T1 = (TextView)findViewById(R.id.textview1);
        TextView T2 = (TextView)findViewById(R.id.textview2);
        TextView T3 = (TextView)findViewById(R.id.textview3);
        TextView T4 = (TextView)findViewById(R.id.textview4);
        TextView T5 = (TextView)findViewById(R.id.textview5);

        String A = ((Structure) A1).getValue("reh");
        String B = ((Structure) A2).getValue("reh");
        String C =((Structure) A3).getValue("reh");
        String D = ((Structure) A4).getValue("reh");
        String E = ((Structure) A5).getValue("reh");

        T1.setText(A);
        T2.setText(B);
        T3.setText(C);
        T4.setText(D);
        T5.setText(E);

    }
}
