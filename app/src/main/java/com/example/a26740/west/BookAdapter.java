package com.example.a26740.west;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> mBookList;
    LinearLayout linearLayout;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView bookName;
        public ViewHolder(View view){
            super(view);
            bookName=(TextView) view.findViewById(R.id.book_name);
        }
    }
    public BookAdapter(List<Book> bookList){
        mBookList=bookList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view =LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
        Book book = mBookList.get(position);
        holder.bookName.setText(book.getName());
        if(position %2 == 1)
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#D5F5E3"));
        }
        else
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#D4EFDF"));
        }
    }
    @Override
    public int getItemCount(){
        return mBookList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv1;
        public MyViewHolder(View view){
            super(view);
            tv1 = (TextView) itemView.findViewById(R.id.edit_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    return ;
                }
            });
        }
    }
    public void addData(int position,ViewHolder holder) {
        TextView bookName;
        notifyItemInserted(position);
    }

}
