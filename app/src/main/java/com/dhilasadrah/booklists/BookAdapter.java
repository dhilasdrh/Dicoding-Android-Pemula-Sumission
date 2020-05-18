package com.dhilasadrah.booklists;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private Context context;
    private ArrayList<Book> bookList;

    BookAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Book> getBookList() {
        return bookList;
    }

    void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_books, viewGroup, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.BookViewHolder bookViewHolder, int i) {
        Book book = getBookList().get(i);
        bookViewHolder.img_cover.setImageResource(book.getCover());
        bookViewHolder.txt_title.setText(book.getTitle());
        bookViewHolder.txt_author.setText(book.getAuthor());
        bookViewHolder.txt_totalPages.setText(book.getTotalPages());
        bookViewHolder.rating.setRating(book.getRating());
    }

    @Override
    public int getItemCount() {
        return getBookList().size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView img_cover;
        TextView txt_title, txt_author, txt_totalPages;
        RatingBar rating;

        BookViewHolder(View itemView) {
            super(itemView);
            img_cover = itemView.findViewById(R.id.cover);
            txt_title = itemView.findViewById(R.id.title);
            txt_author = itemView.findViewById(R.id.author);
            txt_totalPages = itemView.findViewById(R.id.totalPages);
            rating = itemView.findViewById(R.id.rating);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(context, BookDetails.class);
                    intent.putExtra("books", bookList.get(position));
                    context.startActivity(intent);
                }
            });
        }
    }
}
