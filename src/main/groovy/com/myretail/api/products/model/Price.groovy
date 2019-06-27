package com.myretail.api.products.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = 'prices')
class Price {

    @JsonIgnore
    @Id
    int productId

    String currency_code
    double value
}
