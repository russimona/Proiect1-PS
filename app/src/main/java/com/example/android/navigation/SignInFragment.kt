package com.example.android.navigation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentSignInBinding
import com.example.tema3.network.SpeciesWebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import kotlinx.android.synthetic.main.fragment_sign_in.emailTextSignIn
import kotlinx.android.synthetic.main.fragment_sign_in.editTextTextPassword2
import kotlinx.android.synthetic.main.fragment_sign_in.editTextNumber
import kotlinx.android.synthetic.main.fragment_sign_in.editTextTextPersonName2

class SignInFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentSignInBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_sign_in, container, false)

        binding.signinButton.setOnClickListener { view : View ->
            var client = Clients(emailTextSignIn.text.toString(),
                editTextTextPersonName2.text.toString(),
                editTextTextPassword2.text.toString(),
                editTextNumber.text.toString(),
                "CLIENT"
                )

            val ctx = this
            SpeciesWebService.instance?.put(client)?.enqueue(object : Callback<Clients> {
                override fun onResponse(
                    call: Call<Clients>,
                    response: Response<Clients>
                    ) {
                    //client = response.body()!!
                }
                override fun onFailure(call: Call<Clients?>, t: Throwable) {
                    throw t
                }
            })

            view.findNavController().navigate(SignInFragmentDirections.actionGameOverFragmentToLoginFragment())
        }

        return binding.root
    }




}
