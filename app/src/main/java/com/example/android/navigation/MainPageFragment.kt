
package com.example.android.navigation


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentMainPageBinding>(inflater,
                R.layout.fragment_main_page,container,false)

        binding.button.setOnClickListener { view : View ->
            view.findNavController().navigate(MainPageFragmentDirections.actionTitleFragmentToLoginFragment())
        }

        binding.allProducts.setOnClickListener { view : View ->
            view.findNavController().navigate(MainPageFragmentDirections.actionMainPageToRulesFragment())
        }

        binding.aboutUsButton.setOnClickListener{view: View ->
            view.findNavController().navigate(MainPageFragmentDirections.actionTitleFragmentToAboutFragment())
        }


        return binding.root
    }


}
