package uz.otamurod.pass_object_by_navigation.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import uz.otamurod.pass_object_by_navigation.data.Person

class SharedViewModel : ViewModel() {
    var person by mutableStateOf<Person?>(null)
        private set

    fun addPerson(newPerson: Person) {
        person = newPerson
    }
}