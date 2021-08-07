package com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.databinding.ActivityMainBinding
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.validation.ValidationInteractor
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.login.LoginContract
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.login.LoginPresenter
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.validation.ValidationContract
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.validation.ValidationPresenter
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.ui.dialog.LoadingDialog

class MainActivity : AppCompatActivity() , ValidationContract , LoginContract.View {

    private val mBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var email :String ?= null
    private var password :String ?= null
    private var mLoginPresenter: LoginPresenter? = null
    private lateinit var validationInteractor: ValidationInteractor
    private var dialog :LoadingDialog ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        validationInteractor = ValidationPresenter(this)
        mLoginPresenter = LoginPresenter(this)
        dialog = LoadingDialog()

        with(mBinding){
           btnLogin.setOnClickListener {
               email = tvEmail.text.toString().trim()
               password = tvPassword.text.toString().trim()
               validationInteractor.onLogin(email!!,password!!)
           }
        }

    }

    override fun onLoginResult(message: String) {
        when (message) {
            "Login Success" -> {
                dialog!!.show(supportFragmentManager,"")
                mLoginPresenter!!.login(this, email, password)
            }
            else -> {
                Snackbar.make(mBinding.root,message,Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onLoginSuccess(message: String?) {
        if (dialog!!.isAdded)
            dialog!!.dismiss()
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onLoginFailure(message: String?) {
        if (dialog!!.isAdded)
            dialog!!.dismiss()
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

}