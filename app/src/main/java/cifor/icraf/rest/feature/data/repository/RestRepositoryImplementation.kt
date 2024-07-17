package cifor.icraf.rest.feature.data.repository

import cifor.icraf.rest.feature.data.model.Subject
import cifor.icraf.rest.feature.source.local.source.LocalSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class RestRepositoryImplementation(
    private val ioDispatcher: CoroutineDispatcher,
    private val localSource: LocalSource
) : RestRepository {

    override suspend fun getAllSubjects(): Flow<List<Subject>> {
        return withContext(context = ioDispatcher) {
            localSource.getAllSubjects().map { subjectEntityList ->
                subjectEntityList.map { subjectEntity ->
                    Subject(
                        restId = subjectEntity.restId,
                        restName = subjectEntity.restName
                    )
                }
            }
        }
    }

}