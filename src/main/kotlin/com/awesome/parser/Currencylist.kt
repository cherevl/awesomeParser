package com.awesome.parser

data class Currencylist(val CharCode: String?, val Name: String?, val Value: String?) {
    fun printInfo(){
        println("$CharCode $Name ${Value?.replace(",",".")}")
    }
}
