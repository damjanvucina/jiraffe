package com.damjanvucina.jiraffe.vcs;

import git4idea.repo.GitRepository;
import git4idea.repo.GitRepositoryChangeListener;

public interface IGitRepositoryChangeListener extends GitRepositoryChangeListener {
    void subscribe(IGitRepositoryChangeTracker tracker);

    void unsubscribe(IGitRepositoryChangeTracker tracker);

    void notifyTrackers(GitRepository repository);
}
