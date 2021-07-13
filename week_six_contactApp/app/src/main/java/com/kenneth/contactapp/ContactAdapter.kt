package com.kenneth.contactapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kenneth.contactapp.databinding.ContactItemBinding


class ContactAdapter(
    val contactItems: List<ContactModel>,
    val clickerFun: (ContactModel) -> Unit
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ContactItemBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun bind(contactItem :ContactModel){
            binding.tvName.text = contactItem.name
            binding.tvPhoneNumber.text = contactItem.phoneNumber
            binding.root.setOnClickListener {
                clickerFun(contactItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ContactItemBinding =
            ContactItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int): Unit {
        holder.bind(contactItems.get(position))
    }
    override fun getItemCount() = contactItems.size
}