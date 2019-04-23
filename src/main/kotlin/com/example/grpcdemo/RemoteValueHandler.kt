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

    override fun setValue(request: SetValueRequest): SetValueResponse {
        return valueService.setValue(request)
    }

    override fun getValueById(request: GetValueByIdRequest): GetValueResponse {
        return valueService.getValueById(request)
    }

    override fun getValueByPath(request: GetValueByPathRequest): GetValueResponse {
        return valueService.getValueByPath(request)
    }

    override fun deleteValueById(request: DeleteValueByIdRequest): DeleteValueResponse {
        return valueService.deleteValueById(request)
    }

    override fun deleteValueByPath(request: DeleteValueByPathRequest): DeleteValueResponse {
        return valueService.deleteValueByPath(request)
    }
}