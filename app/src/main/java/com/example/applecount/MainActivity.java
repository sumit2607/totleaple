package com.example.applecount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.applecount.Fragment.BuyApplesFragment;
import com.example.applecount.Fragment.TotalApplesFragment;
import com.example.applecount.Intetface.CommunicationListener;

public class MainActivity extends AppCompatActivity implements CommunicationListener {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchTotalNoOfApplesFragment();
    }

    private void launchTotalNoOfApplesFragment() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TotalApplesFragment totalApplesFragment = new TotalApplesFragment();
        fragmentTransaction.add(R.id.flcontainer, totalApplesFragment, "TotalApples").addToBackStack("TotalApples").commit();
    }

    @Override
    public void launchbuyapplesfragment(Bundle bundle) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BuyApplesFragment buyApplesFragment = new BuyApplesFragment();
        buyApplesFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.flcontainer, buyApplesFragment, "Buyapples").addToBackStack("buyapples").commit();

    }

    @Override
    public void launchTotalNoOfApplesFragment(Bundle bundle) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TotalApplesFragment totalApplesFragment = new TotalApplesFragment();
        totalApplesFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.flcontainer, totalApplesFragment, "TotalApples").addToBackStack("TotalApples").commit();
        

    }
}