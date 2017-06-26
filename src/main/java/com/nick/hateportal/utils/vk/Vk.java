package com.nick.hateportal.utils.vk;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Vk {
    private static final String SEC_KEY = "c5gxoDRIDhSuYbTKckS7";
    private static final String APP_ID = "6058012";
    private static final String RETURN_URL = "http://localhost:80/log/log.access";

    public static String getCodeHttp(){
        HttpClient client= HttpClientBuilder.create().build();
        StringBuilder str =new StringBuilder();
        str.append("https://oauth.vk.com/authorize?client_id="+
                APP_ID+"&display=page&redirect_uri="+RETURN_URL+"&scope=email&response_type=code&v=5.65");
        HttpGet get=new HttpGet(String.valueOf(str));
        try {
            HttpResponse httpResponse = client.execute(get);
            HttpEntity entity = httpResponse.getEntity();
            if (entity!= null){
                String data = IOUtils.toString(entity.getContent(),"cp1251");
                System.out.println("Data" + data);
            }
            for (Header header: httpResponse.getAllHeaders()){
                System.out.println(header.getName()+":"+header.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(str);
    }

    public static HashMap<String,String> finalHttp(String code) {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("client_id", APP_ID));
        nameValuePairs.add(new BasicNameValuePair("client_secret", SEC_KEY));
        nameValuePairs.add(new BasicNameValuePair("code", code));
        nameValuePairs.add(new BasicNameValuePair("redirect_uri", RETURN_URL));

        HashMap<String, String> list= new HashMap<>();

        HttpPost httpPost = new HttpPost("https://oauth.vk.com/access_token");
        try
        {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
        }
        catch (UnsupportedEncodingException e) {
            System.out.println("Fail to send request");
        }
        HttpClient client = HttpClientBuilder.create().build();
        try
        {
            HttpResponse httpResponse = client.execute(httpPost);
            JsonObject element = new JsonParser().parse(EntityUtils.toString(httpResponse.getEntity())).getAsJsonObject();
            if (httpResponse != null)
            {
                JsonElement error = element.get("error");
                if (error != null)
                {
                    System.out.println("ERROR at answer!!!");
                }

                JsonElement accessToken = element.get("access_token");
                if (accessToken != null && accessToken.isJsonPrimitive())
                {
//                    System.out.println(accessToken.getAsString());
                }
                JsonElement userId = element.get("user_id");
                if (userId != null && userId.isJsonPrimitive())
                {
                    list.putAll(getVkUserInfo(userId.toString()));
//                    System.out.println(userId.getAsString());
                }
                JsonElement email = element.get("email");
                if (userId != null && userId.isJsonPrimitive())
                {
//                    System.out.println(email.getAsString());
                    list.put("email",email.getAsString());
                }
                else
                {
                    System.out.println("Error - userid");
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public static HashMap<String,String> getVkUserInfo(String userId){
        HashMap<String,String> userInfo = new HashMap<>();

        HttpClient client= HttpClientBuilder.create().build();
        StringBuilder str =new StringBuilder();
        str.append("https://api.vk.com/method/users.get?user_id="+ userId +"&v=5.52");
        HttpGet get=new HttpGet(String.valueOf(str));

        try {
            HttpResponse httpResponse = client.execute(get);
//            HttpEntity entity = httpResponse.getEntity();
            JsonObject element = new JsonParser().parse(EntityUtils.toString(httpResponse.getEntity())).getAsJsonObject();
            if (element!=null){
                String el = element.toString();
                JSONObject obj = new JSONObject(el);
                JSONArray res = obj.getJSONArray("response");
                int n = res.length();
                for (int i = 0; i < n; ++i) {
                    JSONObject person = res.getJSONObject(i);
                    userInfo.put("first_name", person.getString("first_name"));
                    userInfo.put("last_name", person.getString("last_name"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userInfo;
    }
}
