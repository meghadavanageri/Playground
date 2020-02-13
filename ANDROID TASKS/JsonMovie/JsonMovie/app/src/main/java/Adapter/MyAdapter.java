package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carmel.jsonmovie.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Model.ExampleItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mcontext;
    private ArrayList<ExampleItem> mExampleItem;

    public MyAdapter(Context mcontext, ArrayList<ExampleItem> mExampleItem) {
        this.mcontext = mcontext;
        this.mExampleItem = mExampleItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExampleItem currentItem = mExampleItem.get(position);

        String mimageview = currentItem.getMimageview();
        String mtextview = currentItem.getMtextview();

        holder.mtextview.setText(mtextview);
        Picasso.with(mcontext).load(mimageview).fit().centerInside().into(holder.mimageview);


    }

    @Override
    public int getItemCount() {
        return mExampleItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mimageview;
        public TextView mtextview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mimageview = itemView.findViewById(R.id.imageView);
            mtextview = itemView.findViewById(R.id.textView);
        }
    }
}
