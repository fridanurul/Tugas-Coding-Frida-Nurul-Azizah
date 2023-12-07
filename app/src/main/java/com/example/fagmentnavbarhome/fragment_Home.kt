 package com.example.fagmentnavbarhome

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fagmentnavbarhome.data.DataIlmuwan
import com.example.fagmentnavbarhome.databinding.FragmentHomeBinding
import com.example.fagmentnavbarhome.model.Ilmuwan


 class fragment_Home : Fragment() {
     private var _binding: FragmentHomeBinding? = null
     private val binding get() = _binding
     private lateinit var ilmuwanAdapter: IlmuwanAdapter

     override fun onCreateView(
         inflater: LayoutInflater, container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View? {
         _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
         return binding?.root
     }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)

         val data = DataIlmuwan.dummyIlmuwan
         ilmuwanAdapter = IlmuwanAdapter{ data ->
             val intent = Intent(requireActivity(), DetailIlmuwanActivity::class.java)
             intent.putExtra("data", data)
             startActivity(intent)
         }

         binding?.apply {
             btnQuiz.setOnClickListener {
                 navigateToMain2()
             }
             rvIlmuwan.apply {
                 adapter = ilmuwanAdapter
                 layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
             }
         }
         ilmuwanAdapter.submitList(data)
     }

     private fun navigateToMain2() {
         val intent = Intent(requireActivity(), activity_menu_quiz::class.java)
         startActivity(intent)
     }
 }
