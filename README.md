# employee-api-security
Spring Boot REST Employee API with Spring Security.

## Endpoints
`GET` - `/employees`

Retrieves all employees. Requires `EMPLOYEE` role.

![Screenshot from 2024-12-10 18-47-02](https://github.com/user-attachments/assets/fc76e1ce-8a2d-40d8-a749-3726180a6511)

`GET` - `/employees/{employeeId}`

Find employee by ID. Requires `EMPLOYEE` role.

![Screenshot from 2024-12-10 18-47-46](https://github.com/user-attachments/assets/84fbd998-fc19-4402-a6d8-af44ec82b60b)

`POST` - `/employees`

Create employee. Requires `MANAGER` role.

![Screenshot from 2024-12-10 18-49-55](https://github.com/user-attachments/assets/af90fe16-eb58-4321-b16a-5eadf039569d)

`PUT` - `/employees`

Update an existing employee. Requires `MANAGER` role.

![Screenshot from 2024-12-10 18-50-58](https://github.com/user-attachments/assets/08a6a9f7-3172-412d-9c2a-41b8a8ee0459)

`DELETE` - `/employees/{employeeId}`

Deletes an employee. Requires `ADMIN` role.

![Screenshot from 2024-12-10 18-51-25](https://github.com/user-attachments/assets/6f62a792-6d90-43df-8131-fde26d03a190)


401 Unauthorized

![Screenshot from 2024-12-10 18-47-20](https://github.com/user-attachments/assets/519ddca6-9b9d-4f92-9eb0-493a9b59a509)

403 Forbidden
![Screenshot from 2024-12-10 18-49-18](https://github.com/user-attachments/assets/2436455a-cca2-489c-b206-6c450f16d42b)
