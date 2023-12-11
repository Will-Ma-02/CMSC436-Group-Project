package com.example.groupproject

class WordleCell {

    private var letter : Char?
    private var status : String

    constructor(letter : Char?, status : String) {
        this.letter = letter
        this.status = status
    }

    fun getLetter() : Char? {
        return letter
    }

    fun setLetter(newLetter : Char?) {
        this.letter = newLetter
    }

    fun getStatus() : String {
        return status
    }

    fun setStatus(newStatus : String) {
        this.status = newStatus
    }
}