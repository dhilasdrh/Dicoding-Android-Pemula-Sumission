package com.dhilasadrah.booklists;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String title, releaseDate, author, totalPages, publisher, ISBN, overview, totalVote;
    private int cover, backdrop;
    private float rating;

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getReleaseDate() {
        return releaseDate;
    }

    void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    String getAuthor() {
        return author;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    String getPublisher() {
        return publisher;
    }

    void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    String getISBN() {
        return ISBN;
    }

    void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    String getOverview() {
        return overview;
    }

    void setOverview(String overview) {
        this.overview = overview;
    }

    int getCover() {
        return cover;
    }

    void setCover(int cover) {
        this.cover = cover;
    }

    int getBackdrop() {
        return backdrop;
    }

    void setBackdrop(int backdrop) {
        this.backdrop = backdrop;
    }

    float getRating() {
        return rating;
    }

    void setRating(float rating) {
        this.rating = rating;
    }

    String getTotalPages() {
        return totalPages;
    }

    void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    String getTotalVote() {
        return totalVote;
    }

    void setTotalVote(String totalVote) {
        this.totalVote = totalVote;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.releaseDate);
        dest.writeString(this.author);
        dest.writeString(this.publisher);
        dest.writeString(this.ISBN);
        dest.writeString(this.totalPages);
        dest.writeString(this.overview);
        dest.writeInt(this.cover);
        dest.writeInt(this.backdrop);
        dest.writeFloat(this.rating);
        dest.writeString(this.totalVote);
    }

    Book() {
    }

    private Book(Parcel in) {
        this.title = in.readString();
        this.releaseDate = in.readString();
        this.author = in.readString();
        this.publisher = in.readString();
        this.ISBN = in.readString();
        this.totalPages = in.readString();
        this.overview = in.readString();
        this.cover = in.readInt();
        this.backdrop = in.readInt();
        this.rating = in.readFloat();
        this.totalVote = in.readString();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
