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

      viewModel.imageResponse.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Success -> {
                    if (it.data.isSuccessful) {
                        it.data.body()?.data?.get(0)?.imageslider?.let {
                             //   it1 -> setSlide(it1)
                        };
                        Log.e("data", it.data.body()?.data?.get(0)?.imagestopcategories.toString())

                    }

                }
                is NetworkResult.Failure -> {

                }
                is NetworkResult.Loading -> {

                }
            }
        }


        return root
    }


   /* private fun setSlide(imageList: ArrayList<String>) {
        val imageList = ArrayList<SlideModel>() // Create image list

        // imageList.add(SlideModel("String Url" or R.drawable)
        // imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(
            SlideModel(
                imageList[0].imageUrl,
                "The animal population decreased by 58 percent in 42 years."
            )
        )
        imageList.add(
            SlideModel(
                imageList[0].imageUrl,
                "Elephants and tigers may become extinct."
            )
        )
        imageList.add(SlideModel(imageList[0].imageUrl, "And people do that."))

        binding.imageSlider.setImageList(imageList)
    }
*/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}