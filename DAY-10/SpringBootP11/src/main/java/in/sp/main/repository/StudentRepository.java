package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>
{
	
}


// The reason StudentRepository (and other repositories in Spring Data JPA) often have no code written in them is because of 
// the magic ofSpring Data JPA. When we extend JpaRepository, Spring Data JPA automatically generates the implementation of the most common 
// the most common CRUD (Create, Read, Update, Delete) methods.

// This interface StudentRepository is a Spring Data JPA Repository, which is responsible for interacting with the database and 
// performing CRUD (Create, Read, Update, Delete) operations on the Student entity.
// 1. To interact with the database easily using built-in methods.
// 2️. No need to write SQL queries manually – Spring Data JPA provides ready-made methods.
// 3️. Supports automatic query generation for operations like findById(), save(), delete(), etc.
//   Reason Behind Using These Two Parameters here JpaRepository<Student, Long>
//  1.Tells JPA which entity to manage
//  Student → Maps this repository to the student table.
//  This means StudentRepository will only handle Student entity operations.
//  2️. Specifies the type of Primary Key (id)
//
//Long → Ensures that JPA knows the Primary Key’s data type for queries like findById(Long id)
