package com.codepath.apps.basictwitter.fragments;

import android.os.Bundle;

import com.codepath.apps.basictwitter.models.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qingdi on 10/4/14.
 */
public class UserTimelineFragment extends TweetsListFragment{

    private User        user;

    public static UserTimelineFragment newInstance(User user) {
        UserTimelineFragment fragment = new UserTimelineFragment();
        Bundle args = new Bundle();
        args.putParcelable(User.ARG_PARAM, user);
        fragment.setArguments(args);
        return fragment;
    }

    public UserTimelineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = getArguments().getParcelable(User.ARG_PARAM);
        }
    }

    public void populateTimeline() {
        Map params = new HashMap<String, String>();
        params.put("user_id", Long.toString(user.getUid()));
        if (maxId != null) {
            params.put("max_id", maxId.toString());
        }

        populateTimeline("getUserTimeline", params);
    }
}
