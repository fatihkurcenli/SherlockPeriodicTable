package com.autumnsun.sherlockperiodictable.util

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import coil.load
import com.autumnsun.sherlockperiodictable.R
import com.autumnsun.sherlockperiodictable.databinding.ShowDialogBinding
import com.autumnsun.sherlockperiodictable.model.PeriodicTableModel

class MyDialog(val model: PeriodicTableModel) : DialogFragment() {

    private var _binding: ShowDialogBinding? = null
    private val binding get() = _binding!!

    private var name: String? = null
    private var description: String? = null
    private var imageViewUrl: String? = null
    private var number: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model.let {
            name = it.name
            description = it.summary
            number = "${it.id?.plus(1)}"
            imageViewUrl = it.spectralImage
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ShowDialogBinding.inflate(inflater, container, false)
        binding.let {
            name = name
            description = description
            number = number
            imageViewUrl = imageViewUrl
        }

        return binding.root
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view: View = LayoutInflater.from(context).inflate(R.layout.show_dialog, null, false)
        val name = view.findViewById<TextView>(R.id.show_dialog_name);
        val numberText = view.findViewById<TextView>(R.id.number_dialog_text_view);
        val imageUrl = view.findViewById<ImageView>(R.id.imageView);
        val summaryText = view.findViewById<TextView>(R.id.summary_text);
        val solidPhaseText = view.findViewById<TextView>(R.id.solid_phase_text_view);

        model.let {
            name.text = it.name
            numberText.text = "${it.id?.plus(1)}"
            summaryText.text = it.summary
            solidPhaseText.text = it.phase
        }
        if (model.spectralImage != null) {
            imageUrl.show()
            imageUrl.load(model.spectralImage) {
                crossfade(true)
                crossfade(2000)
            }
        } else {
            imageUrl.remove()
        }

        val dialogAnimationWith =
            activity?.let {
                val alertDialog = AlertDialog.Builder(it)
                alertDialog.setView(view)
                alertDialog.setPositiveButton(
                    "ok",
                    DialogInterface.OnClickListener() { dialog, id ->
                    })
                alertDialog.create()
            } ?: throw IllegalAccessException("Activity is null !!")
        dialogAnimationWith.window?.setWindowAnimations(R.style.AnimationsForDialog)
        return dialogAnimationWith
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}