package com.damjanvucina.jiraffe.vcs;

import com.intellij.openapi.project.Project;
import com.intellij.util.messages.MessageBusConnection;
import git4idea.repo.GitRepository;
import git4idea.repo.GitRepositoryManager;

import java.util.Objects;

public class BranchTracker implements IGitRepositoryChangeTracker{
    private Project project;
    private GitRepositoryManager repositoryManager;
    private GitRepositoryChangeListener repositoryChangeListener;
    private MessageBusConnection connection;

    public BranchTracker(){
    }

    public void initialize(Project project){
        this.project = project;

        repositoryManager = GitRepositoryManager.getInstance(project);
        repositoryChangeListener = new GitRepositoryChangeListener();
        repositoryChangeListener.subscribe(this);
    }

    private void track(){
        connection = project.getMessageBus().connect();
        connection.subscribe(GitRepository.GIT_REPO_CHANGE, repositoryChangeListener);
    }

    public void startTracking(Project project){
        if(!isTracking()){
            if(!isInitialized()){
                initialize(project);
            }

            track();
        }
    }

    public void stopTracking(){
        if(isTracking()){
            repositoryChangeListener.unsubscribe(this);
            connection.disconnect();

            project = null;
            repositoryManager = null;
            repositoryChangeListener = null;
            connection = null;
        }
    }

    private boolean isInitialized(){
        return repositoryManager != null;
    }

    public boolean isTracking(){
        return connection != null;
    }

    @Override
    public void repositoryChangeOccurred(GitRepository repository) {
        System.out.println("novi branch je");
        System.out.println(repository.getCurrentBranch().getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BranchTracker that = (BranchTracker) o;
        return Objects.equals(project, that.project) &&
                Objects.equals(repositoryManager, that.repositoryManager) &&
                Objects.equals(repositoryChangeListener, that.repositoryChangeListener) &&
                Objects.equals(connection, that.connection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, repositoryManager, repositoryChangeListener, connection);
    }
}
