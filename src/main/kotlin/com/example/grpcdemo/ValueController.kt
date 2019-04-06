package com.example.grpcdemo

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(
        path = [ValueController.ENDPOINT],
        produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
class ValueController(val valueHandler: ValueHandler){
    companion object {
        const val ENDPOINT = "/api/v1/values"
    }

    @RequestMapping(method = [RequestMethod.POST], path = [""])
    @ResponseStatus(HttpStatus.OK)
    fun storeValue(@RequestBody request: StoreValueRequest): StoreValueResponse{
        return valueHandler.storeValue(request)
    }

    @RequestMapping(method = [RequestMethod.GET], path = [""])
    @ResponseStatus(HttpStatus.OK)
    fun getValueByPath(@RequestParam(value = "path", required = true) path: String,
              @RequestParam(value = "version", required = false, defaultValue = "-1") version: Long): GetValueResponse{
        val valueRequest = GetValueByPathRequest.newBuilder().setPath(path).setVersion(version).build()
        return valueHandler.getValueByPath(valueRequest)
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/{uuid}"])
    @ResponseStatus(HttpStatus.OK)
    fun getValueByUuid(@PathVariable("uuid") uuid: String): GetValueResponse{
        val valueRequest = GetValueByUUIDRequest.newBuilder().setUuid(uuid).build()
        return valueHandler.getValueByUuid(valueRequest)
    }

}