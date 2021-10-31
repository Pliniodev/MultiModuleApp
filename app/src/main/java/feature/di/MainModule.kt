package feature.di

import feature.database.provideDB
import feature.database.provideStepDAO
import feature.retrofit.provideOkHttpClient
import feature.retrofit.provideRetrofitAdviceSlip
import feature.retrofit.provideRetrofitRAM
import feature.data.local.localdatasource.LocalDataSource
import feature.data.local.localdatasource.LocalDataSourceImpl
import feature.domain.usecase.ApiUseCase
import feature.presentation.home.HomeViewModel
import feature.retrofit.provideRetrofitDogs
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val networkCoreModule = module {
    single<OkHttpClient>(named("auth1")) { provideOkHttpClient() }
    single<Retrofit>(named("retrofitRicky")) { provideRetrofitRAM(get(named("auth1"))) }
    single<Retrofit>(named("retrofitAdviceSlip")) { provideRetrofitAdviceSlip(get(named("auth1"))) }
    single<Retrofit>(named("retrofitDogs")) { provideRetrofitDogs(get(named("authDogs"))) }
}

val databaseModule = module {
    single { provideDB(application = get()) }
    single { provideStepDAO(database = get()) }
}

val dataModule = module {
    factory<LocalDataSource> { LocalDataSourceImpl(db = get()) }
}

val domainModule = module {
    factory { ApiUseCase(repository = get()) }
}

val homeModule = module {
    viewModel { HomeViewModel() }
}
