package com.example.fogospt.ui.fires

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fogospt.R
import com.example.fogospt.databinding.FragmentFiresBinding
import com.example.fogospt.ui.model.FireParceLable
import com.example.fogospt.ui.model.FireRoom

class FiresFragment(private var items: List<FireParceLable> = listOf()) : Fragment(), MyAdapter.OnItemClickListener {

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

        binding.mapa.setOnClickListener{ show() }
        binding.lista.setOnClickListener{ hide() }

        binding.recyclerView.adapter = MyAdapter(items, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.setHasFixedSize(true)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun show() {
        _binding!!.showMap.setVisibility(View.VISIBLE)
        //_binding!!.showList.setVisibility(View.INVISIBLE)
    }


    private fun hide() {
        _binding!!.showMap.setVisibility(View.INVISIBLE)
        //_binding!!.showList.setVisibility(View.VISIBLE)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this.context,"Item $position" , Toast.LENGTH_SHORT).show()
        val clickedItem: FireParceLable = items[position]
        val mDialogView = LayoutInflater.from(this.context).inflate(R.layout.popup_detail,null)
        val mBuilder = AlertDialog.Builder(this.context).setView(mDialogView)

        var nome: TextView = mDialogView.findViewById(R.id.nomePop)
        var cc: TextView = mDialogView.findViewById(R.id.ccPop)
        var destrito: TextView = mDialogView.findViewById(R.id.destritoPop)
        var data: TextView = mDialogView.findViewById(R.id.dataPop)
        //var fotografia: TextView = mDialogView.findViewById(R.id.fotografia)

        nome.text = "Nome: " + clickedItem.name
        cc.text = "Documento de identificação. " + clickedItem.cartaoCidadao
        destrito.text = "Localização: " + clickedItem.distrito
        data.text = "Data do registo: " + clickedItem.data

        mBuilder.show()

        binding.recyclerView.adapter?.notifyItemChanged(position)
    }


}