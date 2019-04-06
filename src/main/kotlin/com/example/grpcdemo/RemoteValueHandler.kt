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

    override fun getValueByUuid(request: GetValueByUUIDRequest): GetValueResponse {
        return valueService.getValueByUUID(request)
    }

    override fun getValueByPath(request: GetValueByPathRequest): GetValueResponse {
        return valueService.getValueByPath(request)
    }

    override fun storeValue(request: StoreValueRequest): StoreValueResponse {
        return valueService.storeValue(request)
    }
}