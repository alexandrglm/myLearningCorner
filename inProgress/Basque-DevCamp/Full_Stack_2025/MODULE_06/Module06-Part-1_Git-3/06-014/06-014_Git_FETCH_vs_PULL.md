# MODULE 06-014:    Git (3)

### Fetch VS Pull

---

## Differences

| Feature       | `git fetch`                         | `git pull`                   |
| ------------- | ----------------------------------- | ---------------------------- |
| Action        | Downloads changes but doesn't merge | Downloads AND merges changes |
| Safety        | Safer - lets you review first       | Riskier - automatic merge    |
| Workflow      | Two-step process (fetch then merge) | Single-step process          |
| Local Changes | Preserves your local work           | May cause merge conflicts    |

## ****

## When to Use Each

### Use `git fetch` when:

- Working on complex features

- Multiple developers are contributing

- You want to review changes before merging

- You anticipate merge conflicts

- Working on critical production code

### Use `git pull` when:

- Working alone on a simple project

- You're sure remote changes won't conflict

- You want a quick sync with remote

- Working on non-critical features

## How They Work

### `git pull` = `git fetch` + `git merge`

- Automatically brings down remote changes

- Immediately merges them into your local branch

- Can create unexpected merge conflicts

### `git fetch` + manual merge

1. `git fetch` downloads remote changes

2. `git diff` lets you review changes

3. `git merge origin/branch` merges when ready

## ****

## Step-by-Step Examples

### `git pull` Example

```bash
# Simple update of local branch
git checkout main
git pull origin main
```

### `git fetch` Example

```bash
# Safer approach for team environments
git fetch origin  # Download changes
git diff origin/main  # Review changes
git merge origin/main  # Merge when ready
```

****

## Best Practices

1. **Default to fetch-first workflow** - Especially in team environments

2. **Review before merging** - Always check what you're merging

3. **Use pull for simple updates** - When you're certain of no conflicts

4. **Clean working directory** - Stash or commit changes before both operations

## Handling Diverged Branches

When you see

```bash
Your branch and 'origin/main' have diverged,
and have 1 and 1 different commits each, respectively.
```



Recommended approach:

```bash
git fetch  # Get latest changes
git log --all --graph --oneline  # Visualize differences
git merge origin/main  # Merge remote changes
# OR for cleaner history:
git rebase origin/main  # Replay your commits on top
```

****

## Common Scenarios

### Scenario 1: Safe Update

```bash
git fetch
git merge origin/main
```

### Scenario 2: Conflict Resolution

```bash
git fetch
git diff origin/main  # Identify conflicts
# Manually resolve conflicts in files
git add .
git commit -m "Resolved merge conflicts"
```

### Scenario 3: Quick Sync

```bash
git pull  # Only when you're sure of no issues
```

****

## Resources

* [Git - git-pull Documentation](https://git-scm.com/docs/git-pull)

* [Git - git-push Documentation](https://git-scm.com/docs/git-push)





---

## Video Lesson Speech

In this lesson, we're going to walk through the differences between git 
fetch and git pull. And I think one of the easiest ways of seeing what 
the difference is is by going and walking through an example.

****

So that's what we are going to do. We've already talked about what `git pull` does `git pull` brings down all of the changed code from whatever branch that we're wanting to pull down so many times that can be the master branch so if I have some changes that have been made to the master branch right here I can come and let's make those changes. So I will say 

```
made changes for git pull demo
```

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+11.51.13+AM.png)

So I'm going to add that to that commit message which, remember when I do this I'm simply mimicking what would happen if a different user or different developer made changes. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+11.58.05+AM.png)

So if I come back now let's switch to the master branch 

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+12.00.53+PM.png)

and if I type `git pull` what's going to happen is it's going to bring down those latest changes and it is also going to automatically update the file. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+12.05.01+PM.png)

So if I look inside of the readme now you can see that it says made changes for the `git pull` demos. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+12.07.27+PM.png)

So those changes were made and they were automatically applied. So that is `git pull` and whenever you have completely kind of application where you're either doing all of the work yourself or maybe it's something where there's not a ton of other developers out there and you haven't made a lot of changes to your local version `git pull` can work. 

But imagine a scenario like this where we have already made a few changes ourselves on our local machines so I can say my file and let's just duplicate this python function. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+12.29.37+PM.png)

I'm going to save this and if I type `git status` you can see that it has that my file element right there. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+12.31.02+PM.png)

So I have a different version on my local machine then we have up here so I'm going to come right here and I'm going to create and go through the full `git add` and `git commit` process.

```
git add .
git commit -m "Added new python function"
```

So now what I can do is switch back and add one more change. So we'll just copy this in the readme

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+12.34.31+PM.png)

and say made more changes for the `git pull` demo and I will say `git pull/fetch` just to make it clear what we are working on. I'll copy this move down to the commit message and now instead of running `git pull`  what I'm going to do is say `git fetch`. And so I can say `git fetch` and then type in my passphrase. This is going to do is it is simply going to bring back those changes and so it's going to pull everything down

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+12.34.31+PM.png)

