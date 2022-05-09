package contagiouscode.mirsengar.fitlance.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import contagiouscode.mirsengar.fitlance.db.Equipment
import contagiouscode.mirsengar.fitlance.db.MuscleGroup


@Entity(tableName = "exercises")
data class Exercise(
          @PrimaryKey(autoGenerate = true)
          var exerciseId : Long = 0L ,
          @ColumnInfo(name = "title")
          var exerciseTitle : String = "Exercise" ,
          @ColumnInfo(defaultValue = MuscleGroup.NULL)
          var muscleGroups : String = MuscleGroup.NULL ,
          @ColumnInfo(defaultValue = Equipment.NULL)
          var equipment : String = Equipment.NULL ,
          @ColumnInfo(defaultValue = "https://www.musclewiki.com")
          var url : String = "https://www.musclewiki.com" ,
)