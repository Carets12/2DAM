package com.example.matinal.userretrofit.data.remote;

/**
 * Created by matinal on 18/01/2018.
 */

public class ApiUtils {

    public static final String BASE_URL = "http://192.168.16.124:3000/";//"https://192.168.17.183:3000/"

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
