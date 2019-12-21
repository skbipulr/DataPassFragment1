package com.ezzytech.datapassfragment1.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ezzytech.datapassfragment1.R;
import com.ezzytech.datapassfragment1.interfaces.DataPassInterface;
import com.ezzytech.datapassfragment1.model.Employee;
import com.google.android.material.textfield.TextInputEditText;

public class FragmentRegistration extends Fragment {

    private TextInputEditText firstNameET, lastNameET, phoneET, emailET;
    private Button submitBtn;
    private Context context;
    private DataPassInterface dataPassInterface;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        dataPassInterface = (DataPassInterface) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        init(view);

        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameET.getText().toString();
                String lastName = lastNameET.getText().toString();
                String phone = phoneET.getText().toString();
                String email = emailET.getText().toString();

                Employee employee = new Employee(firstName, lastName, phone, email);
                dataPassInterface.dataPass(employee);

            }
        });
    }

    private void init(View view) {
        firstNameET = view.findViewById(R.id.firstNameET);
        lastNameET = view.findViewById(R.id.lastNameET);
        phoneET = view.findViewById(R.id.phoneET);
        emailET = view.findViewById(R.id.emailET);
        submitBtn = view.findViewById(R.id.submitBtn);
    }
}
