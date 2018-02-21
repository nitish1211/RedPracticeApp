package practice.carpet.red.redpractice.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import practice.carpet.red.redpractice.R;
import practice.carpet.red.redpractice.data.model.World;
import practice.carpet.red.redpractice.ui.RecyclerViewItemClickListener;

/**
 * Created by nitish on 19/2/18.
 */

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.MyViewHolder> {

    private World world;
    private Context context;
    private RecyclerViewItemClickListener recyclerViewItemClickListener;
    public PlacesAdapter(World world, Context context) {
        this.world = world;
        this.context = context;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView population;
        public TextView country;
        public int position;


        public MyViewHolder(final View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            population = itemView.findViewById(R.id.population);
            country = itemView.findViewById(R.id.country);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewItemClickListener.onItemClick(itemView,position);
                }
            });
        }
    }

    public void setOnItemClickListener(RecyclerViewItemClickListener recyclerViewItemClickListener){
        this.recyclerViewItemClickListener=recyclerViewItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.place_element, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d("Test","hmm bind view");

        holder.position = position;
        Picasso.with(context).load(world.getWorld().get(position).getFlag()).into(holder.image);
        Log.d("Image loading","Image url "+world.getWorld().get(position).getFlag());
        holder.country.setText(world.getWorld().get(position).getCountry());
        holder.population.setText(world.getWorld().get(position).getPopulation());
    }


    @Override
    public int getItemCount() {
        return world.getWorld().size();
    }

}
