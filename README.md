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

Entity Relation Diagram
- (need to fill)

User Stories
- Requirements:
- Guest
    - As a guest, I can register for an account.
    - As a guest, I can log in to my account.
- User:
    - As a user, I have a profile which I can view.
    - As a user, I can browse posts on my feed 
    - As a user, I can make posts.
    - As a user, I can edit posts on my home page.
    - As a user, I can remove posts on my home page.


- Stretch Goals:
    -As a User, (fill)
    
Submission
Due Date: Thursday 6/16/2022 at 9:00 AM CST

Your project needs to be pushed into the main branch of your team's P3 repository no later than the due date and time above. Commits after this deadline will not be considered. On the due date there will be a presentation. You will be expected to briefly cover your project, and should be prepared to discuss it with QC.
