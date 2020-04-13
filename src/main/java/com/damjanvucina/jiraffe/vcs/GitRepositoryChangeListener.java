package com.damjanvucina.jiraffe.vcs;

import git4idea.repo.GitRepository;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class GitRepositoryChangeListener implements IGitRepositoryChangeListener {
    private List<IGitRepositoryChangeTracker> repositoryTrackers;

    public GitRepositoryChangeListener(){
        repositoryTrackers = new ArrayList<>();
    }

    @Override
    public void repositoryChanged(@NotNull GitRepository repository) {
        notifyTrackers(repository);
    }

    @Override
    public void subscribe(IGitRepositoryChangeTracker tracker){
        repositoryTrackers.add(tracker);
    }

    @Override
    public void unsubscribe(IGitRepositoryChangeTracker tracker){
        repositoryTrackers.remove(tracker);
    }


    public void notifyTrackers(GitRepository repository){
        for(IGitRepositoryChangeTracker tracker : repositoryTrackers){
            tracker.repositoryChangeOccurred(repository);
        }
    }
}
