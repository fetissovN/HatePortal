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
        String secKey = "c5gxoDRIDhSuYbTKckS7";
        String appId = "6058012";
        String REDIR_URI = "/";
        HttpClient client= HttpClientBuilder.create().build();
        StringBuilder request =new StringBuilder();
        request.append("https://oauth.vk.com/authorize?client_id="+appId+"&display=page&redirect_uri="
                +REDIR_URI+"&scope=email&response_type=code&v=5.65");
        HttpGet get=new HttpGet(request.toString());
        client.execute(get);

        }
    }
