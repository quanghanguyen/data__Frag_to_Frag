package com.example.fragtofrag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.ISendDataListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Để add fragment vào 1 activity thì sử dụng FragmentTranscasion

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fameLayout1, new Fragment1());
        fragmentTransaction.add(R.id.fameLayout2, new Fragment2());
        fragmentTransaction.commit();

    }

    @Override
    public void sendData(String email) {
            Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fameLayout2);
            fragment2.receiveDataFromFragment1(email);
    }
}