package com.rudio.moviesdemo.utils

import com.rudio.moviesdemo.networking.ServiceTMDB

class ServiceTMDBHelper {

    companion object {

        fun getInstance(): ServiceTMDB {
            return RetrofitHelper.getInstance().create(ServiceTMDB::class.java)
        }
    }
}