# Classroom

You are the class monitor and you want to maintain the structure of the classroom by making a simple spring boot application to perform basic CRUD operations. 

There are 3 ways to define the structure of the classroom:
1. Add a new student to the classroom.
2. Add a new teacher to the classroom. 
3. Add a student-teacher pair denoting that the student is taught by given teacher

### Requirements of the application:
Make an MVC architecture, with Student and Teacher as your only model classes, which will have some fields as their properties, constructors and getters-setters. 
Then make a controller, service and repository class with appropriate annotations. 
Since you want to keep it simple, you don’t need to use any database. (Hint: Think HashMap(s))

### Implement the logic for following functionalities:

#### Add a Student: 
    **POST /students/add-student** 
    Pass the Student object as request body Return success message wrapped in a ResponseEntity object Controller Name - addStudent

#### Add a teacher: 
    **POST /students/add-teacher** 
    Pass the Teacher object as request body Return success message wrapped in a ResponseEntity object Controller Name - addTeacher

#### Pair an existing student and teacher: 
    **PUT /students/add-student-teacher-pair** 
    Pass student name and teacher name as request parameters Return success message wrapped in a ResponseEntity object Controller Name - addStudentTeacherPair

#### Get Student by student name: 
    **GET /students/get-student-by-name/{name}** 
    Pass student name as path parameter Return Student object wrapped in a ResponseEntity object Controller Name - getStudentByName

#### Get Teacher by teacher name: 
    **GET /students/get-teacher-by-name/{name}** 
    Pass teacher name as path parameter Return Teacher object wrapped in a ResponseEntity object Controller Name - getTeacherByName

#### Get List of students name for a given teacher name: 
    **GET /students/get-students-by-teacher-name/{teacher}** 
    Pass teacher name as path parameter Return List of students name(List()) wrapped in a ResponseEntity object Controller Name - getStudentsByTeacherName

#### Get List of all students added: 
    **GET /students/get-all-students** 
    No params or body required Return List of students name(List()) wrapped in a ResponseEntity object Controller Name - getAllStudents

#### Delete a teacher and its students from the records: 
    **DELETE /students/delete-teacher-by-name**
    Pass teacher’s name as request parameter Return success message wrapped in a ResponseEntity object Controller Name - deleteTeacherByName

#### Delete all teachers and all students by them from the records: 
    **DELETE /students/delete-all-teachers** 
    No params or body required Return success message wrapped in a ResponseEntity object Controller Name - deleteAllTeachers

### Please make the following classes and make sure you name them exactly as following:

1. StudentController.java
2. StudentService.java
3. StudentRepository.java
4. Student.java
5. Teacher.java

**_Note:_**

Use ResponseEntity object to return the required objects in the controllers
Make sure you follow the requirements for the controller very very carefully or your application will give compilation error while running against hidden test cases
Test all the APIs in postman before you submit.