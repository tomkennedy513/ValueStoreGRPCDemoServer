package com.example.grpcdemo

interface ValueHandler {

    fun setValue(request: SetValueRequest): SetValueResponse

    fun getValueById(request: GetValueByIdRequest): GetValueResponse

    fun getValueByPath(request: GetValueByPathRequest): GetValueResponse

    fun deleteValueById(request: DeleteValueByIdRequest): DeleteValueResponse

    fun deleteValueByPath(request: DeleteValueByPathRequest): DeleteValueResponse
}