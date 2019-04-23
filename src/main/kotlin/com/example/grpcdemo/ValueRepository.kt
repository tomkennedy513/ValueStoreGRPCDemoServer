package com.example.grpcdemo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ValueRepository : JpaRepository<Value, String> {

    fun findByPath(path: String) : Optional<Value>

}