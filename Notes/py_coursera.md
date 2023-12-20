------------------------------------------------------------------------------------------------------------------------

script = short program.
automation =>   +less effort 
				+less time 
				+consistency! 
				-takes effort, cost  
				-a lot of annoying factors to be considered 
				-creativity
				
------------------------------------------------------------------------------------------------------------------------

Testing can help make good code great.

Manual testing, 
Automated testing,
unit testing ->
			individual units to be tested. "unittest" "pytest"
			
------------------------------------------------------------------------------------------------------------------------

I/O streams := The basic mechanism for performing I/O operations in your programs.

	Input --->  Program ---> Output

	STDIN  : standard input
	STDOUT : standard output
	STDERR : standard error
	
------------------------------------------------------------------------------------------------------------------------

Linux shells:
	Bash, Zsh, Fish
	
Programs get executed inside a shell CLE. (Command-Line Environment)

------------------------------------------------------------------------------------------------------------------------
		
Redirection: 
	the process of sending a stream to a different destination.
	can be done using '>' symbol
	***  '>'   *** OVERWRITES STDOUT ('w')  ***
	***  '>>'  ***   APPENDS  STDOUT ('a')  ***
	***  '2>'  *** redirects  STDERROR     ***
	
	
	like:
		cat text.py :
		print("hello")
		
		./text.py > new_text.txt
		
		cat new_text.txt :
		hello
		
------------------------------------------------------------------------------------------------------------------------
		
Piping:
	Pipes -> 
		connects the output of one program to the input of another, 
			in order to pass data between programs
						
Signals:
	Tokens delivered to running processes to indicate a desired action.
	
PID: Process Identifier

------------------------------------------------------------------------------------------------------------------------

