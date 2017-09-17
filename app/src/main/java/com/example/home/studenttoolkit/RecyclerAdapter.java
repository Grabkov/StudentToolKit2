package com.example.home.studenttoolkit;

/**
 * Created by Shade on 5/9/2016.
 */

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] titles = {"КИМ АЛЕКСЕЙ ХЫСИКОВИЧ",
            "ТЯН ВЯЧЕСЛАВ ГВОНДЯЕВИЧ",
            "ЧЕХОНИНА СВЕТЛАНА АРСЕНТЬЕВНА",
            "КИЧИГИН ЕВГЕНИЙ ФЕДОРОВИЧ",
            "КОСВИНЦЕВА АННА АЛЕКСАНДРОВНА",
            "ЧЕРНЯНСКАЯ НАТАЛЬЯ ВЛАДИМИРОВНА",
            "ИЩАК АЛЕКСАНДРА АНДРЕЕВНА",
            "ТАБУНЩИК НАТАЛЬЯ ВИКТОРОВНА"};

    private String[] details = {"Архитектура Аппаратных Средств",
            "МДК и ТСИ", "Информатика",
            "Английский Язык (1гр.)", "Английский Язык(2гр.)",
            "Математика", "$BIGRUSSIANBOSS$",
            "Физическая культура"};

    private int[] images = { R.drawable.kim,
            R.drawable.tyan,
            R.drawable.chehonina,
            R.drawable.kichigin,
            R.drawable.kosvinceva,
            R.drawable.chernyanskaya,
            R.drawable.ishak,
            R.drawable.tabunshik };

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail =
                    (TextView)itemView.findViewById(R.id.item_detail);

            //Действие при нажатии на карточку
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });*/
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}