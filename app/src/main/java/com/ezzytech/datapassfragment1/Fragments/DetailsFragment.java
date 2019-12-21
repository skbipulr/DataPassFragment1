package com.ezzytech.datapassfragment1.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ezzytech.datapassfragment1.R;
import com.ezzytech.datapassfragment1.model.Employee;

public class DetailsFragment extends Fragment {

    private TextView firstNameTV ,lastNameTV, phoneTV,emailTV;
    private Context context;

    public DetailsFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_framgment,container,false);

        init(view);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Employee employee = (Employee) getArguments().getSerializable("emp");

        if (employee !=null){
            firstNameTV.setText(employee.getFirstName());
            lastNameTV.setText(employee.getLastName());
            phoneTV.setText(employee.getPhoneNo());
            emailTV.setText(employee.getEmail());
        }else {
            Toast.makeText(context, "Sorry No data found!!", Toast.LENGTH_SHORT).show();
        }

    }

    private void init(View view) {
        firstNameTV = view.findViewById(R.id.firstNameTV);
        lastNameTV = view.findViewById(R.id.lastNameTV);
        phoneTV = view.findViewById(R.id.phoneTV);
        emailTV = view.findViewById(R.id.emailTV);
    }
}
