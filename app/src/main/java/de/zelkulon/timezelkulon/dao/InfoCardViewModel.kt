package de.zelkulon.timezelkulon.dao

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.zelkulon.timezelkulon.model.InfoCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch

class InfoCardViewModel(private val repository: InfoCardRepository) : ViewModel() {
    private val _infoCards = MutableStateFlow<List<InfoCard>>(emptyList())
    val infoCards: StateFlow<List<InfoCard>> = _infoCards

    init {
        loadInfoCards()
    }

    fun loadInfoCards() {
        viewModelScope.launch {
            _infoCards.value = repository.getAllCards()
        }
    }

    fun addInfoCard(text: String, prio: Int) {
        viewModelScope.launch {
            repository.insert(InfoCard(text = text, prio = prio))
            loadInfoCards()
        }
    }

    fun deleteInfoCard(card: InfoCard) {
        viewModelScope.launch {
            repository.delete(card)
            loadInfoCards() // Liste nach Löschung aktualisieren
        }
    }
}
