package com.nick.hateportal.utils;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

import static jdk.nashorn.internal.codegen.types.Type.SCOPE;

public class Vk {
    public void test() throws IOException {
        int APP_ID = 6058012;
        String REDIR_URI = "/";
        HttpClient client= HttpClientBuilder.create().build();
        StringBuilder request =new StringBuilder();
        request.append("https://oauth.vk.com/authorize?client_id=").append(APP_ID).
                append("&display=page&redirect_uri=").append(REDIR_URI).append("&scope=").
                append(SCOPE).append("&response_type=token&v=5.45");
        HttpGet get=new HttpGet(request.toString());
        HttpResponse resp=client.execute(get);
        System.out.println(resp.getFirstHeader("Location").getValue());
        System.out.println(resp.toString());
        System.out.println(request.toString());
    }
    }
