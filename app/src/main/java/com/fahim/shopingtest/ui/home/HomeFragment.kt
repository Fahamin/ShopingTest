package com.fahim.shopingtest.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.fahim.shopingtest.Profile.viewModel.CreateAccountViewModel
import com.fahim.shopingtest.R
import com.fahim.shopingtest.Utils.NetworkResult
import com.fahim.shopingtest.databinding.FragmentHomeBinding
import com.fahim.shopingtest.ui.notifications.NotificationsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.imageResponse.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {
                    setSlide()
                    var s = it.data.body()?.data?.get(0)?.imagestopcategories
                    Log.e("data", s.toString())

                }
                is NetworkResult.Failure -> {

                }
                is NetworkResult.Loading -> {
// show loading
                }
            }
        }


    }

    private fun setSlide() {
        //  Log.e("data", "call setslide")

        val imageList = ArrayList<SlideModel>() // Create image list

        // imageList.add(SlideModel("String Url" or R.drawable)
        // imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(
            SlideModel(
                R.drawable.head1,
                " 42 years."
            )
        )
        imageList.add(
            SlideModel(
                R.drawable.head2,
                "Elephants"
            )
        )
        // imageList.add(SlideModel(imageList[0].imageUrl, "And people do that."))

        binding.imageSlider.setImageList(imageList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}