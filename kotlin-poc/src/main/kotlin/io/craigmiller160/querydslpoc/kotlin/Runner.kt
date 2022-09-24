package io.craigmiller160.querydslpoc.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication class Runner

fun main(args: Array<String>) {
  runApplication<Runner>(*args)
}
