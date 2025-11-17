# 🚀 Task Tracker API

A robust and efficient RESTful API for comprehensive task management, built using **Spring Boot** and **PostgreSQL**. This application provides a solution for managing multiple hierarchical task lists, tracking progress, and ensuring data integrity with reliable persistence and global error handling.

## ✨ Key Features

* **Task List Management (CRUD):** Complete functionality to **C**reate, **R**ead, **U**pdate, and **D**elete task lists.
* **Task Management (CRUD):** Full CRUD operations for individual tasks nested within specific task lists.
* **Hierarchical Structure:** Tasks are logically nested under their respective task lists, accessed via paths like `/task-lists/{id}/tasks`.
* **Progress Tracking:** Automatically calculates and reports the progress (percentage of `CLOSED` tasks) for each task list.
* **Persistence:** Reliable data storage is ensured using **PostgreSQL** via **Spring Data JPA**.
* **Status & Priority:** Tasks support essential fields:
    * **Status:** `OPEN` or `CLOSED`.
    * **Priority:** `HIGH`, `MEDIUM`, or `LOW`.
* **Global Error Handling:** Consistent and predictable error responses, providing a uniform `400 Bad Request` for validation errors across the API.

## 🛠️ Technology Stack

| Category | Technology | Purpose |
| :--- | :--- | :--- |
| **Framework** | Spring Boot | Provides a rapid, robust foundation for the RESTful API. |
| **Database** | PostgreSQL | Reliable and scalable relational database for persistent storage. |
| **Data Access** | Spring Data JPA | Simplifies ORM and database interactions with repositories. |
| **Language** | Java | The core programming language for the application. |

## 🌐 API Endpoints Overview

The base URL for all requests is: `http://localhost:8080/api`

### Task List Endpoints (CRUD)

| HTTP Method | Path | Description |
| :--- | :--- | :--- |
| `GET` | `/task-lists` | Retrieve all task lists. |
| `POST` | `/task-lists` | Create a new task list. |
| `GET` | `/task-lists/{id}` | Retrieve a specific task list by ID, including its calculated progress. |
| `PUT` | `/task-lists/{id}` | Update an existing task list. |
| `DELETE` | `/task-lists/{id}` | Delete a task list. |

### Task Endpoints (Nested CRUD)

Tasks are nested under their parent task lists, adhering to the hierarchical structure.

| HTTP Method | Path | Description |
| :--- | :--- | :--- |
| `GET` | `/task-lists/{taskListId}/tasks` | Retrieve all tasks belonging to a specific task list. |
| `POST` | `/task-lists/{taskListId}/tasks` | Create a new task within the specified task list. |
| `GET` | `/task-lists/{taskListId}/tasks/{taskId}` | Retrieve a specific task by its ID. |
| `PUT` | `/task-lists/{taskListId}/tasks/{taskId}` | Update an existing task's details, status, or priority. |
| `DELETE` | `/task-lists/{taskListId}/tasks/{taskId}` | Delete a specific task. |
