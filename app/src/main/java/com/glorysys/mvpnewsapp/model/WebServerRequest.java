package com.glorysys.mvpnewsapp.model;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.glorysys.mvpnewsapp.contract.NewsContract;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebServerRequest  {
    private final static String BaseURL="https://newsapi.org/v2/everything?q=Apple&from=2021-07-21&sortBy=popularity&";
    private final static String ApiKey="apiKey=4f26d4bcf70142f7acae55212c487482";
    private static final String TAG = "WebServer";
    private Context Context;

    public WebServerRequest(android.content.Context context) {
        Context = context;

    }

    public void onWebServerRequest(NewsContract.IgetNewsFromServer igetNewsFromServer) {
        List<ObjNews> objNewsList=new ArrayList<>();

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, BaseURL + ApiKey, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray=response.getJSONArray("articles");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                    ObjNews objNews=new ObjNews();
                                    JSONObject jsonObject1=jsonObject.getJSONObject("source");
                                    objNews.setNewsSource(jsonObject1.getString("name"));
                                    objNews.setNewsTitle(jsonObject.getString("title"));
                                    objNews.setNewsDescription(jsonObject.getString("description"));
                                    objNews.setNewsAuthor(jsonObject.getString("author"));
                                    objNews.setNewsImage(jsonObject.getString("urlToImage"));
                                    objNews.setNewsTime(jsonObject.getString("publishedAt"));

                                    objNewsList.add(objNews);
                                    Log.i(TAG, "onResponse: "+objNewsList.get(i).getNewsSource());
                                }

                           igetNewsFromServer.onGetNewsSuccess(objNewsList);





                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
        igetNewsFromServer.onGetNewsError();





            }
        }){


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("User-Agent", "Mozilla/5.0");
                return headers;
        }};



RequestQueueContainer.getInstance(Context).add(jsonObjectRequest);


    }

}
