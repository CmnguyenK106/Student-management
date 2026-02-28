# Student Management System

Hệ thống quản lý sinh viên được xây dựng với **Spring Boot**, **Thymeleaf** (Server-Side Rendering), kết nối **PostgreSQL** trên [Neon.tech](https://neon.tech) và deploy lên [Render](https://render.com) bằng Docker.

🌐 **Live demo:** [https://student-management-wtqm.onrender.com](https://student-management-wtqm.onrender.com)

> **Lưu ý:** Hệ thống sử dụng Render Free tier, app có thể mất ~50 giây để khởi động nếu không có request trong thời gian dài.

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

### Quản lý sinh viên
- **Xem danh sách** — hiển thị toàn bộ sinh viên dưới dạng bảng
- **Tìm kiếm theo tên** — tìm kiếm không phân biệt hoa thường (case-insensitive)
- **Xem chi tiết** — xem đầy đủ thông tin của từng sinh viên
- **Thêm mới** — nhập thông tin và lưu sinh viên vào database
- **Chỉnh sửa** — cập nhật thông tin sinh viên đã có
- **Xóa** — xóa sinh viên với hộp thoại xác nhận trước khi thực hiện

### REST API
| Method | Endpoint | Mô tả |
|--------|----------|-------|
| GET | `/api/students` | Lấy tất cả sinh viên |
| GET | `/api/students/{id}` | Lấy sinh viên theo ID |

---

## Hỗ trợ AI trong phát triển

Hệ thống này được phát triển có sự hỗ trợ của **GitHub Copilot** (Claude Sonnet) trong suốt quá trình xây dựng:

- **Sinh code** — tạo nhanh các lớp Entity, Repository, Service, Controller theo đúng cấu trúc Spring Boot
- **Thiết kế giao diện** — hỗ trợ tạo các template Thymeleaf (`students.html`, `student-detail.html`, `student-form.html`, `student-edit.html`)
- **Cấu hình hệ thống** — hướng dẫn kết nối PostgreSQL Neon.tech, cấu hình biến môi trường `.env`, `application.properties`
- **Debug** — phát hiện và hướng dẫn sửa các lỗi như form đặt sai vị trí trong HTML, lỗi 404 thiếu root route, lỗi driver JDBC không đọc được biến môi trường


