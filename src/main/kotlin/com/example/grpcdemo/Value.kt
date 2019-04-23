package com.example.grpcdemo

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Value(@Id var id: String = UUID.randomUUID().toString(),
                 var path: String = "",
                 var value: String = "")