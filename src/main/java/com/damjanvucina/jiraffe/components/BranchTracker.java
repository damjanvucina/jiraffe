package com.damjanvucina.jiraffe.components;

import com.intellij.openapi.project.Project;
import git4idea.repo.GitRepository;
import git4idea.repo.GitRepositoryManager;

import java.util.List;

public class BranchTracker {
    public static GitRepositoryManager repositoryManager;

    public static void initialize(Project project){
        repositoryManager = GitRepositoryManager.getInstance(project);
        List<GitRepository> repositoryList = repositoryManager.getRepositories();
        for(GitRepository repo : repositoryList){
            System.out.println(repo.getCurrentBranchName());
            System.out.println("-----");
        }
//        project.getMessageBus().connect().subscribe(VcsRepositoryManager.VCS_REPOSITORY_MAPPING_UPDATED, );
    }
}
