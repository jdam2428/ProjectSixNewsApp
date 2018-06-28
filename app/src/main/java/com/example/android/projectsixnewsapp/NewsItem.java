package com.example.android.projectsixnewsapp;

import java.util.Date;

/**
 * An {@link NewsItem} object contains information related to a single news article.
 */
public class NewsItem {

    /**
     * News header
     */
    private String mHeader;

    /**
     * News title
     */
    private String mTitle;

    /**
     * News article date and time
     */
    private Date mTimeAndDate;

    /**
     * Author of the news article
     */
    private String mAuthor;

    /**
     * URL containing the news article
     */
    private String mUrl;

    /**
     * Constructs a new {@Link NewsItem} object
     *
     * @param title           is the title of the news article
     * @param sectionName     is the header of the news article
     * @param authorName      is the name of the person who wrote the article
     * @param publicationDate is the date the news article was published
     * @param url             is the URL used to retrieve the article
     */
    public NewsItem(String title, String sectionName, String authorName, Date publicationDate,
                    String url) {

        mHeader = title;
        mTitle = sectionName;
        mAuthor = authorName;
        mTimeAndDate = publicationDate;
        mUrl = url;
    }

    public String getHeader() {
        return mHeader;
    }

    public String getmTitle() {
        return mTitle;
    }

    public Date getmTimeAndDate() {
        return mTimeAndDate;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmUrl() {
        return mUrl;
    }
}