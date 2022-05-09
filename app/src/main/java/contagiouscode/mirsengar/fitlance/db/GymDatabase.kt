package contagiouscode.mirsengar.fitlance.db

import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import androidx.sqlite.db.SupportSQLiteDatabase
import contagiouscode.mirsengar.fitlance.db.entities.Exercise
import contagiouscode.mirsengar.fitlance.db.entities.GymSet
import contagiouscode.mirsengar.fitlance.db.entities.Session
import contagiouscode.mirsengar.fitlance.db.entities.SessionExercise


@Database(
          entities = [
               Session::class ,
               Exercise::class ,
               SessionExercise::class ,
               GymSet::class
          ] ,
          autoMigrations = [
          ] ,
          version = 1 , exportSchema = true
)
abstract class GymDatabase : RoomDatabase() {
     abstract val dao : GymDAO
     
     @RenameColumn(tableName = "exercises" , fromColumnName = "muscleGroup" , toColumnName = "muscleGroups")
     internal class MyExampleAutoMigration : AutoMigrationSpec {
          override fun onPostMigrate(db : SupportSQLiteDatabase) {
          }
     }
     
     @RenameColumn(tableName = "sets" , fromColumnName = "setType" , toColumnName = "type")
     internal class AddSetType : AutoMigrationSpec {
          override fun onPostMigrate(db : SupportSQLiteDatabase) {
          
          }
     }
}