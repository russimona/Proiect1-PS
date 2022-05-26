package com.example.android.navigation
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentLogInBinding
import kotlinx.android.synthetic.main.fragment_log_in.editTextTextEmailAddress
import kotlinx.android.synthetic.main.fragment_log_in.editTextTextPassword
import kotlinx.android.synthetic.main.fragment_rules.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var isClient = "FALSE"

class LogInFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentLogInBinding>(
                inflater, R.layout.fragment_log_in, container, false)

        binding.logIn.setOnClickListener { view : View ->
            Log.d("Login fragment ", editTextTextEmailAddress.text.toString())
            Log.d("Login fragment ", editTextTextPassword.text.toString())

            logIn( editTextTextEmailAddress.text.toString(), editTextTextPassword.text.toString()  )
            if(isClient.equals("TRUE")){
                view.findNavController().navigate(LogInFragmentDirections.actionGameFragmentToClientPageFragment())
                Log.d("LOG IN STATUS", "SUCCESSFULLY")

            }else{
                Log.d("LOG IN STATUS", "NOT A CLIENT")
            }


        }

        binding.signInButton.setOnClickListener{ view : View ->
            view.findNavController().navigate(LogInFragmentDirections.actionGameFragmentToGameOverFragment())
        }

        return binding.root
    }

    private fun logIn( email: String, password : String){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.0.2.2:8080/admin/")
            .build()
            .create(IClients::class.java)

        val data = retrofitBuilder.getData()

        data.enqueue(object : Callback<List<Clients>?> {
            override fun onResponse(
                call: Call<List<Clients>?>,
                response: Response<List<Clients>?>
            ) {
                val responseBody = response.body()!!
                for(myData in responseBody){
                    Log.d("LOG IN STATUS", email)
                    if(myData.email.equals(email) && myData.password.equals(password)){
                        isClient = "TRUE"
                        return
                    }else{
                        isClient = "\n"
                    }
                }
            }
            override fun onFailure(call: Call<List<Clients>?>, t: Throwable) {
                throw t
            }
        })
    }


}
