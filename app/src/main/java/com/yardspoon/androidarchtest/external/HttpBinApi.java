package com.yardspoon.androidarchtest.external;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HttpBinApi {
    @GET("ip")
    Observable<IpResponse> ip();

    @GET("delay/{seconds}")
    Observable<IpResponse> delay(@Path("seconds") int seconds);

    class IpResponse {
        public String origin;
    }
}
