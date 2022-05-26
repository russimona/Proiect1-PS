package com.example.android.navigation
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_rules.productsName;
import kotlinx.android.synthetic.main.fragment_rules.productsPrice;
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RulesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        getProducts()
        return inflater.inflate(R.layout.fragment_rules, container, false)
    }

    private fun getProducts(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.0.2.2:8080/admin/")
            .build()
            .create(IProducts::class.java)

        val data = retrofitBuilder.getData()

        data.enqueue(object : Callback<List<Products>?> {
            override fun onResponse(
                call: Call<List<Products>?>,
                response: Response<List<Products>?>
            ){
                val responseBody = response.body()!!
                val myStringBuilderName = StringBuilder()
                val myStringBuilderPrice = StringBuilder()
                for(myData in responseBody){
                    myStringBuilderName.append(myData.name)
                    myStringBuilderName.append("\n")
                    myStringBuilderPrice.append(myData.price)
                    myStringBuilderPrice.append("\n")
                    Log.d("Rules Fragment", "${myData.name}")
                    Log.d("Rules Fragment", "${myData.price}")
                }

                productsName.text = myStringBuilderName
                productsPrice.text = myStringBuilderPrice

            }
            override fun onFailure(call: Call<List<Products>?>, t: Throwable) {
                throw t
            }
        })
    }





}
