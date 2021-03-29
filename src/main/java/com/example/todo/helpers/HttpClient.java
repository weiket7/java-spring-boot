package com.example.todo.helpers;

import com.example.todo.exceptions.ApiException;
import com.example.todo.models.Todo;
import lombok.SneakyThrows;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HttpClient {

    @Autowired
    private JsonHelper jsonHelper;

    private final OkHttpClient client = new OkHttpClient.Builder()
            //.addInterceptor(new HttpLoggingInterceptor())
            //.cache(new Cache(cacheDir, cacheSize))
            .build();

    @SneakyThrows
    public <T> T get(String url, Class<T> target) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        if(response.isSuccessful() == false) {
            throw new ApiException();
        }
        if(response.body() == null) {
            throw new ApiException();
        }
        return jsonHelper.Serialize(response.body().string(), target);

    }
}
