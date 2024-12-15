package com.example.wisdomshare

class User {
    var name : String? = null
    var email : String? = null
    var uid : String? = null
    var skill : String? = null
    var frineds : ArrayList<String>? = null

    constructor(){}

    constructor(name: String?, email: String?, uid: String?, skill: String?, frineds : ArrayList<String>?){
        this.name = name
        this.email = email
        this.uid = uid
        this.skill = skill
        this.frineds = frineds
    }
}