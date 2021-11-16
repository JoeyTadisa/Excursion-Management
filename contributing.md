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
