package com.example.twittertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.models.User;

public class ProfileActivity extends AppCompatActivity {

    TextView followers;
    TextView following;
    TextView profileName;
    ImageView profileImage;
    ImageView headerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = (TextView) findViewById(R.id.user_name);
        followers = (TextView) findViewById(R.id.tv_followers);
        following = (TextView) findViewById(R.id.tv_following);
        profileImage = (ImageView) findViewById(R.id.profile_photo);
        headerImage = (ImageView) findViewById(R.id.header_image);

        Gson gson = new Gson();
        User user = gson.fromJson(getIntent().getStringExtra(LoginActivity.TWITTER_USER), User.class);

        Picasso.with(this).load(user.profileImageUrl).into(profileImage);
        Picasso.with(this).load(user.profileBannerUrl).into(headerImage);
        profileName.setText(user.name);
        followers.setText("Followers\n" + user.followersCount);
        following.setText("Following\n" + user.friendsCount);
    }
}
