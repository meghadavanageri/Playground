package com.example.moviedetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<MovieDetails> mMovieDetails;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public Adapter(Context context,ArrayList<MovieDetails> movieList){
        mContext = context;
        mMovieDetails = movieList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.movie,parent,false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        MovieDetails currentItem = mMovieDetails.get(position);

        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();


        holder.mTextViewCreator.setText(creatorName);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mMovieDetails.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextViewCreator;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
