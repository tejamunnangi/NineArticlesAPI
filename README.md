# NineArticlesAPI

Pre-requisites
----------------------
1. Apache Maven 3.6.2
2. JDK 1.8
3. Git

Intallation Instructions
--------------------------------------
1. Clone / Download the source code using the below command into your local environment:

https://github.com/tejamunnangi/NineArticlesAPI.git

2. Open the project directory in a terminal

3. In the root directory of the app, execute the below command (You need to set up maven in your environment path):

mvn clean package

4. Execute the below command:

java -jar NineArticlesAPI-0.0.1-SNAPSHOT.jar

5. Application runs on an embedded tomcat app server on the port 8080 and can be accessible using the localhost.

For example, you can make a post request with a body to save the articles using http://localhost:8080/articles end-point.

Solution Rationale
-----------------------------------------------------

I've used spring boot framework for quick bootstrapping of the application.

The project is packaged based on the MVC pattern where the HTTP rest requests are received by controller classes which then are passed to the service layer for business logic.

I have used H2 IN-MEMORY database for quick db setup.

Data validation is incomplete owing to insufficient time but a basic architecture is established to handle them.

Exception handling is done using @ControllerAdvice annotation of spring framework. This will make global exception handling of the layers very simple to maintain.

Owing to the lack of sufficient time, I have only handled exceptions for ArticleController, but this gives an idea of how error handling is approached.

One of the things I learned is to throw 422 response code instead of 400 for granular understanding of the error type. For further details, please refer to the below URL:
https://www.bennadel.com/blog/2434-http-status-codes-for-invalid-data-400-vs-422.htm

Assumptions
-----------------------------------

As previously mentioned, data sanitization couldn't be done but the idea was to use Hibernate Validators on each input object that enters the API.

For the ArticleTagResponse, I assumed the tags that were used in the articles for the given date should only be returned and only those tags that are related to those articles need to be returned.

Test Feedback
----------------------------------------

The premise of this format of testing is innovative and straight forward. Rather than coding few lines in a tight schedule, I took some time every day (1 hour) to work our way through creating solutions.

It took me 6 hours over 5 days to finish this assignment from project bootstrap to this documentation.

If I had more time, I would have implemented the input validations, logging, java/api spec documentation, more test coverage and comprehensive test cases and exception handling of the code.

