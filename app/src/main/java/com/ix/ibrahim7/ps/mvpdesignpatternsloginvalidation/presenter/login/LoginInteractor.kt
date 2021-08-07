package com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.login

import android.app.Activity
import com.google.firebase.auth.FirebaseAuth
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.login.LoginContract.onLoginListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginInteractor(onLoginListener: onLoginListener?) : LoginContract.Intractor {

    private var mOnLoginListener: onLoginListener? = onLoginListener

    override fun performFirebaseLogin(activity: Activity?, email: String?, password: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        mOnLoginListener!!.onSuccess(task.result!!.user.uid)
                    } else {
                        mOnLoginListener!!.onFailure(task.exception.toString())
                    }
                }
        }
    }

}