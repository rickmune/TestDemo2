package com.exsolv.tempglovo.room


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.exsolv.tempglovo.model.University
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@SmallTest
@HiltAndroidTest
class UniversityDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Inject
    @Named("test_db")
    lateinit var database: UniversityDatabase
    private lateinit var dao: UniversityDao
    @Inject
    lateinit var cacheMapper: CacheMapper

    @Before
    fun setUp(){
        hiltRule.inject()
        dao = database.universityDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun testInsertShoppingItem() = runTest {
        val university = University("", "", "JKUAT", "Kenya", "KE")
        dao.insertUni(cacheMapper.mapToEntity(university))
        val list = dao.getUni().first()
        assertThat(list.contains(cacheMapper.mapToEntity(university))).isTrue()
    }

    @Test
    fun testGet() = runTest {
        val university = University("", "", "JKUAT", "Kenya", "KE")
        val university1 = University("", "", "Nairobi", "Kenya", "KE")
        val university2 = University("", "", "KU", "Kenya", "KE")
        dao.insertUni(cacheMapper.mapToEntity(university))
        dao.insertUni(cacheMapper.mapToEntity(university1))
        dao.insertUni(cacheMapper.mapToEntity(university2))

        val list = dao.getUni().first()

        assertThat(list.size == 3).isTrue()
    }
}