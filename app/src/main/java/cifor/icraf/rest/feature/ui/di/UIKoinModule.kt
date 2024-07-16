package cifor.icraf.rest.feature.ui.di

import cifor.icraf.rest.feature.data.di.dataKoinModule
import cifor.icraf.rest.feature.ui.viewmodel.RestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiKoinModule = module {

    viewModel {
        RestViewModel(
            restRepository = get()
        )
    }

    includes(dataKoinModule)

}