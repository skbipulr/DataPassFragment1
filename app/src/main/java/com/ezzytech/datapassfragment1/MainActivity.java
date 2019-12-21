package com.ezzytech.datapassfragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.ezzytech.datapassfragment1.Fragments.DetailsFragment;
import com.ezzytech.datapassfragment1.Fragments.FragmentRegistration;
import com.ezzytech.datapassfragment1.interfaces.DataPassInterface;
import com.ezzytech.datapassfragment1.model.Employee;

public class MainActivity extends AppCompatActivity implements DataPassInterface {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        FragmentRegistration fragmentRegistration = new FragmentRegistration();
        ft.add(R.id.container,fragmentRegistration);
        ft.commit();

    }

    @Override
    public void dataPass(Employee employee) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        DetailsFragment detailsFragment = new DetailsFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("emp",employee);
        detailsFragment.setArguments(bundle);
        ft.replace(R.id.container,detailsFragment);
        ft.commit();
    }
}
