package com.rudio.moviesdemo.networking

import com.squareup.moshi.*

class AdapterNullToDefaultInt() {

    @FromJson
    fun fromJson(reader: JsonReader): Int {
        if (reader.peek() != JsonReader.Token.NULL) {
            return reader.nextInt()
        }
        reader.nextNull<Unit>()
        return 0
    }
}