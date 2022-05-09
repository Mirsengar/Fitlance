package contagiouscode.mirsengar.fitlance.di

import android.app.Application
import androidx.room.Room
import contagiouscode.mirsengar.fitlance.db.GymDatabase
import contagiouscode.mirsengar.fitlance.db.GymRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
     
     @Provides
     @Singleton
     fun provideGymDatabase(app : Application) : GymDatabase {
          return Room
                    .databaseBuilder(
                              app ,
                              GymDatabase::class.java ,
                              "gym_database.db"
                    )
                    .createFromAsset("gym_database.db")
                    .fallbackToDestructiveMigration()
                    .build()
     }
     
     @Provides
     @Singleton
     fun provideGymRepository(db : GymDatabase) : GymRepository {
          return GymRepository(db.dao)
     }
}