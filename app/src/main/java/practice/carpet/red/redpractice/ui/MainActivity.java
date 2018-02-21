package practice.carpet.red.redpractice.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import practice.carpet.red.redpractice.R;
import practice.carpet.red.redpractice.data.model.World;
import practice.carpet.red.redpractice.data.remote.APIService;
import practice.carpet.red.redpractice.data.remote.RedOkHTTPClient;
import practice.carpet.red.redpractice.ui.adapter.PlacesAdapter;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView recyclerView;
    private PlacesAdapter placesAdapter;
    private Context context;
    private World worldData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        context = this;

        prepareData();


    }

    private void prepareData() {

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://www.androidbegin.com/tutorial/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new RedOkHTTPClient().getOkHTTPClient())
                .build();

        Log.d("Preparing","data");
        APIService apiService = retrofit.create(APIService.class);

        Observable<World> observable = apiService.getPlacesData().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(new Observer<World>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(World world) {
                Log.d("Check","size "+world.getWorld().size());

                worldData = world;
                placesAdapter = new PlacesAdapter(world, context);

                placesAdapter.setOnItemClickListener(new RecyclerViewItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("CLicked","click "+position);
                        Intent intent = new Intent(context, ImageFullScreen.class);
                        intent.putExtra("IMAGE_URL", worldData.getWorld().get(position).getFlag());
                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                });

                recyclerView.setAdapter(placesAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onClick(View view) {
        int itemPosition = recyclerView.getChildLayoutPosition(view);

    }
}
