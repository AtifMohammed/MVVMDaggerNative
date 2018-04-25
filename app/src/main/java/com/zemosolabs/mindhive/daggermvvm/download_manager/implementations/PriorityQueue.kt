package com.zemosolabs.mindhive.daggermvvm.download_manager.implementations

import android.support.annotation.IntRange
import com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces.PriorityTask
import java.util.*

/**
 * @author atif
 * Created on 25/04/18.
 * Adds the PriorityTask to the queue based on the specified priority
 * This class handles the starvation case internally
 * This algorithm uses element priority increment strategy to prevent starvation
 */

class PriorityQueue : LinkedList<PriorityTask>() {

    /**
     * Adds the priority task to respective priority range.
     * By default it adds the task to the last of the given priority range
     */
    override fun add(element: PriorityTask): Boolean {
        add(0, element)
        return true
    }

    /**
     * Adds the priority task to respective position based on Task priority and Explicit Priority
     * @param index 0, if to be added in last for given priority range
     *              1, if to be added in first for given priority range
     * @param element Task to be executed
     */
    override fun add(@IntRange(from = 0, to = 1) index: Int, element: PriorityTask) {
        for (i in size..0){
            val task = get(i)
            val taskPriority = task.getPriority()
            val elementPriority = element.getPriority()
            if(taskPriority > elementPriority){
                super.add(i+1, element)
                return
            }else if(taskPriority == elementPriority){
                if(index == 0){
                    super.add(i+1, element)
                    return
                }
            }else{
                task.incrementPriority()
            }
        }
        super.add(0, element)
    }

}