## Scenarios that are not covered by the existing test 
* Press "Absenden" without filling in anything: 
* Enter a space several times while in the field, and then press "Absenden".
* Enter a minus, fill in the field with the maximum number of letters, and click "Absenden".
* Enter your email with special characters and click "Absenden".
* Introduce cross-site scripting - enter the following script: <script> alert ("I hacked this!") </script> and click the "Absenden" button.
* Enter an email that is already included in the mailing list click the "Absenden" button.
* Enter email without domain and click "Absenden".

**If we know what should be entered in this field, and what the data restrictions are, we can conduct the following series of checks:**
* If the field expects a special @ symbol, try to enter a value with two special @ symbols and press the "Absenden" button.
* Fill in the field with the maximum number of letters, and then click "Absenden".
* Fill in the field with the minimum number of letters, and then click "Absenden".
* Fill in the field with a value above the maximum and below the minimum, and a value twice the maximum, including the domain, and click "Absenden".
## List of cases that need to be automated for regression:
* Entering a zero value.
* Entering emptiness.
* Enter the maximum length or maximum value.
* Enter the minimum length or minimum value.
* Enter a value that exceeds the maximum length or the maximum allowed.
* Entering a value less than the minimum.

### Testing Strategies
**Firstly** when choosing a testing strategy for the test cases that I described: functional types of testing can be used. 
**Secondly**, also types of testing related to changes such as regression testing, smoke testing. 
**Finally**, when testing, you can use test design techniques, and testing black, white, and gray boxes.

### Jenkins
Unfortunately, I haven't created any Jenkins projects before so I wasn't able to set up Jenkins completely. I have added a `JenkinsFile` that contains a pipeline that would run tests inside jenkins environment.

## Test Architecture
* I have used page objects for the email page and newsletter page
* The base abstract test is used to initialize the web driver and some helpful functions
* I have created a testing Outlook email to receive newsletter mails. The downside of it is that if something on the Outlook side changes - the tests would be broken.

## How to run

**From IDE**
Run tests in NewLetterSubscriptionTest class

**From command line**
Maven must be installed beforehand
```
mvn clean test
```



