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
