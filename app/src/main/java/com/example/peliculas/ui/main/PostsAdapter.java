package com.example.peliculas.ui.main;

import static com.nostra13.universalimageloader.core.ImageLoader.TAG;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peliculas.R;
import com.example.peliculas.pojo.PostModel;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import com.bumptech.glide.Glide;




public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder>  {
    private List<PostModel> moviesList = new ArrayList<>();





    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {


        holder.titleTV.setText(moviesList.get(position).getName());
        holder.userTV.setText(moviesList.get(position).getId()+"");
        holder.releaseTV.setText(moviesList.get(position).getRelease());
        holder.descriptionTV.setText(moviesList.get(position).getDescription());
        holder.playTimeTV.setText(moviesList.get(position).getPlaytime());
        holder.plotTV.setText(moviesList.get(position).getPlot());


        ImageView imageView = holder.bodyTv;




        if (holder.itemView.getContext() != null ) {
            Glide.with(holder.itemView.getContext())
                    .load(moviesList.get(position).getPoster())
                    .into(imageView);
        } else {
            Log.i(TAG, "Picture loading failed,context is null");
        }
        holder.setOnclickListeners();

    }




    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void setList(List<PostModel> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }



    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTV, userTV, releaseTV, descriptionTV, playTimeTV, plotTV, Elemento;
        ImageView bodyTv;
        Context context;



        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            context=itemView.getContext();
            titleTV = itemView.findViewById(R.id.titleTV);
            Elemento=itemView.findViewById(R.id.eliminarElemento);
            userTV = itemView.findViewById(R.id.userIDTV);
            userTV.setVisibility(View.GONE);
            bodyTv = itemView.findViewById(R.id.bodyTV);
            releaseTV = itemView.findViewById(R.id.release);
            releaseTV.setVisibility(View.GONE);
            plotTV = itemView.findViewById(R.id.plot);

            playTimeTV=itemView.findViewById(R.id.playTime);
            playTimeTV.setVisibility(View.GONE);
            descriptionTV = itemView.findViewById(R.id.Description);
            descriptionTV.setVisibility(View.GONE);


            Elemento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int pos=-1;
                    for(int i=0; i<moviesList.size();i++){

                        if(moviesList.get(i).getName().equals(titleTV.getText().toString()))
                            pos=i;

                    }
                    if(pos!=1){

                        moviesList.remove(pos);
                        titleTV.setText("");
                        notifyDataSetChanged();
                        Toast.makeText(v.getContext(), "Se ha eliminado el elemento", Toast.LENGTH_LONG).show();

                    }


                }
            });




        }


        public void setOnclickListeners() {
            bodyTv.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            Intent intent=new Intent(context, DetailsActivity.class);
            intent.putExtra("titleTV", titleTV.getText());
            intent.putExtra("releaseTV", releaseTV.getText());
            intent.putExtra("descriptionTV", descriptionTV.getText());
            intent.putExtra("playTimeTV", playTimeTV.getText());

            context.startActivity(intent);

        }


    }


}
