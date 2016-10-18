package chap15

import math.{E, Pi}

object Patterns {

  val v = Var("x")
  val expr = BinOp("+", Number(1), v)
  val expr1 = 1

  // Wild-card patterns
  expr match {
    case BinOp(_, _, _) => println(expr + " is a binary operation")
    case _ => println("It's something else")
  }

  // Constant patterns
  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }

  // Variable patterns
  expr1 match {
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
  }

  val pi = math.Pi
  E match {
    case `pi` => "strange math? Pi = " + pi
    case _ => "OK"
  }

  // Constructor patterns
  expr match {
    case BinOp("+", e, Number(0)) => println("a deep match")
    case _ =>
  }

  // Sequence patterns
  val list = List(1, 2, 3)
  list match  {
    case List(0, _, _) => println("found it")
    case _ =>
  }

  // Sequence pattern with arbitrary length
  list match {
    case List(0, _*) => println("found it")
    case _ =>
  }

  // Tuple patterns
  def tupleDemo(expr: Any) = expr match {
    case (a, b, c) => println("matched " + a + b + c)
    case _ =>
  }

  // Typed patterns
  def generalSize(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }

  // Type Erasure: No information about type arguments is maintained at
  // runtime. Thus, there is no way to determine at runtime whether a given
  // Map object has been created with two Int arguments, rather than with
  // arguments of different types.
  /*
  def isIntIntMap(x: Any) = x match {
    case m: Map[Int, Int] => true
    case _ => false
  }
  */
  // The above function always returns true for any map.

  // The only exception to the erasure rule is arrays, because they are
  // handled specially in Java as well as in Scala. The element type of an
  // array is stored with the array value, so you can pattern match on it.
  def isStringArray(x: Any) = x match {
    case a: Array[String] => "yes"
    case _ => "no"
  }
}
