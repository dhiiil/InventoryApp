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

/**
 * App container for Dependency injection.
 */

/**
 * Kode pada file ini berfungsi untuk Dependency Injection
 * Dependency Injection adalah teknik di mana objek yang dibutuhkan oleh suatu kelas-
 * disuntikkan ke dalam kelas tersebut seperti dibuat langsung oleh kelas itu sendiri.
 */

/**
 * AppContainer -> interface yang berperan sebagai kontrak untuk menyediakan instance ItemsRepository.
 */
interface AppContainer {
    val itemsRepository: ItemsRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */

/**
 * AppDataContainer -> implementasi dari AppContainer
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */

    /**
     * ItemsRepository dideklarasikan menggunakan by lazy
     * Berarti instance hanya akan dibuat saat pertama kali diakses
     * Tujuan : Menghemat Resource, instance dibuat hanya saat dibutuhkan
     */
    override val itemsRepository: ItemsRepository by lazy {

        /**
         * Ini adalah instance dari class OfflineItemsRepository
         * Memungkinkan adanya akses data, khususnya dalam mode offline
         */
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }
}