General Info About GIT:

	- created by Linus Torvalds (2005), dev of Linux Kernel
	
	- distributed (not a centralized server) VCS, 
		which means each dev has a full copy of the repo.
	- Repo's can be used by unlimited dev's.
	
	- git-scm.com
	+ SCM : Source Control Management 
	+ (however, it's more like VCS atm, since its more powerful)
	
	- other VCS: Subversion, Mercurial
	
------------------------------------------------------------------------------------------------------------------------

Technical Info:
	
Every GIT project consists of three sections:
	1- Git Directory:
		history of all the files and changes. 
	2- The Working Tree:
		current state of the project.
	3- Staging Area:
		changes to be committed.
		after making a change, they are here.
		when you commit, they move to Working Tree.
		
		
	Staging area (index):
		- a file, maintained by Git
		  that contains all of the info about what files
		  and changes are going to go into your next commit
		  
		  
	"HEAD -> master":
	"HEAD" is the current snapshot of repo.
	
	
git commit -m -a "$message":
	commits a TRACKED file without having to "add" 
	(skips Staging Area)
	(useful for the changes you made, files still have to be tracked in order to use this cmd)
	
	
commit 230e8c0a8edd9dd7582293e47433f2ff119b6678
	this number is called: HASH
		and calculated using an algorithm called: SHA1
			SH1 is part of the class of 
			"Cryptographic hash functions".
				However, Git doesn't really use them 
				for security, uses for consistency.
				

Branch:
	a pointer to a particular commit
	
	it represents an independent line of development in a project
	
	default branch is called "master"
	
	git branch: lists all the branches in Work Tree
	git branch -d <>: deletes the branch 
	git branch -m <>: renames the branch
	
	to enter a branch : git checkout 
		we use git checkout to check out the latest snapshot for both files and for branches.
	
	- git checkout -b new_branch
	+ Switched to a new branch 'new_branch'
		
	
	"Merging" : 
		the term that Git uses for combining branched data and history together.
		
		git merge --abort
			the "current" branch is represented by <HEAD> tag.
			
	
------------------------------------------------------------------------------------------------------------------------

TIPS: 

		  
Every time you "commit", git takes a "screenshot".
	each screenshot is added to the git dir.
	
When you create a file, it's untracked.
	You have to "add" it to the Staging Area in order to track it. 
		When untracked, it's not a part of Git directory.
	
The git init command creates a new Git repo. 
	In our case, it transformed the current directory into a Git repo. 
		It can also be used to convert an existing, unversioned project to a Git repo or to initialize a new, empty repo.

Executing git init creates a .git subdirectory in the current working directory, which contains all of the necessary Git metadata for the new repo. This metadata includes subdirectories for objects, refs, and template files. A HEAD file is also created which points to the currently checked out commit.

If you've already run git init on a project directory containing a .git subdirectory, you can safely run git init again on the same project directory. The operation is what we call idempotent; running it again doesn't override an existing .git configuration.
	
* Pull Req:
	commit(s) that you send to the owner of the repo to incorporate the commit into their tree
		
		
* Issue (Bug) Tracker
	like Bugzilla
	GIT already has an issue tracker in it.
	
	when working on an issue as a dev, adding "Closes #x" into the msg file will close issue #x

* Continuous Integration (CI) System:
	allows for automation of tests
	will build and test the code after every change
	
	* Continuous Development (Delivery) System: (CD)
		after CI
		deploys a new version whenever a commit is merged into the MT (main tree).
		Update with incremental rollouts
		this way, small changes/patches will be done to make big changes
		small changes are easier to troubleshoot!
		
		* also called CI/CD
			Jenkins, Travis-> popular CI/CD tools.
			for gitHub, gitHub Actions exist. 
			AWS, devOps
			
		* Pipelines:
			specify the steps that need to run to get the result you want
		* Artifacts:
			describes any file that pipeline-generated.
			
----------------------------------------------------------------------------------------------------------------------
	
GIT Hazards:
	
**** Avoid amending commits that 
	 have already been made public.

* Keep the latest version in the master branch and the latest stable version in a separate branch.

* What is a nit?
	A trivial comment or suggestion	
------------------------------------------------------------------------------------------------------------------------
HOW TO CREATE .gitignore FILES:

	touch .gitignore
	npp .gitignore & add line ".DS_STORE"
		git add .gitignore
		git commit -m "Added .gitignore to ignore .DS_STORE files"
			* Now, if you create a new .DS_STORE file or already have it in your working directory, Git will ignore it:
				touch .DS_STORE
				git status
					"The output should indicate that .DS_STORE is untracked and will not be included in future commits."
			
------------------------------------------------------------------------------------------------------------------------
GIT Commands:

	git --version
		displays installed version of Git.
		
	git config --global user.x "y"
		sets the global x config to "y" 
		i.e: git config --global user.email "email@.com"
		
	git init
		initializes a new git repo.
		
	cd ..
		changes current working dir to parent dir.
		
	git add x
		adds (tracks) the file 'x' to the staging area for the next commit
		
	git add -p 
		adds and stages the file.
		
	git commit
		opens a text editor for the user to enter a commit message and commit the staged changes.
		
	git commit -m <text>
		commits changes with a specific message
			quicker than "git commit", but long messages are not possible
			
	git commit -a -m <text>
		commits without needing to stage the change, but file has to be already tracked.
		helpful for changes in a file (that already exists.).
		
	git status
		shows the status of changes as 
			"untracked, modified, staged"
			
	git config -l
		lists the global Git configs.
		
	chmod +x file.py
		adds execution permission to the "file.py".
		
	git show <commit>
		views the details of a specific commit
		
	git log --stat
		gives concise summary of changes introduced in each commit
		
	git log -p 
		shows the patch introduced by each commit
		
	git log -u
		displays GPG signature info.
	
	git log --graph --oneline
		shows a summarized view of the commit history with nice visuals.
	
	git diff
		views the changes in the working dir
		
	git diff --staged
		views the staged changes in the working dir
	
	git revert
		undos the changes made in a previous commit
	
	git branch
		used to manage branches
		lists all the branch names
		
	git branch <name>
		creates the branch
		
	git branch -d <name>
		deletes the  branch
		
	git branch -D <name>
		Forcibly deletes the branch
		
	git push --delete origin <name>
		Forcibly deletes the branch <name> from remote origin branch (on git servers, remote.)
		
	git checkout <branch>
		switches to a branch
		
	git checkout -b <branch>
		creates a new branch and switches to it.
		
	git merge <branch>
		Merges branch together
		
	git merge --abort
		aborts the merge.
		
	git push -u origin <branch-name>
		pushes the local branch into the remote origin branch.
			useful when you create a new branch to do a change, then combine this branch into origin/master branch 
			
	git rebase -i <master_branch>
		it's an "interactive" rebase.
		it's very powerful. Many stuff can be done here, including rewording, editing commits, squashing commits into one
	
	git push -f 
		force git push

					
	
	
### Coursera Troubleshooting
	Amanda Ballas - Security Systems Admin.

1) gather info
	- what, why, result, consequences
	- Reproduction case
		recreate the problem to understand how and why

2) Find the root cause
3) Perform necessary remedition
	* maybe rebooting (workaround) (short-term remedition)
	
- check pc logs
- what was user doing, how long has it been going on


* short term remedition: cleaning the fan
* long term remedition: creating a IoT monitoring to remind you 

# Some Key Functions:
- strace : system trace func
    -o (flag): saves the output to a file [strace -o fail.strace ./script.py]
		then you can use "less fail.strace" to browse throught it (open it)
	" strace ./script.py | less " works too.

- top
	shows CPU loads
- iotop
    shows I/O loads (input and output)
- iostat
    shows statistics on I/O loads
- vmstat
    shows stats on VM ops (virtual memory) 
- ionice
    reduces priority to access the disk (nice I/O)
- nice
    reduces priority to access the CPU
- iftop
    shows network traffic
- rsync
    used to backup data (sync)
    has an option to limit bandwidth (-bw) 
    # or can use a tool like Trickle to limit bw
- kill -STOP 
	suspends the system (pause)


# Logs. Which logs to read?
	Linux:
		var/log/syslog
		.xsession-errors
	macOS:
		syslogs
		/Library/Logs
	Windows:
		"Event Viewer" tool

* Always check your hypothesis in a TEST env.

# A few important steps:
- get info
- modify program to get more/better log (debugging mode)
- isolate the causes
- understand the error messages 

# Intermittent Bugs:

1) Heisenbugs (observer bugs)
    - the bug goes away when observing, but pop up again after
2) Bugs that go away when restarting 
    # (restart = power cycling)

	