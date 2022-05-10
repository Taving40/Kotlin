package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ShareFragment : Fragment() {

    private lateinit var buttonShare: Button
    private lateinit var textToShare: EditText
    private lateinit var emailToShare: EditText
    private lateinit var subjectToShare: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflated = inflater.inflate(R.layout.fragment_share, container, false)

        buttonShare = inflated.findViewById(R.id.buttonShare)
        textToShare = inflated.findViewById(R.id.textToShare)
        emailToShare = inflated.findViewById(R.id.emailToShare)
        subjectToShare = inflated.findViewById(R.id.subjectToShare)

        buttonShare.setOnClickListener {
            share(textToShare)
        }

        return inflated

    }

    private fun share(textToShare: EditText){

        val message = textToShare.text
        val email = emailToShare.text //this has to be a valid format for an email address or gmail wont display it in the To category
        val subject = subjectToShare.text

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            putExtra(Intent.EXTRA_EMAIL, arrayOf(email.toString()))
            putExtra(Intent.EXTRA_SUBJECT, subject.toString())
            type = "text/plain"
            setPackage("com.google.android.gm")
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        if (shareIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        } else {
            Toast.makeText(requireActivity().applicationContext, "Gmail isn't installed", Toast.LENGTH_SHORT).show()
        }

    }

}