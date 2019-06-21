package com.knoldus

import com.knoldus.InfixToPostfix.getPostFixExpression
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}

import scala.collection.mutable

class InfixtoPostFixSpec extends WordSpec with ScalaFutures with Matchers {


  "InfixToPostFix#" should {
    "evaluate to post-fix" in {
      val array = Array("(", "A", "+", "B", "*", "C", ")")
      assert( mutable.Stack("*", "+", "C", "B", "A")  == getPostFixExpression(array.toList))
    }

    "not correctly evaluated" in {
      val array = Array("(", "A", "+", "B", "*", "C", "+", "D", ")")
      assert( mutable.Stack("*", "+", "C", "B", "A")  != getPostFixExpression(array.toList))

    }
  }
}
