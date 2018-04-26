package com.zemosolabs.mindhive.daggermvvm.download_manager

import com.zemosolabs.mindhive.daggermvvm.download_manager.implementations.PriorityQueue
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.Priority
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.PriorityTask
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * @author atif
 * Created on 25/04/18.
 */

class PriorityQueueTest {

    private val priorityQueue : PriorityQueue = PriorityQueue()
    private val priorityTask1 : PriorityTask = PriorityTask(Priority.MEDIUM)
    private val priorityTask2 : PriorityTask = PriorityTask(Priority.LOW)
    private val priorityTask3 : PriorityTask = PriorityTask(Priority.HIGHEST)
    private val priorityTask4 : PriorityTask = PriorityTask(Priority.HIGH)
    private val priorityTask5 : PriorityTask = PriorityTask(Priority.HIGH)
    private val priorityTask6 : PriorityTask = PriorityTask(Priority.HIGHEST)
    private val priorityTask7 : PriorityTask = PriorityTask(Priority.MEDIUM)
    private val priorityTask8 : PriorityTask = PriorityTask(Priority.HIGHEST)

    @Before
    fun setupQueue(){
        priorityQueue.add(priorityTask1)
        priorityQueue.add(priorityTask2)
        priorityQueue.add(priorityTask3)
    }

    @Test
    fun testAdditionOrder1(){
        val priorityTaskHigh  = PriorityTask(Priority.HIGHEST)
        val priorityTaskLow  = PriorityTask(Priority.HIGHEST)
        priorityQueue.add(0, priorityTaskLow)
        priorityQueue.add(1, priorityTaskHigh)
        assertNotEquals("Checking if it is highest priority", priorityQueue.poll(), priorityTaskLow)
    }

    @Test
    fun testAdditionOrder2(){
        val priorityTaskHigh  = PriorityTask(Priority.HIGHEST)
        val priorityTaskLow  = PriorityTask(Priority.HIGHEST)
        priorityQueue.add(1, priorityTaskHigh)
        priorityQueue.add(0, priorityTaskLow)
        assertEquals("Checking if it is highest priority", priorityQueue.poll(), priorityTaskHigh)
    }

    @Test
    fun testPriorityAddition() {
        beginTest()
        priorityQueue.add(priorityTask4)
        priorityQueue.add(1, priorityTask5)
        priorityQueue.add(1, priorityTask6)
        beginTest()
        priorityQueue.add(priorityTask7)
        priorityQueue.add(priorityTask8)
        beginTest()
    }

    @After
    fun cleanupQueue(){
        priorityQueue.clear()
    }

    private fun beginTest() {
        var priorityTask = priorityQueue.poll()
        var activeTask = priorityTask
        while (priorityTask != null){
            System.out.println("Active Task is ${activeTask.getPriority()} Priority Task is ${priorityTask.getPriority()}")
            assertTrue("Checking if priority is is order", activeTask.getPriority() >= priorityTask.getPriority())
            activeTask = priorityTask
            priorityTask = priorityQueue.poll()
        }
    }
}
