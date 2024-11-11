/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * File ini adalah file yang memiliki tanggung jawab utama ke database room
 * fungsinya adalah membuat instance dari database (connect database)
 * bertanggung jawab sebagai titik akses utama ke database Room
 */

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {
    /**
     * Membuat instance dari DAO
     */
    abstract fun itemDao(): ItemDao

    /**
     * companion object adalah sebuah konsep yang memungkinkan untuk-
     * mendefinisikan anggota atau metode statis di dalam kelas.
     * Ini serupa dengan static di Java.
     */
    companion object {

        /**
         * Anotasi @Volatile untuk menandai semua perubahan nilai yang ada
         * perubahan tersebut akan langsung nampak pada thread
         */
        @Volatile

        /**
         * Kode di bawah ini untuk membuat instance kosong
         * (Ada kaitannya dengan design pattern singleton)
         */
        private var Instance: InventoryDatabase? = null

        /**
         * Fungsi ini digunakan untuk mendapatkan instance InventoryDatabase.
         * Jika Instance tidak null, fungsi ini akan mengembalikannya.
         * Jika null, fungsi ini akan membuat instance baru menggunakan Room.databaseBuilder.
         */
        fun getDatabase(context: Context): InventoryDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.

            /**
             * synchronized(this)
             * Menjamin bahwa hanya satu thread yang dapat mengakses blok kode ini-
             * pada satu waktu, untuk mencegah pembuatan lebih dari satu instance database.
             */
            return Instance ?: synchronized(this) {

                /**
                 * Membuat dan mengkonfigurasi instance database baru dengan nama "item_database"
                 */
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build().also { Instance = it }
            }
        }
    }
}

