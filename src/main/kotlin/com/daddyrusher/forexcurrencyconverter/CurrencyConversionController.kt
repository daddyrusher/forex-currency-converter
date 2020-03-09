package com.daddyrusher.forexcurrencyconverter

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class CurrencyConversionController(val proxy: CurrencyExchangeServiceProxy) {
    companion object {
        private val LOG = LoggerFactory.getLogger(CurrencyConversionController::class.java)
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    fun convertCurrency(@PathVariable from: String, @PathVariable to: String, @PathVariable quantity: BigDecimal): CurrencyConversionBean {
        val uri: MutableMap<String, String> = mutableMapOf()
        uri["from"] = from
        uri["to"] = to

        val response: CurrencyConversionBean = proxy.retrieveExchangeValue(from, to)
        LOG.info("$response")

        return CurrencyConversionBean(
                response.id,
                from,
                to,
                response.conversionMultiple,
                quantity,
                quantity.multiply(response.conversionMultiple),
                response.port)
    }
}