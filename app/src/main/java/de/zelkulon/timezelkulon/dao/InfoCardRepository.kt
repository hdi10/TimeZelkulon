package de.zelkulon.timezelkulon.dao

import de.zelkulon.timezelkulon.model.InfoCard

class InfoCardRepository(private val dao: InfoCardDao) {
    suspend fun insert(infoCard: InfoCard) = dao.insert(infoCard)
    //suspend fun getAllCards() = dao.getAllCards()
    suspend fun getCardsForTheDay(day: String) = dao.getCardsForTheDay(day)
    suspend fun delete(infoCard: InfoCard) = dao.delete(infoCard) // Löscht über das Objekt
    suspend fun deleteById(id: Int) = dao.deleteById(id) // Löscht über die ID

}
