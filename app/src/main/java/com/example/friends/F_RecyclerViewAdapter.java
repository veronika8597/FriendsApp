package com.example.friends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class F_RecyclerViewAdapter extends RecyclerView.Adapter<F_RecyclerViewAdapter.MyViewHolder>{


    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList <Friends_Model> friendsModels;

    public F_RecyclerViewAdapter(Context context, ArrayList<Friends_Model> friendsModels,
                                 RecyclerViewInterface recyclerViewInterface)
    {
        this.context = context;
        this.friendsModels = friendsModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }


    // Inflates the layout (Gives a look to the rows)
    @NonNull
    @Override
    public F_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new F_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    // assigning values to the views we created in the recycler_view_row layout file based on the position
    // of the recycler view.
    @Override
    public void onBindViewHolder(@NonNull F_RecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.tvName.setText(friendsModels.get(position).getName());
        holder.tvZodiac.setText(friendsModels.get(position).getZodiac());
        holder.imageView.setImageResource(friendsModels.get(position).getImage());
    }

    // checks the number of items that we want to display.
    @Override
    public int getItemCount() {

        return friendsModels.size();
    }


    // Grabbing all the views from our recycler_view_row layout file (can be looked as an onCreate file)
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvName, tvZodiac;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface){
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.CharacterName);
            tvZodiac = itemView.findViewById(R.id.CharacterZodiac);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(recyclerViewInterface != null)
                    {
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION)
                        {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }

                }
            });
        }
    }
}
