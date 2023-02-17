package com.kaio.klist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KlistApplication

fun main(args: Array<String>) {
	runApplication<KlistApplication>(*args)
}
