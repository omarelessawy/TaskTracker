🚀 Task Tracker API
A robust Task Tracking RESTful API built with Spring Boot and PostgreSQL. This application allows users to manage multiple task lists and the individual tasks within them, providing features like task progress calculation and basic error handling.

✨ Features
Task List Management: Create, read, update, and delete (CRUD) task lists.

Task Management: Create, read, update, and delete (CRUD) tasks within specific task lists.

Hierarchical Structure: Tasks are nested under their respective task lists (/task-lists/{id}/tasks).

Progress Tracking: Calculates and reports the progress (percentage of closed tasks) for each task list.

Persistence: Uses PostgreSQL for reliable data storage via Spring Data JPA.

Status & Priority: Tasks include OPEN/CLOSED status and HIGH/MEDIUM/LOW priority.

Global Error Handling: Provides consistent 400 Bad Request responses for validation errors.
