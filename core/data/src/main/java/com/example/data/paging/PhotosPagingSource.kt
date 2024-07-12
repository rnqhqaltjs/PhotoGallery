package com.example.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.mapper.PhotoMapper.toEntity
import com.example.data.source.PhotosDataSource
import com.example.domain.model.PhotosResponseEntity
import retrofit2.HttpException
import java.io.IOException

class PhotosPagingSource(
    private val photosDataSource: PhotosDataSource
) : PagingSource<Int, PhotosResponseEntity>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotosResponseEntity> {
        return try {
            val pageNumber = params.key ?: STARTING_PAGE_INDEX
            val response = photosDataSource.getPhotos(pageNumber, params.loadSize)

            val data = response.body()?.map { it.toEntity() }
            val prevKey = if (pageNumber == STARTING_PAGE_INDEX) null else pageNumber - 1
            val nextKey = if (response.body()?.isEmpty() == true) {
                null
            } else {
                pageNumber + (params.loadSize / 10)
            }
            LoadResult.Page(
                data = data ?: emptyList(),
                prevKey = prevKey,
                nextKey = nextKey,
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PhotosResponseEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        const val STARTING_PAGE_INDEX = 1
    }
}