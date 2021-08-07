package com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.databinding.ActivityMainBinding
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.ILoginPresenter
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.LoginPresenter
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.ui.views.ILoginView

class MainActivity : AppCompatActivity() , ILoginView {

    private val mBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var loginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        loginPresenter = LoginPresenter(this)

        with(mBinding){
           btnLogin.setOnClickListener {
               loginPresenter.onLogin(tvEmail.text.toString().trim(),tvPassword.text.toString().trim())
           }
        }

    }

    override fun onLoginResult(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

}