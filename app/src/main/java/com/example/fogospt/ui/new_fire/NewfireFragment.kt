package com.example.fogospt.ui.new_fire


import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.fogospt.R
import com.example.fogospt.databinding.FragmentNewFireBinding
import com.example.fogospt.ui.model.FireDataBase
import com.example.fogospt.ui.model.FireModelRoom
import java.util.*

class NewfireFragment : Fragment() {
    private var _binding: FragmentNewFireBinding? = null
    private val binding get() = _binding!!
    private lateinit var firemodelroom : FireModelRoom

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        firemodelroom = FireModelRoom(FireDataBase.getInstance(requireContext()).fireDao())
        _binding = FragmentNewFireBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnSubmit: Button = root.findViewById(R.id.button_submit_form)
        val name: String = root.findViewById<EditText>(R.id.new_fire_person_name).getText().toString()
        val cc: String = root.findViewById<EditText>(R.id.new_fire_person_cc).getText().toString()
        val district: String = root.findViewById<EditText>(R.id.new_fire_district).getText().toString()
        val fireDate = root.findViewById<DatePicker>(R.id.dpDate)
        val foto: Editable? = root.findViewById<EditText>(R.id.new_fire_photo).getText()

        val date = Date(fireDate.getYear() - 1900, fireDate.getMonth(), fireDate.getDayOfMonth())


        btnSubmit.setOnClickListener {
            firemodelroom.addFire("Rafael", "123456", "Lisboa","","", "2022-11-11", "13:30", "N/A", "true")
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}