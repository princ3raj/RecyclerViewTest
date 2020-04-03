package com.example.recyclerviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>

{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageName=new ArrayList<>();

    private ArrayList<String> mImages= new ArrayList<>();

    private Context mContext;

    public RecyclerViewAdapter(Context context,ArrayList<String> imageName, ArrayList<String> images)
    {
        mImageName = imageName;
        mImages = images;
        mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.mCircleImageView);

        holder.mImageLocation.setText(mImageName.get(position));

        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, mImageName.get(position), Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    public int getItemCount() {
        return mImageName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView mCircleImageView;
        TextView mImageLocation;
        RelativeLayout mRelativeLayout;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mCircleImageView=itemView.findViewById(R.id.image);
            mImageLocation=itemView.findViewById(R.id.image_location);
            mRelativeLayout=itemView.findViewById(R.id.relative_layout);

        }
    }
}
