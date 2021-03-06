# GIT README 

Shortcuts to recurrent Git commands 

## Sync remote fork 

```bash
git fetch public
git checkout master
git merge public/master
```

Read more [here](https://help.github.com/articles/syncing-a-fork/).

## Fork a remote branch and push changes 

```
git co --track upstream/master -b upstream
git cherry-pick <something> [--no-commit]
git push upstream HEAD:master
```

## Subtree  

The `tests` directory is a Git subtree created with the 
following commands: 

    git remote add tower-admin git@github.com:seqeralabs/tower-admin.git
    git subtree add --squash --prefix=tower-admin/ tower-admin master


To pull changes from the [tests repo](https://github.com/nextflow-io/tests) use this command: 

    git subtree pull --squash --prefix=tower-admin/ tower-admin master

To push changes to to [tests repo](https://github.com/nextflow-io/tests) use this command: 

    git subtree push --prefix=tower-admin/ tower-admin master


Read more [here](https://andrey.nering.com.br/2016/git-submodules-vs-subtrees/).

## Stash shortcuts

    git stash list
    git stash pop
    git stash pop stash@{1}
    git stash drop
    git stash drop stash@{1}
    git stash clear
    git diff stash
    git diff stash@{1} [other]


## GPG keys 

To sign Git commits with a GPG key on Mac use [GPG Suite](https://gpgtools.org/), import your key, then: 

    git config --global gpg.program /usr/local/MacGPG2/bin/gpg2
    git config --global user.signingkey <your key> 
    git config --global commit.gpgsign true 
    git config --global format.signoff true ## TO AVOID TO SPECIFY -S option each time

Read more: 
https://gist.github.com/danieleggert/b029d44d4a54b328c0bac65d46ba4c65

## Misc 

Resolve files with conflic 

    git checkout --theirs/--ours path/to/file


Merge unrelatd histories 

    git merge <branch> --squash -n --allow-unrelated-histories