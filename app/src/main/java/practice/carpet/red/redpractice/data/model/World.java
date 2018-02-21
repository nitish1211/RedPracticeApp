package practice.carpet.red.redpractice.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.Url;

/**
 * Created by nitish on 19/2/18.
 */
public class World{

    @SerializedName("worldpopulation")
    @Expose
    private List<Places> world;

    public List<Places> getWorld() {
        return world;
    }

    public void setWorld(List<Places> world) {
        this.world = world;
    }

    public class Places {
        @SerializedName("rank")
        @Expose
        private  int rank;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("population")
        @Expose
        private String population;
        @SerializedName("flag")
        @Expose
        private String flag;

        public Places(int rank, String country, String population, String flag) {
            this.rank = rank;
            this.country = country;
            this.population = population;
            this.flag = flag;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPopulation() {
            return population;
        }

        public void setPopulation(String population) {
            this.population = population;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }
    }


}
