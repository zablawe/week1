package com.bawei.zhangjiafu1707b20191225.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.zhangjiafu1707b20191225.app.App;

import java.util.Map;

/**
 * @author: 张家辅
 * @date: 2019/12/25
 */
public class VolleyUtils {
    private static VolleyUtils volleyUtils;
    private final RequestQueue requestQueue;
    // 二次封装Volley，封装get和post请求
    public VolleyUtils() {
        requestQueue = Volley.newRequestQueue(App.getContext());
    }

    public static VolleyUtils getInstance() {
        if(volleyUtils==null){
            synchronized (VolleyUtils.class){
                volleyUtils=new VolleyUtils();
            }
        }
        return volleyUtils;
    }
    public void doGet(String URL, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error);
            }
        });
        requestQueue.add(stringRequest);
    }
    public void doPost(String URL, final Map<String,String> map, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }
    public interface CallBack{
        void success(String string);
        void error(Throwable throwable);
    }
}
