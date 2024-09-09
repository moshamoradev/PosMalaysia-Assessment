This Repo contains two set of question/section

1. API testing - Postman
  - use any of the two json file 'PosMalaysia.postman_collection.json' or 'PosMalaysia - Run using existing .json file.postman_collection.json'
  - first file can be simply imported to Postman and run.
  - 2nd file require user to add data file 'data.json', during Collection Run

2. Test Automation - Selenium Java Maven with Cucumber BDD
  - To run, import into any IDE (IntelliJ or Eclipse) as Maven project
  - the directory structure contains :
      - src/main/java/pages/**RateCalculatorPage**
          - Page file with Page Object Model structure
      - src/main/java/pages/**WebDriverManagerClass**
          - contains implementation of bonigarcia's WebDriverManager, that auto downloads chromedriver based on user's version
      - src/test/java/**TestRunner**
          - simple TestRunner in CucumberBDD format
      - src/test/java/**StepDefinitions**
          - contains all the test steps, which are written in parallel with a Cucumber .feature 
      - src/test/resources/**test.feature**
          - feature file that contains Gherkin language test step, which focus on readable steps
          - this is mirroed in StepDefinitions.java 
