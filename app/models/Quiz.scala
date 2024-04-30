package models

case class Question(id: Int, title: String, options: List[String], correctAnswer: Int)

case class Quiz(questions: List[Question])
