package com.example.tecktailor.android.loginregisterauth

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tecktailor.android.common.base.BaseFragment
import com.example.tecktailor.android.databinding.FragmentUserTypeSelectionBinding
import androidx.navigation.fragment.findNavController

class UserTypeSelectionFragment : BaseFragment<FragmentUserTypeSelectionBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserTypeSelectionBinding {
        return FragmentUserTypeSelectionBinding.inflate(inflater, container, false)
    }

    override fun fetchData() {

    }

    override fun setUpViews() {

    }

    override fun setUpListeners() {
        binding?.apply {
            cardCustomer.setOnClickListener {
                //TODO when customer is selected

            }
            cardAdmin.setOnClickListener {
                //TODO when admin is selected

            }

        }
    }

    private fun navigateToLoginSignUpFragment() {
        val action = UserTypeSelectionFragmentDirections.actionUserTypeSelectionFragmentToLoginSignupFragment()
        findNavController().navigate(action)
    }
}