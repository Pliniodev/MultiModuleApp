package feature.di

import feature.database.provideDB
import feature.database.provideStepDAO
import com.retrofit.provideOkHttpClient
import com.retrofit.provideRetrofitAdviceSlip
import com.retrofit.provideRetrofitRAM
import feature.data.local.localdatasource.LocalDataSource
import feature.data.local.localdatasource.LocalDataSourceImpl
import feature.domain.usecase.ApiUseCase
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val networkCoreModule = module {
    single<OkHttpClient>(named("auth1")) { provideOkHttpClient() }
    single<Retrofit>(named("retrofitRicky")) { provideRetrofitRAM(get(named("auth1"))) }
    single<Retrofit>(named("retrofitAdviceSlip")) { provideRetrofitAdviceSlip(get(named("auth1"))) }
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