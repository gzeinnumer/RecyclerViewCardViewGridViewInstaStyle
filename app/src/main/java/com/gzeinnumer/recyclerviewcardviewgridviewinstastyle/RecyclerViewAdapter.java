package com.gzeinnumer.recyclerviewcardviewgridviewinstastyle;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//3
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder>{

    private Context context;
    private int images[];
    private String name[];

    public RecyclerViewAdapter(Context context, int[] images, String[] name) {
        this.context = context;
        this.images = images;
        this.name = name;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_layout,null);
        MyHolder myHolder = new MyHolder(layout);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int positon) {

        myHolder.indexImage.setImageResource(images[positon]);
        myHolder.indexName.setText(name[positon]);
        myHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Card ditekan",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, TampilGambar.class);
                intent.putExtra("index",positon);
                context.startActivity(intent);
            }
        });
        myHolder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                final View inflater = layoutInflater.inflate(R.layout.popup,null);
                ImageView imageView = inflater.findViewById(R.id.imagePopup);
                imageView.setImageResource(images[positon]);
                builder.setView(inflater);
                final AlertDialog alertDialog=builder.create();

                alertDialog.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView indexImage;
        TextView indexName;
        CardView cardView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            indexImage = itemView.findViewById(R.id.images);
            indexName = itemView.findViewById(R.id.txtName);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
