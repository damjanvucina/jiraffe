# jiraffe

# tl;dr
Custom JetBrains platform (WebStorm/IntelliJ/PyCharm etc.) plugin for populating Jira Worklogs automatically. Integrates with git4idea plugin, tracks time spent on each branch, and logs it to JIRA for you. #projectmanagershatethis #loggingjirahasneverbeeneasier

## Key Features
* Generate acces token in Jira Tempo and import it to enable the plugin to log JIRA worklogs on your behalf
* Specify how to extract JIRA task code from the branch name (e.g. if your branch naming adheres to gitflow: feature/JIR-123 maps to JIR-123 task)
* Plugin tracks time spent on each branch and automatically logs it upon request

## Future Work
* Generate access token in Google and import it to enable the plugin to read your calendar and log time spent on meetings

## How It Works?
![App video](https://github.com/damjanvucina/jiraffe/blob/develop/assets/jiraffe-demo.gif)
