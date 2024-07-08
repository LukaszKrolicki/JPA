JPA – Java persistance API – it is a tool that allows programmers to map Java objects onto database tables and operate on them with objective approach instead of SQL.

1.Entity Creation

![image](https://github.com/LukaszKrolicki/JPA/assets/54467678/ffc64415-1d99-44dc-a3d0-df3b2d832951)

@Entiy means its JPA entity

@Table – it is mapped on Author table in database

@Id – it is a key

@GeneratedValue – 1,2,3…

![image](https://github.com/LukaszKrolicki/JPA/assets/54467678/bc3293f0-cfe2-4b76-9674-67bb6e29b85c)

@ManyToOne(cascade) – means that CRUD operation will also effect bounded Author entity in database

@JoinColumn – joins with id

2. Hibernate DDL
-Hibernate is ORM(Object Relational Mappin) framework for Java. It is used to map Java object onto Database

-Take care of CRUD operations 

-Thanks to Hibernate it is easier to change Database

3. Creating Entities

![image](https://github.com/LukaszKrolicki/JPA/assets/54467678/51959a74-a47d-4d18-bab7-63b36b47194d)

![image](https://github.com/LukaszKrolicki/JPA/assets/54467678/8c68305d-3b45-47f6-ba1e-88c4ea88372a)

4. Add, FindOne

![image](https://github.com/LukaszKrolicki/JPA/assets/54467678/317b372c-522a-47e8-8a8a-e3d626ebb699)

CRUD repository automatically creates CRUD operations

![image](https://github.com/LukaszKrolicki/JPA/assets/54467678/c6153d37-77ac-4a19-801e-76cbf32632b8)

Save(), findById() – thats all

5. Findall, update, delete

Findall:

![image](https://github.com/LukaszKrolicki/JPA/assets/54467678/f2fadf49-8fc5-4a08-b877-b6a62438e2da)

Update:

![image](https://github.com/LukaszKrolicki/JPA/assets/54467678/dabc6b9c-5634-4d4d-8755-caa5d457400c)

Delete:

![image](https://github.com/LukaszKrolicki/JPA/assets/54467678/4d8a4693-97b0-4311-91c5-8d7495068140)

6. CustomQueries

![image](https://github.com/LukaszKrolicki/JPA/assets/54467678/8bf0faa4-12eb-4c9d-b5c0-a854cdc51b7e)

Thats all… you dont need to do anything, JPA is clever enough to look at authors and get with age less, based just on name of the method

7.HQL

HQL – Hibernate query language. HQL is similiar to SQL but works on Java objects instead of SQL tables

![image](https://github.com/LukaszKrolicki/JPA/assets/54467678/b38110f6-e4c5-429a-8853-599ed5c0ebc2)

We make this name on purpose

![image](https://github.com/LukaszKrolicki/JPA/assets/54467678/2c4483f4-7145-4949-805a-312663b522a2)

Select all objects marked as a where age is …


