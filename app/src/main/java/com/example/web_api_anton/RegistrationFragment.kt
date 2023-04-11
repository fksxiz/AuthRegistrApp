package com.example.web_api_anton

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton

class RegistrationFragment : Fragment() {
    private val viewModel = AuthorizationViewModel()

    private lateinit var login: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            login = findViewById(R.id.loginEditText)
            password = findViewById(R.id.passwordEditText)
            confirmPassword = findViewById(R.id.confirmPasswordEditText)

            Glide.with(context).load(
                "http://cdn.onlinewebfonts.com/svg/img_532221.png"
            ).into(findViewById(R.id.registerImage))

            findViewById<MaterialButton>(R.id.confirmRegisterButton).setOnClickListener {
                if (login.text.isEmpty() || password.text.isEmpty() || confirmPassword.text.isEmpty()) {
                    Toast.makeText(context, "Не все поля заполнены", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                if (!Validator.validateEmail(login.text.toString())) {
                    Toast.makeText(context, "Почта указана неверно", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (!Validator.validatePassword(password.text.toString())) {
                    Toast.makeText(context, "Пароль слишком легкий", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (password.text.toString() != confirmPassword.text.toString()) {
                    Toast.makeText(context, "Пароли не совпадают", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                viewModel.registerUser(User(login.text.toString(), password.text.toString())) {
                    if (!it)
                        return@registerUser

                    Log.d("SERVER_TAG", "User registration is success.")
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistrationFragment()
    }
}