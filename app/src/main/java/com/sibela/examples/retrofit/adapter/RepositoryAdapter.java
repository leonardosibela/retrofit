package com.sibela.examples.retrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sibela.examples.retrofit.R;
import com.sibela.examples.retrofit.model.Repository;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {

    List<Repository> repositories;

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repository_item, parent, false);
        return new RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder holder, int position) {
        Repository repository = repositories.get(position);
        holder.repoName.setText(repository.getName());
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
        notifyDataSetChanged();
    }

    public static class RepositoryViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.repo_name)
        TextView repoName;

        public RepositoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
