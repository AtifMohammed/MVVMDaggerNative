package com.zemosolabs.mindhive.daggermvvm.download_manager

import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.PriorityQueue
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * @author atif
 * Created on 25/04/18.
 */
class PriorityQueueTest {

    val priorityQueue : PriorityQueue = PriorityQueue()

    @Before
    fun setupQueue(){

    }

    @Test
    fun testPriorityAddition() {
    }

    @After
    fun cleanupQueue(){
        priorityQueue.clear()
    }
}
