package com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.model

interface IUser {
    val email : String
    val password : String
    val isDataValid: Boolean
}