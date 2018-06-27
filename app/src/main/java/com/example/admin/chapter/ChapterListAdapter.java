package com.example.admin.chapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ChapterListAdapter extends RecyclerView.Adapter<ChapterListAdapter.ChapterViewHolder> {

    class ChapterViewHolder extends RecyclerView.ViewHolder {
        private final TextView chapterItemView;

        private ChapterViewHolder(View itemView) {
            super(itemView);
            chapterItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Chapter> chapterList; // Cached copy of words

    ChapterListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public ChapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ChapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChapterViewHolder holder, int position) {
        if (chapterList != null) {
            Chapter current = chapterList.get(position);
//            holder.chapterItemView.setText(current.id);
           holder.chapterItemView.setText(current.title);
           holder.chapterItemView.setText(current.notion);
        } else {
            // Covers the case of data not being ready yet.
            holder.chapterItemView.setText("No Word");
        }
    }

    void setChapter(List<Chapter> words){
        chapterList = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (chapterList != null)
            return chapterList.size();
        else return 0;
    }
}
