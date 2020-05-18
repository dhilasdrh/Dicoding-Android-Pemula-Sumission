package com.dhilasadrah.booklists;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] title, releaseDate, author, publisher, totalPages, ISBN, overview, rating, totalVote;
    TypedArray cover, backdrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvBook = findViewById(R.id.rv_books);
        rvBook.setLayoutManager(new LinearLayoutManager(this));

        cover = getResources().obtainTypedArray(R.array.cover);
        backdrop = getResources().obtainTypedArray(R.array.cover);
        title = getResources().getStringArray(R.array.title);
        releaseDate = getResources().getStringArray(R.array.releaseDate);
        author = getResources().getStringArray(R.array.author);
        totalPages = getResources().getStringArray(R.array.totalPages);
        publisher = getResources().getStringArray(R.array.publisher);
        overview = getResources().getStringArray(R.array.overview);
        ISBN = getResources().getStringArray(R.array.ISBN);
        rating = getResources().getStringArray(R.array.rating);
        totalVote = getResources().getStringArray(R.array.totalVotes);

        ArrayList<Book> bookList = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            Book book = new Book();
            book.setCover(cover.getResourceId(i, -1));
            book.setBackdrop(cover.getResourceId(i, -1));
            book.setTitle(title[i]);
            book.setReleaseDate(releaseDate[i]);
            book.setAuthor(author[i]);
            book.setPublisher(publisher[i]);
            book.setTotalPages(totalPages[i]);
            book.setRating(Float.valueOf(rating[i]));
            book.setISBN(ISBN[i]);
            book.setOverview(overview[i]);
            book.setTotalVote(totalVote[i]);
            bookList.add(book);
        }

        BookAdapter bookAdapter = new BookAdapter(this);
        bookAdapter.setBookList(bookList);
        rvBook.setAdapter(bookAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about_menu){
            Intent mIntent = new Intent(this, About.class);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
