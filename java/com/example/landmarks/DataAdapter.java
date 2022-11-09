package com.example.landmarks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private Context context;
    private int rowID;
    private String [] names;
    private String[] countries;
    private String [] regions;
    private String [] urls;
    private String[] extra;
    private final String[] icons;

    public DataAdapter(Context context, int rowID, String[] names, String[] countries, String[] regions, String[] urls, String[] extra, String[] icons) {
        this.context = context;
        this.rowID = rowID;
        this.names = names;
        this.countries = countries;
        this.regions = regions;
        this.urls = urls;
        this.extra = extra;
        this.icons = icons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout and return the data tree view
        View v = LayoutInflater.from(this.context).inflate(this.rowID, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //populate / bind the viewholder fields with data

        holder.subtitle.setText(countries[position]);
        holder.name.setText(names[position]);
        int iconId = 0;
        switch(position) {
            case 0:
                holder.icon.setImageResource(R.drawable.pyramid);
                iconId = R.drawable.pyramid;
                break;
            case 1:
                holder.icon.setImageResource(R.drawable.newgrange);
                iconId = R.drawable.newgrange;
                break;
            case 2:
                holder.icon.setImageResource(R.drawable.christ);
                iconId = R.drawable.christ;
                break;
            case 3:
                holder.icon.setImageResource(R.drawable.china);
                iconId = R.drawable.china;
                break;
            case 4:
                holder.icon.setImageResource(R.drawable.eiffel);
                iconId = R.drawable.eiffel;
                break;
            case 5:
                holder.icon.setImageResource(R.drawable.wat);
                iconId = R.drawable.wat;
                break;
            case 6:
                holder.icon.setImageResource(R.drawable.chichen);
                iconId = R.drawable.chichen;
                break;
            case 7:
                holder.icon.setImageResource(R.drawable.moscow);
                iconId = R.drawable.moscow;
                break;
            case 8:
                holder.icon.setImageResource(R.drawable.liberty);
                iconId = R.drawable.liberty;
                break;
            case 9:
                holder.icon.setImageResource(R.drawable.piza);
                iconId = R.drawable.piza;
                break;
            case 10:
                holder.icon.setImageResource(R.drawable.nazca);
                iconId = R.drawable.nazca;
                break;
                case 11:
                holder.icon.setImageResource(R.drawable.reef);
                    iconId = R.drawable.reef;
                break;
            case 12:
                holder.icon.setImageResource(R.drawable.taj);
                iconId = R.drawable.taj;
                break;
        }

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do somthing with names[position]
                try {
                    Intent intent = new Intent(context, InfoActivity.class);
                    intent.putExtra("name", names[position]);
                    intent.putExtra("country", countries[position]);
                    intent.putExtra("region", regions[position]);
                    intent.putExtra("url", urls[position]);
                    intent.putExtra("extra", extra[position]);
                    context.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return names.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView subtitle;
        public ImageView icon;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.textView5);
            this.icon = itemView.findViewById(R.id.imageView);
            this.subtitle = itemView.findViewById(R.id.subTitle);
        }

    }

    public int getLength() {
        return names.length;
    }

}
