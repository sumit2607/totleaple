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
import android.widget.TextView;

import com.example.applecount.Intetface.CommunicationListener;
import com.example.applecount.R;


public class TotalApplesFragment extends Fragment {

    private EditText etnoofapples;
    private TextView tvnoofapples;
    private Button btnnext;
    private CommunicationListener listener;
    private String tobuy;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tobuy = getArguments().getString("totaltobuy");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initviews(view);
        
        tvnoofapples.setText(tobuy);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }



    private void initviews(View view) {
        etnoofapples = view.findViewById(R.id.etNoofapples);
        tvnoofapples = view.findViewById(R.id.tvnoodapples);
        btnnext = view.findViewById(R.id.btnNext);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvnoofapples.setText(etnoofapples.getText().toString());
                int total = Integer.parseInt((etnoofapples.getText().toString()));
                Bundle bundle = new Bundle();
                bundle.putInt("quantity", total);
                if (listener != null) {
                    listener.launchbuyapplesfragment(bundle);
                }
            }
        });
    }
}