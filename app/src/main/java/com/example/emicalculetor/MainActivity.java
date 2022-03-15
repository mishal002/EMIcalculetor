package com.example.emicalculetor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emicalculetor.R;

public class MainActivity extends AppCompatActivity {
    EditText amount_edt,inter_edt,year_edt,month_edt;
    Button calcu_btn,reset_btn,delet_btn;
    TextView ans_txt,monthly_emi,total_interest,total_payment;
    double f1_amount=0;
    double f_month=0;
    double f_amount=0;
    double f_inter=0;
    double f_year=0;
    double f1_month=0;
    double f2_month=0;
    double f_emi=0;
    double t_payment;
    private TableLayout table_tbl;
    double t_emi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //btn
        binding();
        calcu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f_amount= Double.parseDouble(amount_edt.getText().toString());
                f_inter= Double.parseDouble(inter_edt.getText().toString());
                f_year= Double.parseDouble(year_edt.getText().toString());
                f_month= Double.parseDouble(month_edt.getText().toString());
                // convert to intrest
                f1_amount=(f_amount*f_inter)/100;
                // convart to month
                f1_month=f_year*12;
                if(f_month>=12)
                {
                    f2_month=f_month;
                }
                //  sum to month
                f2_month=f1_month+f_month;
                // one month EMI
                f_emi=f1_amount/f2_month;
                //monthly emi
                t_emi= t_payment/f2_month;
                //total interest


                //total payment
                t_payment=f_amount+f1_amount;

                ans_txt.setText(""+t_emi);
                //Toast.makeText(MainActivity.this, ""+f_emi, Toast.LENGTH_SHORT).show();
            }
        });
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount_edt.setText("");
                inter_edt.setText("");
                year_edt.setText("");
                month_edt.setText("");
                ans_txt.setText("0");
                monthly_emi.setText("0");
                total_interest.setText("0");
                total_payment.setText("0");
            }
        });
        delet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table_tbl.setVisibility(View.VISIBLE);
                monthly_emi.setText(""+t_emi);
                total_interest.setText(""+f1_amount);
                total_payment.setText(""+t_payment);
            }
        });

    }

    void binding()
    {
        amount_edt=findViewById(R.id.amount_edt);
        inter_edt =findViewById(R.id.inter_edt);
        year_edt  =findViewById(R.id.year_edt);
        month_edt =findViewById(R.id.month_edt);
        calcu_btn =findViewById(R.id.calcu_btn);
        ans_txt   =findViewById(R.id.ans_txt);
        reset_btn =findViewById(R.id.reset_btn);
        delet_btn =findViewById(R.id.delet_btn);
        monthly_emi=findViewById(R.id.monthly_emi);
        total_interest=findViewById(R.id.total_interest);
        total_payment=findViewById(R.id.total_payment);
        table_tbl=findViewById(R.id.table_tbl);
    }
}
