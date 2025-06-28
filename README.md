# Quizdemic
This is a quizz app on various subjects for computer science students on their core courses 

Project Description:
This Java-based offline application integrates a quiz system with data visualization to assess and analyze student performance using strong Object-Oriented Programming (OOP) principles. The system includes:

User Authentication: Separate login systems for students and admins with secure data handling.

Quiz Module:

Admins can create, edit, and delete quizzes and questions.

Students can attempt quizzes by subject and receive immediate feedback and scores.

Question Types: Supports multiple choice and true/false questions using polymorphism and an abstract Question class.

Data Storage: All user data, quiz content, and results are saved and read from local text files, ensuring offline operation and persistence.

Visualization Module:

Generates charts such as bar graphs, line graphs, pie charts, and histograms.

Visualizes individual and subject-wise performance.

Allows customization of chart titles, labels, color schemes, and axis scaling.

Chart Management: A central controller handles chart creation, update, deletion, and display through inheritance and encapsulated logic.

OOP Integration:

Classes like User, Admin, Student, Quiz, Question, Chart, and specific chart types are implemented using encapsulation and inheritance.

Polymorphism is used in methods like draw() and display(), which behave differently depending on the object type.

Exception handling ensures smooth operation during invalid input, file errors, or system misuse.

This application provides a complete offline solution for academic institutions to conduct quizzes and visualize student performance interactively without using collections or databases.


