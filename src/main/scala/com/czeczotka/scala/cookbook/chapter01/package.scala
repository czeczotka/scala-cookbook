package com.czeczotka.scala.cookbook.chapter01

package object utils {

  implicit class StringImprovements(val s: String) {
    def increment: String = s.map(c => (c + 1).toChar)
  }
}
