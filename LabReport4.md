# Lab Report 4

## Step 4: Log into ieng6

Keys Pressed: `ssh ssamal-201@ieng6.ucsd.edu` <enter>
Logs into the server at port 201

## Step 5: Clone your fork of the repository from your Github account (using the SSH URL)

Keys Pressed: `git clone` <command><v> to paste the ssh `git@github.com:ssamal12/lab7.git` <enter>
Clones the repository

## Step 6: Run the tests, demonstrating that they fail

Keys Pressed: `cd lab7` <enter> `ls` <enter> `bash test.sh` <enter>
Goes into the newly cloned lab7 directory, and runs the bash script `test.sh` to see if it works. 

## Step 7: Edit the code file to fix the failing test

Keys Pressed: `vim ListExamples.java` <enter> `43jer2:wq`<enter>
Opens the code in `ListExamples.java` and fixes it. 

## Step 8: Run the tests, demonstrating that they now succeed

Keys Pressed: `bash test.sh` <enter>
Reruns the test code and sees it works

## Step 9: Commit and push the resulting change to your Github account (you can pick any commit message!)

Keys Pressed: `git add ListExamples.java` <enter> `git commit` <enter> `ifixed code with vim` <esc> `:wq` `git push`
Adds the file to be pushed, adds a commit message, and pushes the changes to the main directory on github. 
