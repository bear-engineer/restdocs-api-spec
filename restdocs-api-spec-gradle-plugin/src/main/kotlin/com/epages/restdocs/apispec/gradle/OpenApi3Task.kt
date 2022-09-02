package com.epages.restdocs.apispec.gradle

import com.epages.restdocs.apispec.model.ResourceModel
import com.epages.restdocs.apispec.openapi3.OpenApi3Generator
import io.swagger.v3.oas.models.servers.Server
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional

open class OpenApi3Task : OpenApiBaseTask() {

    @Input
    @Optional
    var servers: List<Server> = listOf()

    fun applyExtension(extension: OpenApi3Extension) {
        super.applyExtension(extension)
        servers = extension.servers
    }

    override fun generateSpecification(resourceModels: List<ResourceModel>): String {
        if(oauth2SecuritySchemeDefinition != null) {
            return OpenApi3Generator.generateAndSerialize(
                resources = resourceModels,
                servers = servers,
                title = title,
                description = apiDescription,
                tagDescriptions = tagDescriptions,
                version = apiVersion,
                oauth2SecuritySchemeDefinition = oauth2SecuritySchemeDefinition,
                format = format
            )
        } else {
            return OpenApi3Generator.generateAndSerialize(
                resources = resourceModels,
                servers = servers,
                title = title,
                description = apiDescription,
                tagDescriptions = tagDescriptions,
                version = apiVersion,
                headerSecuritySchemeDefinition = headerSecuritySchemeDefinition,
                format = format
            )
        }
    }
}
