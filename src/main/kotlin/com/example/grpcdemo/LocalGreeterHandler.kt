//package com.example.grpcdemo
//
//import org.springframework.context.annotation.Profile
//import org.springframework.stereotype.Service
//
//
//@Profile("!remote")
//@Service
//class LocalGreeterHandler : GreeterHandler {
//
//    override fun sayHello(request: HelloRequest): HelloReply {
//        val builder = HelloReply.newBuilder()
//        builder.message = "Hello ${request.name} from local handler"
//        return builder.build()
//    }
//}