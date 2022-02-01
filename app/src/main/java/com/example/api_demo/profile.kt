package com.example.api_demo

data class profile(
    var `data`: List<Data>,
    var page: Int,
    var per_page: Int,
    var support: Support,
    var total: Int,
    var total_pages: Int
)