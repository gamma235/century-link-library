# century-link-library
A library for calculating and summarizing costs for managers and their teams

To use, simply import century-link-library.core and begin

# notes
To run tests, you can call (run-tests) directly from a repl after loading the century-link-library.tests name-space; else you can call:
`java -cp /path/to/clojure.jar clojure.main -i file.to.run.clj` from the command line.

# TODO:
1. The tests are sparse at this point and are not checking for nil or against type. I have included assertions in the tree-walking function itself, however, so it should throw an exception if input is not a collection type or if output is not a sequence of keywords.
