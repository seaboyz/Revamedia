Git Branching Strategy P3

Main: Only 100% working code because this is the Live branch
^
Dev: Working development branch of the whole team which working feature branches get pulled to
^
Feature Branches: Working branch of the specific feature which individual team members create pull requests on
^
Individual Branches: Since individuals won't be able to merge directly to Dev or Feature Branches without review. This is the actual working branch of individual team members to push their code to.


Restrictions:
You can't merge your code without review by a second team member

When you want to push your code you have to create a pull request on github

No one has sole power to merge code
