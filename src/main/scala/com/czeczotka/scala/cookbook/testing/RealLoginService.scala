package com.czeczotka.scala.cookbook.testing

class RealLoginService extends LoginService {

  override def login(name: String, password: String): Option[User] = Some(User("Henry"))

}