package com.kutaykerem.sqltenotdefterikotlin

class NotDetails {

    var Notlar : String? = null
    get
    set

    var id : Int? = null
    get
    set

    var tarih : Int? = null
    get
    set

    constructor(Notlar: String?, id: Int?, tarih: Int?) {
        this.Notlar = Notlar
        this.id = id
        this.tarih = tarih
    }

    constructor(Notlar: String, id: Int, tarih: String)


}