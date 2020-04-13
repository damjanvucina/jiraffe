package com.damjanvucina.jiraffe.vcs;

import git4idea.repo.GitRepository;

public interface IGitRepositoryChangeTracker {
    void repositoryChangeOccurred(GitRepository repository);
}
