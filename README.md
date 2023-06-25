# hurt-me-planty

## Maven prompt commands to run tests:

_to run the main GoogleCloud test:_
> mvn clean test -Dbrowser=chrome -Dtestsuite=src/test/resources/testng-main.xml

_to run the SendEstimationToEmail test:_
> mvn clean test -Dbrowser=chrome -Dtestsuite=src/test/resources/testng-extended.xml

_to run all the test suites together (could be used as a parameter to run all the tests in one Jenkins job):_
> mvn clean test -Dbrowser=chrome -Dtestsuite=src/test/resources/testng-suite.xml
