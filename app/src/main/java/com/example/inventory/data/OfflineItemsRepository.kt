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

import kotlinx.coroutines.flow.Flow

/**
 * OfflineItemsRepository
 * bertindak sebagai penghubung atau lapisan antara ItemDao-
 * dan komponen lain dalam aplikasi (misalnya ViewModel).
 */

/**
 * OfflineItemsRepository -> untuk akses data dari lokal (offline)
 * Dalam arti lain menyediakan data yang sudah ada di database lokal
 * tanpa perlu mengakses sumber daya eksternal seperti server atau API
 */

/**
 * OfflineItemsRepository merupakan implementasi dari ItemsRepository
 */
class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {

    /**
     * getAllItemsStream -> Untuk mengakses semua item yang ada di database dan mengembalikan data dalam bentuk Flow
     */
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    /**
     * getItemStream -> akses item berdasarkan id
     */
    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    /**
     * insertItem -> menyisipkan item baru ke db
     * seluruh fungsi di bawah menggunakan keyword suspend
     * suspend -> memungkinkan eksekusi secara asinkron
     */
    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    /**
     * deleteItem -> menghapus item
     */
    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    /**
     * updateItem -> update item
     */
    override suspend fun updateItem(item: Item) = itemDao.update(item)
}
