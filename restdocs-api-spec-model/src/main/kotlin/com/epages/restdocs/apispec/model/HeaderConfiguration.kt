package com.epages.restdocs.apispec.model

open class HeaderConfiguration(
    var type: String = "",
    var name: String = "",
    var `in`: String = "",
    var description: String? = null
) {
    fun securitySchemeName() = this.name
}