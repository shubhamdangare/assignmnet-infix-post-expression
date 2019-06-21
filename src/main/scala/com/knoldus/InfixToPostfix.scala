package com.knoldus

import scala.collection.mutable.Stack

object InfixToPostfix extends App {

  def getPostFixExpression(expression: List[String]): Stack[String] = {

    val infixExpression = Stack[String]()
    val operators = Stack[String]()
    val precedence: Map[String, Int] = Map("+" -> 2, "-" -> 2, "*" -> 1, "/" -> 1, "(" -> 3, ")" -> 3)

    for (i <- expression.indices) {
      if (expression(i) <= "Z" && expression(i) >= "A" || expression(i) <= "z" && expression(i) >= "a") {
        println(expression(i) + " infix stack")
        infixExpression.push(expression(i))
      }
      else {
        if (expression(i) == "(") {
          println(expression(i) + " operator stack")
          operators.push(expression(i))
        }
        else {
          if (expression(i) == ")") {
            println(expression(i) + " operator stack pop out")
            val lastOperator = operators.popAll
            for (i <- 1 to lastOperator.length - 1) {
              infixExpression.push(lastOperator(i))
            }
          }
          else {

            if (operators.nonEmpty) {

              if (precedence(expression(i)) < precedence(operators.top)) {
                println(expression(i) + " operator push stack for operators")
                operators.push(expression(i))
                println(operators)
              }
              else if (precedence(expression(i)) >= precedence(operators.top)) {
                println(expression(i) + " get operator from infix stack")
                infixExpression.push(expression(i))
                println(operators)
              }
            }
          }
        }
      }
    }
    infixExpression
  }


}
