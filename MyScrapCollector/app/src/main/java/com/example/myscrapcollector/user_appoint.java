package com.example.myscrapcollector;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link user_appoint#newInstance} factory method to
 * create an instance of this fragment.
 */
public class user_appoint extends Fragment implements View.OnClickListener {
    EditText text_n,text_lo,text_em,text_cnt,editText_date;
DatePickerDialog datePickerDialog;
//DatePicker datePicker;
    Button btn_sub;
    UDBHelper udbHelper;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public user_appoint() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment user_appoint.
     */
    // TODO: Rename and change types and number of parameters
    public static user_appoint newInstance(String param1, String param2) {
        user_appoint fragment = new user_appoint();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_user_appoint, container, false);
        text_n = view.findViewById(R.id.ap_name);
        text_lo = view.findViewById(R.id.ap_loc);
        text_em = view.findViewById(R.id.ap_email);
        text_cnt = view.findViewById(R.id.ap_no);
        editText_date = view.findViewById(R.id.ap_dateed);
      //  datePicker = view.findViewById(R.id.ap_date);
        btn_sub=view.findViewById(R.id.ap_btn);
        btn_sub.setOnClickListener(this);
udbHelper = new UDBHelper(getContext());
        final  Calendar calendar = Calendar.getInstance();
        final  int day = calendar.get(Calendar.DAY_OF_MONTH);
        final  int year = calendar.get(Calendar.YEAR);
        final  int month = calendar.get(Calendar.MONTH);
        editText_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        editText_date.setText(i2+"/"+(i1+1)+"/"+i);

                    }},year,month,day);
                datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
                datePickerDialog.show();
            }
        });

        return view;
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
    public void onClick(View view) {
        CheckEnterData();
        boolean check = udbHelper.insert_pickup(text_n.getText().toString(),text_lo.getText().toString(),text_em.getText().toString(),text_cnt.getText().toString(),editText_date.getText().toString());
        if(check == true)
        {

            Dialog alert = new Dialog(getContext());
            alert.setTitle("Confirmed");
            View view1 = getActivity().getLayoutInflater().inflate(R.layout.c_dialog,null);
            alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alert.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            alert.setContentView(view1);
            Button button = view1.findViewById(R.id.b_btn);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(),userhome.class);
                    startActivity(intent);
                }
            });
            alert.show();

        }
//        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
//        alert.setTitle("Alert");
      //  String dates= datePicker.getDayOfMonth()+"-"+datePicker.getMonth()+"-"+datePicker.getYear();

//        alert.setMessage(text_n.getText().toString()
//                        +"\n"+text_lo.getText().toString()
//                        +"\n"+text_em.getText().toString()
//                        +"\n"+text_cnt.getText().toString()
//                        +"\n"+editText_date.getText().toString()
//
//                        );
//        alert.setIcon(R.drawable.ic_baseline_add_alert_24);
//        alert.show();
      //  Toast.makeText(getContext(), ""+text_n.getText().toString(), Toast.LENGTH_SHORT).show();
    }
    public  boolean boxisEmpty(EditText text)
    {
        CharSequence str = text.getText().toString();
        return (!TextUtils.isEmpty(str));

    }
    public  void  CheckEnterData() //define
    {
        if (boxisEmpty(text_n) == false) {
            text_n.setError("Name is Required");

        }
        if (boxisEmpty(text_lo) == false) {
            text_lo.setError("Location is Required");


        }
        if (boxisEmpty(text_em) == false) {
            text_em.setError("Email is Required");


        }
        if (boxisEmpty(text_cnt) == false) {
            text_cnt.setError("Contact is Required");


        }
        if (boxisEmpty(editText_date) == false) {
            editText_date.setError("Date is Required");


        }


    }

}