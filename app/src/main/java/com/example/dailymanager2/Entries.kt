package com.example.dailymanager2

import android.content.Context
import java.io.*

object Entries: Serializable {
    public var entryList = arrayListOf(
        Entry("22/06/2000", "22:10", "Schlafen", "Hamburg","Wichtig")
    )

    fun addEntry(entry: Entry, addEntryActivity: AddEntryActivity) {
        entryList.add(entry)
        writeEntries(addEntryActivity)
    }

    fun getEntries(date: String): ArrayList<Entry> {
        return ArrayList(entryList.filter { entry -> entry.date == date })
    }

    fun readEntries(mainActivity: MainActivity){
        val fis: FileInputStream = mainActivity.openFileInput("data.txt")
        val ois = ObjectInputStream(fis)
        val entries = ois.readObject() as ArrayList<Entry>
        ois.close()
        fis.close()
        entryList = entries
    }

    private fun writeEntries(addEntryActivity: AddEntryActivity) {
        val fos: FileOutputStream = addEntryActivity.openFileOutput("data.txt", Context.MODE_PRIVATE)
        val os = ObjectOutputStream(fos)
        os.writeObject(entryList)
        os.close()
        fos.close()
    }
}