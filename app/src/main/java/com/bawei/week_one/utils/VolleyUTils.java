package com.bawei.week_one.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.week_one.apis.App;

import java.util.Map;

/**
 * author: 张奥
 * data: 2019-09-29
 * function:
 */
public class VolleyUTils  {

    private  static VolleyUTils volleyUTils;
    private  RequestQueue requestQueue;

    private VolleyUTils (){
        requestQueue = Volley.newRequestQueue( App.getContext() );
    }

    public static VolleyUTils getInstance() {
        if (volleyUTils != null) {
            synchronized (VolleyUTils.class){
                if (volleyUTils != null) {
                    volleyUTils = new VolleyUTils();
                }
            }
        }
        return volleyUTils;
    }

    public interface VollCallback{
        void getSuccess(String dates);
        void getError(Throwable throwable);
    }
    public void doGet(String url, final VollCallback vollCallback){
        StringRequest stringRequest = new StringRequest( url, new Response.Listener <String>() {
            @Override
            public void onResponse(String response) {
                 vollCallback.getSuccess( response );
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             vollCallback.getError( error );
            }
        } );
        requestQueue.add( stringRequest );
    }
    public void doPost(String url, final Map<String,String> parms, final VollCallback vollCallback){
        StringRequest stringRequest = new StringRequest( url, new Response.Listener <String>() {
            @Override
            public void onResponse(String response) {
                vollCallback.getSuccess( response );
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                vollCallback.getError( error );
            }
        } ){

            @Override
            protected Map <String, String> getParams() throws AuthFailureError {
                return parms;
            }
        };
        requestQueue.add( stringRequest );
    }

}
