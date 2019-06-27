package com.myretail.api.products.controller

import com.myretail.api.products.model.Price
import com.myretail.api.products.model.Product
import com.myretail.api.products.service.ProductsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('products')
class ProductsRestController {

    @Autowired
    ProductsService productsService

    @GetMapping('/{id}')
    Product getProduct(@PathVariable int id){
        productsService.getProduct(id)
    }

    @PutMapping('/{id}')
    void addProductPrice(@RequestBody Product product, @PathVariable int id){
        productsService.savePrice(price, id)
    }
}