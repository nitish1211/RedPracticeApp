package practice.carpet.red.redpractice.data.remote;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by nitish on 21/2/18.
 */

public class RedOkHTTPClient {

    public OkHttpClient getOkHTTPClient(){

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        //Enable Full Body Logging
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);

        //Interceptor :> Full Body Logger
        builder.addInterceptor(logger);

        return builder.build();

    }
}
