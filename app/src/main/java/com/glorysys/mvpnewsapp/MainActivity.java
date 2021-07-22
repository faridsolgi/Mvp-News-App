package com.glorysys.mvpnewsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.glorysys.mvpnewsapp.view.ShowNewsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=this.getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        ShowNewsFragment showNewsFragment=new ShowNewsFragment();
        transaction.add(R.id.cl_mainActivity_clFragment,showNewsFragment).commit();



    }
}
