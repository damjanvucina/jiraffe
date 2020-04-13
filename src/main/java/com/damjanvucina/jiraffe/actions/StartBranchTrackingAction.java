package com.damjanvucina.jiraffe.actions;

import com.damjanvucina.jiraffe.vcs.VCSManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class StartBranchTrackingAction extends AnAction {

    public StartBranchTrackingAction() {
        super();
    }

    public StartBranchTrackingAction(@Nullable String text, @Nullable String description, @Nullable Icon icon) {
        super(text, description, icon);
    }

    /**
     * Gives the user feedback when the dynamic action menu is chosen.
     * @param event Event received when the associated menu item is chosen.
     */
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Project project = event.getProject();
        VCSManager.getBranchTracker().startTracking(project);

        String dialogTitle = "Tracking Started";
        String dialogMessage = "Started tracking checked out branch.";
        Messages.showMessageDialog(project, dialogMessage, dialogTitle, Messages.getInformationIcon());
    }

    /**
     * Determines whether this menu item is available for the current context.
     * @param event Event received when the associated group-id menu is chosen.
     */
    @Override
    public void update(AnActionEvent event) {
        boolean isTracking = VCSManager.getBranchTracker().isTracking();
        event.getPresentation().setEnabled(!isTracking);
    }
}
