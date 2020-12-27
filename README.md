# HelpCenter

## Introduction

-This is a test automation project testing "Support & FAQ” webpage on desktop browser(on default chrome)

-Only the most important test scenarios are automated.

-Automated scenarios are;      

* Search with keywords that returns result

* Browse through the FAQ topics 

* Search with keyword that returns no result

    Note: I didn’t include Contact Support page because I didn’t want to submit request forms in real.                   

## Technology Used

* Java

* Selenium

* Junit

* TestNG

* Maven

## How to Run Tests

    mvn clean test

## Additional Information

- I used page object pattern with page factory. 

- On fail scenarios sreenshots are added to screenshots folder.

- Cross browser test can be executed by enabling or adding new test on testing.xml document. For Firefox enabling the written test is enough.

- Reruns failed tests

- Url and timeout informations are read from profile information of pom.xml (can also be read from application.properties file)

- Some custom logs are added to logs folder in html format. Some logs are created depending on events in Listener class.

- Ideally Chrome, Firefox, Opera, Safari, Edge and Internet Explorer browsers are supported but I tested with only Chrome and Firefox browser. I don’t guarantee that tests successfully run with all other browsers.