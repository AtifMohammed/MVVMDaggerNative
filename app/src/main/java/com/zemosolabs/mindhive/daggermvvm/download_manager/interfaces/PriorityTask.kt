package com.zemosolabs.mindhive.daggermvvm.download_manager.interfaces

/**
 * @author atif
 * Created on 25/04/18.
 */
open class PriorityTask(priority: Priority){

    private var priorityCount : Int = priority.ordinal

    fun getPriority() : Int {
        return priorityCount
    }

    fun incrementPriority(){
        if(priorityCount < Priority.HIGHEST.ordinal){
            priorityCount++
        }
    }

}