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


🛠️ Technology Stack

<img width="410" height="188" alt="image" src="https://github.com/user-attachments/assets/f2ef2d19-72c5-4e7f-bf4a-ce22d3ece6a3" />


🌐 API Endpoints Overview
The base URL for all requests is http://localhost:8080/api.

Task List Endpoints (/api/task-lists)
<img width="868" height="381" alt="image" src="https://github.com/user-attachments/assets/f264caaf-69c4-4a0f-8669-cbaacdd882b5" />

Task Endpoints (/api/task-lists/{task_list_id}/tasks)
<img width="869" height="439" alt="image" src="https://github.com/user-attachments/assets/2c932cb3-41ac-4dd4-9aa3-a578aff83865" />

