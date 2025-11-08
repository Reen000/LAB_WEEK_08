package com.example.lab_week_08.worker

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class ThirdWorker(
    context: Context, workerParams: WorkerParameters
) : Worker(context, workerParams) {

    // Fungsi ini mengeksekusi proses latar belakang
    override fun doWork(): Result {
        // Ambil input parameter
        val id = inputData.getString(INPUT_DATA_ID)

        // Simulasikan proses panjang selama 3 detik
        Thread.sleep(3000L)

        // Build the output based on process result
        val outputData = Data.Builder()
            .putString(OUTPUT_DATA_ID, id)
            .build()

        // Return the output
        return Result.success(outputData)
    }

    companion object {
        const val INPUT_DATA_ID = "inId"
        const val OUTPUT_DATA_ID = "outId"
    }
}