and if I type `git status` I don't have any changes. But now notice it says your branch and origin master have diverged and have 1 and 1 different commits each respectively. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+12.34.31+PM.png)

Use `git pull` to merge the remote branch into yours nothing to commit working tree clean. 

Okay well, that's fine it's a little bit confusing. You may notice right here we have the master branch and depending on what your terminal set up as you may not have this but this gives you an idea of what occurred. We have A1B1 listed right here but if you go up before we ran `git fetch`  you can see that this used to only say A1 and so this gives a little bit of a hint of what's happening and then obviously this message saying that it diverged is really what is throwing it off. So if I type `git branch`

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+3.46.17+PM.png)

then you can see that nothing's changed on our branches and if I open up the file that did change here you can see that it did not add those other elements so it did not add the made changes for the `git pull` demo. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+3.48.11+PM.png)

It didn't say made more changes so that is giving us our best hint on what's happening. `Git fetch` does not automatically override the code that we have locally. So now that we see that it hasn't made any changes how can we actually merge this in. Well, let's type `git status` once again just to make sure we don't have any changes and also to get that message. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+3.51.51+PM.png)

So notice how it gives us a little bit of a hint here where it says your branch and origin master. So that means that our local branch and then origin master. This is our remote origins the name of the remote and then master have diverged so we could just run `git pull` but I'm going to show you a different way of doing it. 

What you can do and this is considered more of the best practice is you can say

```bash
git merge origin/master
```

and we know to do this because that's exactly what it says right here.

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+3.57.42+PM.png)

So now we can say `git merge origin master` and now this is going to open up this window and this may look a little bit confusing if you've never seen this before. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+3.59.45+PM.png)

So let's walk through it. It says merge remote-tracking branch origin master please enter a commit message to explain why this merge is necessary especially if it merges an updated upstream into a topic branch. Do not worry about keywords like updated upstream because we're going to get into that later. Just know it's asking for us to add some details on why we need to perform this process. And so if you come down here and add new line this is where and make sure you do not add a prefect's of the hash symbol or else that's going to be considered a comment. 

So this is where we explain why it is necessary and so we can say 

```text
Merged in a remote master with local master changes
```

and typically you'd add what kind of features you're working on right now we're just saying that we're merging that in. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+4.04.03+PM.png)

I'm going to save that and now if I type `git status` everything is clean but it says your branch is ahead of origin master by 2 commits and for the moment of truth. Let's open up that readme file and now you can see that the made more changes for git pull/fetch demo is life so I'm going to close this out and all we have to do now is type `git push` type the passphrase in and then everything is going to be sync up if you switch back to Google Chrome here. Nothing has changed in this file but if you then go to my project and click on commits you'll see that we have two new commits

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+4.09.28+PM.png)

we have made more changes for a git pull/fetch demo and then we also have the main one here. This was our local change or we added a new Python function. And then lastly we have and this is our most up to date one. The merge remote-tracking branch. So this gives the little description we added where he said merged in remote master with the local master changes and so if I click on this-this is going to show that it brought in those changes. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-git-fetch-git-pull/Screen+Shot+2018-03-08+at+4.12.00+PM.png)

So this merged our remote copy of origin master with our local one. Now you may be curious and be wondering why in the world did we just have to go through all of those steps. When `git pull` did that for us automatically. And that's a great question because in the example I just gave. It's perfectly fine to run `git pull` if you know the files that were changed remotely on the master. And you know that you can safely pull those in and place them right inside of and automatically override all of the files you have locally then you're fine. Where `git fetch` comes is where you don't have maybe that much clarity. So imagine a scenario where you are working on a massive application and maybe 50 files were changed and you need to bring those down to your local machine. `Git fetch` is a much more clean way, It's a cleaner way of being able to pull that code in and give yourself a step in between the merge process so essential to 'git pull' is doing is it combines fetch and merge and so because of that it gives you a little bit less control whereas `git fetch` allows you to control the exact steps that are happening so you're pulling the code down. You check to see right there remember where it gave the message where it said that the origin master so our remote and our local code diverged. 

That tells us that there were changes and then it allows you to then merge it manually and when you know that there is going to be a merge conflict so when you have a large number of files and you know there's going to be issues and some conflicts where you and another developer both ran into or both worked on the same files and the same lines than doing this process where you do fetch and then merge that allows you to do is to have much more granular control over fixing those conflicts and later on in our section on managing merged conflicts then this is going to make even more sense and is going to be a little bit more clear on why you'd want to use fetch and merge where `git pull` is a little bit of a more generic tool. Where it's performing a few different processes for you all at one time which is good in certain circumstances but then in others when you know there's going to be merge conflicts then it will create a problem. So part of this guide is giving you a little bit of a preview of how you can manage your different merges especially on larger projects and give you more control. 
