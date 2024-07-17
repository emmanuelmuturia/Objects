package cifor.icraf.objects.feature.ui.di

import cifor.icraf.objects.feature.data.di.dataKoinModule
import cifor.icraf.objects.feature.ui.viewmodel.ObjectsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiKoinModule = module {

    viewModel {
        ObjectsViewModel(
            objectsRepository = get()
        )
    }

    includes(dataKoinModule)

}