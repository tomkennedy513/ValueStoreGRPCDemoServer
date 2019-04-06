package com.example.grpcdemo

interface ValueHandler {

    fun getValueByPath(request: GetValueByPathRequest): GetValueResponse

    fun getValueByUuid(request: GetValueByUUIDRequest): GetValueResponse

    fun storeValue(request: StoreValueRequest): StoreValueResponse
}