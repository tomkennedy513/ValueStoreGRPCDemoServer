package com.example.grpcdemo

interface ValueHandler {

    fun getValue(request: GetValueRequest): ValueResponse

    fun storeValue(request: StoreValueRequest): ValueResponse
}