package com.example.grpcdemo

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*


@Profile("!remote")
@Service
class LocalValueHandler(val valueRepository: ValueRepository) : ValueHandler{
    override fun setValue(request: SetValueRequest): SetValueResponse {
        val value = Value(UUID.randomUUID().toString(),request.path, request.value )
        val instant = Instant.now().toString()
        val save = valueRepository.save(value)
        return SetValueResponse
                .newBuilder()
                .setPath(save.path)
                .setId(save.id)
                .setCreatedAt(instant)
                .build()
    }

    override fun getValueById(request: GetValueByIdRequest): GetValueResponse {
        val id = request.id
        val findById = valueRepository.findById(id).orElseGet {Value("", "")}
        return GetValueResponse
                .newBuilder()
                .setId(findById.id)
                .setValue(findById.value)
                .build()

    }

    override fun getValueByPath(request: GetValueByPathRequest): GetValueResponse {
        val path = request.path
        val findByPath = valueRepository.findByPath(path).orElseGet {Value("", "")}
        return GetValueResponse
                .newBuilder()
                .setId(findByPath.id)
                .setValue(findByPath.value)
                .build()
    }

    override fun deleteValueById(request: DeleteValueByIdRequest): DeleteValueResponse {
        val id = request.id
        val findById = valueRepository.findById(id).orElseGet {Value("", "")}
        valueRepository.deleteById(id)
        return DeleteValueResponse
                .newBuilder()
                .setId(findById.id)
                .setPath(findById.path)
                .build()

    }

    override fun deleteValueByPath(request: DeleteValueByPathRequest): DeleteValueResponse {
        val path = request.path
        val findByPath = valueRepository.findByPath(path).orElseGet {Value("", "")}
        valueRepository.deleteById(findByPath.id)
        return DeleteValueResponse
                .newBuilder()
                .setId(findByPath.id)
                .setPath(findByPath.path)
                .build()
    }


}
