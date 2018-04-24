package com.zemosolabs.mindhive.daggermvvm.download_manager

import java.util.*
import java.util.concurrent.Executor
import javax.inject.Inject

/**
 * @author atif
 * Created on 24/04/18.
 */
class DownloadSerializer @Inject constructor(private val serialExecutor: Executor) : Executor {

    private val downloadTasks : Queue<Runnable> = ArrayDeque<Runnable>()
    private var activeTask : Runnable? = null

    @Synchronized override fun execute(command: Runnable?) {
        downloadTasks.add(Runnable {

        })
        if(activeTask == null){
            scheduleNext()
        }
    }

    @Synchronized private fun scheduleNext() {
        activeTask = downloadTasks.poll()
        activeTask?.let {
            serialExecutor.execute(activeTask)
        }
    }
}