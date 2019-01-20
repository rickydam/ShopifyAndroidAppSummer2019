package com.rickydam.shopifyandroidappsummer2019.model

/**
 * Data class to model the CustomCollection
 * @constructor Sets all the properties of the CustomCollection
 * @property id The unique identifier of the CustomCollection
 * @property title The title of the CustomCollection
 * @property body_html The description of the CustomCollection
 * @property image The image of the CustomCollection
 */

data class CustomCollection (
    var id: Int,
    var handle: String,
    var title: String,
    var updated_at: String,
    var body_html: String,
    var published_at: String,
    var sort_order: String,
    var template_suffix: String,
    var published_scope: String,
    var admin_graphql_api_id: String,
    var image: Image
)