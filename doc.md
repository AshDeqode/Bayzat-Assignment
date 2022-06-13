# Backend Engineer Assignment
In this assignment, I corrected all the functional and logical bugs in the assignment, designed and created the REST API end points and jobs to update the team.

## Tools Used : 
- GIT for version control
- Gradle
- Java 8
- MySQL 5.6+ 
- Liquibase

## Application Constraints:
- At the time of registration the user has to choose whether he is a customer or a delivery man by mentioning "yes" or "no" at respective fields
- The delivery man commission is calculated in the delivery controller once the delivery man requests to create the delivery

## Completed Tasks:
1. Fixed logical and functional bugs in the codebase and written unit tests
2. End point to find top 3 delivery persons whose delivery has the maximum order price is at `/api/toppersons/{start-time}/{end-time}` here `{start-time}/{end-time}` are time time stamps of the interval in which top 3 delivery persons has to be find.
3. An asynchronous job is created which runs every 30 seconds and found out all the deliveries which are not completed in 45 minutes and updates the customer team and also gives them the details of all such deliveries.
4. Used Jococco to generate unit test coverage report.

## How to Run
Simply initiate the `BayzDeliveryApplication.java` spring boot main class and your REST application is ready to run.

## List of End Points
For Persons : 
1. `/api/person` and `method = RequestMethod.POST`
2. `/api/person` and `method = RequestMethod.GET`
3. `/api/person/{person-id}` and `method = RequestMethod.GET`

For Delivery : 
1. `/api/delivery` and `method = RequestMethod.POST`
2. `/api/delivery/{delivery-id}` and `method = RequestMethod.GET`

For Top 3 delivery persons whose delivery has the maximum order price : 
1. `/api/toppersons/{start-time}/{end-time}` and `method = RequestMethod.GET`
