package com.example.android.projectsixnewsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Loads a list of news articles by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class NewsLoader extends AsyncTaskLoader<List<NewsItem>> {

    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<NewsItem> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<NewsItem> News = QueryUtils.fetchNewsData(mUrl);
        return News;
    }
}