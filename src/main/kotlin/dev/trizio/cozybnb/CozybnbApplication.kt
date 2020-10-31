package dev.trizio.cozybnb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CozybnbApplication

fun main(args: Array<String>) {
	runApplication<CozybnbApplication>(*args)
}
