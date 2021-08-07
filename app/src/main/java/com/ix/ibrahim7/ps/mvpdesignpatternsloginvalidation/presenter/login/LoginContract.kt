package com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.login

import android.app.Activity

interface LoginContract {
    interface View {
        fun onLoginSuccess(message: String?)
        fun onLoginFailure(message: String?)
    }

    interface Presenter {
        fun login(activity: Activity?, email: String?, password: String?)
    }

    interface Intractor {
        fun performFirebaseLogin(activity: Activity?, email: String?, password: String?)
    }

    interface onLoginListener {
        fun onSuccess(message: String?)
        fun onFailure(message: String?)
    }
}