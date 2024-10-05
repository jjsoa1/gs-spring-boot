package com.example.springboot

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class Application {

    fun main(args: Array<String>) {
        SpringApplication.run(Application::class.java, *args)
    }

    @Bean
    open fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
        return CommandLineRunner { args ->
            println("Let's inspect the beans provided by Spring Boot:")

            val beanNames = ctx.beanDefinitionNames.sortedArray()
            for (beanName in beanNames) {
                println(beanName)
            }
        }
    }
}