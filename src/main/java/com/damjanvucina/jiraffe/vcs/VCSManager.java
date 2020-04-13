package com.damjanvucina.jiraffe.vcs;

public class VCSManager {
    private static final BranchTracker branchTracker = new BranchTracker();

    public static BranchTracker getBranchTracker(){
        return branchTracker;
    }
}
