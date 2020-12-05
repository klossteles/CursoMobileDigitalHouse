package com.klossteles.aula39.card.repository

import com.klossteles.aula39.card.dao.CardDao
import com.klossteles.aula39.card.entity.CardEntity

class CardRepository(private val cardDao: CardDao) {
    suspend fun addCard(card: CardEntity) = cardDao.addCard(card)
    suspend fun getCount() = cardDao.getCount()
}