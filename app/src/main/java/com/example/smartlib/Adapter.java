package com.example.smartlib;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<PinjamClass> pinjamClassArrayList;
    Context context;

    public Adapter(ArrayList<PinjamClass> pinjamClassArrayList, Context context) {

        this.pinjamClassArrayList = pinjamClassArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PinjamClass pinjamClass = pinjamClassArrayList.get(position);
        int idBuku = pinjamClass.getIdBuku();
        holder.title.setText(pinjamClass.getNamaBuku());
        holder.author.setText(pinjamClass.getPenulis());
        holder.ratings.setText(pinjamClass.getTahun());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                switch (idBuku){
                    case (1) :
                        intent =  new Intent(context, BookRead1.class);
                        break;
                    case (2) :
                        intent =  new Intent(context, BookRead2.class);
                        break;
                    case (3) :
                        intent =  new Intent(context, BookRead3.class);
                        break;
                    case (4) :
                        intent =  new Intent(context, BookRead4.class);
                        break;
                    case (5) :
                        intent =  new Intent(context, BookRead5.class);
                        break;
                    case (6) :
                        intent =  new Intent(context, BookRead6.class);
                        break;
                    case (7) :
                        intent =  new Intent(context, JournalRead1.class);
                        break;
                    case (8) :
                        intent =  new Intent(context, JournalRead2.class);
                        break;
                    case (9) :
                        intent =  new Intent(context, JournalRead3.class);
                        break;
                    case (10) :
                        intent =  new Intent(context, JournalRead4.class);
                        break;
                    case (11) :
                        intent =  new Intent(context, JournalRead5.class);
                        break;
                }
                context.startActivity(intent);
            }

        });



        if(idBuku==1){
            holder.gmbrBuku.setImageResource(R.drawable.image1);
        }else if(idBuku==2){
            holder.gmbrBuku.setImageResource(R.drawable.image2);
        }else if(idBuku==3){
            holder.gmbrBuku.setImageResource(R.drawable.image3);
        }else if(idBuku==4){
            holder.gmbrBuku.setImageResource(R.drawable.image4);
        }else if(idBuku==5){
            holder.gmbrBuku.setImageResource(R.drawable.image5);
        }else if(idBuku==6){
            holder.gmbrBuku.setImageResource(R.drawable.image6);
        }else if(idBuku==7) {
            holder.gmbrBuku.setImageResource(R.drawable.image12);
        }else if(idBuku==8){
            holder.gmbrBuku.setImageResource(R.drawable.image10);
        }else if(idBuku==9){
            holder.gmbrBuku.setImageResource(R.drawable.image7);
        }else if(idBuku==10){
            holder.gmbrBuku.setImageResource(R.drawable.image8);
        }else if(idBuku==11){
            holder.gmbrBuku.setImageResource(R.drawable.image9);
        }
    }

    @Override
    public int getItemCount() {
        return pinjamClassArrayList.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    TextView title, author, ratings;
    private Adapter adapter;
    ImageView gmbrBuku;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        author = itemView.findViewById(R.id.author);
        ratings = itemView.findViewById(R.id.ratings);
        gmbrBuku = itemView.findViewById(R.id.gmbrBuku);
    }


}