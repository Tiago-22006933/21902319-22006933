package com.example.fogospt.ui.new_fire

import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.fogospt.R
import com.example.fogospt.databinding.FragmentNewFireBinding
import com.example.fogospt.ui.model.FireModel
import com.example.fogospt.ui.model.FiresModel.listOfFires
import java.text.SimpleDateFormat
import java.util.*

class NewfireFragment : Fragment() {
    private var _binding: FragmentNewFireBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewFireBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnSubmit: Button = root.findViewById(R.id.button_submit_form)
        val name: Editable? = root.findViewById<EditText>(R.id.new_fire_person_name).getText()
        val cc: Editable? = root.findViewById<EditText>(R.id.new_fire_person_cc).getText()
        val district: Editable? = root.findViewById<EditText>(R.id.new_fire_district).getText()
        val fireDate = root.findViewById<DatePicker>(R.id.dpDate)
        val foto: Editable? = root.findViewById<EditText>(R.id.new_fire_photo).getText()

        val date = Date(fireDate.getYear() - 1900, fireDate.getMonth(), fireDate.getDayOfMonth())

        btnSubmit.setOnClickListener {
            listOfFires.add(FireModel(name.toString(), cc.toString().toLong(), district.toString(), date, "17:00", foto.toString()))
            for (fire in listOfFires) {
                Log.d(TAG, "${fire.name} ${fire.cartaoCidadao} ${fire.destrito} ${fire.data} ${fire.hora} ${fire.fotografia}")
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}