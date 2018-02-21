package practice.carpet.red.redpractice.data.remote;

import java.util.List;

import io.reactivex.Observable;
import practice.carpet.red.redpractice.data.model.World;
import retrofit2.http.GET;

/**
 * Created by nitish on 20/2/18.
 */

public interface APIService {

    @GET("jsonparsetutorial.txt")
    Observable<World> getPlacesData();
}
