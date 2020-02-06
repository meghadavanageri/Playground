package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewexample.R;

import java.util.Date;
import java.util.List;

import Model.ListItem;

public class MyAdapter extends	RecyclerView.Adapter<MyAdapter.ViewHolder>	 {

    private	Context	context;
    private	List<ListItem> listItems;

    public MyAdapter(Context context, List<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return	new	ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        ListItem	item	=	listItems.get(position);

        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());

    }

    @Override
    public int getItemCount() {
        return	listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public	TextView	title;
        public TextView description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.titleID);
            description	= (TextView)itemView.findViewById(R.id.descriptionID);
        }
    }
}
