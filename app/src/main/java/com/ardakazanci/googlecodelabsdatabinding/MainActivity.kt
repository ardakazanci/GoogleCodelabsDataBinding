package com.ardakazanci.googlecodelabsdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.ardakazanci.googlecodelabsdatabinding.databinding.ActivityMainBinding
import com.ardakazanci.googlecodelabsdatabinding.databinding.UserInfoModel

class MainActivity : AppCompatActivity() {

    // lateinit scope
    private lateinit var binding: ActivityMainBinding
    private lateinit var userInfoModel: UserInfoModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Binding aracılığıyla ilgili görünümümüze ulaşıyoruz.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        userInfoModel = UserInfoModel(userEmail = " ", userName = " ", userPassword = " ")

        binding.userInfoModel = userInfoModel


        binding.btnVisible.setOnClickListener {
            userInfoLoading(it)
        }

    }

    private fun userInfoLoading(it: View?) {


        binding.apply {

            userInfoModel?.userEmail = etEmail.text.toString()
            userInfoModel?.userName = etUsername.text.toString()
            userInfoModel?.userPassword = etPassword.text.toString()
            invalidateAll() // Model ' e aktarılan verilerin gösterilmesi için güncelleştirilmesini sağlar.
        }

    }
}
