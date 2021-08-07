package com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.validation

interface ValidationInteractor {
    fun onLogin(email: String, password: String)
}