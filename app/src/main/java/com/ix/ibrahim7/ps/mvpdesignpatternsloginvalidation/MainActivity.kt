package com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.databinding.ActivityMainBinding
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.ILoginPresenter
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.presenter.LoginPresenter
import com.ix.ibrahim7.ps.mvpdesignpatternsloginvalidation.view.ILoginView

class MainActivity : AppCompatActivity() ,ILoginView{

    private val mBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var loginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        loginPresenter = LoginPresenter(this)
    }

    override fun onLoginResult(message: String) {

    }

}