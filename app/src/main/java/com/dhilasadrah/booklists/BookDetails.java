package com.dhilasadrah.booklists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.*;

public class BookDetails extends AppCompatActivity {

    @BindView(R.id.detail_backdrop) ImageView detail_backdrop;
    @BindView(R.id.detail_cover) ImageView detail_cover;
    @BindView(R.id.detail_title) TextView detail_title;
    @BindView(R.id.detail_author) TextView detail_author;
    @BindView(R.id.detail_releaseDate) TextView detail_releaseDate;
    @BindView(R.id.detail_totalpages) TextView detail_totalPages;
    @BindView(R.id.detail_publisher) TextView detail_publisher;
    @BindView(R.id.detail_ISBN) TextView detail_ISBN;
    @BindView(R.id.detail_overview) TextView detail_overview;
    @BindView(R.id.detail_rating) TextView detail_rating;
    @BindView(R.id.total_votes) TextView detail_votes;
    @BindView(R.id.rating) RatingBar rb_rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        ButterKnife.bind(this);

        Book book = getIntent().getParcelableExtra("books");

        int cover = book.getCover();
        int backdrop = book.getBackdrop();
        String title = book.getTitle();
        String author = book.getAuthor();
        String release_date = ": "+book.getReleaseDate();
        String numberOfPages = ": "+book.getTotalPages();
        String publisher = ": "+book.getPublisher();
        String ISBN = ": "+book.getISBN();
        String overview = book.getOverview();
        String rating = String.valueOf(book.getRating());
        String detailVotes = book.getTotalVote();

        Glide.with(this).load(backdrop)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(20, 3)))
                .into(detail_backdrop);

        detail_cover.setImageResource(cover);
        detail_backdrop.setImageResource(backdrop);
        detail_title.setText(title);
        detail_author.setText(author);
        detail_releaseDate.setText(release_date);
        detail_totalPages.setText(numberOfPages);
        detail_publisher.setText(publisher);
        detail_ISBN.setText(ISBN);
        detail_overview.setText(overview);
        detail_rating.setText(rating);
        detail_votes.setText(detailVotes);
        rb_rating.setRating(Float.parseFloat(rating));

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(book.getTitle());
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}
