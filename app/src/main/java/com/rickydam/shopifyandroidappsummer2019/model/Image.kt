package com.rickydam.shopifyandroidappsummer2019.model

/**
 * Data class to model the Image
 * @constructor Sets all the properties of the Image
 * @property width The width of the image
 * @property height The height of the image
 * @property src The URL of the image
 */

data class Image(
    var created_at: String,
    var alt: String,
    var width: Int,
    var height: Int,
    var src: String
)
