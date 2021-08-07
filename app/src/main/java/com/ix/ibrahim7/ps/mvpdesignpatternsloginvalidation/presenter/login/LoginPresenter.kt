package com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.login

import android.app.Activity

class LoginPresenter : LoginContract.Presenter, LoginContract.onLoginListener {

    private var mLoginView: LoginContract.View? = null
    private var mLoginInteractor: LoginInteractor? = null

    constructor(mLoginView: LoginContract.View?) {
        this.mLoginView = mLoginView
        mLoginInteractor = LoginInteractor(this)
    }

    override fun login(activity: Activity?, email: String?, password: String?) {
        mLoginInteractor!!.performFirebaseLogin(activity, email, password)
    }

    override fun onSuccess(message: String?) {
        mLoginView!!.onLoginSuccess(message)
    }

    override fun onFailure(message: String?) {
        mLoginView!!.onLoginFailure(message)
    }
}