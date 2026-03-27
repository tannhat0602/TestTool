# phungnhattan-portfolio

Personal portfolio website of **Phung Nhat Tan** — Backend Developer Intern.

Built with Spring Boot + Thymeleaf, displaying profile, projects, education, skills, and languages.

## Tech Stack

- **Backend:** Java 21, Spring Boot 4.0.3, Spring Data JPA
- **Frontend:** Thymeleaf, Bootstrap 5, Font Awesome
- **Database:** MySQL 8.0
- **DevOps:** Docker, Docker Compose

## Run Locally

**Requirements:** Docker & Docker Compose installed.

```bash
git clone https://github.com/tannhat0602/phungnhattan-portfolio.git
cd phungnhattan-portfolio
docker-compose up
```

Open [http://localhost:8080](http://localhost:8080)

## Project Structure

```
src/main/java/com/example/phungnhattan/
├── config/         # Data initializer
├── controller/     # Web controllers
├── entity/         # JPA entities (Profile, Project, Education, Skill, Language)
├── repository/     # Spring Data repositories
└── service/        # Business logic

src/main/resources/
├── templates/      # Thymeleaf HTML templates
└── static/css/     # Custom styles
```

## Docker Image

```bash
docker pull tannhat0602/phungnhattan
```
