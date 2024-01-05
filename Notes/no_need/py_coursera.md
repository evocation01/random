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

* Linux shells:
	Bash, Zsh, Fish
	
- Programs get executed inside a shell CLE. (Command-Line Environment)

* OS = 
	* Kernel 
		main core
		manages sys resources 
	* User Space
		things that are interacted
		i.e. UI
		
* Linux distributions =
	Ubuntu, ChromeOS, Redhat, Android 
	(MacOS : BSD Kernel) 
	# MacOS != Linux
	
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
    * (restart = power cycling)

	
# How to search

1) Linear Search
	- 1 2 3 4 ...
	- it works but can take a lot of time in a huge set
	- t --> len  
2) Binary Search
	- you keep halving the set (bisecting)
	- asking "is it on the left side, or right". 
	- i.e. for 100,000 comparisons, instead of 100,000
	- binary search requires sorting b4hand
	
	- git bisect



# Slowness

* Memory Leak
	- memory which is no longer needed is not getting released

* find root cause and bottleneck

* To access elements by position	
	use dictionaries (much faster than lists)

* time (command)
	gives real, user, sys time.
	real:
		actual time
	user:
		user space
	sys:
		sys-level ops

* profilers
	pprofile3
	kcachegrind

# complex problems

- Concurrency
	a dedicated field of CS 
	on parallel ops

* parallel ops
	>1 core
		OS decides what gets executed on which core

* Threads
	lets us run parallel tasks inside a process
	Py: Threading, AsyncIO

# A problem, hosting data.
* Hosting data, increasingly more popular. 
* Starting with .csv as most people do. 
* It's getting slower and slower, so you have to switch.
* Solution?
	- .csv
	- SQLite
	- DB server
	- Dynamic cacher


* Executor
	process thats in charge of distributing the work among the diff. workers
* Futures module
	Threads
		has more security measures to 
		avoid writing to the same var
		(slight delay from t1 to t2, waiting to make sure
		it's not the same var.)

		GIL limitations. (Global Interpreter Lock) 
		Limits the utilization of multiple cores
 	Processes
		a little faster than threads
	asyncIO
		more powerful
		bypasses GIL limitations

# Terms and definitions from Course 4, Module 2

* Activity Monitor: Mac OS tool that shows what's using the most CPU, memory, energy, disk, or network
* 
* Cache: This stores data in a form that's faster to access than its original form
* 
* Executor: This is the process that's in charge of distributing the work among the different workers
* 
* Expensive actions: Actions that can take a long time to complete
* 
* Futures: A module provides a couple of different executors, one for using threads and the other one for using processes
* 
* Lists: Sequences of elements
* 
* Memory leak: This happens when a chunk of memory that's no longer needed is not released
* 
* Profiler: A tool that measures the resources the code is using to see how the memory is allocated and how the time is spent
* 
* Real time: The amount of actual time that it took to execute the command
* 
* Resource Monitor (or Performance Monitor): Windows OS tool that shows what's using the most CPU, memory, energy, disk, or network
* 
* Sys time: The time spent doing system level operations
* 
* Threads: Run parallel tasks inside a process
* 
* User time: The time spent doing operations in the user space

# Week 3 
# Crashing Programs 

memtech86
	to check for health of RAM
linux: 
# some commands
	strace 
		to trace sys calls/signals.
	ptrace 
	netstat 
		gives a bunch of network stats
# some directories to find stuff
	/var/log 
	/etc/<app folder> 
		contains config files
	/srv/<app folder>
		stores data for services&apps
		i.e. 
			"example.com" web content (Saved)
			.py files for the service

mac
	dtruss (cmd)
	Console (app)
windows
	process monitor (app)
	Event Viewer (app)


to find root cause of a crash, look at;
	logs
	changes/new versions (change history in VCS maybe?)
	trace sys/library calls
	create reproduction case (as small as possible!)

Watchdog:
	a process that checks whether a program is running, and when it's not, starts the program again.
		run negative -> restart


* Answer these questions, when reporting a bug:
	- What were you trying to do?
	- What were steps you followed?
	- What did you expect to happen?
	- What was the actual outcome?
	- - Also, try to create a reproduction case and submit it as well. Will help wonders!

# Remarks
* Blue screen of death (BSoD)
* Event Tracing for Windows (ETW) 


