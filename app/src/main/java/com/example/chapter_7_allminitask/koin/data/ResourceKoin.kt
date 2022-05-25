package com.example.chapter_7_allminitask.koin.data

data class ResourceKoin<out T>(val status: Status, val data: T?, val message: String?) {
    companion object{
        fun <T> success(data: T): ResourceKoin<T> =  ResourceKoin(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(message: String?, data: T? = null): ResourceKoin<T> = ResourceKoin(status = Status.ERROR, data = data, message = message)

        fun <T> loading(data: T? = null): ResourceKoin<T> = ResourceKoin(status = Status.LOADING, data = data, message = null)
    }
}

enum class Status{
    SUCCESS,
    ERROR,
    LOADING
}