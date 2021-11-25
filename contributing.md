# Welcome to GitHub docs contributing guide <!-- omit in toc -->

Below you will find a list of guidelines to follow when making a contribution.

In this guide you will get an overview of the contribution workflow from opening an issue, creating a PR, reviewing, and merging the PR.

## New contributor guide

To get an overview of the project, read the [README](README.md). Here are some resources to help you get started with open source contributions:

- [Finding ways to contribute to open source on GitHub](https://docs.github.com/en/get-started/exploring-projects-on-github/finding-ways-to-contribute-to-open-source-on-github)
- [Set up Git](https://docs.github.com/en/get-started/quickstart/set-up-git)
- [GitHub flow](https://docs.github.com/en/get-started/quickstart/github-flow)
- [Collaborating with pull requests](https://docs.github.com/en/github/collaborating-with-pull-requests)

## We Use [Github Flow](https://guides.github.com/introduction/flow/index.html), So All Major Code Changes Happen Through Pull Requests
Pull requests are the best way to propose changes to the codebase (we use [Github Flow](https://guides.github.com/introduction/flow/index.html)). We actively welcome your pull requests:

1. Fork the repo and create your branch from `main`. (This step can be skipped if you have already forked before)
2. If you've added any new code that should be tested, please do add tests.
3. If you've changed/modified any APIs, update the documentation.
4. Ensure the test suite passes.
5. Make sure your code lints. Refer to this link for more infomation on linting: https://www.perforce.com/blog/qac/what-lint-code-and-why-linting-important
6. Issue a new pull request for reviewing and merging.
7. You're all done! :)

##Fixing the internal server error from the API

To apply on the branch:
    1.Run the following commands i) "git checkout main" ... ii)"git pull" to update your local repositories
    2.Open MySQL Workbench
    3.Open the localhost connection
    4.Go to Administration/Server and Click 'Data Import/Restore'
    5.Go to Import to Disk
    6.Choose Import from Self-Contained File
    7.Import Excursion-Management/project/database/bdbarmr9bpoyjedn4yyi v4.sql (found on the gitHub repo)
    8.Create a new database by clicking "new". But if you do not want to create a new database, just choose a database to replaced to and proceed to the next step.  However, creating a new database is recommended to preserve a backup and for tracing purposes.
    9.Make sure that the dropdown on the bottom part of the window before the start import button is set to Dump Structure and Data
    10.Click Start Import
    11.If you want to modify your changes (i.e. Related to steps 13,14 & 15): please create a branch out of the update main branch using git checkout -b (your_branch_name_here)
    12.Go to Excursion-Management/project/api/thu-excursion/src/main/resources/application.properties
    13.Modify spring.datasource.url by changing: jdbc:mysql://localhost:3306/(name of newly imported database here)?allowPublicKeyRetrieval=true&useSSL=false
    14.Modify spring.datasource.username (only if applicable)
    15.Modify spring.datasource.password (only if applicable)
    16.Save application.properties.
    17.Open the file :Excursion-Management/project/api/thu-excursion/src/main/java/com/thuexcursion/crud/SpringBootThuexcursionCrudApplication.java in any IDE
    18.Run the program
    19.Launch PostMan and test the endpoint

### Pull Request

When you're finished with the changes, create a pull request, also known as a PR.
- Fill the "pull_request_template" template so that we can review your PR. This template helps reviewers understand your changes as well as the purpose of your pull request. 
- Don't forget to [link PR to issue](https://docs.github.com/en/issues/tracking-your-work-with-issues/linking-a-pull-request-to-an-issue) if you are solving one.
- Enable the checkbox to [allow maintainer edits](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/allowing-changes-to-a-pull-request-branch-created-from-a-fork) so the branch can be updated for a merge.
Once you submit your PR, a Docs team member will review your proposal. We may ask questions or request for additional information.
- We may ask for changes to be made before a PR can be merged, either using [suggested changes](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/incorporating-feedback-in-your-pull-request) or pull request comments. You can apply suggested changes directly through the UI. You can make any other changes in your fork, then commit them to your branch.
- As you update your PR and apply changes, mark each conversation as [resolved](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/commenting-on-a-pull-request#resolving-conversations).
- If you run into any merge issues, checkout this [git tutorial](https://lab.github.com/githubtraining/managing-merge-conflicts) to help you resolve merge conflicts and other issues.

### Issues

#### Create a new issue

If you spot a problem with the documentation such as spelling or grammer errors etc... [search if an issue already exists](https://docs.github.com/en/github/searching-for-information-on-github/searching-on-github/searching-issues-and-pull-requests#search-by-the-title-body-or-comments). If a related issue doesn't exist, you can open a new issue using a relevant [issue form](https://github.com/github/docs/issues/new/choose).

## Write bug reports with detail, background, and sample code (source: https://gist.github.com/briandk/3d2e8b3ec8daf5a27a62)
[This is an example](http://stackoverflow.com/q/12488905/180626) of a bug report someone else wrote. Here's [another example from Craig Hockenberry](http://www.openradar.me/11905408).

**Great Bug Reports** tend to have (source:https://gist.github.com/briandk/3d2e8b3ec8daf5a27a62) :

- A quick summary and/or background
- Steps to reproduce the bug
  - Be specific!
  - Give sample code if you can. [My stackoverflow question](http://stackoverflow.com/q/12488905/180626) includes sample code that *anyone* with a base R setup can run to reproduce what I was seeing
- What you expected would happen
- What actually happens
- Notes (possibly including why you think this might be happening, or stuff you tried that didn't work)

## References
This document was adapted from the open-source contribution guidelines for [Facebook's Draft](https://github.com/facebook/draft-js/blob/a9316a723f9e918afde44dea68b5f9f39b7d9b00/CONTRIBUTING.md)
[briandk/CONTRIBUTING.md]: https://gist.github.com/briandk/3d2e8b3ec8daf5a27a62
