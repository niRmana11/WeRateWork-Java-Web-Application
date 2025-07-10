# 💼 WeRateWork - Employee Satisfaction Web App

**WeRateWork** is a full-stack employee satisfaction web application built to collect, manage, and analyze employee feedback across different job roles and work categories.

Employees can anonymously rate their workplace experience, while administrators gain insights through an interactive dashboard to make data-driven decisions and improve work culture.

---

## ✨ Features

### 👤 Employee Features

- **Rate Job Categories:-**  Rate various work-related categories on a scale of 1–5.
- **Add Comments:-**  Submit optional feedback comments.
- **Smart Form UX:-**  Emoji-based rating selection for an engaging experience.
- **Category & Role Selection:-**  Auto-filled dropdowns for category and role.
- **Edit Ratings Inline:-**  Update ratings directly from the profile page.
- **View Submitted Ratings:-**  View all past ratings and comments.
- **Profile Management:-**  Update personal details and job role.

---

### 🛠️ Admin Features

- **Admin Dashboard:**
  - 📊 Bar Chart: Average rating by category
  - 🥧 Pie Chart: Rating distribution
  - 📈 Line Chart: Trends over time

- **Filters & Management:**
  - Filter ratings by date range, category, and job role.
  - Add or delete job categories and roles.
  - View a detailed rating table with category, role, score, comment, and date.

---

### 🧩 Technical Highlights

- ✅ **Authentication:** Secure login system for users and admins.
- 🔐 **Protected Routes:** Access control with session handling.
- 🎨 **Modern UI/UX:** Mobile-friendly layout, gradient buttons, and dark theme.
- 🔄 **Dynamic Data Loading:** Real-time filter updates and dropdowns from backend.
- 🧹 **Reset Filters:** Instantly reload complete rating data.

---

## 🛠️ Technologies Used

### 🚀 Backend

- **Java 22**
- **Spring Boot**, **Spring MVC**, **Spring Data JPA**
- **Hibernate**
- **MySQL** (Managed using **MySQL Workbench 8.0 CE**)
- **Maven**

---

### 🎨 Frontend

- **HTML5**, **CSS3** (Internal styling)
- **JavaScript (ES6)**
- **Chart.js** – Visualizations
- **Font Awesome 6.5** – Icons

---

### 💻 Tools & Platforms

- **IntelliJ IDEA** – Development IDE
- **MySQL Workbench** – DB Management
- **Git** & **GitHub** – Version control and collaboration
- **Postman** – API testing

---

### 📁 Others

- **JSON** – Backend-frontend data exchange
- **Sessions/Cookies** – Basic session management
- **Browser Dev Tools** – Debugging

---

## User Interfaces

### Home Page
![home](https://github.com/user-attachments/assets/bff4e51c-136a-4803-8fda-3818a7c27f86)

### Login Page
![login](https://github.com/user-attachments/assets/006c6e13-a7bf-42eb-8487-03358a89b849)

### Register Page
![register](https://github.com/user-attachments/assets/619450b4-380e-405d-b5c7-69c77c491f24)

### Rating Page (User)
![ratingPage](https://github.com/user-attachments/assets/c8f732ab-9ab9-4477-af91-0a66697992ee)

### Profile (User)
![userProfile](https://github.com/user-attachments/assets/4681a84c-a898-455a-8c4d-f5db63150d78)

### Dashboard (Admin)
![adminDashboard](https://github.com/user-attachments/assets/fcd64256-4148-4d8a-b986-6de931eee8f6)

### Manage Page (Admin)
![manage](https://github.com/user-attachments/assets/07ec4a70-968c-468c-b069-e3cb344d2426)

### Profile (Admin)
![adminProfile](https://github.com/user-attachments/assets/1b8427e8-8786-4e7c-b2b3-4e0e4d3aa3a4)

---

## 📂 Project Structure

<pre> ```text BackEnd ├── controller │ ├── AdminController.java │ ├── AuthController.java │ ├── CategoryController.java │ ├── ProfileController.java │ ├── RatingController.java │ └── RoleController.java ├── dto │ └── CategoryRatingSummary.java ├── model │ ├── Category.java │ ├── Rating.java │ ├── Role.java │ └── User.java └── repository ├── CategoryRepository.java ├── RatingRepository.java ├── RoleRepository.java └── UserRepository.java FrontEnd ├── admin │ ├── adminManage.html │ ├── adminProfile.html │ └── dashboard.html └── user ├── home.html ├── login.html ├── profile.html ├── ratingPage.html └── register.html ``` </pre>

---

## 🔗 API Endpoints

### 🔐 Authentication

| Method | Endpoint         | Description             |
|--------|------------------|-------------------------|
| POST   | `/auth/login`    | Login user              |
| POST   | `/auth/register` | Register new user       |
| GET    | `/auth/me`       | Get logged-in user info |
| GET    | `/auth/logout`   | Logout current user     |

---

### 👥 User Profile

| Method | Endpoint             | Description         |
|--------|----------------------|---------------------|
| GET    | `/profile`           | Get user profile    |
| PUT    | `/profile/update`    | Update user profile |

---

### 🗳️ Ratings

| Method | Endpoint         | Description              |
|--------|------------------|--------------------------|
| GET    | `/ratings`       | Get all ratings          |
| POST   | `/ratings`       | Submit a new rating      |
| PUT    | `/ratings/{id}`  | Update an existing rating|
| DELETE | `/ratings/{id}`  | Delete a rating          |

---

### 🗂️ Categories

| Method | Endpoint              | Description                 |
|--------|-----------------------|-----------------------------|
| GET    | `/categories`         | Get all categories          |
| POST   | `/categories`         | Add new category (Admin)    |
| DELETE | `/categories/{id}`    | Delete category (Admin)     |

---

### 🧑‍💼 Roles

| Method | Endpoint           | Description              |
|--------|--------------------|--------------------------|
| GET    | `/roles`           | Get all roles            |
| POST   | `/roles`           | Add new role (Admin)     |
| DELETE | `/roles/{id}`      | Delete role (Admin)      |

---

### 📊 Admin - Rating Summary

| Method | Endpoint                   | Description                        |
|--------|----------------------------|------------------------------------|
| GET    | `/admin/ratings-summary`   | Get all ratings with filters       |

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to fork this repo and submit a pull request.

---

## 📃 License

This project is open source and available under the [MIT License](LICENSE).

---

## 📬 Contact

Have questions or suggestions? Reach out via GitHub Issues or message me directly.

---



       











