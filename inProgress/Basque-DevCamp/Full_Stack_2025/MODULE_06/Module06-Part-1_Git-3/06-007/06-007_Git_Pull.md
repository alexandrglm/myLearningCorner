# MODULE 06-007:    Git (3)

## Pull

****

`git pull` is a combination of two commands:

1. `git fetch` - Downloads latest changes from remote

2. `git merge` - Merges changes into your local branch

Basic syntax:

```bash
git pull origin main
```

****

## Team Collaboration Workflow

### Standard Process

1. Team member pushes changes to remote

2. You pull changes before starting work

3. Resolve any conflicts

4. Continue development

5. Push your changes

### Why Pull First?

- Avoids merge conflicts

- Ensures you're working with latest code

- Maintains project history integrity

---

## Step-by-Step Pull Process

1. Check current status:
   
   ```bash
   git status
   ```

2. Pull latest changes:
   
   ```bash
   git pull origin main
   ```

3. Verify updates:
   
   ```bash
   git log --oneline -n 3
   ```

4. Check file changes:
   
   ```bash
   git diff HEAD~1
   ```

****

---

## Handling Remote Changes

### Scenario: Remote Changes Exist

```bash
$ git pull

remote: Counting objects: 3, done.
remote: Compressing objects: 100% (2/2), done.
remote: Total 3 (delta 0), reused 0 (delta 0)
Unpacking objects: 100% (3/3), done.

From github.com:user/repo
   1a2b3c4..5d6e7f8  main     -> origin/main

Updating 1a2b3c4..5d6e7f8

Fast-forward
 my_file.py | 2 ++
 1 file changed, 2 insertions(+)
```

****

### Conflict Resolution:

1. Pull reveals conflicts

2. Open conflicted files

3. Manually resolve (keep/discard changes)

4. Mark as resolved:
   
   ```bash
   git add .
   
   git commit -m "Resolved merge conflicts"
   ```

****

## Best Practices

1. **Pull Before You Push**
   
   ```bash
   # Always pull before pushing
   
   git pull && git push
   ```

2. **Regular Sync**
   
   ```bash
   # Pull every 1-2 hours during active development
   
   git pull origin main
   ```

3. **Branch Protection**
   
   ```bash
   # Work on feature branches, not main
   
   git checkout -b feature/new-login
   ```

4. **Visual Diff Tools**
   
   ```bash
   # Configure merge tool for easier conflict resolution
   
   git config --global merge.tool vscode
   ```

****

## Common Scenarios

### 1. Behind Remote Changes

```bash
# When remote has changes you don't have locally

$ git status

Your branch is behind 'origin/main' by 1 commit
```

### 2. Diverged Branches

```bash
# When you and remote both have new commits

$ git status

Your branch and 'origin/main' have diverged
```

### 3. Fast-Forward Merge

```bash
# When no local changes exist

$ git pull

Fast-forward
```

****

## Video lesson speech

And if you're working on your own so you have a project and you're the only developer that's working on it then that's actually going to carry you a very long way in terms of what you're going to be doing with git on a day in day out basis. 

However, if you're working with a team then that adds a whole nother component and it adds in some different complexities that have to be aware of. Specifically, if you have another developer on your team that is pushing code up you need to be able to sync the most up to date version of the application with your current local version and I will show you how that works and that's what we're going to walk through in this guide. 

So if I come up to my_file.py right here 

![large](./06-007_IMG1.png)

you have the ability to come and to make changes directly in Github. 

Now, this is not recommended for your day to day development but instead what I'm going to be doing is I'm going to be mimicking what it would look like if you had another developer on your team who made a change. So say we have print out hi git and then a few lines below that we say print out hi git from another dev.

```github
print('Hi Git')

print('Hi from another dev')
```

And now if I come down here I can update the changes so I'll just say updated python code and then from there I can commit changes 

![large](./06-007_IMG2.png)

and it gives you a few options. But like I said you're very rarely ever going to be making changes directly on GitHub what you usually want to make sure that if you're personally making changes to a repository you're doing it on your local machine and then pushing it up but right here we're just pretending that there is another developer who made a change to this file. 

Now if I come down to my local repository so if I open this up in the text editor and look at my file you notice I do not have those changes. 

![large](./06-007_IMG3.png)

So we need to walk through how we can pull down the latest version of the application. So the way we can do that is with the term git pull. So if I type in git pull this is going to bring down after I type in my password the latest version of the application. 

![large](./06-007_IMG4.png)

So if I come and see that it is calling the remote it is comparing the objects and then from there, it is updating the current version so it's giving the new version with this new commit ID. And then you can even see it tells you which file was changed and it had two lines that were added. 

And so now if I type status there are no changes because we brought down the newest changes 

![large](./06-007_IMG5.png)

and if I open the file up you can see that the file has been updated 

![large](./06-007_IMG6.png)

and so that is how you can pull down someone else's changes onto your local machine.
