package com.br.franchises.recyclerView;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.br.franchises.R;
import com.br.franchises.model.VO.RestaurantVO;

import java.util.ArrayList;

public class RestaurantRecyclerView extends RecyclerView.Adapter<RestaurantRecyclerView.ViewHolder> {
    private ArrayList<RestaurantVO> restaurants;

    public RestaurantRecyclerView(ArrayList<RestaurantVO> dataSet) {
        this.restaurants = dataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewCity;
        private final TextView textViewAddress;
        private final ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            this.textViewName = (TextView) v.findViewById(R.id.restaurantName);
            this.textViewCity = (TextView) v.findViewById(R.id.restaurantCity);
            this.textViewAddress = (TextView) v.findViewById(R.id.restaurantAddress);
            this.imageView = (ImageView)v.findViewById(R.id.image);
        }
        public TextView getTextViewName() {
            return textViewName;
        }
        public TextView getTextViewCity() { return textViewCity;  }
        public TextView getTextViewAddress() { return textViewAddress;  }
        public ImageView getImageView() { return imageView; }
    }

    @Override
    public RestaurantRecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurant_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(RestaurantRecyclerView.ViewHolder viewHolder, final int position) {
        viewHolder.getTextViewName().setText(restaurants.get(position).getName());
        viewHolder.getTextViewAddress().setText(String.valueOf(restaurants.get(position).getAddress()));
        viewHolder.getTextViewCity().setText(String.valueOf(restaurants.get(position).getCity()));
        viewHolder.getImageView().setImageDrawable(viewHolder.getImageView().getContext().getDrawable(restaurants.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }
}
