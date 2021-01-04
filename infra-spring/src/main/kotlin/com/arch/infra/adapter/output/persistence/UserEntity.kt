package com.arch.infra.adapter.output.persistence

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class UserEntity(@Id val id: String = "", val name: String) {
}
