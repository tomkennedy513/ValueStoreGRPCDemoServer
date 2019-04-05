package com.example.grpcdemo

interface ValueHandler {

    fun getValue(request: GetValueRequest): GetValueResponse

    fun storeValue(request: StoreValueRequest): StoreValueResponse
}