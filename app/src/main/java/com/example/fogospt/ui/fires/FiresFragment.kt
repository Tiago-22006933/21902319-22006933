package com.example.fogospt.ui.fires

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fogospt.R
import com.example.fogospt.databinding.FragmentFiresBinding

class FiresFragment : Fragment() {

    private var _binding: FragmentFiresBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(FiresViewModel::class.java)

        _binding = FragmentFiresBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

       _binding!!.mapa.setOnClickListener{ onClickSymbol() }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onClickSymbol() {
    _binding!!.textGallery.text = "Sucesso"
    }
}