package com.kenneth.contactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.kenneth.contactapp.databinding.ActivityMainBinding

const val CATEGORY_KEY =  "CATEGORY_KEY"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myContactAdapter: ContactAdapter
    private lateinit var myContactList: MutableList<ContactModel>
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]

        myContactList = mutableListOf()

        myContactAdapter = ContactAdapter(myContactList){
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("name", it.name)
            intent.putExtra("phoneNumber", it.phoneNumber)
            startActivity(intent)
        }
        //myContactAdapter = ContactAdapter(myContactList)
        binding.recyclerView.adapter = myContactAdapter

        val db = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java, "contact-database"
        ).allowMainThreadQueries().build()


        viewModel.getAllContactItems(db).observe(this, {
            myContactAdapter = ContactAdapter(it){
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("name", it.name)
                intent.putExtra("phoneNumber", it.phoneNumber)
                startActivity(intent)
            }
            binding.recyclerView.adapter = myContactAdapter
            myContactAdapter.notifyDataSetChanged()
        })

        binding.button.setOnClickListener {
            val name : String = binding.etName.text.toString()
            val phoneNumber : String = binding.etPhone.text.toString()

            val contactItem = ContactModel(name, phoneNumber)
            viewModel.addContactItem(contactItem, db)

            myContactAdapter.notifyDataSetChanged()
        }
    }
}
