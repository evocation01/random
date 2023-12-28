Test can help make good code great.

Manual testing
Automated testing:

Unit testing:
	"small, individual units" to be tested.
	"unittest" "pytest" frameworks.

	Regression tests:
		To verify that an error has been fixed once it's identified.
		Write a test -> fails (bug identified) -> fix the bug (test passes)
		Regression testing is a type of software test used to confirm that a recent program or code change has not adversely affected existing features, by re-executing a full or partial selection test cases.

	Smoke tests:
		Plug in a piece of hardware -> see if there is "smoke" coming out of it!
		detects MAJOR errors.
		"does the program run?"
		This test finds out if the program can run in its basic form before undergoing more refined test cases.
	Load tests:
		Under pressure/traffic --> see if it works well.

Integration Testing:
	testing interactions between different modules
	"unittest", "pytest"
	like "test_database"
White-Box Testing (Clear-Box) (Transparent Testing):
	Tester knows the code.
	Expected errors will be tested.
Black-Box Testing:
	Tester doesn't know the code. Code is opaque.
	Can detect exceptions that the coder didn't anticipate

TEST-DRIVEN-DEVELOPMENT:
	creating test BEFORE writing the code.


