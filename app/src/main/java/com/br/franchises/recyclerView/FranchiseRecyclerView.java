package com.br.franchises.recyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.CircularArray;
import androidx.recyclerview.widget.RecyclerView;
import com.br.franchises.R;
import com.br.franchises.RestaurantActivity;
import com.br.franchises.model.VO.FranchiseVO;
import com.br.franchises.model.VO.RestaurantVO;

import java.util.ArrayList;
import java.util.List;

public class FranchiseRecyclerView extends RecyclerView.Adapter<FranchiseRecyclerView.ViewHolder> implements Filterable {
    private final ArrayList<FranchiseVO> franchises;
    private final ArrayList<FranchiseVO> franchisesSearch;

    public FranchiseRecyclerView(ArrayList<FranchiseVO> dataSet) {
        this.franchises = dataSet;
        this.franchisesSearch = new ArrayList<>(this.franchises);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewDescription;
        private final ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            this.textViewName = (TextView) v.findViewById(R.id.franchiseName);
            this.textViewDescription = (TextView) v.findViewById(R.id.franchiseDescription);
            this.imageView = (ImageView)v.findViewById(R.id.franchiseImage);


            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        Intent intent = new Intent(view.getContext(), RestaurantActivity.class);
                        intent.putExtra("restaurants", franchises.get(pos).getRestaurants());
                        view.getContext().startActivity(intent);

                    }

                }
            });
        }
        public TextView getTextViewName() {
            return textViewName;
        }
        public TextView getTextViewDescription() { return textViewDescription;  }
        public ImageView getImageView() { return imageView; }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.franchise_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextViewName().setText(franchises.get(position).getName());
        viewHolder.getTextViewDescription().setText(String.valueOf(franchises.get(position).getDescription()));
        viewHolder.getImageView().setImageDrawable(viewHolder.getImageView().getContext().getDrawable(franchises.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return franchises.size();
    }

    @Override
    public Filter getFilter() {
        return franchisesFilter;
    }

    private Filter franchisesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<FranchiseVO> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(franchisesSearch);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (FranchiseVO franchise : franchises) {
                    if (franchise.getName().toLowerCase().contains(filterPattern) || franchise.getDescription().toLowerCase().contains(filterPattern)) {
                        filteredList.add(franchise);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            franchises.clear();
            franchises.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };
}
