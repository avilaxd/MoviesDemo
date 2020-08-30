package com.rudio.moviesdemo.framework.remote

import com.squareup.moshi.*

class AdapterNullToDefaultDouble() {

    @FromJson
    fun fromJson(reader: JsonReader): Double {
        if (reader.peek() != JsonReader.Token.NULL) {
            return reader.nextDouble()
        }
        reader.nextNull<Unit>()
        return 0.0
    }
}