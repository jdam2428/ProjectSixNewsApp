package com.example.android.projectsixnewsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<NewsItem> {

    /**
     * Create a new ArrayAdapter
     */
    public NewsAdapter(Context context, List<NewsItem> news) {
        super(context, 0, news);
    }

    /**
     * Create a getView method which will return the news stories
     */
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_item, parent, false);
        }

        NewsItem currentNews = getItem(position);

        TextView newsTitle = listItemView.findViewById(R.id.news_title);
        newsTitle.setText(currentNews.getHeader());

        TextView newsType = listItemView.findViewById(R.id.news_type);
        newsType.setText(currentNews.getmTitle());

        TextView newsAuthor = listItemView.findViewById(R.id.news_author);

        /** Check whether current news has an author name, show if it does, hide if it doesn't */
        if (currentNews.getmAuthor() != "") {
            newsAuthor.setText(currentNews.getmAuthor());
            newsAuthor.setVisibility(View.VISIBLE);
        } else {
            newsAuthor.setVisibility(View.GONE);
        }

        // Create a new Date object from the time in milliseconds of the published
        Date dateObject = new Date(String.valueOf(currentNews.getmTimeAndDate()));

        // Section has been referenced from course app - QuakeReport.
        // Find the TextView with view ID date
        TextView dateView = listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current news in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current news in that TextView
        timeView.setText(formattedTime);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}