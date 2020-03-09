package com.daddyrusher.forexcurrencyconverter

import java.math.BigDecimal

class CurrencyConversionBean {
    var id: Long? = 0
    var from: String? = ""
    var to: String? = ""
    var conversionMultiple: BigDecimal? = BigDecimal.ZERO
    var quantity: BigDecimal? = BigDecimal.ZERO
    var totalCalculatedAmount: BigDecimal? = BigDecimal.ZERO
    var port: Int? = 0

    constructor() {}

    constructor(id: Long?, from: String, to: String, conversionMultiple: BigDecimal?, quantity: BigDecimal, totalCalculatedAmount: BigDecimal, port: Int?) : super() {
        this.id = id
        this.from = from
        this.to = to
        this.conversionMultiple = conversionMultiple
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount
        this.port = port
    }
}