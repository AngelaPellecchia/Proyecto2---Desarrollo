package com.example.proyecto2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_principal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_principal extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText et1,et2;
    Button btn1,btn2;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_principal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_principal.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_principal newInstance(String param1, String param2) {
        fragment_principal fragment = new fragment_principal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_principal, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et1= view.findViewById(R.id.et1);
        et2=view.findViewById(R.id.et2);
        btn1=view.findViewById(R.id.btn1);
        btn2=view.findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle1 =new Bundle();
                Bundle bundle2 =new Bundle();
                bundle1.putString("nombre",et1.getText().toString().trim());
                bundle2.putString("apellido",et2.getText().toString().trim());
                getParentFragmentManager().setFragmentResult("key1",bundle1);
                getParentFragmentManager().setFragmentResult("key2",bundle2);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText("");
                et2.setText("");
            }
        });
    }
}