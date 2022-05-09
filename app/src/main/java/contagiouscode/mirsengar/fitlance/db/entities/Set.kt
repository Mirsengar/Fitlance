package contagiouscode.mirsengar.fitlance.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import contagiouscode.mirsengar.fitlance.db.SetType

@Entity(tableName = "sets")
data class GymSet(
          @PrimaryKey(autoGenerate = true)
          val setId : Long = 0L ,
          val parentSessionExerciseId : Long ,
          val reps : Int = - 1 ,
          val weight : Float = - 1f ,
          val mood : Int = - 1 ,
          val deleted : Boolean = false ,
          @ColumnInfo(defaultValue = SetType.NORMAL)
          val setType : String = SetType.NORMAL ,
)