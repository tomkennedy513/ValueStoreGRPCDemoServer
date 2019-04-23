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
    @ResponseStatus(HttpStatus.CREATED)
    fun storeValue(@RequestBody request: SetValueRequest): SetValueResponse{
        return valueHandler.setValue(request)
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/{id}"])
    @ResponseStatus(HttpStatus.OK)
    fun getValueById(@PathVariable("id") id: String): GetValueResponse{
        val valueRequest = GetValueByIdRequest.newBuilder().setId(id).build()
        return valueHandler.getValueById(valueRequest)
    }

    @RequestMapping(method = [RequestMethod.GET], path = [""])
    @ResponseStatus(HttpStatus.OK)
    fun getValueByPath(@RequestParam(value = "path", required = true) path: String): GetValueResponse{
        val valueRequest = GetValueByPathRequest.newBuilder().setPath(path).build()
        return valueHandler.getValueByPath(valueRequest)
    }

    @RequestMapping(method = [RequestMethod.DELETE], path = ["/{id}"])
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteValueById(@PathVariable("id") id: String): DeleteValueResponse{
        val valueRequest = DeleteValueByIdRequest.newBuilder().setId(id).build()
        return valueHandler.deleteValueById(valueRequest)
    }

    @RequestMapping(method = [RequestMethod.DELETE], path = [""])
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteValueByPath(@RequestParam(value = "path", required = true) path: String): DeleteValueResponse{
        val valueRequest = DeleteValueByPathRequest.newBuilder().setPath(path).build()
        return valueHandler.deleteValueByPath(valueRequest)
    }

}