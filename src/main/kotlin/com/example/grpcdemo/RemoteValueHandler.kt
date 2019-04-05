package com.example.grpcdemo

import io.grpc.ManagedChannelBuilder
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Profile("remote")
@Service
class RemoteValueHandler: ValueHandler {

    val valueService: ValueStoreGrpc.ValueStoreBlockingStub = ValueStoreGrpc
            .newBlockingStub(
                    ManagedChannelBuilder
                            .forAddress("localhost", 10000)
                            .usePlaintext()
                            .build()

    )

    override fun getValue(request: GetValueRequest): ValueResponse {
        return valueService.getValue(request)
    }

    override fun storeValue(request: StoreValueRequest): ValueResponse {
        return valueService.storeValue(request)
    }


}