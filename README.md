# Student Management System

Hệ thống quản lý sinh viên được xây dựng với **Spring Boot**, **Thymeleaf** (Server-Side Rendering), kết nối **PostgreSQL** trên [Neon.tech](https://neon.tech) và có thể deploy lên [Render](https://render.com) bằng Docker.

---

## Công nghệ sử dụng

| Thành phần | Công nghệ |
|-----------|-----------|
| Backend | Java 17, Spring Boot 4 |
| Template Engine | Thymeleaf (SSR) |
| ORM | Spring Data JPA / Hibernate |
| Database | PostgreSQL (Neon.tech) |
| Build tool | Maven |
| Containerization | Docker (multi-stage build) |
| Deploy | Render |

---

## Tính năng

- Xem danh sách sinh viên
- Tìm kiếm sinh viên theo tên (case-insensitive)
- Xem chi tiết sinh viên
- Thêm sinh viên mới
- Chỉnh sửa thông tin sinh viên
- Xóa sinh viên (có xác nhận)

---

## Cấu trúc project

```
src/
├── main/
│   ├── java/.../
│   │   ├── controller/
│   │   │   ├── StudentController.java      # REST API
│   │   │   └── StudentWebController.java   # Web (Thymeleaf)
│   │   ├── entity/
│   │   │   └── Student.java
│   │   ├── repository/
│   │   │   └── StudentRepository.java
│   │   └── service/
│   │       └── StudentService.java
│   └── resources/
│       ├── templates/
│       │   ├── students.html               # Danh sách + tìm kiếm
│       │   ├── student-detail.html         # Chi tiết
│       │   ├── student-form.html           # Thêm mới
│       │   └── student-edit.html           # Chỉnh sửa
│       └── application.properties
```

---

## Chạy local

### Yêu cầu
- Java 17+
- Maven 3.8+ (hoặc dùng `mvnw` đính kèm)
- PostgreSQL database (hoặc tạo free trên [Neon.tech](https://neon.tech))

### 1. Clone repo

```bash
git clone https://github.com/CmnguyenK106/Student-management.git
cd Student-management
```

### 2. Tạo file `.env`

```bash
cp .env.example .env
```

Điền thông tin kết nối database vào `.env`:

```env
DB_URL=jdbc:postgresql://<host>/<dbname>?sslmode=require
DB_USERNAME=<user>
DB_PASSWORD=<password>
```

> Lấy connection string từ: Neon Dashboard → **Connection Details** → chọn **JDBC**.

### 3. Chạy ứng dụng

```bash
./mvnw spring-boot:run
```

Truy cập: [http://localhost:8080/students](http://localhost:8080/students)

---

## REST API

| Method | Endpoint | Mô tả |
|--------|----------|-------|
| GET | `/api/students` | Lấy tất cả sinh viên |
| GET | `/api/students/{id}` | Lấy sinh viên theo ID |

---

## Web Routes

| Method | Endpoint | Mô tả |
|--------|----------|-------|
| GET | `/students` | Danh sách (có tìm kiếm `?keyword=`) |
| GET | `/students/{id}` | Chi tiết sinh viên |
| GET | `/students/new` | Form thêm mới |
| POST | `/students` | Lưu sinh viên mới |
| GET | `/students/{id}/edit` | Form chỉnh sửa |
| POST | `/students/{id}` | Cập nhật thông tin |
| POST | `/students/{id}/delete` | Xóa sinh viên |

---

## Deploy lên Render

### 1. Push code lên GitHub

Đảm bảo file `.env` đã có trong `.gitignore` (không bao giờ commit thông tin nhạy cảm).

### 2. Tạo Web Service trên Render

1. Đăng nhập [render.com](https://render.com) → **New + → Web Service**
2. Kết nối repo `CmnguyenK106/Student-management`
3. Render tự phát hiện `Dockerfile`, chọn runtime **Docker**

### 3. Thêm Environment Variables

Vào mục **Environment** trên Render dashboard, thêm:

| Key | Value |
|-----|-------|
| `DB_URL` | `jdbc:postgresql://...neon.tech/neondb?sslmode=require` |
| `DB_USERNAME` | `neondb_owner` |
| `DB_PASSWORD` | `your-password` |

### 4. Deploy

Nhấn **Create Web Service** — Render sẽ tự build Docker image và khởi chạy.

---

## Biến môi trường

| Biến | Mô tả | Bắt buộc |
|------|-------|----------|
| `DB_URL` | JDBC URL của PostgreSQL | ✅ |
| `DB_USERNAME` | Tên đăng nhập database | ✅ |
| `DB_PASSWORD` | Mật khẩu database | ✅ |
