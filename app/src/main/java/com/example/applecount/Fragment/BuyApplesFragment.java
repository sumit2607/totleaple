package com.example.applecount.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applecount.Intetface.CommunicationListener;
import com.example.applecount.R;


public class BuyApplesFragment extends Fragment {

    private EditText ettobuyapples;
    private Button btnback;
    private CommunicationListener listener;
    private int age;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            age = (int) getArguments().get("quantity");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initviews(view);
        change();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Bundle bundle = new Bundle();
        String data = ettobuyapples.getText().toString();
        bundle.putString("totaltobuy", data);
    }

    private void initviews(View view) {
        ettobuyapples = view.findViewById(R.id.ettobuyapples);
        btnback = view.findViewById(R.id.btnback);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int check1 = Integer.parseInt(ettobuyapples.getText().toString());
                if (check1 < age) {
                    Bundle bundle = new Bundle();
                    int check = Integer.parseInt(ettobuyapples.getText().toString());
                    int remaning = age - check;
                    String data = String.valueOf(remaning);
                    bundle.putString("totaltobuy", data);
                    listener.launchTotalNoOfApplesFragment(bundle);
                } else {
                    Toast.makeText(getActivity(), "Please check the qunantity", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    public void change() {

    }
}