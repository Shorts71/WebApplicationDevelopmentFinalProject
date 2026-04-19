# Java Spring Inventory Management System

## Overview

This application serves as an inventory website for a warehouse company. It is intended to hold a database of various
brands, products, and contains orders that would be delivered to the manager's respective company (For example, the
manager of a Nike store would request to a staff member an order of product, which the staff member would put in the
system). Staff members can make orders, and company managers can make brands and products in the system.

---

## How to run with Docker

### Option A:

After cloning the project to your repository and opening Docker, you can either build the docker images on your own
using:

```
docker compose build
```

and then use the command

```
docker compose up-d
```

to start the application.

### Option B:

Because a docker-compose.yml is present in the project, you can also pull the images without touching the source code.
Instead of the above method, use:

```
docker compose pull
```

and then start the application with:

```
docker compose up -d
```

In either case, the application can be accessed by visiting

```
localhost:8080
```

## Contributions

### Tyler

- Added user roles
- Implemented security structure
- hosted Github repository

### Samsun Verja

- Added Docker and MySQL functionality
- Designed database structure and entity relationships

### Aneesa Tariq

- Planned UI layout
- Organized page structure

### Sajan Thavarasa

- Organized Spring Boot Project structure
- Organized application layers
- Contributed to backend structure

