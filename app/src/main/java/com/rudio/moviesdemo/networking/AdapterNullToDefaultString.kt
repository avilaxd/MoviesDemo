package com.rudio.moviesdemo.networking

import com.squareup.moshi.*

class AdapterNullToDefaultString() {

    @FromJson
    fun fromJson(reader: JsonReader): String {
        if (reader.peek() != JsonReader.Token.NULL) {
            return reader.nextString()
        }
        reader.nextNull<Unit>()
        return ""
    }
}