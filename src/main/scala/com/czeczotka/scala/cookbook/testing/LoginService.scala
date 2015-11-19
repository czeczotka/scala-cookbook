package com.czeczotka.scala.cookbook.testing

trait LoginService {
  def login(name: String, password: String): Option[User]
}
