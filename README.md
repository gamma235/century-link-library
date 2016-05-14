# century-link-library
A library for calculating and summarizing costs for managers and their teams

To use, simply import century-link-library.core and begin

# notes
To run tests, you can call (run-tests) directly from a repl after loading the century-link-library.tests name-space; else you can call:
`java -cp /path/to/clojure.jar clojure.main -i file.to.run.clj` from the command line.

# TODO:

1. The structure of the data takes the form of vectors (e.g. []) for multiple items under a manager and maps (e.g. {}) for a new manager.
So, for example, a nested hierarchy may look like this {:manager [:developer :qa]} or {:manager {:manager[:developer :qa]}}. The current
library can handle arbitrarily deep trees, but cannot handle managers with multiple team-members as well as managers mixed in. To do this
will require a walk of the vector to look for maps, recurring again on that node when found.

2. The tests are sparse at this point and are not checking for nil or against type. It would be good to add them in and/or include
constraints in the original functions themselves.
