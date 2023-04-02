# web-service

**Project Web API for CRUD operations for employees and projects.**

The program has three entities:
* Projects (CRUD)
* Tasks (CRUD, but subject to the presence of a project and a user)
* Employees (users) (CRUD)

The program uses a Postgresql relational remote database and a Model-View-Controller data partitioning scheme.
The program has Exception handling, outputs logs and records the history of operations in the database.