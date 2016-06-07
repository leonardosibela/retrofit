package com.sibela.examples.retrofit.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sibela.examples.retrofit.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.StringViewHolder> {

    List items = new ArrayList();

    @LayoutRes
    private int layoutId;

    public StringAdapter(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public StringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new StringViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StringViewHolder holder, int position) {
        Object item = items.get(position);
        holder.itemText.setText(item.toString());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public static class StringViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.item_text)
        TextView itemText;

        public StringViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
