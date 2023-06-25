# hurt-me-planty

# Maven prompt commands to run tests:

to run the main GoogleCloud test:
mvn clean test -Dbrowser=chrome -Dtestsuite=src/test/resources/testng-main.xml

to run the SendEstimationToEmail test:
mvn clean test -Dbrowser=chrome -Dtestsuite=src/test/resources/testng-extended.xml

to run all the test suites together (could be used as a configuration setup to run all tests in one Jenkins pipeline)
mvn clean test -Dbrowser=chrome -Dtestsuite=src/test/resources/testng-suite.xml
