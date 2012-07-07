package com.am05.reddit.library.datasources;

import java.util.List;

import android.test.AndroidTestCase;
import android.util.Log;

import com.am05.reddit.library.things.Comment;
import com.am05.reddit.library.things.Link;
import com.am05.reddit.library.things.Subreddit;

public class RedditDataSourceTest extends AndroidTestCase {
    private static final String TAG = RedditDataSourceTest.class.getName();
    private RedditDataSource ds;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        ds = new RedditDataSource();
        ds.setDataSource(new MockDataSource(getContext()));
    }

    public void testGetSubreddits() {
        try {
            List<Subreddit> subreddits = ds.getSubreddits(null).getChildren();
            for (Subreddit subreddit : subreddits) {
                Log.v(TAG, "subreddit: " + subreddit.getDisplayName());
            }
        } catch (DataSourceException e) {
            logAndFail("failed to get subreddits", e);
        }
    }

    public void testGetLinksForSubreddit() {
        try {
            List<Link> links = ds.getLinksForSubreddit("askreddit").getChildren();
            for (Link link : links) {
                Log.v(TAG, "link: " + link);
            }
        } catch (DataSourceException e) {
            logAndFail("failed to get links for subreddit", e);
        }
    }

    public void testGetCommentsForLink() {
        try {
            Link link = new Link();
            link.setPermalink("/r/nba/comments/w3bs6/50_years_later_lingering_heat_from_wilt/");
            List<Comment> comments = ds.getCommentsForLink(link).getChildren();

            for (Comment comment : comments) {
                Log.v(TAG, "comment: " + comment);
            }
        } catch (DataSourceException e) {
            logAndFail("Failed to get comments for link", e);
        }
    }

    public void testGetSubreddit() {
        try {
            Subreddit subreddit = ds.getSubreddit("programming");
            Log.v(TAG, "subreddit programming found: " + subreddit);
        } catch (DataSourceException e) {
            logAndFail("Could not get subreddit.", e);
        }
    }

    public void testGetDefaultSubreddits() {
        try {
            List<Subreddit> subreddits = ds.getDefaultSubreddits().getChildren();
            for (Subreddit subreddit : subreddits) {
                Log.v(TAG, "subreddit: " + subreddit.getDisplayName());
            }
        } catch (DataSourceException e) {
            logAndFail("failed to get default subreddits", e);
        }
    }

    private void logAndFail(String message, Throwable t) {
        Log.e(TAG, message, t);
        fail(message);
    }
}
