@file:JvmName("Main")

package com.awesome.parser

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import com.google.gson.Gson
import com.sun.net.httpserver.Authenticator
import java.io.File

fun main() {
    val input = File("./src/main/resources/files/dz.json")
        .readText()
    var gson = Gson()
    if (input != null) {
        val jsonInfo = gson.fromJson(input, jsonData::class.java)
        for (currency in jsonInfo.Currencylist) {
            currency.printInfo()
        }
    }
    val url = "https://openexchangerates.org/api/latest.json?app_id=24fc13407b3246e9b01aa99b7cdeeb13"
    val (_, _, result) = url.httpGet().responseString()
    val (data, err) = result
    if (err != null) {
        System.err.println(err.cause)
        return
    }
    println(data)
}