package com.example.web_api_anton

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton

class LoginFragment : Fragment() {
    private val viewModel = AuthorizationViewModel()

    private lateinit var login: EditText
    private lateinit var password: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            Glide.with(context).load(
                "https://cdn-icons-png.flaticon.com/512/3580/3580168.png"
            ).into(findViewById(R.id.loginImage))

            login = findViewById(R.id.loginEditText)
            password = findViewById(R.id.passwordEditText)

            findViewById<MaterialButton>(R.id.confirmLoginButton).setOnClickListener {
                if (login.text.isEmpty() || password.text.isEmpty()) {
                    Toast.makeText(context, "Не введен логин или пароль", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                viewModel.authorizationUser(User(login.text.toString(), password.text.toString())) {
                    if (!it)
                        return@authorizationUser

                    Log.d("SERVER_TAG", "User authorization is success.")
                }
            }

            findViewById<MaterialButton>(R.id.registrationButton).setOnClickListener {
                (activity as MainActivity).showFragment(RegistrationFragment.newInstance())
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}