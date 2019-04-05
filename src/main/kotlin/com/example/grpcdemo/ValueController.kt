package com.example.grpcdemo

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(
        path = [ValueController.ENDPOINT],
        produces = [MediaType.APPLICATION_JSON_UTF8_VALUE],
        consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE])
class ValueController(val valueHandler: ValueHandler){
    companion object {
        const val ENDPOINT = "/api/v1/values"
    }

    @RequestMapping(method = [RequestMethod.POST], path = [""])
    @ResponseStatus(HttpStatus.OK)
    fun hello(@RequestBody request: StoreValueRequest): StoreValueResponse{
        return valueHandler.storeValue(request)
    }

    @RequestMapping(method = [RequestMethod.GET], path = [""])
    @ResponseStatus(HttpStatus.OK)
    fun hello(@RequestParam("path") path: String): GetValueResponse{
        val valueRequest = GetValueRequest.newBuilder().setPath(path).setVersion(1).build()
        return valueHandler.getValue(valueRequest)
    }


}