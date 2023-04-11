package com.example.web_api_anton

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            findViewById<MaterialButton>(R.id.loginButton).setOnClickListener {
                (activity as MainActivity).showFragment(LoginFragment.newInstance())
            }

            findViewById<MaterialButton>(R.id.registrationButton).setOnClickListener {
                (activity as MainActivity).showFragment(RegistrationFragment.newInstance())
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}