package com.simamat.testapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.simamat.testapplication.R;
import com.simamat.testapplication.model.GithubUser;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GithubAdapter extends ArrayAdapter<GithubUser> {

    private Context context;
    private List<GithubUser> data;

    public GithubAdapter(@NonNull Context context, int resource, @NonNull List<GithubUser> data) {
        super(context, resource, data);

        this.context = context;
        this.data = data;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        GithubUser gu = data.get(position);

        LayoutInflater inflater  = LayoutInflater.from(getContext());

        convertView = inflater.inflate(R.layout.github_user, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.txt_name);
        ImageView ivUser = (ImageView) convertView.findViewById(R.id.author_image);

        Picasso.get().load(gu.getAvatarUrl()).into(ivUser);
        tvName.setText(gu.getLogin());

        return convertView;
    }
}
