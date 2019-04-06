package com.example.grpcdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter

@SpringBootApplication
class GrpcdemoApplication {
    @Bean
    fun protobufJsonFormatHttpMessageConverter(): ProtobufJsonFormatHttpMessageConverter {
        return ProtobufJsonFormatHttpMessageConverter()
    }
}

fun main(args: Array<String>) {
    runApplication<GrpcdemoApplication>(*args)
}


