package com.myretail.api.products.service

import com.myretail.api.products.model.Price
import com.myretail.api.products.model.Product
import com.myretail.api.products.repository.PriceRepository
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductsService {

    @Autowired
    PriceRepository repository

    Product getProduct(int id) {
        new Product(id:id, name: getProductName(id), current_price: getProductPrice(id))
    }

    Price getProductPrice(int id) {
        repository.findByProductId(id)
    }

    String getProductName(int id) {
        try{
            new JsonSlurper().parseText(new URL('https://redsky.target.com/v2/pdp/tcin/' + id).text).product?.item?.product_description?.title
        }catch (Exception ex)
        {
            ''
        }
    }

    void savePrice(Price price, int id) {
        price.productId = id
        repository.saveAll([price])
    }
}
