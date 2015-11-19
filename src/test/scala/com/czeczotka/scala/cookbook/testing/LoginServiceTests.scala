package com.czeczotka.scala.cookbook.testing

import org.mockito.Mockito.when
import org.scalatest.mock.MockitoSugar
import org.scalatest.{BeforeAndAfter, FunSuite}

class LoginServiceTests extends FunSuite with BeforeAndAfter with MockitoSugar {

  test("test login service with mockito") {
    val service = mock[LoginService]

    when(service.login("johndoe", "secret")).thenReturn(Some(User("John Doe")))
    when(service.login("joehacker", "secret")).thenReturn(None)

    val johnDoe = service.login("johndoe", "secret")
    val joeHacker = service.login("joehacker", "secret")

    assert(johnDoe.get == User("John Doe"))
    assert(joeHacker.isEmpty)
  }
}