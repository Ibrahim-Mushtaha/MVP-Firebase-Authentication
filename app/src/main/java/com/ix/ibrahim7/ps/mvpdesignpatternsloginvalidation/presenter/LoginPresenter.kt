package com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter

import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.model.User
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.ui.views.ILoginView

class LoginPresenter(private var isLoginView: ILoginView) : ILoginPresenter {

    override fun onLogin(email: String, password: String) {
     val user = User(email, password)
        val isLoginSucces = user.isDataValid
        if (isLoginSucces)
            isLoginView.onLoginResult("Login Success")
        else
            isLoginView.onLoginResult("Login Failed")
    }

}