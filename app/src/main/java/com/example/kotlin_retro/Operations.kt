package com.example.kotlin_retro

import javax.security.auth.callback.Callback

interface Operations {
    fun detailBtn(search: Search?)
    fun deleteBtn(search: Search?)
    fun updateBtn(search: Search?, position: Int)
}