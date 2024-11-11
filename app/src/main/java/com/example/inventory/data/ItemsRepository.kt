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
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 */

/**
 * Secara keseluruhan method yang ada di dalam ini sama juga fungsi/perannya dengan OfflineItemsRepository
 * yang membedakan pada file ini merupakan interface-
 * yang bisa diimplementasikan oleh berbagai sumber data, baik itu database lokal, API remote, atau lainnya.
 * Sedangkan pada OfflineItemsRepository hanya untuk lokal
 */

/**
 * Summary :
 * getAllItemsStream -> Untuk mengakses semua item yang ada di database dan mengembalikan data dalam bentuk Flow
 * getItemStream -> akses item berdasarkan id
 * insertItem -> menyisipkan item baru ke db
 * deleteItem -> menghapus item
 * updateItem -> update item
 */

interface ItemsRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(item: Item)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(item: Item)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(item: Item)
}

