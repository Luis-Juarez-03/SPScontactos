package com.example.spscontactos.room.VMR

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spscontactos.room.DAOR.ContactDao
import com.example.spscontactos.room.ER.Contact
import kotlinx.coroutines.launch

class ContactViewModel(private val contactDao: ContactDao) : ViewModel() {
    var contacts by mutableStateOf(listOf<Contact>())
        private set

    fun loadContacts() {
        viewModelScope.launch {
            contacts = contactDao.getAllContacts()
        }
    }

    fun addContact(contact: Contact) {
        viewModelScope.launch {
            contactDao.insertContact(contact)
            loadContacts()
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch {
            contactDao.deleteContact(contact)
            loadContacts()
        }
    }

    fun updateContact(contact: Contact) {
        viewModelScope.launch {
            contactDao.updateContact(contact)
            loadContacts()
        }
    }
}