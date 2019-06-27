package com.myretail.api.products.repository

import com.myretail.api.products.model.Price
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PriceRepository extends MongoRepository<Price, Integer>{

    Price findByProductId(int productId)
}
