# Project 3 Revamedia

## Summary
Revamedia is a social media app which allows Revature employees to communicate amongst each other. As a user, you will be able to register and log in. Users will also be able to search for others, follow them, create groups and teams. In addition, Revamedia is also rich with customizables features such as light and dark mode, changing passwords, notifications, and more. Lastly, Revamedia would like to keep a clean environment and includes a profanity filter to keep it professional.


# Tech Stack
- Languages
    - Java
    - JavaScript
    - TypeScript
- Data Persistence
    - PostgreSQL
    - Hibernate
- AWS
    - RDS
    - S3
    - CodeBuild & CodePipeline
    - ElasticBeanstalk
- Spring Framework
    - Spring Boot
    - Spring MVC
    - Spring Data JPA
- Angular


Functional Requirements
- Required:
    - Domain objects persisted in relational database via ORM
    - All CRUD functionality accessible via RESTful API
    - Single page web UI to consume RESTful API
    - Workflows to complete all user stories
    - Validate all user input
    - Unit test coverage for service-layer classes
    - Stretch Goals:
    - Application is merged, tested, and deployed with a fully functional CI/CD Pipeline
    - Architecture Diagram Explanation

The persistence layer shall use Hibernate ORM to translate between the database and the application server. The API layer shall abstract away the low-level servlets with Spring Web MVC. The client shall use Angular to produce an SPA which is styled to be functional and readable. The server should follow a proper layered architecture, and have adequate unit testing of the service layer. The client and server should communicate in a RESTful manner, and the server should be stateless.

# Entity Relation Diagram
- (https://www.figma.com/file/c92vLAv3SncE2s9uDAKtlW/P2-DB-MODEL-DESIGN?node-id=205%3A2
)

# User Stories
## Requirements:
### Guest
    - As a guest, I can register for an account.
    - As a guest, I can log in to my account.
### User:
    - As a User, I should be able to create a post with text and images.
    - As a User, I should be able to like another user's post.
    - As a User, I should be able to comment on posts or reply to comments on posts.
    - As a User, I should have a post feed that displays other user's posts.

## Stretch Goals:
    - As a user, I have a profile which I can view.
    - As a User, I should be able to create and maintain a profile page that is visible to other users.
    - As a User, I should be able to follow another user to see their posts on my feed. My feed should only displays posts from user that I follow.
    - As a User, I should be able to reset my password.
    - As a User, I should be able to change the color scheme from the normal mode to a dark mode option.
    - As a User, I should be able to join a live chatroom with others and only see messages when I am in the room.
    - As a User, I should be able to upload an image as a profile picture.
    - As a User, I should be able to bookmark or save specific posts in order to reference them later.
    - As a User, I should be able to add YouTube links to my posts.
    - As a User, I should be able to host or join events on the social media platform. 
    - As a User, I should receive notifications when another user interacts with my post or follows me.
    - As a User, I should be able to create or join a group/team where there can be collaborative posts only for the group/team to view.
    - As a User, I should be able to choose other users that I want to see first in my feed. Their posts should show before others.
    - Integrate a profanity filter api to ensure that no posts can be submitted with profanity in them to ensure a professional social media environment.
    
## Research Goals(Minimum 4 features required):
### Security
    - Add extra security to all passwords by encrypting them via password hashing.
    - Implement Two-Factor Authentication into your extended security measures. This two-factor auth can use email or SMS.
    - Implement Spring Security in your application to help manage authentication per request.
    - Implement Identity Server in your application to help manage authentication per request.
    - Integrate with and rely on Firebase for user management and authentication.
        This will allow us to pass the responsibility of managing and securing user credentials to an external system.
    - Integrate with and rely on Auth0 for user management and authentication.
        This will allow us to pass the responsibility of managing and securing user credentials to an external system.
### Testing
    - Achieve a minimum of 70% unit test code coverage across your frontend and backend applications.
    - Write unit tests before writing application logic then write application logic to pass your tests.
        This should produce code with fewer bugs and errors as well as higher code coverage.
    - Using Selenium and Cucumber define the behavior you expect the application to follow and write application logic to fulfill that.
        This should help you reduce unnecessary code and wasted effort.
    - Integration testing is the next testing step after unit testing, where we test the software with the units working together. Basically expand the concept of unit testing with no need to mock or intercept method calls
    - Run Penetration Testing against your application to probe for security risks, then refactor the application to be more secure.
### Deployment
    - (DevOps team fill please)
### Database
    - (Backend team fill please)
    - Leverage an H2 database in the dev environment and a cloud managed database for the production/hosted environment.
        H2 is an in memory database which offers some quality of life functionality for local development.


# Submission
## Due Date: Thursday 6/16/2022 at 9:00 AM CST

Your project needs to be pushed into the main branch of your team's P3 repository no later than the due date and time above. Commits after this deadline will not be considered. On the due date there will be a presentation. You will be expected to briefly cover your project, and should be prepared to discuss it with QC.
