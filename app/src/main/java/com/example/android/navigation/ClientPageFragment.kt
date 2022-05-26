
package com.example.android.navigation
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentClientPageBinding


class ClientPageFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentClientPageBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_client_page, container, false)

        binding.logOut.setOnClickListener{ view : View ->
            view.findNavController().navigate(ClientPageFragmentDirections.actionClientPageToMainPage())
        }



        return binding.root
    }

}
