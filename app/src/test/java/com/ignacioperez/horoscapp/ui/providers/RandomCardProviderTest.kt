package com.ignacioperez.horoscapp.ui.providers

import org.junit.Assert.*
import org.junit.Test

class RandomCardProviderTest{

    //estos test no son necesarios, pero son de ejemplo (se testea nuestra logica, no android)
    @Test
    fun `getRandomCardProvider should return a random card`(){
        //Given
        val randomCard = RandomCardProvider()

        //When
        val card = randomCard.getLuckey()

        //Then
        assertNotNull(card)
    }
}