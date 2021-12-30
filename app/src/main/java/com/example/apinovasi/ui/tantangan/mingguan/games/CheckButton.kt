package com.example.apinovasi.ui.tantangan.mingguan.games

interface CheckButton {
    fun onButtonActive(status: Boolean, jawaban: String)
    fun onNextButtonClicked(status: Boolean)
}