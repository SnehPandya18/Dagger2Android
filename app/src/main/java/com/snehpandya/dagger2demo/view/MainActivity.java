package com.snehpandya.dagger2demo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.snehpandya.dagger2demo.R;
import com.snehpandya.dagger2demo.RandomUserApplication;
import com.snehpandya.dagger2demo.adapter.RandomUserAdapter;
import com.snehpandya.dagger2demo.di.component.DaggerMainActivityComponent;
import com.snehpandya.dagger2demo.di.component.MainActivityComponent;
import com.snehpandya.dagger2demo.di.module.MainActivityModule;
import com.snehpandya.dagger2demo.service.RandomUserApiResponse;
import com.snehpandya.dagger2demo.service.RandomUserService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//TODO: 01. Add dependencies in `app` level `build.gradle`
    //TODO: 02. Add INTERNET permission in `AndroidManifest.xml`

    //TODO: 18. Implement Retrofit call & MainActivityComponent

    //https://speakerdeck.com/chintansoni202/a-k-night-with-dagger

public class MainActivity extends AppCompatActivity {

    private Call<RandomUserApiResponse> mResultCall;

    private RecyclerView mRecyclerView;

    @Inject
    RandomUserService mRandomUserService;
    @Inject
    RandomUserAdapter mRandomUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .randomUserApplicationComponent(RandomUserApplication.get(this).getRandomUserApplicationComponent())
                .build();

        mainActivityComponent.injectMainActivity(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setAdapter(mRandomUserAdapter);

        mResultCall = mRandomUserService.randomUser(20);
        mResultCall.enqueue(new Callback<RandomUserApiResponse>() {
            @Override
            public void onResponse(Call<RandomUserApiResponse> call, Response<RandomUserApiResponse> response) {
                mRandomUserAdapter.setItems(response.body().getResults());
            }

            @Override
            public void onFailure(Call<RandomUserApiResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mResultCall.cancel();
    }
}
