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

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * -source comment/doc-
 * Entity data class represents a single row in the database.
 */

/**
 * Jadi ini adalah class Item, representasi objek dari satu item yang kita simpan di database.
 * Untuk manipulasi data (CRUD) yang ada sebagai atribut class ini, erat kaitannya dengan file dengan nama DAO
 */

/*Anotasi @Entity menunjukkan bahwa kelas Item akan direpresentasikan sebagai tabel di Room*/
@Entity(tableName = "items")
data class Item(

    /**
     * Anotasi @PrimaryKey di variabel berfungsi menjadikan variabel id sebagai primary key
     * Parameter autoGenerate berfungsi untuk memberikan nilai unik setiap kali ada item baru yang disimpan
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int
)
